package za.ac.wits.eie.ELEN7045.aps.model;

import javax.persistence.Entity;

import za.ac.wits.eie.ELEN7045.aps.model.base.BaseDomainEntity;

@Entity
public class CompanyAccount extends BaseDomainEntity<Long> {

    public CompanyAccount() {
        super();
    }

    public CompanyAccount(Long id) {
        super(id);
    }
}
