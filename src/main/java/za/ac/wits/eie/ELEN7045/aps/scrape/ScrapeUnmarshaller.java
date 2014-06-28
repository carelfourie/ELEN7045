package za.ac.wits.eie.ELEN7045.aps.scrape;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ScrapeUnmarshaller {

	public static ScrapeSession domUnmarshaller(String filename) {
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(new File(filename));
			doc.getDocumentElement().normalize();

			ScrapeSession ss = new ScrapeSession();
			ss.setBaseurl(getTagValue(doc.getDocumentElement().getElementsByTagName("base-url")));
			ss.setDate(getTagValue(doc.getDocumentElement().getElementsByTagName("date")));
			ss.setTime(getTagValue(doc.getDocumentElement().getElementsByTagName("time")));
			ss.setReturncode(getTagValue(doc.getDocumentElement().getElementsByTagName("return-code")));

			NodeList nodeList = doc.getElementsByTagName("datapair");
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					Datapair datapair = new Datapair();
					datapair.setText(getTagValue("text", element));
					datapair.setValue(getTagValue("value", element));
					ss.addDatapair(datapair);
				}
			}
			return ss;
		} catch (Exception e) {
			return null;
		}
	}

	private static String getTagValue(NodeList nodeList) {
		if (nodeList == null) {
			return null;
		}
		for (int i = 0; i < nodeList.getLength(); i++) {
			return nodeList.item(i).getTextContent();
		}
		return null;
	}

	private static String getTagValue(String sTag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
		Node nValue = nlList.item(0);
		return nValue.getNodeValue();
	}
}