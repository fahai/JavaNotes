package org.fahai.app.spider.lunch;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.fahai.app.spider.lunch.bean.Meal;
import org.fahai.app.spider.lunch.bean.Shop;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 描述：
 * 
 * <pre>HISTORY
 * ****************************************************************************
 *  ID   DATE           PERSON          REASON
 *  1    2015年6月1日      449631         Create
 * ****************************************************************************
 * </pre>
 * @author 449631
 * @since 1.0
 */
public class Lunch {
	
	private static Logger logger = Logger.getLogger(Lunch.class);
	
	/**
	 * 根据html文件获取店铺的名字
	 * @param file
	 * @return
	 * String
	 */
	public String getShopName(File file) {
		Document doc = null;
		try {
			doc = Jsoup.parse(file, "UTF-8", "http://");
		} catch (IOException e) {
			e.printStackTrace();
		}
		Elements titles = doc.select("li.xtit");
		String shopName = titles.get(0).text();
		int index = shopName.indexOf("(");
		if(index > 0){
			shopName = shopName.substring(0, index);
		}
		index = shopName.indexOf(".");
		if(index > 0){
			shopName = shopName.substring(0, index);
		}
		return shopName;
	}

	/**
	 * 根据html文件获取所有的饭菜名字
	 * @param file
	 * @return
	 * ArrayList<Meal>
	 */
	public ArrayList<Meal> getDishNames(File file){
		ArrayList<Meal> meals = new ArrayList<Meal>();
		Document doc = null;
		try {
			doc = Jsoup.parse(file, "UTF-8", "http://");
		} catch (IOException e) {
			e.printStackTrace();
		}
		Elements lis = doc.select("#id_alllist li");
		for(Element li : lis){
			Meal meal = new Meal();
			if(li.childNodes().size() > 1){
				String name = li.child(0).text();
				int index = name.indexOf("已售");
				name = name.substring(0, index-1);
				meal.setName(name);
				meal.setPrice(li.child(2).text());
				meals.add(meal);
			}
		}
		return meals;
	}
	
	/**
	 * 遍历目录下的所有文件，并提取html文件中的店铺名字和饭菜名字
	 * @param directory
	 * @return
	 * ArrayList<Shop>
	 */
	public ArrayList<Shop> getShops(File directory){
		ArrayList<Shop> shops = new ArrayList<Shop>();
		if(!directory.isDirectory()){
			logger.error("not directory!");
			return shops;
		}
		File[] files = directory.listFiles();
		for(File file : files){
			Shop shop = new Shop();
			shop.setName(getShopName(file));
			shop.setMeals(getDishNames(file));
			shops.add(shop);
		}
		return shops;
	}
	
	/**
	 * 输出格式为markdown的文档
	 * @param meals
	 * @return
	 * String
	 */
	public boolean exportMd(ArrayList<Shop> shops){
		boolean result = false;
		StringBuilder sb = new StringBuilder();
		sb.append("# 菜单  \n\n");
		sb.append("标签（空格分隔）：lunch  \n\n");
		sb.append("---  \n\n");
		for(Shop shop : shops){
			sb.append( "## " + shop.getName() + "  \n");
			ArrayList<Meal> meals = shop.getMeals();
			for(int i=0; i<meals.size(); i++){
				sb.append(" | " + shop.getName());
				sb.append(" | " + meals.get(i).getName());
				sb.append(" | " + meals.get(i).getPrice() + " |  \n");
				if(i == 0){
					sb.append("| ------ | ------ | ------ | \n");
				}
			}
			sb.append("\n\n");
		}
		File file = new File("./others/eat.md");
		try {
			FileWriter fw = new FileWriter(file);
			fw.write(sb.toString());
			fw.flush();
			fw.close();
			result = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
}
