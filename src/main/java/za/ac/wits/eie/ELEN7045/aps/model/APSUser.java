package za.ac.wits.eie.ELEN7045.aps.model;

import javax.persistence.Entity;

import za.ac.wits.eie.ELEN7045.aps.model.base.BaseDomainEntity;

@Entity
public class APSUser extends BaseDomainEntity<Long> {

    public APSUser() {
        super();
    }

    public APSUser(Long id) {
        super(id);
    }
}
