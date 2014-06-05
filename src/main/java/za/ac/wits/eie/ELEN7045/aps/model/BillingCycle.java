package za.ac.wits.eie.ELEN7045.aps.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import za.ac.wits.eie.ELEN7045.aps.model.base.BaseDomainEntity;

@Entity
public class BillingCycle extends BaseDomainEntity<Long> {
    
    @OneToOne
    private Company company;

    public BillingCycle() {
        super();
    }

    public BillingCycle(Long id) {
        super(id);
    }
}
