package com.powerswitchsim.service;

import com.powerswitchsim.entities.Transaction;

public enum PowerSource {
    GRID("Active"),
    SOLAR("Inactive"),
    GENERATOR("Failed");

    private final String sourceState;

    PowerSource(String sourceState) {
        this.sourceState = sourceState;
    }

    public String getSourceState() {
        return sourceState;
    }

}
