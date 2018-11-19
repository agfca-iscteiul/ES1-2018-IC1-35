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
			XPathExpression exprAttributeT = xpath.compile("/Serviços/Serviço/Tweet/@*");
			XPathExpression exprTextT = xpath.compile("/Serviços/Serviço/Tweet/text()");
			NodeList nAT = (NodeList) exprAttributeT.evaluate(doc, XPathConstants.NODESET);
			NodeList nTT = (NodeList) exprTextT.evaluate(doc, XPathConstants.NODESET);
			int t = 0;
			for (int i = 0; i < nAT.getLength(); i++) {
				System.out.println(nAT.item(i).getNodeName() + ":" + nAT.item(i).getNodeValue());
				while (t != nTT.getLength()) {
					i++;
					System.out.println(nAT.item(i).getNodeName() + ":" + nAT.item(i).getNodeValue());
					System.out.println(nTT.item(t).getTextContent());
					System.out.println("--------------------------------------------------------");
					break;
				}
				t++;
			}
			// Query 2
			System.out.println("\nServiço Facebook\n\n");
			XPathExpression exprAttributeF = xpath.compile("/Serviços/Serviço/Post/@*");
			XPathExpression exprTextF = xpath.compile("/Serviços/Serviço/Post/text()");
			NodeList nAF = (NodeList) exprAttributeF.evaluate(doc, XPathConstants.NODESET);
			NodeList nTF = (NodeList) exprTextF.evaluate(doc, XPathConstants.NODESET);
			int f = 0;
			for (int i = 0; i < nAF.getLength(); i++) {
				System.out.println(nAF.item(i).getNodeName() + ":" + nAF.item(i).getNodeValue());
				while (f != nTF.getLength()) {
					i++;
					System.out.println(nAF.item(i).getNodeName() + ":" + nAF.item(i).getNodeValue());
					System.out.println(nTF.item(f).getTextContent());
					System.out.println("--------------------------------------------------------");
					break;
				}
				f++;
			}
			// Query 3
			System.out.println("\nServiço Email\n\n");
			XPathExpression exprAttributeE = xpath.compile("/Serviços/Serviço/Mail/@*");
			XPathExpression exprTextE = xpath.compile("/Serviços/Serviço/Mail/text()");
			NodeList nAE = (NodeList) exprAttributeE.evaluate(doc, XPathConstants.NODESET);
			NodeList nTE = (NodeList) exprTextE.evaluate(doc, XPathConstants.NODESET);
			int e = 0;
			for (int i = 0; i < nAE.getLength(); i++) {
				System.out.println(nAE.item(i).getNodeName() + ":" + nAE.item(i).getNodeValue());
				while (e != nTE.getLength()) {
					i++;
					System.out.println(nAE.item(i).getNodeName() + ":" + nAE.item(i).getNodeValue());
					System.out.println(nTE.item(e).getTextContent());
					System.out.println("--------------------------------------------------------");
					break;
				}
				e++;
			}
		} catch (ParserConfigurationException | SAXException | IOException | XPathExpressionException e) {
			e.printStackTrace();
		}

	}

}
