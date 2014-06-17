package za.ac.wits.eie.ELEN7045.aps.scrape;

/*
 * This class enables the use of the below fields
 * 
 * Municipalities
 * --------------
 * Instalment notice
 * Electricity used
 * Electricity charges
 * Gas used
 * Gas charges
 * Water used
 * Water charges
 * Sewerage charges
 * Refuse charges
 */

public class MunicipalityScrape extends ScrapeSessionInfo {

	private String instalmentNotice;
	private String electricityUsed;
	private String electricityCharges;
	private String gasUsed;
	private String gasCharges;
	private String waterUsed;
	private String waterCharges;
	private String sewerageCharges;
	private String refuseCharges;

	public String getInstalmentNotice() {
		return instalmentNotice;
	}

	public void setInstalmentNotice(String instalmentNotice) {
		this.instalmentNotice = instalmentNotice;
	}

	public String getElectricityUsed() {
		return electricityUsed;
	}

	public void setElectricityUsed(String electricityUsed) {
		this.electricityUsed = electricityUsed;
	}

	public String getElectricityCharges() {
		return electricityCharges;
	}

	public void setElectricityCharges(String electricityCharges) {
		this.electricityCharges = electricityCharges;
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

	@Override
	public String toString(){
		return String.format("{MUNICIPALITY-SCRAPE [base-url: %s][date: %s][time: %s][return-code: %s]}", getBaseUrl(), getDate(), getTime(), getReturnCode());
	}
}
