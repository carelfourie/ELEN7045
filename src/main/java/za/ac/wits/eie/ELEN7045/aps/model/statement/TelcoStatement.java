package za.ac.wits.eie.ELEN7045.aps.model.statement;

import javax.persistence.Entity;

import za.ac.wits.eie.ELEN7045.aps.model.statement.base.Statement;

@Entity
public class TelcoStatement extends Statement {

	private String callCharges;
	private String serviceCharges;
	private String telephoneNumber;
	private String totalCallDuration;
	private String totalNumberOfCalls;

	public TelcoStatement() {
		super();
	}

	public TelcoStatement(Long id) {
		super(id);
	}

	public String getCallCharges() {
		return callCharges;
	}

	public String getServiceCharges() {
		return serviceCharges;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public String getTotalCallDuration() {
		return totalCallDuration;
	}

	public String getTotalNumberOfCalls() {
		return totalNumberOfCalls;
	}

	public void setCallCharges(String callCharges) {
		this.callCharges = callCharges;
	}

	public void setServiceCharges(String serviceCharges) {
		this.serviceCharges = serviceCharges;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public void setTotalCallDuration(String totalCallDuration) {
		this.totalCallDuration = totalCallDuration;
	}

	public void setTotalNumberOfCalls(String totalNumberOfCalls) {
		this.totalNumberOfCalls = totalNumberOfCalls;
	}

	@Override
	public String toString() {
		return String.format("{TELCO-SCRAPE [base-url: %s][date: %s][time: %s][return-code: %s][tel-number: %s][total due: %s]}", getBaseUrl(), getDate(), getTime(), getReturnCode(),
				getTelephoneNumber(), getTotalDue());
	}
}