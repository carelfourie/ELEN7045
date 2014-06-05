package za.ac.wits.eie.ELEN7045.aps.model;

import javax.persistence.Entity;

import za.ac.wits.eie.ELEN7045.aps.model.base.BaseDomainEntity;

@Entity
public class ReturnCode extends BaseDomainEntity <Long> {

    public ReturnCode() {
        super();
    }

    public ReturnCode(Long id) {
        super(id);
    }
}
