package com.xrk.task;

import com.xrk.service.serverinfo.ServerInfoService;
import com.xrk.utils.Commons;
import com.xrk.utils.EmailUtils;
import com.xrk.utils.PropertiesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;

/**
 * Spring调度，指定时间执行
 * 利用了spring 3 中使用注解的方式来进行任务调度。 
 * @author tong
 * 2013-11-19
 * @Email: luomingtong@163.com
 * @version 1.0v
 */
@Component
public class SpringTaskController {
	@Autowired
	private ServerInfoService serverInfoService;

	public static void main(String[] args) {
		SpringTaskController action = new SpringTaskController();
		try {
			action.action();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 该方法为任务调度是自动调用的方法，在这里可以实现你要实现的功能
	 * 
	 * @throws Exception
	 */
	// @Scheduled(cron = "0 0 9  * * ? ")
	public void action() throws Exception {
		Properties prop = PropertiesUtils.getProperties();
		if (null != prop) {
			String data = null;
			try {
				Iterator<Entry<Object, Object>> itr = prop.entrySet().iterator();
				while (itr.hasNext()) {
					Entry<Object, Object> e = (Entry<Object, Object>) itr.next();
					int sun = e.getKey().toString().indexOf("jhost");
					if (sun > -1) {
						String name = e.getKey().toString().substring(5);
						data = this.task(name, e.getValue().toString());
					}
				}
				EmailUtils.sendMail(prop.getProperty("fromEmail"), prop.getProperty("toEmail"), prop.getProperty("emailName"), prop.getProperty("emailPassword"), "警报！警报！", data);
			} catch (Exception e) {
				EmailUtils.sendMail(prop.getProperty("fromEmail"), prop.getProperty("toEmail"), prop.getProperty("emailName"), prop.getProperty("emailPassword"), "执行异常出错", e.toString());
			}
		}
	}

	public String task(String username, String pass) throws Exception {

		URL url = null;
		String data = "<font color='red'>";
		try {
			url = new URL("http://www.jhost.cn/os/loginCheck.action?user=" + username + "&pass=" + pass + "&module=login");

			HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
			httpConn.setRequestMethod("GET");
			httpConn.setConnectTimeout(15000);
			httpConn.setReadTimeout(20000);
			httpConn.connect();
			if (httpConn.getResponseCode() == 200) {
				String sessionId = "";
				String cookieVal = null;
				String key = null;
				for (int i = 1; (key = httpConn.getHeaderFieldKey(i)) != null; i++) {
					// System.out.println(key + "-----"+
					// httpConn.getHeaderField(i));
					if (key.equalsIgnoreCase("set-cookie")) {
						cookieVal = httpConn.getHeaderField(i);
						cookieVal = cookieVal.substring(0, cookieVal.indexOf(";"));
						// System.out.println(cookieVal);
						String[] str = sessionId.split(";");
						boolean flag = false;
						for (int t = 0; t < str.length; t++) {
							if (str[t] == cookieVal)
								flag = true;
						}
						if (!flag) {
							sessionId = sessionId + cookieVal + ";";
						}
					}
				}
				sessionId = sessionId.substring(0, sessionId.length() - 1);
				url = new URL("http://www.jhost.cn/user/userControl.action?addDay=3&action=ADD_TIME");
				httpConn = (HttpURLConnection) url.openConnection();
				httpConn.setRequestMethod("GET");
				// System.out.println("second:" + sessionId);
				httpConn.setRequestProperty("Cookie", sessionId);
				httpConn.setDoOutput(true);
				httpConn.setDoInput(true);
				httpConn.setConnectTimeout(15000);
				httpConn.setUseCaches(false);
				data = Commons.fromDateH() + " 时刻的调用:<br>";
				data += Commons.readHtml(httpConn.getInputStream(), "UTF-8");
			} else {
				data += "jhost 于" + Commons.fromDateH() + "　返回服务器状态：" + httpConn.getResponseCode() + "　连接失败！！";
			}
		} catch (SocketTimeoutException e) {
			data += "jhost 于" + Commons.fromDateH() + " 连接超时:　" + e;
		} catch (Exception e) {
			data += "jhost 于" + Commons.fromDateH() + " 时刻的调用报错　" + e;
		}
		return data + "</font>";
	}
}
