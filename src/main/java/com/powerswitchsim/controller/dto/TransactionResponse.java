package com.powerswitchsim.controller.dto;

import com.powerswitchsim.service.PowerSource;

import java.math.BigDecimal;

public class TransactionResponse {
    private long transactionID;
    private BigDecimal amount;
    private String transactionConfirmed;
    private PowerSource powerSrc;
    private String transactionTimeStamp;

    public long getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(long transactionID) {
        this.transactionID = transactionID;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getTransactionConfirmed() {
        return transactionConfirmed;
    }

    public void setTransactionConfirmed(String transactionConfirmed) {
        this.transactionConfirmed = transactionConfirmed;
    }

    public PowerSource getPowerSrc() {
        return powerSrc;
    }

    public void setPowerSrc(PowerSource powerSrc) {
        this.powerSrc = powerSrc;
    }

    public String getTransactionTimeStamp() {
        return transactionTimeStamp;
    }

    public void setTransactionTimeStamp(String transactionTimeStamp) {
        this.transactionTimeStamp = transactionTimeStamp;
    }
}
