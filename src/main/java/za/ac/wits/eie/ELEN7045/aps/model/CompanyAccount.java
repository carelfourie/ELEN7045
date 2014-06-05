package za.ac.wits.eie.ELEN7045.aps.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import za.ac.wits.eie.ELEN7045.aps.model.base.BaseDomainEntity;

@Entity
public class CompanyAccount extends BaseDomainEntity<Long> {
    
    @OneToOne
    private Status status;
    
    @ManyToOne
    private APSUser apsUser;
    
    @OneToMany(mappedBy = "companyAccount")
    private List<ScrapingEvent> scrapingEvents;

    public CompanyAccount() {
        super();
    }

    public CompanyAccount(Long id) {
        super(id);
    }
}
