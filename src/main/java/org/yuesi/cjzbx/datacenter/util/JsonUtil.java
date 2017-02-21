package org.yuesi.cjzbx.datacenter.util;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonUtil {

	private static String getDataFromDataYes(String json) {
		return json.replace("{\"retCode\":1,\"retMsg\":\"Success\",\"data\":[", "").replace("]}", "");
	}

	public static JSONObject getDataObject(String json) throws NoSuchMethodException {
		String dataJson = getDataFromDataYes(json);
		return JSONObject.fromObject(dataJson);
	}

	@SuppressWarnings("unchecked")
	public static List<JSONObject> getDataObjList(String json) {
		String dataJson = getDataFromDataYes(json);

		JSONArray jsonArray = JSONArray.fromObject("[" + dataJson + "]");
		List<JSONObject> list = (List<JSONObject>) JSONArray.toCollection(jsonArray, JSONObject.class);
		return list;
	}

}
