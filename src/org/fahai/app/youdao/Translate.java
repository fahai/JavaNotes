package org.fahai.app.youdao;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.Set;

import org.fahai.common.BaseObject;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

/**
 * 描述：
 * 
 * @author 449631
 * @since 1.0
 */
public class Translate extends BaseObject{
	
	public String readByGet(String keyword) {
		StringBuilder sb = new StringBuilder();
		try {
			String urlStr = "http://fanyi.youdao.com/openapi.do?keyfrom=httponnection&key=316264537&type=data&doctype=json&version=1.1&q=" + keyword.trim();
			URL url = new URL(urlStr);
			URLConnection conn = url.openConnection();
			InputStream is = conn.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "UTF-8");
			BufferedReader br = new BufferedReader(isr);
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
//			log.info(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	public String parser(String jsonData){
		StringBuilder sb = new StringBuilder();
		JsonParser parser = new JsonParser();
		try {
			JsonObject json = (JsonObject) parser.parse(jsonData);
			int isError = json.get("errorCode").getAsInt();
			if(isError == 0){
				sb.append("translation: ");
				sb.append(json.get("translation").getAsString());
				sb.append("\n");
				JsonObject basic = json.get("basic").getAsJsonObject();
				sb.append("explains: ");
				sb.append(basic.get("explains").getAsJsonArray().toString());
				sb.append("\n");
				sb.append("web: \n");
				JsonArray web = json.get("web").getAsJsonArray();
				for(JsonElement element : web){
					JsonObject obj = element.getAsJsonObject();
					sb.append("\t");
					sb.append(obj.get("key").getAsString());
					sb.append(": ");
					sb.append("\t");
					sb.append(obj.get("value").getAsJsonArray().toString());
					sb.append("\n");
				}
			}else{
				return "error";
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return sb.toString();
	}
	
	public static void main(String[] args){
		Translate tr = new Translate();
		String jsonData = tr.readByGet(args[0]);
		String result = tr.parser(jsonData);
		System.out.println(result);
	}

}
