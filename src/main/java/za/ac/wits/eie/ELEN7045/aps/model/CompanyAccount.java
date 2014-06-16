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
    
    private String url;
    
    @OneToOne
    private Status status;
    
    private String accountNumber;
    
    @OneToOne
    private Company company;
    
    @ManyToOne
    private APSUser apsUser;
    
    @ManyToOne
    private Statement statement;
    
    private String username; 
    
    private String password; 
    
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<ScrapingEvent> getScrapingEvents() {
        return scrapingEvents;
    }

    public void setScrapingEvents(List<ScrapingEvent> scrapingEvents) {
        this.scrapingEvents = scrapingEvents;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
