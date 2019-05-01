package com.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpTest {

	public static void main(String[] args) {
		getJSON("https://jsonplaceholder.typicode.com/posts", null);
	}

	private static String getJSON(String endpoint, String access_token) {

		String result = null;

		try {

			URL url = new URL(endpoint);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestProperty("Authorization", "Bearer " + access_token);
			connection.setRequestProperty("Accept", "application/json");
			connection.setRequestMethod("GET");

			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder builder = new StringBuilder();
			char[] buf = new char[1000];
			int l = 0;
			while (l >= 0) {
				builder.append(buf, 0, l);
				l = in.read(buf);
			}
			in.close();
			result = builder.toString();
			
			System.out.println(result);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}
	
//	private String patchRequest(String url, String body, String access_token) {
//
//		try {
//
//			StringEntity params = new StringEntity(body, "UTF-8");
//
//			CloseableHttpClient httpClient = HttpClients.createDefault();
//
//			HttpPatch httpPatch = new HttpPatch(new URI(url));
//			httpPatch.setHeader("Authorization", "Bearer " + access_token);
//			httpPatch.setHeader("Content-Type", "application/json");
//			httpPatch.setHeader("Accept", "application/json");
//			httpPatch.setEntity(params);
//
//			CloseableHttpResponse response = httpClient.execute(httpPatch);
//
//			String responseString = EntityUtils.toString(response.getEntity(), "UTF-8");
//
//			return responseString;
//
//		} catch (ClientProtocolException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (URISyntaxException e) {
//			e.printStackTrace();
//		}
//
//		return "something went wrong while updating grades";
//	}

	private String postJSON(String endpoint, String bodyJson, String access_token, String requestMethod) {

		String result = null;

		try {

			URL url = new URL(endpoint);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestProperty("Authorization", "Bearer " + access_token);
			connection.setRequestProperty("Accept", "application/json");

			connection.setRequestMethod(requestMethod);

			connection.setDoOutput(true);
			OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
			out.write(bodyJson);
			out.close();

			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder builder = new StringBuilder();
			char[] buf = new char[1000];
			int l = 0;
			while (l >= 0) {
				builder.append(buf, 0, l);
				l = in.read(buf);
			}
			in.close();
			result = builder.toString();
		} catch (Exception ex) {
		}
		return result;
	}
}
