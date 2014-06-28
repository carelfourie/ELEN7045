package za.ac.wits.eie.ELEN7045.aps.model;

import javax.persistence.Entity;

import za.ac.wits.eie.ELEN7045.aps.model.base.BaseDescriptionDomainEntity;

@Entity
public class ReturnCode extends BaseDescriptionDomainEntity<Long> {

	private String apsdescription;

	private String code;

	public ReturnCode() {
		super();
	}

	public ReturnCode(Long id) {
		super(id);
	}

	public String getApsdescription() {
		return apsdescription;
	}

	public String getCode() {
		return code;
	}

	public void setApsdescription(String apsdescription) {
		this.apsdescription = apsdescription;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
