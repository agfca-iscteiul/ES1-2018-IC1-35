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

import principal.AbstractInfo;

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
	private FacebookApp facebook;
	private TwitterApp twitter;
	private MailApp outlook;

	public void createXMLFile(FacebookApp facebook,TwitterApp twitter,MailApp outlook) {
		this.facebook=facebook;
		this.twitter=twitter;
		this.outlook=outlook;
		System.out.println("A criar ficheiro XML\n");
		twitter.writeTwitterXML();
		facebook.writeFacebookXML();
		outlook.writeMailXML();
		System.out.println("\nFicheiro XML criado");
	}
	

	public void removeXMLFile() {
		File data = new File("config.xml");
		System.out.println(data.exists());
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
				Element twitter = (Element) child.item(x);
				if (twitter.getAttribute("Plataforma").equals("Twitter")) {
					root.removeChild(twitter);
				}
			}
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer t = tf.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new FileOutputStream("config.xml"));
			t.transform(source, result);
		} catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
			e.printStackTrace();
		}
	}

	public void removeFacebook() {
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
				if (facebook.getAttribute("Plataforma").equals("Facebook")) {
					root.removeChild(facebook);
				}
			}
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer t = tf.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new FileOutputStream("config.xml"));
			t.transform(source, result);
		} catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
			e.printStackTrace();
		}
	}

	public void removeOutlook() {
		File datebase = new File("config.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(datebase);
			Element root = doc.getDocumentElement();
			NodeList child = root.getElementsByTagName("Serviço");
			for (int x = 0; x < child.getLength(); x++) {
				Element outlook = (Element) child.item(x);
				if (outlook.getAttribute("Plataforma").equals("Mail")) {
					root.removeChild(outlook);
				}
			}
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer t = tf.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new FileOutputStream("config.xml"));
			t.transform(source, result);
		} catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
			e.printStackTrace();
		}
	}
	
	public void addTwitterInfo() {
		twitter.writeTwitterXML();
	}
	
	public void addFacebookInfo() {
		facebook.writeFacebookXML();;
	}
	
	public void addOutlookInfo() {
		outlook.writeMailXML();
	}
	public void readFromXML() {
		listaTwitter.clear();
		listaFacebook.clear();
		listaMail.clear();
		File inputFile = new File("config.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
//			System.out.println("\n----- Search the XML document with xpath queries -----");
			// Query 1
//			System.out.println("Ler do serviço Twitter\n");
			XPathFactory xpathFactory = XPathFactory.newInstance();
			XPath xpath = xpathFactory.newXPath();
			XPathExpression exprAttributeT = xpath.compile("/Serviços/Serviço/Tweet/@*");
			XPathExpression exprTextT = xpath.compile("/Serviços/Serviço/Tweet/text()");
			NodeList nAT = (NodeList) exprAttributeT.evaluate(doc, XPathConstants.NODESET);
			NodeList nTT = (NodeList) exprTextT.evaluate(doc, XPathConstants.NODESET);
			String autorT, tweet;
			Date dataT;
			SimpleDateFormat formatter = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
			int t = 0;
			for (int i = 0; i < nAT.getLength(); i++) {
				autorT = nAT.item(i).getNodeValue();
				while (t != nTT.getLength()) {
					i++;
					dataT = formatter.parse(nAT.item(i).getNodeValue());
					tweet = nTT.item(t).getTextContent();
					listaTwitter.add(new TwitterInfo(autorT, tweet, dataT));
					break;
				}
				t++;
			}
			// Query 2
//			System.out.println("\nLer do serviço Facebook\n\n");
			XPathExpression exprAttributeF = xpath.compile("/Serviços/Serviço/Post/@*");
			XPathExpression exprTextF = xpath.compile("/Serviços/Serviço/Post/text()");
			NodeList nAF = (NodeList) exprAttributeF.evaluate(doc, XPathConstants.NODESET);
			NodeList nTF = (NodeList) exprTextF.evaluate(doc, XPathConstants.NODESET);
			String autorF, post;
			Date dataF;
			int f = 0;
			for (int i = 0; i < nAF.getLength(); i++) {
				autorF = nAF.item(i).getNodeValue();
				while (f != nTF.getLength()) {
					i++;
					dataF = formatter.parse(nAF.item(i).getNodeValue());
					post = nTF.item(f).getTextContent();
					listaFacebook.add(new FacebookInfo(autorF, post, dataF));
					break;
				}
				f++;
			}
			// Query 3
//			System.out.println("\nLer do serviço Outlook\n\n");
			XPathExpression exprAttributeE = xpath.compile("/Serviços/Serviço/Mail/@*");
			XPathExpression exprTextE = xpath.compile("/Serviços/Serviço/Mail/text()");
			NodeList nAE = (NodeList) exprAttributeE.evaluate(doc, XPathConstants.NODESET);
			NodeList nTE = (NodeList) exprTextE.evaluate(doc, XPathConstants.NODESET);
			String autorM, mail;
			Date dataM;
			int e = 0;
			for (int i = 0; i < nAE.getLength(); i++) {
				autorM = nAE.item(i).getNodeValue();
				while (e != nTE.getLength()) {
					i++;
					dataM = formatter.parse(nAE.item(i).getNodeValue());
					mail = nTE.item(e).getTextContent();
					listaMail.add(new MailInfo(autorM, mail, dataM));
					break;
				}
				e++;
			}
		} catch (ParserConfigurationException | SAXException | IOException | XPathExpressionException | DOMException
				| ParseException e) {
			e.printStackTrace();
		}

	}


	public ArrayList<TwitterInfo> getListaTwitter() {
		return listaTwitter;
	}


	public ArrayList<FacebookInfo> getListaFacebook() {
		return listaFacebook;
	}


	public ArrayList<MailInfo> getListaMail() {
		return listaMail;
	}
	
	public String getContent() {
		this.readFromXML();
		ArrayList<AbstractInfo> lista=new ArrayList<AbstractInfo>();
		lista.addAll(listaTwitter);
		lista.addAll(listaFacebook);
		lista.addAll(listaMail);
		
		String result=new String();
		
		for (AbstractInfo info:lista) {
			result=result+("  Autor: "+info.getAutor()+"\n"+ "  Data :"+info.getData().toString()+"\n  "+info.getPost()+"\n"
					+"----------------------------------------------------------------------"+"\n");
		}
		
		return result;
		
	}

}
