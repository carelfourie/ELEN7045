package za.ac.wits.eie.ELEN7045.aps.scrape;

import java.util.StringTokenizer;

import org.apache.commons.lang3.text.WordUtils;

public abstract class AttributeTranslator {

	public static String translate(String pre, String elementName) {
		StringBuilder sb = new StringBuilder(pre);
		StringTokenizer tokens = new StringTokenizer(elementName, " -");
		while (tokens.hasMoreElements()) {
			sb.append(WordUtils.capitalizeFully(tokens.nextToken()));
		}
		return sb.toString();
	}
}