package com.chyou.common.config;


import java.util.HashMap;
import java.util.Map;


import com.chyou.common.utils.PropertiesLoader;
import com.chyou.common.utils.StringUtils;

/**
 * 全局配置类
 * 缓存并获取resources配置文件的信息
 * @author chengyou
 * @version 2014-06-25
 */
public class Global {

	/**
	 * 当前对象实例
	 */
	private static Global global = new Global();
	
	/**
	 * 保存全局属性值
	 */
	private static Map<String, String> map = new HashMap<String,String>();
	
	/**
	 * 属性文件加载对象
	 */
	private static PropertiesLoader loader = new PropertiesLoader("resources.properties");

	/**
	 * 获取当前对象实例
	 */
	public static Global getInstance() {
		return global;
	}
	
	/**
	 * 获取配置
	 * @see ${fns:getConfig('product_path')}
	 */
	public static String getConfig(String key) {
		String value = map.get(key);
		if (value == null){
			value = loader.getProperty(key);
			map.put(key, value != null ? value : StringUtils.EMPTY);
		}
		return value;
	}
	
	/**
	 * 获取配置
	 * @see ${fns:getConfig('product_path')}
	 */
	public static String getProductPath() {
		
		return getConfig("product_path");
	}
	
}
