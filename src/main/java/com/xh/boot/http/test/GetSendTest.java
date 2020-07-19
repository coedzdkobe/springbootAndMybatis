package com.xh.boot.http.test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.swing.text.html.parser.Entity;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class GetSendTest {
	
	@org.junit.Test
	public void Test() {
		
		String url = "http://localhost:8085/doGetControllerOne";
		
		//获取http客户端
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		
		//请求参数
		StringBuilder b = new StringBuilder();
		
		try {
			b.append("name="+URLEncoder.encode("奉晓慧","utf-8"));
			b.append("&");
			b.append("age=33");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		//创建get请求
		HttpGet httpGet = new HttpGet(url+"?"+b);
		
		//响应模型
		CloseableHttpResponse response = null;
		
		//配置信息
		RequestConfig requestConfig = null;
		try {
					requestConfig = RequestConfig.custom().setConnectTimeout(5000). //设置连接超时时间
					setConnectionRequestTimeout(5000).	//设置请求超时时间
					setSocketTimeout(5000)	//设置socket读写超时时间
					.setRedirectsEnabled(true).build();	//设置是否允许重定向  时间单位都是毫秒
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		httpGet.setConfig(requestConfig);//将上面的配置与用到这个get请求中
		
		try {
			//由客户端执行（发送）get请求
			response = httpClient.execute(httpGet);
			
			//从响应模型中获取响应实体
			HttpEntity responseEntity = response.getEntity();
			System.out.println("响应状态为："+response.getStatusLine());
			if(responseEntity != null ) {
				System.out.println("响应内容长度为："+responseEntity.getContentLength());
				System.out.println("responseEntity:" + responseEntity);
				System.out.println("响应内容："+EntityUtils.toString(responseEntity));
			}
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(response != null) {
				try {
					response.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(httpClient != null) {
				try {
					httpClient.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
	}
	
}
