package za.ac.wits.eie.ELEN7045.aps.scrape;

import java.util.ArrayList;
import java.util.List;

public class ScrapeSession {

	private String baseurl;

	private List<Datapair> datapairs = new ArrayList<Datapair>();

	private String date;

	private String returncode;

	private String time;

	public void addDatapair(Datapair datapair) {
		datapairs.add(datapair);
	}

	public String getBaseurl() {
		return baseurl;
	}

	public List<Datapair> getDatapairs() {
		return datapairs;
	}

	public String getDate() {
		return date;
	}

	public String getReturncode() {
		return returncode;
	}

	public String getTime() {
		return time;
	}

	public void setBaseurl(String baseurl) {
		this.baseurl = baseurl;
	}

	public void setDatapairs(List<Datapair> datapairs) {
		this.datapairs = datapairs;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setReturncode(String returncode) {
		this.returncode = returncode;
	}

	public void setTime(String time) {
		this.time = time;
	}

}