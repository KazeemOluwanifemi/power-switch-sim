package com.powerswitchsim.service;

import com.powerswitchsim.entities.Transaction;

public enum PowerSource {
    GRID("Running"),
    SOLAR("Down"),
    GENERATOR("Failed");

    private final String sourceState;

    PowerSource(String sourceState) {
        this.sourceState = sourceState;
    }

    public String getSourceState() {
        return sourceState;
    }

    public void setPowerSrc(Transaction transaction, String source){
        transaction.setPowerSrc(String.valueOf(PowerSource.SOLAR));
    }

}
