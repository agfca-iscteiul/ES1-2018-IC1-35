package principal;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadXML {

	public void readFromXML() {
		File inputFile = new File("config.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			System.out.println("\n----- Search the XML document with xpath queries -----");
			// Query 1
			System.out.println("Serviço Twitter\n");
			XPathFactory xpathFactory = XPathFactory.newInstance();
			XPath xpath = xpathFactory.newXPath();
			XPathExpression exprAttribute = xpath.compile("/Serviços/Serviço/Tweet/@*");
			XPathExpression exprText = xpath.compile("/Serviços/Serviço/Tweet/text()");
			NodeList nA = (NodeList) exprAttribute.evaluate(doc, XPathConstants.NODESET);
			NodeList nT = (NodeList) exprText.evaluate(doc, XPathConstants.NODESET);
			int j=0;
			for (int i = 0; i < nA.getLength(); i++) {
				System.out.println(nA.item(i).getNodeName() + ":" + nA.item(i).getNodeValue());
				while(j!=nT.getLength()) {
					i++;
					System.out.println(nA.item(i).getNodeName() + ":" + nA.item(i).getNodeValue());
					System.out.println(nT.item(j).getTextContent());
					System.out.println("--------------------------------------------------------");
					break;
				}
				j++;
			}
		} catch (ParserConfigurationException | SAXException | IOException | XPathExpressionException e) {
			e.printStackTrace();
		}

	}

}
