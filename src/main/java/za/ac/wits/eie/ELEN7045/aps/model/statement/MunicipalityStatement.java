package za.ac.wits.eie.ELEN7045.aps.model.statement;

import javax.persistence.Entity;

import za.ac.wits.eie.ELEN7045.aps.model.statement.base.Statement;

@Entity
public class MunicipalityStatement extends Statement {

	private String electricityCharges;
	
	private String electricityUsed;
	
	private String gasCharges;
	
	private String gasUsed;
	
	private String installmentNotice;
	
	private String refuseCharges;
	
	private String sewerageCharges;
	
	private String waterCharges;
	
	private String waterUsed;

	public MunicipalityStatement() {
		super();
	}

	public MunicipalityStatement(Long id) {
		super(id);
	}

	public String getElectricityUsed() {
		return electricityUsed;
	}

	public String getElectrictyCharges() {
		return electricityCharges;
	}

	public String getGasCharges() {
		return gasCharges;
	}

	public String getGasUsed() {
		return gasUsed;
	}

	public String getInstallmentNotice() {
		return installmentNotice;
	}

	public String getRefuseCharges() {
		return refuseCharges;
	}

	public String getSewerageCharges() {
		return sewerageCharges;
	}

	public String getWaterCharges() {
		return waterCharges;
	}

	public String getWaterUsed() {
		return waterUsed;
	}

	public void setElectricityCharges(String electrictyCharges) {
		this.electricityCharges = electrictyCharges;
	}

	public void setElectricityUsed(String electricityUsed) {
		this.electricityUsed = electricityUsed;
	}

	public void setGasCharges(String gasCharges) {
		this.gasCharges = gasCharges;
	}

	public void setGasUsed(String gasUsed) {
		this.gasUsed = gasUsed;
	}

	public void setInstallmentNotice(String installmentNotice) {
		this.installmentNotice = installmentNotice;
	}

	public void setRefuseCharges(String refuseCharges) {
		this.refuseCharges = refuseCharges;
	}

	public void setSewerageCharges(String sewerageCharges) {
		this.sewerageCharges = sewerageCharges;
	}

	public void setWaterCharges(String waterCharges) {
		this.waterCharges = waterCharges;
	}

	public void setWaterUsed(String waterUsed) {
		this.waterUsed = waterUsed;
	}

	@Override
	public String toString() {
		return String.format("{MUNICIPALITY-SCRAPE [base-url: %s][date: %s][time: %s][return-code: %s][electricity-used: %s][electricity-charges: %s]}", getBaseUrl(), getDate(), getTime(),
				getReturnCode(), getElectricityUsed(), getElectrictyCharges());
	}
}
