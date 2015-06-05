package org.fahai.jikexueyuan.xml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.dom4j.Attribute;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
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
	
	/**
	 * 使用dom4j读xml文件
	 * 参考dom4j的QuickStart
	 * void
	 */
	public void dom4jReadXML(){
		SAXReader reader = new SAXReader();
		File xmlFile = new File("src\\org\\fahai\\jikexueyuan\\xml\\web.xml");
		try {
			org.dom4j.Document doc = reader.read(xmlFile);
			org.dom4j.Element root = doc.getRootElement();
			for(Iterator i=root.elementIterator(); i.hasNext(); ){
				org.dom4j.Element element = (org.dom4j.Element)i.next();
				log.info(element.asXML());
			}        
			
			// iterate through child elements of root with element name "foo"
	        for ( Iterator i = root.elementIterator( "filter" ); i.hasNext(); ) {
	        	org.dom4j.Element filter = (org.dom4j.Element) i.next();
	            log.info(filter.asXML());
	        }

	        // iterate through attributes of root 
	        for ( Iterator i = root.attributeIterator(); i.hasNext(); ) {
	            Attribute attribute = (Attribute) i.next();
	            log.info(attribute.getName());
	        }
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 使用dom4j写xml文件
	 * 参考dom4j的QuickStart
	 * void
	 */
	public void dom4jWriteXML(){
		org.dom4j.Document doc = DocumentHelper.createDocument();
		org.dom4j.Element root = doc.addElement("root");
		org.dom4j.Element author1 = root.addElement("author")
			.addAttribute("name", "fahai")
			.addAttribute("location", "CN")
			.addText("handsome");
		org.dom4j.Element author2 = root.addElement("author")
			.addAttribute("name", "dashi")
			.addAttribute("location", "CN")
			.addText("also handsome");
		try {
			// Pretty print the document to file
			OutputFormat format = OutputFormat.createPrettyPrint();
			XMLWriter writer = new XMLWriter(new FileWriter("src\\org\\fahai\\jikexueyuan\\xml\\fahai.xml"), format);
			writer.write(doc);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
