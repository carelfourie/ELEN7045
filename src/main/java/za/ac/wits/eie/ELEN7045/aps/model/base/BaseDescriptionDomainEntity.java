package za.ac.wits.eie.ELEN7045.aps.model.base;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public abstract class BaseDescriptionDomainEntity<ID> extends BaseDomainEntity<Long> {
    
    @NotNull
    private String description;
    
    public BaseDescriptionDomainEntity() {
        super();
    }

    public BaseDescriptionDomainEntity(Long id) {
        super(id);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
