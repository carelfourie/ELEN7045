package za.ac.wits.eie.ELEN7045.aps.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import za.ac.wits.eie.ELEN7045.aps.model.base.BaseDomainEntity;

@Entity
public class ScrapingEvent extends BaseDomainEntity<Long> {
    
    @OneToOne
    private ReturnCode returnCode;
    
    private Date date;
    
    @ManyToOne
    private CompanyAccount companyAccount;

    public ScrapingEvent() {
        super();
    }

    public ScrapingEvent(Long id) {
        super(id);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public CompanyAccount getCompanyAccount() {
        return companyAccount;
    }

    public void setCompanyAccount(CompanyAccount companyAccount) {
        this.companyAccount = companyAccount;
    }

    public ReturnCode getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(ReturnCode returnCode) {
        this.returnCode = returnCode;
    }
}
