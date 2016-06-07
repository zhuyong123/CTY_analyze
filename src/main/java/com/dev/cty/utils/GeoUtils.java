/**
 * @Copyright: Copyright (c) 2010 TelenavSoftware, Inc. All rights reserved.
 */

package com.dev.cty.utils;

import org.apache.lucene.spatial.DistanceUtils;

public class GeoUtils {

	public static double getDistance(Double lat1, Double lon1, Double lat2, Double lon2) {
		if(lat1==null||lon1==null||lat2==null||lon2==null){
			return 0l;
		}
		return DistanceUtils.getDistanceMi(lat1, lon1, lat2, lon2);
	}

	public static Double milesToKilometers(Double miles) {
		return miles * 1.609344;
	}

	public static Double kilometersToMiles(Double kilometers) {
		return kilometers / 1.609344;
	}

}
