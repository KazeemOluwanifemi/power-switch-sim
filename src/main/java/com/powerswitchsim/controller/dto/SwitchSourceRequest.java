package com.powerswitchsim.controller.dto;

import com.powerswitchsim.service.PowerSource;

public class SwitchSourceRequest {
    private PowerSource powerSource;

    public PowerSource getPowerSource() {
        return powerSource;
    }

    public void setPowerSource(PowerSource powerSource) {
        this.powerSource = powerSource;
    }
}
