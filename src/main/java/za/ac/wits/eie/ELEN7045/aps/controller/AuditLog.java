package za.ac.wits.eie.ELEN7045.aps.controller;

import java.util.Date;

import za.ac.wits.eie.ELEN7045.aps.model.APSUser;
import za.ac.wits.eie.ELEN7045.aps.model.Company;
import za.ac.wits.eie.ELEN7045.aps.model.ReturnCode;

public class AuditLog {
	  
	private String companyName;
	private String apsUserName;
	private String returnCode;
	private Date date;
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getApsUserName() {
		return apsUserName;
	}
	public void setApsUserName(String apsUserName) {
		this.apsUserName = apsUserName;
	}
	public String getReturnCode() {
		return returnCode;
	}
	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	  
}
