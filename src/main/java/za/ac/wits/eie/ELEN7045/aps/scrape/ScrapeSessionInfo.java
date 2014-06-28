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

	@Column(name = "account_number")
	private String acccountNumber;

	@Column(name = "account_holder_name")
	private String accountHolderName;

	@Column(name = "base_url")
	private String baseUrl;

	@Column(name = "closing_balance")
	private String closingBalance;

	@Column(name = "date")
	private String date;

	@Column(name = "deductions")
	private String deductions;

	@Column(name = "discount")
	private String discount;

	@Column(name = "due_date")
	private String dueDate;

	@Column(name = "new_charges")
	private String newCharges;

	@Column(name = "opening_balance")
	private String openingBalance;

	@Column(name = "payment_received")
	private String paymentReceived;

	@Column(name = "return_code")
	private String returnCode;

	@Column(name = "statement_date")
	private String statementDate;

	@Column(name = "statement_month")
	private String statementMonth;

	@Column(name = "statement_number")
	private String statementNumber;

	@Column(name = "time")
	private String time;

	@Column(name = "total_due")
	private String totalDue;

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

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public String getClosingBalance() {
		return closingBalance;
	}

	public String getDate() {
		return date;
	}

	public String getDeductions() {
		return deductions;
	}

	public String getDiscount() {
		return discount;
	}

	public String getDueDate() {
		return dueDate;
	}

	public String getNewCharges() {
		return newCharges;
	}

	public String getOpeningBalance() {
		return openingBalance;
	}

	public String getPaymentReceived() {
		return paymentReceived;
	}

	public String getReturnCode() {
		return returnCode;
	}

	public String getStatementDate() {
		return statementDate;
	}

	public String getStatementMonth() {
		return statementMonth;
	}

	public String getStatementNumber() {
		return statementNumber;
	}

	public String getTime() {
		return time;
	}

	public String getTotalDue() {
		return totalDue;
	}

	public String getVatAmount() {
		return vatAmount;
	}

	public void setAcccountNumber(String acccountNumber) {
		this.acccountNumber = acccountNumber;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public void setClosingBalance(String closingBalance) {
		this.closingBalance = closingBalance;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setDeductions(String deductions) {
		this.deductions = deductions;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public void setNewCharges(String newCharges) {
		this.newCharges = newCharges;
	}

	public void setOpeningBalance(String openingBalance) {
		this.openingBalance = openingBalance;
	}

	public void setPaymentReceived(String paymentReceived) {
		this.paymentReceived = paymentReceived;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public void setStatementDate(String statementDate) {
		this.statementDate = statementDate;
	}

	public void setStatementMonth(String statementMonth) {
		this.statementMonth = statementMonth;
	}

	public void setStatementNumber(String statementNumber) {
		this.statementNumber = statementNumber;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public void setTotalDue(String totalDue) {
		this.totalDue = totalDue;
	}

	public void setVatAmount(String vatAmount) {
		this.vatAmount = vatAmount;
	}

}