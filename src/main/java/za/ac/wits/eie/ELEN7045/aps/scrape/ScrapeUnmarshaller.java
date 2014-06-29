package za.ac.wits.eie.ELEN7045.aps.scrape;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import za.ac.wits.eie.ELEN7045.aps.dto.ScrapeResultDTO;

public class ScrapeUnmarshaller {

	public static ScrapeResultDTO domUnmarshaller(String filename) {
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document doc = documentBuilder.parse(new File(filename));
			doc.getDocumentElement().normalize();

			ScrapeResultDTO scrapeResult = new ScrapeResultDTO();
			scrapeResult.setBaseurl(getTagValue(doc.getDocumentElement().getElementsByTagName("base-url")));
			scrapeResult.setDate(getTagValue(doc.getDocumentElement().getElementsByTagName("date")));
			scrapeResult.setTime(getTagValue(doc.getDocumentElement().getElementsByTagName("time")));
			scrapeResult.setReturncode(getTagValue(doc.getDocumentElement().getElementsByTagName("return-code")));

			NodeList nodeList = doc.getElementsByTagName("datapair");
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					Datapair datapair = new Datapair();
					datapair.setText(getTagValue("text", element));
					datapair.setValue(getTagValue("value", element));
					scrapeResult.addDatapair(datapair);
				}
			}
			return scrapeResult;
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings("unused")
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
		NodeList nodeList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
		Node nodeValue = nodeList.item(0);
		return nodeValue.getNodeValue();
	}
}