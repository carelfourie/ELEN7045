package za.ac.wits.eie.ELEN7045.aps.model;

import javax.persistence.Entity;

import za.ac.wits.eie.ELEN7045.aps.model.base.BaseDomainEntity;

@Entity
public class ReturnCode extends BaseDomainEntity<Long> {
    
    private String code;
    
    private String description;

    public ReturnCode() {
        super();
    }

    public ReturnCode(Long id) {
        super(id);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
