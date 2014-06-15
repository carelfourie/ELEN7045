package za.ac.wits.eie.ELEN7045.aps.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import za.ac.wits.eie.ELEN7045.aps.model.base.BaseDomainEntity;
import za.ac.wits.eie.ELEN7045.aps.model.statement.base.Statement;

@Entity
public class CompanyAccount extends BaseDomainEntity<Long> {
    
    @OneToOne
    private Status status;
    
    private String accountNumber;
    
    @OneToOne
    private Company company;
    
    @ManyToOne
    private APSUser apsUser;
    
    @ManyToOne
    private Statement statement;
    
    @OneToMany(mappedBy = "companyAccount")
    private List<ScrapingEvent> scrapingEvents;

    public CompanyAccount() {
        super();
    }

    public CompanyAccount(Long id) {
        super(id);
    }

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Statement getStatement() {
		return statement;
	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	}

	public APSUser getApsUser() {
		return apsUser;
	}

	public void setApsUser(APSUser apsUser) {
		this.apsUser = apsUser;
	}
    
}
