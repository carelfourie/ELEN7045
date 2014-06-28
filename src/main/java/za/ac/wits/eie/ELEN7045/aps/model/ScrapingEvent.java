package za.ac.wits.eie.ELEN7045.aps.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import za.ac.wits.eie.ELEN7045.aps.model.base.BaseDomainEntity;

@Entity
public class ScrapingEvent extends BaseDomainEntity<Long> {

	@ManyToOne
	private CompanyAccount companyAccount;

	private Date date;

	@OneToOne
	private ReturnCode returnCode;

	public ScrapingEvent() {
		super();
	}

	public ScrapingEvent(Long id) {
		super(id);
	}

	public CompanyAccount getCompanyAccount() {
		return companyAccount;
	}

	public Date getDate() {
		return date;
	}

	public ReturnCode getReturnCode() {
		return returnCode;
	}

	public void setCompanyAccount(CompanyAccount companyAccount) {
		this.companyAccount = companyAccount;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setReturnCode(ReturnCode returnCode) {
		this.returnCode = returnCode;
	}
}
