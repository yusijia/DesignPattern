package com.designPattern.builder;

import java.util.HashMap;
import java.util.Map;

/**
 * 将计划封装到该类中，详细信息存入Map中
 * @author ysj
 *
 */
public class Planner {

	private Map<String, Object> map = new HashMap<String, Object>();
	
	/**
	 * 添加旅游的日期
	 * @param date
	 */
	public void buildDate(String date){
		map.put("Date", date);
	}
	
	/**
	 * 修改旅游的日期
	 * @param date
	 */
	public void setDate(String date){
		map.put("Date", date);
	}
	
	/**
	 * 添加旅游时的住所
	 * @param hotal
	 */
	public void addHotal(String hotal){
		map.put("Hotal", hotal);
	}
	
	/**
	 * 修改旅游时的住所
	 * @param hotal
	 */
	public void setHotal(String hotal){
		map.put("Hotal", hotal);
	}
	
	/**
	 * 添加旅游经费
	 * @param money
	 */
	public void addMoney(String money){
		map.put("Money", money);
	}
	
	/**
	 * 修改旅游经费
	 * @param money
	 */
	public void setMoney(String money){
		map.put("Money", money);
	}
	
	/**
	 * 获取详细的计划表
	 * @return
	 */
	public Map<String, Object> getPlanMap(){
		return map;
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("{" + "\n");
		for(String key : map.keySet()){
			stringBuilder.append("\t" + key + ": " + map.get(key) + "," + "\n");
		}
		stringBuilder.append("}");
		return stringBuilder.toString();
	}
}
