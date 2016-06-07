/**
 * @Copyright: Copyright (c) 2010 TelenavSoftware, Inc. All rights reserved.
 */
package com.dev.cty.utils;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.activation.DataHandler;
import javax.imageio.ImageIO;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.dev.cty.entity.MobileUser;
import com.mortennobel.imagescaling.AdvancedResizeOp;
import com.mortennobel.imagescaling.ResampleOp;
import com.qiniu.api.auth.AuthException;
import com.qiniu.api.auth.digest.Mac;
import com.qiniu.api.config.Config;
import com.qiniu.api.io.IoApi;
import com.qiniu.api.io.PutExtra;
import com.qiniu.api.io.PutRet;
import com.qiniu.api.rs.PutPolicy;

public class MediumUtils {

	private final static Logger logger = LoggerFactory.getLogger(MediumUtils.class);

	private final static Double pressInX = new Double(1.0 / 30.0);

	private final static Double pressInY = new Double(37.0 / 40.0);

	public static String saveLocal(byte[] bytes, String url){
		
		FileOutputStream output = null;
		String filePath = InitParameters.mediaDirectory + url;
		try {
			File directoryFile = new File(filePath.substring(0, filePath.lastIndexOf("/")));
			if (!directoryFile.exists()) {
				directoryFile.mkdirs();
			}

			File file = new File(filePath);
			logger.info("medium path: " + file.getPath());
			if (!file.exists()) {
				file.createNewFile();
			}

			output = new FileOutputStream(filePath);
			output.write(bytes);
			
			if (url.contains(ConstantUtils.MIME_TYPE_JPG)||url.contains(ConstantUtils.MIME_TYPE_PNG)) {
				InputStream inStream160 = new ByteArrayInputStream(bytes);
				InputStream inStream640 = new ByteArrayInputStream(bytes);
				compressByWidth(inStream160, filePath, 160, false);
				compressByWidth(inStream640, filePath, 640, false);
			}
			
			output.close();
			return url;
		} catch (Exception e) {
			logger.error(ExceptionUtils.ConvertStackTrace(e));
			throw new RuntimeException(e);
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					logger.error(ExceptionUtils.ConvertStackTrace(e));
				}
			}
		}
	}
	
	public static String saveLocal(DataHandler data, String url){
		FileOutputStream output = null;
		String filePath = InitParameters.mediaDirectory + url;
		try {
			File directoryFile = new File(filePath.substring(0, filePath.lastIndexOf("/")));
			if (!directoryFile.exists()) {
				directoryFile.mkdirs();
			}

			File file = new File(filePath);
			logger.info("medium path: " + file.getPath());
			if (!file.exists()) {
				file.createNewFile();
			}

			output = new FileOutputStream(filePath);
			data.writeTo(output);
			output.close();
			return url;
		} catch (Exception e) {
			logger.error(ExceptionUtils.ConvertStackTrace(e));
			throw new RuntimeException(e);
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					logger.error(ExceptionUtils.ConvertStackTrace(e));
				}
			}
		}
	}

	public static void compressByWidth( InputStream data, String url, Integer targetWidth, Boolean needCut) throws  IOException {
		FileOutputStream output = null;
		try {
			String filePath = url.replace(ConstantUtils.PHOTO_ORIGIN, targetWidth.toString());

			File directoryFile = new File(filePath.substring(0, filePath.lastIndexOf("/")));
			if (!directoryFile.exists()) {
				directoryFile.mkdirs();
			}

			File file = new File(filePath);
			logger.info("medium compress path: " + file.getPath());
			if (!file.exists()) {
				file.createNewFile();
			}
			BufferedImage image = ImageIO.read(data);
			logger.debug("original width:{}, height:{}", image.getWidth(), image.getHeight());
			float rate = (float) targetWidth / (float) image.getWidth();
			int height = (int) (rate * image.getHeight());
			int width = targetWidth.intValue();
			logger.debug("compress to width:{}, height:{}", width, height);

			ResampleOp resampleOp = new ResampleOp(width, height);
			resampleOp.setUnsharpenMask(AdvancedResizeOp.UnsharpenMask.None);
			resampleOp.setNumberOfThreads(5);
			BufferedImage bufferedImage = resampleOp.filter(image, null);

			if (needCut) {
				Integer squareSide = null;
				Integer x = null;
				Integer y = null;
				if (height > width) {
					squareSide = width;
					x = 0;
					y = (height - width) / 2;
				} else {
					squareSide = height;
					x = (width - height) / 2;
					y = 0;
				}
				logger.debug("cut to squareSide: " + squareSide);
				logger.debug("x:{}, y:{}", x, y);
				bufferedImage = bufferedImage.getSubimage(x, y, squareSide, squareSide);
			}
			
			output = new FileOutputStream(filePath);
			ImageIO.write(bufferedImage, ConstantUtils.MIME_TYPE_JPG, output);
			output.close();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					logger.error(ExceptionUtils.ConvertStackTrace(e));
				}
			}
		}
	}
	
	public static String getRepairsMediaUrl(String mimeType, String userId) {
		String urlPrefix = ConstantUtils.REPAIRS_MEDIUM_FOLDER_PREFIX;
		urlPrefix += "/"+userId;
		urlPrefix = makeUrl(mimeType, userId, urlPrefix);
		return urlPrefix;
	}
	
	public static String getAvatarUrl(String mimeType,String userId) {
		String urlPrefix = ConstantUtils.AVATAR_MEDIUM_FOLDER_PREFIX;
		urlPrefix += "/"+userId;
		urlPrefix = makeUrl(mimeType, userId, urlPrefix);
		return urlPrefix;
	}
	
	private static String makeUrl(String mimeType, String userId, String urlPrefix) {
		if (mimeType.equals(ConstantUtils.MIME_TYPE_JPG) || mimeType.equals(ConstantUtils.MIME_TYPE_PNG)) {
			urlPrefix += "/photo/origin";
		} else if (mimeType.equals(ConstantUtils.MIME_TYPE_MP4)) {
			urlPrefix += "/video";
		} else if (mimeType.equals(ConstantUtils.MIME_TYPE_MP3) || mimeType.equals(ConstantUtils.MIME_TYPE_AAC) || mimeType.equals(ConstantUtils.MIME_TYPE_3GP) || mimeType.equals(ConstantUtils.MIME_TYPE_AMR) || mimeType.equals(ConstantUtils.MIME_TYPE_M4A)) {
			urlPrefix += "/audio";
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		urlPrefix += ("/" + df.format(new Date()));
		urlPrefix += ("/" + (long)(Math.random() * ConstantUtils.FILE_SUB_FOLDER_LIMIT));
		urlPrefix += ("/" + String.valueOf(System.currentTimeMillis()) + "." + mimeType);
		return urlPrefix;
	}
	
	

	public static File read(String url, String directory) throws IOException {
		String filePath = directory + url;
		File file = new File(filePath);
		if (file == null) {
			logger.error(ExceptionUtils.ConvertStackTrace(new IOException("read file failed")));
			throw new IOException("read file failed");
		}
		return file;
	}

	public static void pressImage(String pressImg, BufferedImage targetBufferImage) {
		try {
			Graphics targetGraphic = targetBufferImage.createGraphics();
			File pressFile = new File(pressImg);
			Image pressImage = ImageIO.read(pressFile);
			int pressWidth = pressImage.getWidth(null);
			int pressHeight = pressImage.getHeight(null);
			targetGraphic.drawImage(pressImage, (int) (targetBufferImage.getWidth() * pressInX), (int) (targetBufferImage.getHeight() * pressInY), pressWidth, pressHeight, null);
			targetGraphic.dispose();
		} catch (Exception e) {
			logger.error(ExceptionUtils.ConvertStackTrace(e));
		}
	}

	public static void pressText(String pressText, BufferedImage targetBufferImage) {
		try {
			int xOffset = 5;
			int yOffset = 32;
			Font font = new Font("微软雅黑", Font.PLAIN, 12);
			AlphaComposite composite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f);

			Graphics2D targetGraphic = targetBufferImage.createGraphics();
			targetGraphic.setColor(new Color(Color.WHITE.getRGB()));
			targetGraphic.setFont(font);
			targetGraphic.setComposite(composite);
			targetGraphic.drawString(pressText, (int) (targetBufferImage.getWidth() * pressInX + xOffset), (int) (targetBufferImage.getHeight() * pressInY + yOffset));
			targetGraphic.dispose();

			Graphics2D targetGraphicShadow = targetBufferImage.createGraphics();
			targetGraphicShadow.setColor(new Color(Color.BLACK.getRGB()));
			targetGraphicShadow.setFont(font);
			targetGraphicShadow.setComposite(composite);
			targetGraphicShadow.drawString(pressText, (int) (targetBufferImage.getWidth() * pressInX + xOffset + 1), (int) (targetBufferImage.getHeight() * pressInY + yOffset + 1));
			targetGraphicShadow.dispose();
		} catch (Exception e) {
			logger.error(ExceptionUtils.ConvertStackTrace(e));
		}
	}

	public static String getImageUrl(String url, Integer width) {
		if (url != null) {
			return url.replace(ConstantUtils.PHOTO_ORIGIN, width.toString());
		} else {
			return null;
		}
	}


	public static byte[] getArrayByteFromUrl(String url) {

		ByteArrayOutputStream baos = null;
		try {
			URL u = new URL(url);
			BufferedImage image = ImageIO.read(u);
			// convert BufferedImage to byte array
			baos = new ByteArrayOutputStream();
			ImageIO.write(image, "jpg", baos);
			baos.flush();
			return baos.toByteArray();
		} catch (Exception e) {
			return null;
		} finally {
			if (baos != null) {
				try {
					baos.close();
				} catch (IOException e) {
				}
			}
		}
	}
	
	public static String saveQiniu(MultipartFile multiFile, String url){
		try {
			Config.ACCESS_KEY = "d3bh8DDmmbJ5vOngsOX1bu8jRKn_6mtnTeLinPQl";
			Config.SECRET_KEY = "Vs27TJnvUhW1XCavr95QpO-qX6ifIr-4lvlTbkjP";
			Mac mac = new Mac(Config.ACCESS_KEY, Config.SECRET_KEY);
			// 请确保该bucket已经存在
			String bucketName = "pohoto-avatar";
			PutPolicy putPolicy = new PutPolicy(bucketName);
			String uptoken;
			uptoken = putPolicy.token(mac);
			PutExtra extra = new PutExtra();
			CommonsMultipartFile cf= (CommonsMultipartFile)multiFile;
		    DiskFileItem fi = (DiskFileItem)cf.getFileItem(); 
	        File file = fi.getStoreLocation();
			String key = url.substring(1,url.length());
			PutRet ret = IoApi.putFile(uptoken, key, file, extra);
			if(ret.ok()){
				logger.info("***************************key= "+ret.getKey());
				return ret.getKey();
			}
		} catch (AuthException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return "";
	}
}
