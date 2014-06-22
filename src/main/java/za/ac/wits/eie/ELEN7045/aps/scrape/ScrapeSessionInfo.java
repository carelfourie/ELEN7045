package za.ac.wits.eie.ELEN7045.aps.scrape;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

import za.ac.wits.eie.ELEN7045.aps.model.base.BaseDomainEntity;

/*
 * This class enables use of the common fields.
 * 
 * ======================
 * Common Fields
 * ----------------------
 * Account number
 * Account holder name
 * Statement date
 * Statement number
 * Statement month
 * Total due
 * Due date
 * Opening balance
 * Closing balance
 * Payment received
 * New charges
 * Deductions
 * Discount
 * VAT amount
 * ======================
 */

@XmlRootElement(name = "scrape-session")
@Entity
public class ScrapeSessionInfo extends BaseDomainEntity<Long> {

	@Column(name = "base_url")
	private String baseUrl;
	
	@Column(name = "date")
	private String date;
	
	@Column(name = "time")
	private String time;
	
	@Column(name = "return_code")
	private String returnCode;
	
	@Column(name = "account_number")
	private String acccountNumber;
	
	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}


	@Column(name = "account_holder_name")
	private String accountHolderName;
	
	@Column(name = "statement_date")
	private String statementDate;
	
	@Column(name = "statement_number")
	private String statementNumber;
	
	@Column(name = "statement_month")
	private String statementMonth;
	
	@Column(name = "total_due")
	private String totalDue;
	
	@Column(name = "due_date")
	private String dueDate;
	
	@Column(name = "opening_balance")
	private String openingBalance;
	
	@Column(name = "closing_balance")
	private String closingBalance;
	
	@Column(name = "payment_received")
	private String paymentReceived;
	
	@Column(name = "new_charges")
	private String newCharges;
	
	@Column(name = "deductions")
	private String deductions;
	
	@Column(name = "discount")
	private String discount;
	
	@Column(name = "vat_amount")
	private String vatAmount;
	
	
    public ScrapeSessionInfo() {
        super();
    }

    public ScrapeSessionInfo(Long id) {
        super(id);
    }

	public String getAcccountNumber() {
		return acccountNumber;
	}

	public void setAcccountNumber(String acccountNumber) {
		this.acccountNumber = acccountNumber;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public String getStatementDate() {
		return statementDate;
	}

	public void setStatementDate(String statementDate) {
		this.statementDate = statementDate;
	}

	public String getStatementNumber() {
		return statementNumber;
	}

	public void setStatementNumber(String statementNumber) {
		this.statementNumber = statementNumber;
	}

	public String getStatementMonth() {
		return statementMonth;
	}

	public void setStatementMonth(String statementMonth) {
		this.statementMonth = statementMonth;
	}

	public String getTotalDue() {
		return totalDue;
	}

	public void setTotalDue(String totalDue) {
		this.totalDue = totalDue;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getOpeningBalance() {
		return openingBalance;
	}

	public void setOpeningBalance(String openingBalance) {
		this.openingBalance = openingBalance;
	}

	public String getClosingBalance() {
		return closingBalance;
	}

	public void setClosingBalance(String closingBalance) {
		this.closingBalance = closingBalance;
	}

	public String getPaymentReceived() {
		return paymentReceived;
	}

	public void setPaymentReceived(String paymentReceived) {
		this.paymentReceived = paymentReceived;
	}

	public String getNewCharges() {
		return newCharges;
	}

	public void setNewCharges(String newCharges) {
		this.newCharges = newCharges;
	}

	public String getDeductions() {
		return deductions;
	}

	public void setDeductions(String deductions) {
		this.deductions = deductions;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getVatAmount() {
		return vatAmount;
	}

	public void setVatAmount(String vatAmount) {
		this.vatAmount = vatAmount;
	}

}