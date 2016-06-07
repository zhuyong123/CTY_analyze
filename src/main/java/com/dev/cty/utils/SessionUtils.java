/**
 * @Copyright: Copyright (c) 2010 TelenavSoftware, Inc. All rights reserved.
 */

package com.dev.cty.utils;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;

import com.dev.cty.entity.MobileUser;

public class SessionUtils {
	
	public static final String SNAPMATCH_SESSION_NAME="snapmatch_session_name";
	
	public static String[] decodeSession(String session) {
		String token = new String(Base64.decodeBase64(session));
		return token.split(";");
	}

	public static Long getAnonymityId(String session) {
		if(session == null){
			return null;
		}
		String token = new String(Base64.decodeBase64(session));
		String[] tokens = token.split(";");
		if (tokens == null || tokens.length < 1) {
			return null;
		}
		if(!StringUtils.isNumeric(tokens[0])){
			return null;
		}
		return Long.valueOf(tokens[0]);
	}
	
	public static String createUserSessionToken(MobileUser user) {
		return Base64
				.encodeBase64URLSafeString((user.getId().toString() + ";" + user.getUsername() + ";" + System.currentTimeMillis())
						.getBytes());
	}
	
	public static Long getUserId(String session) {
		if(session == null){
			return null;
		}
		String token = new String(Base64.decodeBase64(session));
		String[] tokens = token.split(";");
		if (tokens == null || tokens.length < 1) {
			return null;
		}
		if(!StringUtils.isNumeric(tokens[0])){
			return null;
		}
		return Long.valueOf(tokens[0]);
	}
}
