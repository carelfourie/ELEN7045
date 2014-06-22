package za.ac.wits.eie.ELEN7045.aps.model.statement;

import javax.persistence.Entity;

import za.ac.wits.eie.ELEN7045.aps.model.statement.base.Statement;

@Entity
public class TelcoStatement extends Statement {

	private String telephoneNumber;
	private String serviceCharges;
	private String callCharges;
	private String totalNumberOfCalls;
	private String totalCallDuration;

	public TelcoStatement() {
		super();
	}

	public TelcoStatement(Long id) {
		super(id);
	}

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

	public String toString() {
		return String
				.format("{TELCO-SCRAPE [base-url: %s][date: %s][time: %s][return-code: %s][tel-number: %s][total due: %s]}",
						getBaseUrl(), getDate(), getTime(), getReturnCode(),
						getTelephoneNumber(), getTotalDue());
	}
}