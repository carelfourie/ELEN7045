package za.ac.wits.eie.ELEN7045.aps.scrape;

/*
 * This class enables the use of the fields below:
 * 
 * Credit Card Providers
 * ---------------------
 * Card type
 * Interest rate
 * Credit limit
 * Credit available
 * Minimum amount due
 */

public class CreditCardScrape extends ScrapeSessionInfo {

	private String cardType;
	private String interestRate;
	private String creditLimit;
	private String creditAvailable;
	private String minimumAmountDue;

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(String interestRate) {
		this.interestRate = interestRate;
	}

	public String getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(String creditLimit) {
		this.creditLimit = creditLimit;
	}

	public String getCreditAvailable() {
		return creditAvailable;
	}

	public void setCreditAvailable(String creditAvailable) {
		this.creditAvailable = creditAvailable;
	}

	public String getMinimumAmountDue() {
		return minimumAmountDue;
	}

	public void setMinimumAmountDue(String minimumAmountDue) {
		this.minimumAmountDue = minimumAmountDue;
	}

	@Override
	public String toString() {
		return String
				.format("{CREDIT-CARD-SCRAPE [base-url: %s][date: %s][time: %s][return-code: %s]}",
						getBaseUrl(), getDate(), getTime(), getReturnCode());
	}
}
