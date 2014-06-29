package za.ac.wits.eie.ELEN7045.aps.model.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseDomainEntity<ID extends Serializable> {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private ID id;

	public BaseDomainEntity() {
	}

	public BaseDomainEntity(ID id) {
		this.id = id;
	}

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}

	protected <T extends BaseDomainEntity<Long>> List<T> constructListIfNull(List<T> list) {
		if (list == null) {
			list = new ArrayList<T>();
		}
		return list;
	}
}
