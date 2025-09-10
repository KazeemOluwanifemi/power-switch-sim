package com.powerswitchsim.transaction;

import jakarta.persistence.*;
//import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Table
public class Transaction {

    @Id
    @SequenceGenerator(
            name = "transaction_sequence",
            sequenceName = "transaction_sequence",
            allocationSize = 50
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "transaction_sequence"
    )
    private int transactionID;
    private BigDecimal amount;
    private String transactionState;
    private String powerSrc;
    private LocalDateTime timeStamp;

    public Transaction() {
    }

    public Transaction(BigDecimal amount, String transactionState,
                       String powerSrc, LocalDateTime timeStamp) {
        this.amount = amount;
        this.transactionState = transactionState;
        this.powerSrc = powerSrc;
        this.timeStamp = timeStamp;
    }

    public Transaction(int transactionID, BigDecimal amount,
                       String transactionState, String powerSrc,
                       LocalDateTime timeStamp) {
        this.transactionID = transactionID;
        this.amount = amount;
        this.transactionState = transactionState;
        this.powerSrc = powerSrc;
        this.timeStamp = timeStamp;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getTransactionState() {
        return transactionState;
    }

    public void setTransactionState(String transactionState) {
        this.transactionState = transactionState;
    }

    public String getPowerSrc() {
        return powerSrc;
    }

    public void setPowerSrc(String powerSrc) {
        this.powerSrc = powerSrc;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
}
