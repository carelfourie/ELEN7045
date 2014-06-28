package za.ac.wits.eie.ELEN7045.aps.model.statement;

import javax.persistence.Entity;

import za.ac.wits.eie.ELEN7045.aps.model.statement.base.Statement;

@Entity
public class CreditCardStatement extends Statement {

	private String cardType;

	private String creditAvailable;

	private String creditLimit;

	private String interestRate;

	private String minimumAmountDue;

	public CreditCardStatement() {
		super();
	}

	public CreditCardStatement(Long id) {
		super(id);
	}

	public String getCardType() {
		return cardType;
	}

	public String getCreditAvailable() {
		return creditAvailable;
	}

	public String getCreditLimit() {
		return creditLimit;
	}

	public String getInterestRate() {
		return interestRate;
	}

	public String getMinimumAmountDue() {
		return minimumAmountDue;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public void setCreditAvailable(String creditAvailable) {
		this.creditAvailable = creditAvailable;
	}

	public void setCreditLimit(String creditLimit) {
		this.creditLimit = creditLimit;
	}

	public void setInterestRate(String interestRate) {
		this.interestRate = interestRate;
	}

	public void setMinimumAmountDue(String minimumAmountDue) {
		this.minimumAmountDue = minimumAmountDue;
	}

	@Override
	public String toString() {
		return String.format("{CREDIT-CARD-SCRAPE [base-url: %s][date: %s][time: %s][return-code: %s]}", getBaseUrl(), getDate(), getTime(), getReturnCode());
	}
}
