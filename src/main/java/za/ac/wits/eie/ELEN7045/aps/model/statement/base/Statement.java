package za.ac.wits.eie.ELEN7045.aps.model.statement.base;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import za.ac.wits.eie.ELEN7045.aps.model.base.BaseDomainEntity;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public class Statement extends BaseDomainEntity<Long> {

    private String statement;
    
      private String baseUrl;
      
      private String date;
      
      private String time;
      
      private String returnCode;
      
      private String acccountNumber;
    
      private String accountHolderName;
      
      private String statementDate;
      
      private String statementNumber;
      
      private String statementMonth;
      
      private String totalDue;
      
      private String dueDate;
      
      private String openingBalance;
      
      private String closingBalance;
      
      private String paymentReceived;
      
      private String newCharges;
      
      private String deductions;
      
      private String discount;
      
      private String vatAmount;
      
      public Statement() {
            super();
        }
    
        public Statement(Long id) {
            super(id);
        }
    
      public String getStatement() {
          return statement;
      }
    
      public void setStatement(String statement) {
          this.statement = statement;
      }
          
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
