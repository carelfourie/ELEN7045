package za.ac.wits.eie.ELEN7045.aps.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import za.ac.wits.eie.ELEN7045.aps.model.base.BaseDomainEntity;

@Entity
public class APSUser extends BaseDomainEntity<Long> {
    
    @OneToMany(mappedBy = "apsUser")
    private List<CompanyAccount> companyAccounts;

    public APSUser() {
        super();
    }

    public APSUser(Long id) {
        super(id);
    }
}
