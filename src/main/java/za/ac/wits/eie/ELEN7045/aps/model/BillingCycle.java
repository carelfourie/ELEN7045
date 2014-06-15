package za.ac.wits.eie.ELEN7045.aps.model;

import javax.persistence.Entity;
//import javax.persistence.OneToOne;

import za.ac.wits.eie.ELEN7045.aps.model.base.BaseDomainEntity;

@Entity
public class BillingCycle extends BaseDomainEntity<Long> {
//    commented out as this will cause cyclic reference
//    @OneToOne
//    private Company company;
	private String cycle;

    public BillingCycle() {
        super();
    }

    public BillingCycle(Long id) {
        super(id);
    }

	public String getCycle() {
		return cycle;
	}

	public void setCycle(String cycle) {
		this.cycle = cycle;
	}
    
}
