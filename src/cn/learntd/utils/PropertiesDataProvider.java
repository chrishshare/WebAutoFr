/**
 * 
 */
package cn.learntd.utils;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

/**
 * @author Administrator
 * Create time:2017-01-02 上午9:13:19
 * Desciption:根据key读取properties配置的值
 */
public class PropertiesDataProvider {

	/**
	 * 
	 * @param configFile properties文件名称
	 * @param key 需要获取值对应的key
	 * @return String key对应的value
	 */
	public static String getProData(String configFile,String key){
		Configuration config = null;
		try {
			config = new PropertiesConfiguration(configFile);
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
		return String.valueOf(config.getProperty(key));
	}
}
