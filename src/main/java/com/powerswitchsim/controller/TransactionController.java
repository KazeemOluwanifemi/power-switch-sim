package com.powerswitchsim.controller;

import com.powerswitchsim.controller.dto.TransactionRequest;
import com.powerswitchsim.controller.dto.TransactionResponse;
import com.powerswitchsim.entities.Transaction;
import com.powerswitchsim.service.PowerSource;
import com.powerswitchsim.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(path = "api/transactions/v1")
public class TransactionController {
    private final TransactionService transactionService;


    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }


    @GetMapping
    public List<Transaction> getTransactions() {

        return transactionService.getTransactions();
    }

    @PostMapping("/log-transaction")
    public ResponseEntity<TransactionResponse> logTransactions(@RequestBody TransactionRequest transactionRequest) {
        Transaction transaction = new Transaction();
        transaction.setAmount(transactionRequest.getAmount());
        transaction.setTransactionConfirmed(transactionRequest.getTransactionConfirmed());
        transaction.setPowerSrc(transactionRequest.getPowerSrc());

        transactionService.logNewTransactions(transaction);

        TransactionResponse response = new TransactionResponse();

        response.setTransactionID(transaction.getTransactionID());
        response.setAmount(transaction.getAmount());
        response.setTransactionConfirmed(transaction.getTransactionConfirmed());
        response.setPowerSrc(transaction.getPowerSrc());
        response.setTransactionTimeStamp(transaction.getTransactionTimestamp());

        return ResponseEntity.ok(response);
    }

    @PutMapping("{transactionID}")
    public List<Transaction> switchSource(
            @PathVariable Long transactionID,
            @RequestBody String powerSrcString
    ) {
        PowerSource powerSrc = PowerSource.valueOf(powerSrcString.toUpperCase());
        return transactionService.switchPowerSource(transactionID, powerSrc);
    }


    @GetMapping("{transactionID}")
    public String getPowerSourceState(
            @PathVariable Long transactionID
    ) {
        return transactionService.getPowerSrcState(transactionID);
    }

}
