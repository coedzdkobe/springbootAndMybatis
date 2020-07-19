package com.xh.boot.http.test;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class UploadFilesTest {

	@Test
	public void test() throws ClientProtocolException, IOException {
		
		HttpClient httpClient = HttpClientBuilder.create().build();
		
		HttpPost post = new HttpPost("http://127.0.0.1:8085/file");
		
		HttpResponse response = null;
		
		MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
		
		// 第一个文件
		String filesKey = "files";
		
		File file1 = new File("D:\\tes.txt");
		
		File file2 = new File("D:\\oop.txt");
		
		multipartEntityBuilder.addBinaryBody(filesKey, file1);
		multipartEntityBuilder.addBinaryBody(filesKey, file2);
		
		ContentType contentType = ContentType.create("text/plain",Charset.forName("UTF-8"));
		multipartEntityBuilder.addTextBody("name", "奉晓慧",contentType);
		multipartEntityBuilder.addTextBody("age", "20",contentType);
	
		HttpEntity httpEntity = multipartEntityBuilder.build();
		
		post.setEntity(httpEntity);
		
		response = httpClient.execute(post);
		
		HttpEntity resEntity = response.getEntity();
		
		System.out.println("响应状态："+response.getStatusLine());
		
		if(resEntity != null) {
			System.out.println("resEntity--:"+resEntity);
			System.out.println("响应长度 为："+resEntity.getContentLength());
			String resStr = EntityUtils.toString(resEntity,StandardCharsets.UTF_8);
			System.out.println("响应内容为：--"+resStr);
		}
		
		if(response != null) {
			try {
				((Closeable) response).close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(httpClient != null) {
			try {
				((Closeable) httpClient).close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
