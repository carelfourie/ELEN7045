package za.ac.wits.eie.ELEN7045.aps.scrape;

/*
 * This class enables the use of the below fields.
 * 
 * Telco Service Providers
 * -----------------------
 * Telephone number
 * Service charges
 * Call charges
 * Total number of calls
 * Total call duration
 */

public class TelcoScrape extends ScrapeSessionInfo {

	private String telephoneNumber;
	private String serviceCharges;
	private String callCharges;
	private String totalNumberOfCalls;
	private String totalCallDuration;

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getServiceCharges() {
		return serviceCharges;
	}

	public void setServiceCharges(String serviceCharges) {
		this.serviceCharges = serviceCharges;
	}

	public String getCallCharges() {
		return callCharges;
	}

	public void setCallCharges(String callCharges) {
		this.callCharges = callCharges;
	}

	public String getTotalNumberOfCalls() {
		return totalNumberOfCalls;
	}

	public void setTotalNumberOfCalls(String totalNumberOfCalls) {
		this.totalNumberOfCalls = totalNumberOfCalls;
	}

	public String getTotalCallDuration() {
		return totalCallDuration;
	}

	public void setTotalCallDuration(String totalCallDuration) {
		this.totalCallDuration = totalCallDuration;
	}

	@Override
	public String toString() {
		return String
				.format("{TELCO-SCRAPE [base-url: %s][date: %s][time: %s][return-code: %s]}",
						getBaseUrl(), getDate(), getTime(), getReturnCode());
	}
}
