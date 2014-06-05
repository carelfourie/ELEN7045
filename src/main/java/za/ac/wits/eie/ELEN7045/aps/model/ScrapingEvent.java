package za.ac.wits.eie.ELEN7045.aps.model;

import javax.persistence.Entity;

import za.ac.wits.eie.ELEN7045.aps.model.base.BaseDomainEntity;

@Entity
public class ScrapingEvent extends BaseDomainEntity<Long> {

    public ScrapingEvent() {
        super();
    }

    public ScrapingEvent(Long id) {
        super(id);
    }
}
