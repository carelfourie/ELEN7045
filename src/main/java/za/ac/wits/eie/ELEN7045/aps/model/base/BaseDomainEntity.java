package za.ac.wits.eie.ELEN7045.aps.model.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseDomainEntity<ID extends Serializable> {

    // Integer: -2,147,483,648 to 2,147,483,647
    // Long: -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
    // @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Id
    @GeneratedValue
    private ID id;

    public BaseDomainEntity() {
    }

    public BaseDomainEntity(ID id) {
        this.id = id;
    }

    protected <T extends BaseDomainEntity<Long>> List<T> constructListIfNull(List<T> list) {
        if (list == null) {
            list = new ArrayList<T>();
        }
        return list;
    }

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }
}
