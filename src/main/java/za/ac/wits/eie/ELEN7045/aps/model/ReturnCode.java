package za.ac.wits.eie.ELEN7045.aps.model;

import javax.persistence.Entity;

import za.ac.wits.eie.ELEN7045.aps.model.base.BaseDomainEntity;

@Entity
public class ReturnCode extends BaseDomainEntity<Long> {
    
    private String apsdescription;
    
    private String code;

    private String description;
    
    public ReturnCode() {
        super();
    }

    public ReturnCode(Long id) {
        super(id);
    }

    public String getApsdescription()
    {
    	return apsdescription;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public void setApsdescription(String apsdescription)
    {
    	this.apsdescription = apsdescription;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
}
