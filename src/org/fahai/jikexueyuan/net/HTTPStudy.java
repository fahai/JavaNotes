package org.fahai.jikexueyuan.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.fahai.common.BaseObject;

public class HTTPStudy extends BaseObject {

	// http://fanyi.youdao.com/openapi.do?keyfrom=httponnection&key=316264537&type=data&doctype=<doctype>&version=1.1&q=要翻译的文本
	public void readByGet() {
		try {
			URL url = new URL(
					"http://fanyi.youdao.com/openapi.do?keyfrom=httponnection&key=316264537&type=data&doctype=json&version=1.1&q=decorator");
			URLConnection conn = url.openConnection();
			InputStream is = conn.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "UTF-8");
			BufferedReader br = new BufferedReader(isr);
			String line;
			StringBuilder sb = new StringBuilder();
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			log.info(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void readByPost() {
		try {
			URL url = new URL("http://fanyi.youdao.com/openapi.do");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.addRequestProperty("encoding", "UTF-8");
			// 打开可读流的标识
			conn.setDoInput(true);
			// 打开可写流的标识
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");

			OutputStream os = conn.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
			bw.write("keyfrom=httponnection&key=316264537&type=data&doctype=xml&version=1.1&q=welcome");
			bw.flush();

			InputStream is = conn.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String line;
			StringBuilder sb = new StringBuilder();
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}

			log.info(sb.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void httpClientbyGet() {
		HttpClient client = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("http://www.baidu.com");
		try {
			HttpResponse response = client.execute(httpGet);
			HttpEntity entity = response.getEntity();
			String result = EntityUtils.toString(entity);
			log.info(result);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// http://fanyi.youdao.com/openapi.do?keyfrom=httponnection&key=316264537&type=data&doctype=<doctype>&version=1.1&q=要翻译的文本
	public void httpClientbyPost() {
		HttpClient client = HttpClients.createDefault();
		HttpPost post = new HttpPost("http://fanyi.youdao.com/openapi.do");
		List<BasicNameValuePair> parameters = new ArrayList<BasicNameValuePair>();
		parameters.add(new BasicNameValuePair("keyfrom", "httponnection"));
		parameters.add(new BasicNameValuePair("key", "316264537"));
		parameters.add(new BasicNameValuePair("type", "data"));
		parameters.add(new BasicNameValuePair("doctype", "json"));
		parameters.add(new BasicNameValuePair("version", "1.1"));
		parameters.add(new BasicNameValuePair("q", "welcome"));
		try {
			post.setEntity(new UrlEncodedFormEntity(parameters, "UTF-8"));
			HttpResponse response = client.execute(post);
			HttpEntity entity = response.getEntity();
			String result = EntityUtils.toString(entity);
			log.info(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
