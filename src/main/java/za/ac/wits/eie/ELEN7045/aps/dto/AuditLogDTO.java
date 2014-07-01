package za.ac.wits.eie.ELEN7045.aps.dto;

import java.util.Date;

public class AuditLogDTO {

	private String apsUserName;

	private String companyName;

	private Date date;

	private String returnCode;

	public String getApsUserName() {
		return apsUserName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public Date getDate() {
		return date;
	}

	public String getReturnCode() {
		return returnCode;
	}

	public void setApsUserName(String apsUserName) {
		this.apsUserName = apsUserName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}
}
