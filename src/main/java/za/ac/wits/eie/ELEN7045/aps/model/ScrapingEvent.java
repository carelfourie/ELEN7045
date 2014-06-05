package za.ac.wits.eie.ELEN7045.aps.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import za.ac.wits.eie.ELEN7045.aps.model.base.BaseDomainEntity;

@Entity
public class ScrapingEvent extends BaseDomainEntity <Long> {
    
    @ManyToOne
    private CompanyAccount companyAccount;

    public ScrapingEvent() {
        super();
    }

    public ScrapingEvent(Long id) {
        super(id);
    }
}
