package za.ac.wits.eie.ELEN7045.aps.model.statement;

import javax.persistence.Entity;

import za.ac.wits.eie.ELEN7045.aps.model.statement.base.Statement;

@Entity
public class MunicipalityStatement extends Statement {

	private String installmentNotice;
	private String electricityUsed;
	private String electricityCharges;
	private String gasUsed;
	private String gasCharges;
	private String waterUsed;
	private String waterCharges;
	private String sewerageCharges;
	private String refuseCharges;
	
    public MunicipalityStatement() {
        super();
    }

    public MunicipalityStatement(Long id) {
        super(id);
    }

	public String getInstallmentNotice() {
		return installmentNotice;
	}

	public void setInstallmentNotice(String installmentNotice) {
		this.installmentNotice = installmentNotice;
	}

	public String getElectricityUsed() {
		return electricityUsed;
	}

	public void setElectricityUsed(String electricityUsed) {
		this.electricityUsed = electricityUsed;
	}

	public String getElectrictyCharges() {
		return electricityCharges;
	}

	public void setElectricityCharges(String electrictyCharges) {
		this.electricityCharges = electrictyCharges;
	}

	public String getGasUsed() {
		return gasUsed;
	}

	public void setGasUsed(String gasUsed) {
		this.gasUsed = gasUsed;
	}

	public String getGasCharges() {
		return gasCharges;
	}

	public void setGasCharges(String gasCharges) {
		this.gasCharges = gasCharges;
	}

	public String getWaterUsed() {
		return waterUsed;
	}

	public void setWaterUsed(String waterUsed) {
		this.waterUsed = waterUsed;
	}

	public String getWaterCharges() {
		return waterCharges;
	}

	public void setWaterCharges(String waterCharges) {
		this.waterCharges = waterCharges;
	}

	public String getSewerageCharges() {
		return sewerageCharges;
	}

	public void setSewerageCharges(String sewerageCharges) {
		this.sewerageCharges = sewerageCharges;
	}

	public String getRefuseCharges() {
		return refuseCharges;
	}

	public void setRefuseCharges(String refuseCharges) {
		this.refuseCharges = refuseCharges;
	}
    
	public String toString(){
		return String.format("{MUNICIPALITY-SCRAPE [base-url: %s][date: %s][time: %s][return-code: %s][electricity-used: %s][electricity-charges: %s]}", getBaseUrl(), getDate(), getTime(), getReturnCode(), getElectricityUsed(),getElectrictyCharges());
	}
    
}