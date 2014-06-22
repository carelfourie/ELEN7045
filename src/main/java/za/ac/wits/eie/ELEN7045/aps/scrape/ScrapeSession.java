package za.ac.wits.eie.ELEN7045.aps.scrape;

import java.util.ArrayList;
import java.util.List;

public class ScrapeSession {

	private String baseurl;
	
	private String date;
	
	private String time;
	
	private String returncode;
	
	private List<Datapair> datapairs = new ArrayList<Datapair>();

	public String getBaseurl() {
		return baseurl;
	}

	public void setBaseurl(String baseurl) {
		this.baseurl = baseurl;
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

	public String getReturncode() {
		return returncode;
	}

	public void setReturncode(String returncode) {
		this.returncode = returncode;
	}

	public List<Datapair> getDatapairs() {
		return datapairs;
	}

	public void setDatapairs(List<Datapair> datapairs) {
		this.datapairs = datapairs;
	}
	
	public void addDatapair(Datapair datapair) {
		datapairs.add(datapair);
	}
	
}