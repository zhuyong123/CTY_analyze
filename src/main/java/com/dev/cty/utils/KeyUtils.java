package com.dev.cty.utils;

public class KeyUtils {
	
	static final String DOT = ".";
	
	static final String COLON = ":";
	
	static final String ORDERID = "oid:";
	
	static final String USERS = "users.";
	
	static final String USERID = "userId.";
	
	static final String USERIDS = "uIds:";
	
	static final String REDIS = "redis.";
	
	static final String CACHEDUSERS = "cacahedUsers.";
	
	static final String CACHE_AUTHCODE = "sms.authcode.mobile";
	
	static final String CACHE_REQUEST_PERMISSION=  "snap.request.permission";
	
	static final String SNAP_USER_SETTING = "snap.user.setting:";
	
	static final String SNAP_USER_INFOMATION = "snap.user.infomation:";
	
	static final String SNAP_USER_PICTURE = "snap.user.picture:";
	
	static final String SNAP_USER_FACEBOOK = "snap.user.facebook:";

	
	public static String getUserKey(Long userId){
		return USERS + USERID + userId;
	}
	
	public static String getUserPostPhotosKey(Long userId){
		return USERS + USERID + userId + ".postPhotos:";
	}
	
	public static String getPhotosDislikedUsersKey(Long userId, String matchUrl){
		return USERS + USERID + userId + ".matchUrl." + matchUrl + ".dislikeUids:";
	}
	
	public static String getLikeUsersKey(Long userId){
		return USERS + USERID + userId + ".likeUids:";
	}
	
	public static String getLikeUserIdsWithTimeKey(Long userId){
		return USERS + USERID + userId + ".likeUidsWithTime:";
	}
	
	public static String getDislikeUsersKey(Long userId){
		return USERS + USERID + userId + ".disLikeUids:";
	}
	
	public static String getDislikeUserIdsWithTimeKey(Long userId){
		return USERS + USERID + userId + ".disLikeUidsWithTime:";
	}
	
	public static String getCachedUsersKey(){
		return CACHEDUSERS + USERIDS ;
	}
	public static Long getOrderId(String orderKey) {
		return Long.parseLong(orderKey.substring(orderKey.indexOf(ORDERID) + 4));
	}
	
	public static Long getUserId(String userKey) {
		return Long.parseLong(userKey.substring(userKey.indexOf(USERID) + 7));
	}
	
	public static String getCachedAuthcode(){
		return CACHE_AUTHCODE;
	}
	
	public static String getRequestPermission(){
		return CACHE_REQUEST_PERMISSION;
	}
	
	public static String getUserSetting(String userId){
		return SNAP_USER_SETTING + userId;
	}
	
	public static String getUserInfomation(String userId){
		return SNAP_USER_INFOMATION + userId;
	}
	
	public static String getUserPicture(String userId){
		return SNAP_USER_PICTURE + userId;
	}
	
	public static String getFaceBook(){
		return SNAP_USER_FACEBOOK;
	}
}
