package za.ac.wits.eie.ELEN7045.aps.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import za.ac.wits.eie.ELEN7045.aps.model.base.BaseDomainEntity;

@Entity
public class ScrapingEventAuditLog extends BaseDomainEntity<Long> {
	
	  @OneToOne
	  private APSUser apsUser;
	  
	  @OneToOne
	  private Company company;
	  
	  @OneToOne
	  private ReturnCode returnCode;
	  
	  @Column(name = "scrapeDate")
	  private Date scrapeDate;
	  
	  
	  
	public ScrapingEventAuditLog() {
		super();
	}
	public ScrapingEventAuditLog(Long id) {
		super(id);
	}
	public APSUser getApsUser() {
		return apsUser;
	}
	public Company getCompany() {
		return company;
	}
	public ReturnCode getReturnCode() {
		return returnCode;
	}
	public Date getScrapeDate() {
		return scrapeDate;
	}
	
	
	public void setApsUser(APSUser apsUser) {
		this.apsUser = apsUser;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public void setReturnCode(ReturnCode returnCode) {
		this.returnCode = returnCode;
	}
	public void setScrapeDate(Date scrapeDate) {
		this.scrapeDate = scrapeDate;
	}
	  
	
	
	 
}
