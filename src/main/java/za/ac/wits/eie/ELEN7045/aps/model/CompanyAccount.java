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
    
    private String accountNumber;
    
    @ManyToOne
    private APSUser apsUser;
    
    @OneToOne
    private Company company;
    
    private String password;
    
    @OneToMany(mappedBy = "companyAccount")
    private List<ScrapingEvent> scrapingEvents;
    
    @ManyToOne
    private Statement statement;
    
    @OneToOne
    private Status status; 
    
    private String url; 
    
    private String username;

    public CompanyAccount() {
        super();
    }

    public CompanyAccount(Long id) {
        super(id);
    }

	public String getAccountNumber() {
		return accountNumber;
	}

	public APSUser getApsUser() {
		return apsUser;
	}

	public Company getCompany() {
		return company;
	}

	public String getPassword() {
        return password;
    }

	public List<ScrapingEvent> getScrapingEvents() {
        return scrapingEvents;
    }

	public Statement getStatement() {
		return statement;
	}

	public Status getStatus() {
		return status;
	}

	public String getUrl() {
        return url;
    }

	public String getUsername() {
        return username;
    }

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

    public void setApsUser(APSUser apsUser) {
		this.apsUser = apsUser;
	}

    public void setCompany(Company company) {
		this.company = company;
	}

    public void setPassword(String password) {
        this.password = password;
    }

    public void setScrapingEvents(List<ScrapingEvent> scrapingEvents) {
        this.scrapingEvents = scrapingEvents;
    }

    public void setStatement(Statement statement) {
		this.statement = statement;
	}

    public void setStatus(Status status) {
		this.status = status;
	}

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
