package za.ac.wits.eie.ELEN7045.aps.model.statement.base;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import za.ac.wits.eie.ELEN7045.aps.model.base.BaseDomainEntity;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public class Statement extends BaseDomainEntity<Long> {

	private String accountHolderName;

	private String accountNumber;
	
	private String baseUrl;
	
	private String closingBalance;
	
	private String date;
	
	private String deductions;

	private String discount;
	
	private String dueDate;
	
	private String newCharges;
	
	private String openingBalance;
	
	private String paymentReceived;
	
	private String returnCode;
	
	private String statement;
	
	private String statementDate;
	
	private String statementMonth;
	
	private String statementNumber;
	
	private String time;
	
	private String totalDue;
	
	private String vatAmount;
	
	public Statement() {
        super();
    }

    public Statement(Long id) {
        super(id);
    }

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public String getAccountNumber() {
		return accountNumber;
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

	public String getStatement() {
		return statement;
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

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public void setAccountNumber(String acccountNumber) {
		this.accountNumber = acccountNumber;
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

	public void setStatement(String statement) {
		this.statement = statement;
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