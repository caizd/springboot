package cn.caizhongdong.util;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;


import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpclientUtil {
	
	public static Map<?,?> getJson(String url) throws Exception {
		return (Map<?,?>)getJson(url, Map.class);
	}
	
	public static <T> T getJson(String url, Class<T> clazz) throws Exception {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet httpRequest = new HttpGet(url);
		CloseableHttpResponse httpResponse = client.execute(httpRequest);
		HttpEntity httpEntity = httpResponse.getEntity();
		String str = EntityUtils.toString(httpEntity);
		EntityUtils.consume(httpEntity);
		httpResponse.close();
		ObjectMapper mapper = new ObjectMapper();
		return (T) mapper.readValue(str, clazz);
	}
	
	public static String getString (String url) throws ClientProtocolException, IOException {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet httpRequest = new HttpGet(url);
		CloseableHttpResponse httpResponse = client.execute(httpRequest);
		HttpEntity httpEntity = httpResponse.getEntity();
		String str = EntityUtils.toString(httpEntity);
		EntityUtils.consume(httpEntity);
		httpResponse.close();
		return str;
	}
	
	
	public static String postJsonData (String url, String json) throws Exception {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost method = new HttpPost(url);
		method.addHeader("Content-type","application/json; charset=utf-8");  
        method.setHeader("Accept", "application/json");  
        method.setEntity(new StringEntity(json.toString(),"utf-8"));
		CloseableHttpResponse httpResponse = client.execute(method);
		HttpEntity httpEntity = httpResponse.getEntity();
		String str = EntityUtils.toString(httpEntity);
		EntityUtils.consume(httpEntity);
		httpResponse.close();
		return str;
	}
	
	public static File downloadWeixinImage (String url, String json, File imgFile) throws Exception {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost method = new HttpPost(url);
		method.addHeader("Content-type","application/json; charset=utf-8");  
        method.setHeader("Accept", "application/json");  
        method.setEntity(new StringEntity(json.toString(),"utf-8"));
		CloseableHttpResponse httpResponse = client.execute(method);
		HttpEntity httpEntity = httpResponse.getEntity();
		if (httpResponse.getEntity().getContentLength() < 1024) {
        	// 小于1k认为不是图片
			throw new Exception("不是图片:" + EntityUtils.toString(httpEntity));
        }
		
		InputStream inputStream = httpEntity.getContent();
		OutputStream outputStream = new FileOutputStream(imgFile);
		int length = 0;
        byte[] buff = new byte[2048];
        while ((length = inputStream.read(buff)) != -1) {
            outputStream.write(buff, 0, length);
        }
        inputStream.close();
        outputStream.close();

		EntityUtils.consume(httpEntity);
		return imgFile;
	}
	
}
