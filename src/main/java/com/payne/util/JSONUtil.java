package com.payne.util;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONUtil {
	private static ObjectMapper mapper = new ObjectMapper();
	
	public static Map<String,Object> fromJSON(String json){
		try {
			return mapper.readValue(json, Map.class);
		} catch (Exception e) {
			e.printStackTrace();
			return Collections.EMPTY_MAP;
		}
	}
	
	public static <T> T  toBean(String json,Class<T> claz){
		try {
			return mapper.readValue(json, claz);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 
	 * 用途：将字符串解析成指定javatype
	 * 
	 * @date 2016年9月29日
	 * @param params
	 * @param javaType
	 * @return
	 */
	public static <T>T toBean(String params,JavaType javaType){
		try {
			return mapper.readValue(params, javaType);
		} catch (Exception e) {
			return null;
		}
	}
	
	public static String toJSON(Object obj){
		try {
			return mapper.writeValueAsString(obj);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
	/**
	 * 
	 * 用途：获取集合类型
	 * @date 2016年9月29日
	 * @param collectionClass
	 * @param elementClasses
	 * @return
	 */
	public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {   
		return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);   
    } 
	
	/**
	 * 
	 * 用途：将字符串解析成map
	 * @date 2016年9月29日
	 * @param params
	 * @return
	 */
	public static Map<String,Object> fromJson(String params){
		try {
			JavaType jType=getCollectionType(Map.class,String.class,Object.class);
			return mapper.readValue(params, jType);
		} catch (Exception e) {
			return Collections.emptyMap();
		} 
	}
}
