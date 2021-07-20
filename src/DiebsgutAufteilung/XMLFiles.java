package DiebsgutAufteilung;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.xml.parsers.DocumentBuilder; 
import javax.xml.parsers.DocumentBuilderFactory; 
import javax.xml.parsers.ParserConfigurationException; 
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.Transformer;
import javax.xml.transform.stream.*;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLFiles {
	private DocumentBuilderFactory factory;
	private DocumentBuilder builder;
	private Document document; 
	
	private List<Diebsgut> diebsgueter = new ArrayList<>();
	
	XMLFiles(int numberFiles) {
		
		try
		{
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
			
		
			for (int anzFiles=0; anzFiles < numberFiles; anzFiles++)
			{
				
				Random rd = new Random(); // creating Random object
				// generate 1000 diebsgueter in an array
				for (int i=0; i <= 1000; i++) {
					double rand = rd.nextDouble() * 100;
					diebsgueter.add(new Diebsgut("item " + Integer.toString(i)  , rand));
				}
				
				document = builder.newDocument();
				
				Element root = document.createElement("diebsgueter");
				document.appendChild(root);
				for (Diebsgut diebsgut : diebsgueter) {
					Element xmlDiebsgut = document.createElement("diebsgut");
					Element name = document.createElement("name");
					name.appendChild(document.createTextNode(diebsgut.getName()));
					xmlDiebsgut.appendChild(name);

					Element wert = document.createElement("wert");
					wert.appendChild(document.createTextNode(String.valueOf(diebsgut.getWert())));
					xmlDiebsgut.appendChild(wert);	  
					root.appendChild(xmlDiebsgut);
				}
			
				TransformerFactory tranFactory = TransformerFactory.newInstance();
				Transformer aTransformer = tranFactory.newTransformer();

				DOMSource source = new DOMSource(document);
				String filename = "cooleDiebsgueter" + Integer.toString(anzFiles) + ".xml";
				FileWriter fos = new FileWriter(filename);
				StreamResult result = new StreamResult(fos);
				aTransformer.transform(source, result);
			       
				builder.reset();
			}
		}
		catch (ParserConfigurationException e) {
			e.printStackTrace();
    		}
		catch (IOException e) {
			e.printStackTrace();
	    	}
		catch (TransformerException ex) {
			System.out.println("Error outputting document");
	       	}
		}
	}
	
