package com.jhta.project.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Service;


@Service
public class RestService {
	public String post(String strUrl,String jsonString) {
		try {
			System.out.println(strUrl);
			URL url = new URL(strUrl);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setConnectTimeout(5000); //������ ����Ǵ� Timeout �ð� ����
			con.setReadTimeout(5000); // InputStream �о� ���� Timeout �ð� ����
			//con.addRequestProperty("x-api-key", RestTestCommon.API_KEY); //key�� ����
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json");
			con.setDoInput(true);
			con.setDoOutput(true); 
			con.setUseCaches(false);
			con.setDefaultUseCaches(false);

			OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
			wr.write(jsonString); 
			System.out.println("message ����...");
			wr.flush();

			StringBuilder sb = new StringBuilder();
			if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				BufferedReader br = new BufferedReader(
						new InputStreamReader(con.getInputStream(), "utf-8"));
				String line;
				while ((line = br.readLine()) != null) {
					sb.append(line).append("\n");
				}
				br.close();
				return sb.toString();
			} else {
				System.out.println(con.getResponseMessage());
				return null;
			}
		} catch (Exception e){
			System.err.println(e.toString());
			return null;
		}
	}
	
	
	public String get(String requestURL) {
		try {
			HttpClient client = HttpClientBuilder.create().build(); // HttpClient 생성
			HttpGet getRequest = new HttpGet(requestURL); //GET 메소드 URL 생성

			HttpResponse response = client.execute(getRequest);

			//Response 출력
			if (response.getStatusLine().getStatusCode() == 200) {
				ResponseHandler<String> handler = new BasicResponseHandler();
				String body = handler.handleResponse(response);
				System.out.println(body);
				return body.toString();
			} else {
				System.out.println("response is error : " + response.getStatusLine().getStatusCode());
				return null;
			}

		} catch (Exception e){
			System.err.println(e.toString());
			return null;
		}
	}

}
