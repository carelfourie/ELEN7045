package za.ac.wits.eie.ELEN7045.aps.model;

import javax.persistence.Entity;

import za.ac.wits.eie.ELEN7045.aps.model.base.BaseDomainEntity;

@Entity
public class Statement extends BaseDomainEntity<Long> {

    public Statement() {
        super();
    }

    public Statement(Long id) {
        super(id);
    }
}
