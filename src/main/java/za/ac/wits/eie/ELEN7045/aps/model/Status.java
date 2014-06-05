package za.ac.wits.eie.ELEN7045.aps.model;

import javax.persistence.Entity;

import za.ac.wits.eie.ELEN7045.aps.model.base.BaseDomainEntity;

@Entity
public class Status extends BaseDomainEntity<Long> {

    public Status() {
        super();
    }

    public Status(Long id) {
        super(id);
    }
}
