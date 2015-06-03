package org.fahai.jikexueyuan.xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.fahai.common.BaseObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * XML文件的读写
 * 文件准备tomcat的webapp的例子web.xml
 * @author fahai
 *
 */
public class XMLParser extends BaseObject{
	
	/**
	 * 
	 * @param filename
	 * src\org\fahai\jikexueyuan\xml\web.xml
	 * TODO 思考为什么使用工厂模式	
	 */
	public void readXML(String filename){
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(new File(filename));
			Element root = doc.getDocumentElement();
			NodeList nodes = root.getElementsByTagName("listener");
			for(int i=0; i<nodes.getLength(); i++){
				Node node = nodes.item(i);
				if(node instanceof Element){
					log.info(node.getTextContent());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void writeXML(String srcName, String destName){
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(new File(srcName));
			Element root = doc.getDocumentElement();
			Element filter = doc.createElement("filter");
			Element filterName = doc.createElement("filter-name");
			filterName.setTextContent("fahai filter");
			Element filterClass = doc.createElement("filter-class");
			filterClass.setTextContent("org.fahai.jikexueyuan.xml");
			filter.appendChild(filterName);
			filter.appendChild(filterClass);
			root.appendChild(filter);
			
			TransformerFactory tfactory = TransformerFactory.newInstance();
			Transformer trans = tfactory.newTransformer();
			trans.transform(new DOMSource(doc), new StreamResult(new File(destName)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void dom4jReadXML(){
		
	}
	
	public void dom4jWriteXML(){
		
	}

}
