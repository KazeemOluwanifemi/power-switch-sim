package com.powerswitchsim.controller.dto;

import com.powerswitchsim.service.PowerSource;
import java.math.BigDecimal;


public class TransactionRequest {
    private long transactionID;
    private BigDecimal amount;
    private String transactionConfirmed;
    private PowerSource powerSrc;
    private String transactionTimeStamp;

}
