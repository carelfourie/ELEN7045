package za.ac.wits.eie.ELEN7045.aps.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import za.ac.wits.eie.ELEN7045.aps.model.base.BaseDomainEntity;

@Entity
public class ScrapingEventAuditLog extends BaseDomainEntity<Long> {
	
	  @OneToOne
	  private Company company;
	  
	  @OneToOne
	  private APSUser apsUser;
	  
	  @Column(name = "scrapeDate")
	  private Date scrapeDate;
	  
	  @OneToOne
	  private ReturnCode returnCode;
	  
	  
	  
	public ScrapingEventAuditLog() {
		super();
	}
	public ScrapingEventAuditLog(Long id) {
		super(id);
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public APSUser getApsUser() {
		return apsUser;
	}
	public void setApsUser(APSUser apsUser) {
		this.apsUser = apsUser;
	}
	
	
	public ReturnCode getReturnCode() {
		return returnCode;
	}
	public void setReturnCode(ReturnCode returnCode) {
		this.returnCode = returnCode;
	}
	public Date getScrapeDate() {
		return scrapeDate;
	}
	public void setScrapeDate(Date scrapeDate) {
		this.scrapeDate = scrapeDate;
	}
	  
	
	
	 
}
