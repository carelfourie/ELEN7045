package za.ac.wits.eie.ELEN7045.aps.scrape;

import java.util.Collection;
import java.util.Vector;

public class ScrapeSession {

	private String baseUrl;
	private String date;
	private String time;
	private String returnCode;
	private Vector<Datapair> datapairs = new Vector<Datapair>();

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public void addDatapair(Datapair datapair) {
		this.datapairs.add(datapair);
	}

	public Collection<Datapair> getDatapairs() {
		return datapairs;
	}

	public String toString() {
		return String
				.format("{SCRAPE-SESSION [base-url: %s][date: %s][time: %s][return-code: %s][datapairs: %d]}",
						getBaseUrl(), getDate(), getTime(), getReturnCode(),
						getDatapairs().size());
	}
}
