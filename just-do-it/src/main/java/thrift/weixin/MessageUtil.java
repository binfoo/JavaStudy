package thrift.weixin;

import com.google.gson.Gson;

public class MessageUtil {
	
	
	/**将bean转换为json字符串
	 * @param obj
	 * @return
	 */
	public static String ToJson(Object bean)
	{
		Gson gson = new Gson();
		return gson.toJson(bean);
	}
}
