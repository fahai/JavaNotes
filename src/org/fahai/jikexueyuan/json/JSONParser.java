package org.fahai.jikexueyuan.json;

import java.io.FileReader;

import org.fahai.common.BaseObject;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JSONParser extends BaseObject {
	
	/**
	 * 使用gson读json文件
	 * @param filename
	 */
	public void readJSON(String filename) {
		JsonParser parser = new JsonParser();
		try {
			JsonObject json = (JsonObject) parser.parse(new FileReader(filename));
			log.info("cat = " + json.get("cat").getAsString());
			log.info("pop = " + json.get("pop").getAsBoolean());
			JsonArray array = json.get("language").getAsJsonArray();
			for(int i=0; i<array.size()-1; i++){
				log.info("--------------------");
				JsonObject item = array.get(i).getAsJsonObject();
				log.info("id=" + item.get("id").getAsInt());
				log.info("name=" + item.get("name").getAsString());
				log.info("ide=" + item.get("ide").getAsString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * 使用gson写json格式的文件
	 * @param filename
	 */
	public void writeJSON(String filename) {
		JsonObject root = new JsonObject();
		root.addProperty("cat", "it");
		root.addProperty("pop", true);
		
		JsonArray array = new JsonArray();
		JsonObject lan1 = new JsonObject();
		lan1.addProperty("id", 1);
		lan1.addProperty("name", "java");
		lan1.addProperty("ide", "Eclipse");
		
		JsonObject lan2 = new JsonObject();
		lan2.addProperty("id", 2);
		lan2.addProperty("name", "swift");
		lan2.addProperty("ide", "Xcode");
		
		JsonObject lan3 = new JsonObject();
		lan3.addProperty("id", 3);
		lan3.addProperty("name", "delphi");
		lan3.addProperty("ide", "Delphi");
		
		array.add(lan1);
		array.add(lan2);
		array.add(lan3);
		root.add("language", array);
		log.info(root.toString());
	}
	
	public static void main(String[] args) {
		JSONParser parser = new JSONParser();
		parser.readJSON("src\\org\\fahai\\jikexueyuan\\json\\test.json");
	}

}
