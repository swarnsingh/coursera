package com.swarn.assignment.observer;

import java.util.Date;

/**
 * @author Swarn Singh.
 */
public class Transaction {
    private int transactionId;
    private Date date;
    private double amount;
    private String customerId;
    private String bankName;
    private Status status;

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", date=" + date +
                ", amount=" + amount +
                ", customerId='" + customerId + '\'' +
                ", bankName='" + bankName + '\'' +
                ", status=" + status +
                '}';
    }
}
