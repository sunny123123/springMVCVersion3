package com.payne.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JSONTest {
	public static void main(String[] args) {
		fun8();
	}
	public static void fun1(){
		List<String> list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		//JSONObject json = JSONObject.fromObject(list);
		JSONArray json = JSONArray.fromObject(list);
		System.out.println(json.toString());
	}
	public static void fun2(){
		String str = "{name:'payne'}";
		JSONObject obj = JSONObject.fromObject(str);
		String val = (String)obj.get("name");
		System.out.println(val);
	}
	public static void fun3(){
		String str = "{n1:'payne',n2:'tomcat'}";
		JSONObject obj = JSONObject.fromObject(str);
		String val = (String)obj.get("n2");
		System.out.println(val);
	}
	public static void fun4(){
		String str = "[{n1:'payne',n2:'tomcat'},{n3:'payne',n4:'tomcat'}]";
		JSONArray obj = JSONArray.fromObject(str);
		
		//String val = (String)obj.get("n2");
		System.out.println(obj.get(1).toString());
	}
	public static void fun5(){
		
	}
	public static void fun6(){
		String str = " {jid: 'imtest0420@djiim01-ts', fields: ['createdDate','roomId','natureName']}";
		JSONObject obj = JSONObject.fromObject(str);
		String val = (String)obj.get("jid");
		JSONArray vs  = (JSONArray)obj.get("fields");
		Object[] vss = vs.toArray();
		System.out.println(vss.toString());
	}
	public static void fun7(){
		String[] defaultFields = new String[]{"modificationDate","name","subject","type","avatarUrl"};
		List<String> needFieldsList = Arrays.asList(defaultFields);
		needFieldsList.add("hllo");
	}
	public static void fun8(){
		String str = "{ name:'test',name:'12'}";//自动变成数组了{"name":["test","12"]}
		JSONObject obj = JSONObject.fromObject(str);
		Object oo = obj.get("name");
		if(oo instanceof JSONArray)
			System.out.println(true);
		else{
			System.out.println(false);
			System.out.println(oo.getClass());
		}
		System.out.println(obj.toString());
		String pw = (String)obj.get("name");
		System.out.println(pw.toString());
	}
}
