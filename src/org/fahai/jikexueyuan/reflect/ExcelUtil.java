package org.fahai.jikexueyuan.reflect;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFShape;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;

/**
 * 使用反射的机制写一个通用的Excel导入/导出
 * @author fahai
 *
 */
public class ExcelUtil {
	
	/**
	 * 根据反射机制获取对象的所有属性
	 * 开启可读标志
	 * 将属性值一一写到单元格里面去
	 * @param data
	 * @param filename
	 */
	public void exportExcel(ArrayList data, String filename){
		File file = new File(filename);
		try {
			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet();
			for(int i=0; i<data.size(); i++){
				HSSFRow row = sheet.createRow(i);
				Object obj = data.get(i);
				Field[] fields = obj.getClass().getDeclaredFields();
				for(int j=0; j<fields.length; j++){
					fields[j].setAccessible(true);
					String value = String.valueOf(fields[j].get(obj));
					row.createCell(j).setCellValue(value);
				}
			}
			FileOutputStream out = new FileOutputStream(file);
			wb.write(out);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据反射机制获取该对象的所有属性
	 * 开启可读标志
	 * 读出Excel文件内容，逐行处理，一行就是一个对象的实例
	 * 逐列获取单元格的值，判断其数据类型，并set到对象对应属性
	 * @param clazz
	 * @param filename
	 * @return
	 */
	public ArrayList importExcel(Class clazz, String filename){
		ArrayList result = new ArrayList();
		File file = new File(filename);
		try {
			HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(file));
			HSSFSheet sheet = wb.getSheetAt(0);
			Integer rowNum = sheet.getLastRowNum();
			Field[] fields = clazz.getDeclaredFields();
			for(int i=0; i<rowNum; i++){
				Object obj = clazz.newInstance();
				for(int j=0; j<fields.length; j++){
					fields[j].setAccessible(true);
					HSSFCell value = sheet.getRow(i).getCell(j);
					if(fields[j].getType().toString().equals("class java.lang.Integer")){
						// 调用set方法需要指定参数的数据类型
						fields[j].set(obj, Integer.valueOf(value.toString()));
					}else if(fields[j].getType().toString().equals("class java.lang.String")){
						fields[j].set(obj, value.toString());
					}
				}
				result.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
