package za.ac.wits.eie.ELEN7045.aps.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import za.ac.wits.eie.ELEN7045.aps.model.base.BaseDomainEntity;

@Entity
public class Company extends BaseDomainEntity<Long> {

	@OneToOne
	private BillingCycle billingCycle;

	private String name;

	public Company() {
		super();
	}

	public Company(Long id) {
		super(id);
	}

	public BillingCycle getBillingCycle() {
		return billingCycle;
	}

	public String getName() {
		return name;
	}

	public void setBillingCycle(BillingCycle billingCycle) {
		this.billingCycle = billingCycle;
	}

	public void setName(String name) {
		this.name = name;
	}

}
