package za.ac.wits.eie.ELEN7045.aps.model.statement.base;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import za.ac.wits.eie.ELEN7045.aps.model.base.BaseDomainEntity;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public class Satement extends BaseDomainEntity<Long> {

}
