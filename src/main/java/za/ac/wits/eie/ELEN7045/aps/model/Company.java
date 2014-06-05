package za.ac.wits.eie.ELEN7045.aps.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import za.ac.wits.eie.ELEN7045.aps.model.base.BaseDomainEntity;

@Entity
public class Company extends BaseDomainEntity<Long> {
    
    @OneToOne
    private BillingCycle billingCycle;

    public Company() {
        super();
    }

    public Company(Long id) {
        super(id);
    }
}
