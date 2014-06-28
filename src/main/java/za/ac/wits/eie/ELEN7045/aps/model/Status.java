package za.ac.wits.eie.ELEN7045.aps.model;

import javax.persistence.Entity;

import za.ac.wits.eie.ELEN7045.aps.model.base.BaseDescriptionDomainEntity;

@Entity
public class Status extends BaseDescriptionDomainEntity<Long> {

    public Status() {
        super();
    }

    public Status(Long id) {
        super(id);
    }
}
