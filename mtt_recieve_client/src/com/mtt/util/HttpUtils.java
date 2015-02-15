package com.mtt.util;

import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

public class HttpUtils {

	public static String getMessageByUrl(String url) {
		String recieveString = "";
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(url);
		ResponseHandler<String> responseHandler = new BasicResponseHandler();

		try {
			recieveString = httpClient.execute(httpGet, responseHandler);
			recieveString = new String(recieveString.getBytes());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		httpClient.getConnectionManager().shutdown();
		return recieveString;
	}

}
