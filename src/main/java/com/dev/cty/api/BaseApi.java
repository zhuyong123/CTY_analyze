package com.dev.cty.api;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Map;
import java.util.TreeMap;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Hex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dev.cty.api.exceptions.BadRequestException;
import com.dev.cty.api.exceptions.RestException;
import com.dev.cty.entity.MobileUser;
import com.dev.cty.service.UserService;
import com.dev.cty.type.ErrorType;
import com.dev.cty.utils.SessionUtils;

public abstract class BaseApi {

	@Autowired
	protected UserService userService;

	@ExceptionHandler(RestException.class)
	@ResponseBody
	public Map<String, Object> handleAllException(RestException ex, HttpServletResponse response) {
		response.setHeader("Content-Type", "application/json");
		response.setStatus(ex.getStatus());
		Map<String, Object> model = new TreeMap<String, Object>();
		model.put("errCode", ex.getErrCode());
		model.put("errMsg", ex.getErrMsg());
		return model;
	}

	protected Long getCurrentUserId(String session) {
		Long userId = SessionUtils.getUserId(session);
		if (userId == null) {
			throw new BadRequestException(ErrorType.NOT_AUTH_EXCEPTION, "session is invalied");
		}
		return userId;
	}

	protected MobileUser getCurrentUser(String session) {
		Long userId = SessionUtils.getUserId(session);
		if (userId == null) {
			throw new BadRequestException(ErrorType.NOT_AUTH_EXCEPTION, "session is invalied");
		}
		MobileUser user = userService.getById(userId);
		if (user == null) {
			throw new BadRequestException(ErrorType.NOT_AUTH_EXCEPTION, "session is invalied");
		}
		return user;
	}

	protected String getSignature(String clientip, String client_secret) throws NoSuchAlgorithmException, InvalidKeyException {
		Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
		SecretKeySpec secretKey = new SecretKeySpec(client_secret.getBytes(), "HmacSHA256");
		sha256_HMAC.init(secretKey);
		byte[] hash = sha256_HMAC.doFinal(clientip.getBytes());
		String signature = Hex.encodeHexString(hash);
		return signature;
	}

	protected String getClientIp(HttpServletRequest request) {
		String ip = request.getHeader("X-Real-IP");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("X-Forwarded-For");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	protected boolean hasPass10Mimite(Calendar createTime) {
		if (createTime != null && (Calendar.getInstance().getTimeInMillis() - createTime.getTimeInMillis() > 10 * 60 * 1000)) {
			return true;
		} else {
			return false;
		}
	}
}