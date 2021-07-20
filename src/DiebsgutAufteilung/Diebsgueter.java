package DiebsgutAufteilung;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Diebsgueter {
	
	private DocumentBuilderFactory factory;
	private DocumentBuilder builder;
	private Document document;
	private File eingabeXML;
	
	private List<Diebsgut> diebsgueter = new ArrayList<>();
	
	Diebsgueter(String dateiname)   {
		eingabeXML = new File(dateiname);
	try {
			readData();
		}
	    
	catch (ParserConfigurationException e) {
		e.printStackTrace();
		}
	catch (SAXException e) {
		e.printStackTrace();
		}
	catch (IOException e) {
		e.printStackTrace();
		}
	}

	
	public void printData()
	{
		for (Diebsgut stueck: diebsgueter)
            System.out.println(stueck.toString());
	}
	
	public List<Diebsgut> getDiesbgueter() {
		return diebsgueter;
	}
	
	private void readData() throws ParserConfigurationException,
    SAXException, IOException {
		factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
        document = builder.parse(eingabeXML);
        NodeList nodeList = document.getDocumentElement().getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) node;
                String name = elem.getElementsByTagName("name")
                        .item(0).getChildNodes().item(0).getNodeValue();
                Double wert = Double.parseDouble(elem.getElementsByTagName("wert")
                        .item(0).getChildNodes().item(0).getNodeValue());
                diebsgueter.add(new Diebsgut(name, wert));
            }
        }
	}
	

}
