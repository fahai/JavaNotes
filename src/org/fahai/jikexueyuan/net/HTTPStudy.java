package org.fahai.jikexueyuan.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.fahai.common.BaseObject;

public class HTTPStudy extends BaseObject {
	
	// http://fanyi.youdao.com/openapi.do?keyfrom=httponnection&key=316264537&type=data&doctype=<doctype>&version=1.1&q=要翻译的文本
	public void readByGet(){
		try {
			URL url = new URL("http://fanyi.youdao.com/openapi.do?keyfrom=httponnection&key=316264537&type=data&doctype=xml&version=1.1&q=welcome");
			URLConnection conn = url.openConnection();
			InputStream is = conn.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String line;
			StringBuilder sb = new StringBuilder();
			while((line=br.readLine()) != null){
				sb.append(line);
			}
			log.info(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void readByPost(){
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
			while((line=br.readLine()) != null){
				sb.append(line);
			}
			
			log.info(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
