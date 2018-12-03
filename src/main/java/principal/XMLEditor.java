package principal;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLEditor {

	private ArrayList<TwitterInfo> listaTwitter = new ArrayList<TwitterInfo>();
	private ArrayList<FacebookInfo> listaFacebook = new ArrayList<FacebookInfo>();
	private ArrayList<MailInfo> listaMail = new ArrayList<MailInfo>();
	private FacebookApp facebook = new FacebookApp();
	private TwitterApp twitter = new TwitterApp();
	private MailApp outlook = new MailApp();

	public void createXMLFile() {
		System.out.println("A criar ficheiro XML\n");
		facebook.runFacebook();
		twitter.runTwitter();
		outlook.runMail();
		twitter.writeTwitterXML();
		facebook.writeFacebookXML();
		outlook.writeMailXML();
		System.out.println("\nFicheiro XML criado");
	}

	public void removeXMLFile() {
		File data = new File("config.xml");
		if (data.delete()) {
			System.out.println("O ficheiro XML foi removido");
		} else {
			System.out.println("Não existe ficheiro XML para ser removido");
		}
	}

	public void removeTwitter() {
		File datebase = new File("config.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(datebase);
			Element root = doc.getDocumentElement();
			NodeList child = root.getElementsByTagName("Serviço");
			for (int x = 0; x < child.getLength(); x++) {
				Element facebook = (Element) child.item(x);
				if (facebook.getAttribute("Plataforma").equals("Twitter")) {
					root.removeChild(facebook);
				}
			}
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer t = tf.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new FileOutputStream("config.xml"));
			t.transform(source, result);
		} catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

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
			String autor, tweet;
			Date data;
			SimpleDateFormat formatter = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
			int t = 0;
			for (int i = 0; i < nAT.getLength(); i++) {
				autor = nAT.item(i).getNodeValue();
				while (t != nTT.getLength()) {
					i++;
					data = formatter.parse(nAT.item(i).getNodeValue());
					tweet = nTT.item(t).getTextContent();
					listaTwitter.add(new TwitterInfo(autor, tweet, data));
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
		} catch (ParserConfigurationException | SAXException | IOException | XPathExpressionException | DOMException
				| ParseException e) {
			e.printStackTrace();
		}

	}

}
