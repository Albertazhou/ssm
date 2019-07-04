package com.cetc.weiwen.commons.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

/**
 * 地图工具类
 * @author jhl
 * @date 2018年8月30日 下午2:57:09
 * @version 1.0 
 *
 */
public class MapUtil {

	private final static String gaodeKey = "ad91aed7f598004d0c89d89a44ad5491";
	
	private final static String baiduKey = "I3aeOAEDuI9Z0vItEOejidzxO4nTXFW1";

	/**
	 * 百度地图根据坐标获取地址信息
	 * @param log<经度>
	 * @param lat<纬度>
	 * @return
	 */
	public static Map<String,Object> getBaiduAddr(String log, String lat) {
		 Map<String,Object> modelMap = new HashMap<String,Object>();
		 
		String urlString = "http://api.map.baidu.com/geocoder/v2/?location=" + lat + "," + 
				log + "&output=json&pois=0&ak="+baiduKey;
//		String res = "";
		String json = loadJSON(urlString);
		
        JSONObject jsonObject = JSONObject.parseObject(json);
        JSONObject resObject = jsonObject.getJSONObject("result");
        JSONObject busObject = resObject.getJSONObject("addressComponent");
		if(jsonObject.get("status").toString().equals("0")){
			modelMap.put("log", log);
			modelMap.put("lat", lat);
			modelMap.put("formatted_address", resObject.get("formatted_address"));
			modelMap.put("country", busObject.get("country"));
			modelMap.put("countrycode", busObject.get("country_code"));
			modelMap.put("province", busObject.get("province"));
			modelMap.put("city", busObject.get("city"));
			modelMap.put("citycode", busObject.get("country_code"));
			modelMap.put("district", busObject.get("district"));
			modelMap.put("adcode", busObject.get("adcode"));
			
			modelMap.put("township", busObject.get("street"));
			modelMap.put("town", busObject.get("town"));
		}else {
			System.out.println("未找到相匹配的经纬度！");
		}
		
		return modelMap;
	}
	
	/**
	 * 根据地址名字来获取坐标，可获取较多信息，推荐使用
	 * @param log<经度>
	 * @param lat<纬度>
	 * @return
	 */
	public static Map<String,Object> getGaodeAddr(String log, String lat) {
		Map<String,Object> modelMap = new HashMap<String,Object>();
		// lat 小 log 大
		// 参数解释: 纬度,经度 type 001 (100代表道路，010代表POI，001代表门址，111可以同时显示前三项)
		String urlString = "https://restapi.amap.com/v3/geocode/regeo?output=JSON&location="+log+","+
					lat+"&key="+gaodeKey+"&radius=1000&extensions=all";
		
		String res = loadJSON(urlString);
		
		JSONObject obj = JSONObject.parseObject(res);
		if (obj.get("status").toString().equals("1")) {
			JSONObject locaObj = obj.getJSONObject("regeocode");
			JSONObject addrComObj = locaObj.getJSONObject("addressComponent");
			modelMap.put("log", log);
			modelMap.put("lat", lat);
			modelMap.put("formatted_address", locaObj.get("formatted_address"));
			modelMap.put("country", addrComObj.get("country"));
			modelMap.put("countrycode", "");
			modelMap.put("province", addrComObj.get("province"));
			modelMap.put("city", addrComObj.get("city"));
			modelMap.put("citycode", addrComObj.get("citycode"));
			modelMap.put("district", addrComObj.get("district"));
			
			modelMap.put("adcode", addrComObj.get("adcode"));
			modelMap.put("township", addrComObj.get("township"));
			modelMap.put("towncode", addrComObj.get("towncode"));
		} else {
			 System.out.println("未找到相匹配的经纬度！");
		}
		return modelMap;
	}

	/**
	 * 百度地图根据地址获取坐标，精确度较高，推荐使用
	 * @param address
	 * @return
	 */
	public static Map<String, Double> getBaiduLngAndLat(String address) {
		Map<String, Double> map = new HashMap<String, Double>();
		String url = "http://api.map.baidu.com/geocoder/v2/?address=" + address
				+ "&output=json&ak="+baiduKey;
		String json = loadJSON(url);
		JSONObject obj = JSONObject.parseObject(json);
		if (obj.get("status").toString().equals("0")) {
			double lng = obj.getJSONObject("result").getJSONObject("location").getDouble("lng");
			double lat = obj.getJSONObject("result").getJSONObject("location").getDouble("lat");
			map.put("lng", lng);
			map.put("lat", lat);
			 System.out.println("经度："+lng+"---纬度："+lat);
		} else {
			 System.out.println("未找到相匹配的经纬度！");
		}
		return map;
	}
	
	/**
	 * 高德地图根据地址获取坐标，精确度不高，不推荐使用
	 * @param address
	 * @return
	 */
	public static Map<String, Double> getGaodeLngAndLat(String address) {
		Map<String, Double> map = new HashMap<String, Double>();
		String url = "https://restapi.amap.com/v3/geocode/geo?address="+address
					+"&output=JSON&key="+gaodeKey;
		String json = loadJSON(url);
		JSONObject obj = JSONObject.parseObject(json);
		if (obj.get("status").toString().equals("1")) {
			JSONObject locationObj = obj.getJSONArray("geocodes").getJSONObject(0);
			String location = locationObj.get("location").toString();
			String[] strArray = null;   
	        strArray = location.split(","); //拆分字符为"," ,然后把结果交给数组strArray 
	        map.put("lng", Double.parseDouble(strArray[0].toString()));
	        map.put("lat", Double.parseDouble(strArray[1].toString()));
			System.out.println("****************"+location);
		} else {
			 System.out.println("未找到相匹配的经纬度！");
		}
		return map;
	}

	/**
	 * 请求链接
	 * @param url
	 * @return
	 */
	public static String loadJSON(String url) {
		StringBuilder json = new StringBuilder();
		try {
			URL oracle = new URL(url);
			URLConnection yc = oracle.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
			String inputLine = null;
			while ((inputLine = in.readLine()) != null) {
				json.append(inputLine);
			}
			in.close();
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		}
		return json.toString();
	}

	
	public static void main(String[] args) throws IOException {
		 Map<String,Object> add = getGaodeAddr("113.949043", "22.583493");
		 System.out.println("***********************"+add.get("formatted_address"));
		 System.out.println("***********************"+add.get("city"));

//		 MapUtil getLatAndLngByBaidu = new MapUtil();
//		
//		 Map<String,Double> map=getLatAndLngByBaidu.getBaiduLngAndLat("深圳市南山区西丽大街留仙居北区13栋");
//		 System.out.println("经度："+map.get("lng")+"---纬度："+map.get("lat"));
	}
}
