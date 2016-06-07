package com.dev.cty.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import net.sf.json.JSONObject;
import net.sf.json.xml.XMLSerializer;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonUtils {

	static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);
	
	public static String convertToXml(JSONObject json) {
		XMLSerializer xml = new XMLSerializer();
		String str = xml.write(json).toString();
		str = str.replace("<?xml version=\"1.0\" encoding=\"UTF-8\"?>", "");
		str = str.replaceFirst("\\s+", "");
		return str;
	}

	public static JSONObject post(String url, String jsonStr) throws Exception {
		HttpClient client = HttpClientBuilder.create().build();
		
		RequestConfig globalConfig = RequestConfig.custom()
		        .setCookieSpec(CookieSpecs.IGNORE_COOKIES)
		        .build();

		HttpPost post = new HttpPost(url);
		post.setConfig(globalConfig);

		StringEntity json = new StringEntity(jsonStr);
		json.setContentEncoding("UTF-8");
		json.setContentType("application/json");
		post.setEntity(json);

		HttpResponse res = client.execute(post);
		if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
			HttpEntity entity = res.getEntity();
			InputStream inputStream = entity.getContent();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
			BufferedReader reader = new BufferedReader(inputStreamReader);

			String s = "";
			StringBuilder result = new StringBuilder();
			while (((s = reader.readLine()) != null)) {
				result.append(s);
			}
			inputStreamReader.close();
			reader.close();

			return JSONObject.fromObject(result.toString());
		}
		
		return null;
	}
}
