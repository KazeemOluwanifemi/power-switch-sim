package com.powerswitchsim.controller;

import com.powerswitchsim.controller.dto.SwitchSourceRequest;
import com.powerswitchsim.controller.dto.TransactionRequest;
import com.powerswitchsim.controller.dto.TransactionResponse;
import com.powerswitchsim.entities.Transaction;
import com.powerswitchsim.service.PowerSource;
import com.powerswitchsim.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/save-transaction")
    public ResponseEntity<TransactionResponse> saveTransactions(
            @RequestBody TransactionRequest transactionRequest
    ) {
        Transaction transaction = new Transaction();
        transaction.setAmount(transactionRequest.getAmount());
        transaction.setTransactionConfirmed(transactionRequest.getTransactionConfirmed());

        String powerSrc = String.valueOf(transactionRequest.getPowerSrc());
        transaction.setPowerSrc(PowerSource.valueOf(powerSrc.toUpperCase()));

        transactionService.saveNewTransactions(transaction);

        TransactionResponse response = new TransactionResponse();

        response.setTransactionID(transaction.getTransactionID());
        response.setAmount(transaction.getAmount());
        response.setTransactionConfirmed(transaction.getTransactionConfirmed());

        String powerSrcRequest = String.valueOf(transactionRequest.getPowerSrc());
        response.setPowerSrc(PowerSource.valueOf(powerSrcRequest.toUpperCase()));

        response.setTransactionTimeStamp(transaction.getTransactionTimestamp());

        return ResponseEntity.ok(response);
    }


    @PutMapping("{transactionID}")
    public List<Transaction> switchSource(
            @PathVariable Long transactionID,
            @RequestBody SwitchSourceRequest powerSrc
    ) {
        return transactionService.switchPowerSource(transactionID, powerSrc.getPowerSource());
    }


    @GetMapping("/source-state/{transactionID}")
    public String getPowerSourceState(
            @PathVariable Long transactionID
    ) {
        return transactionService.getPowerSrcState(transactionID);
    }


    @GetMapping("/single-transaction/{transactionID}")
    public ResponseEntity<TransactionResponse> getOneTransaction(
            @PathVariable Long transactionID
    ) {
        TransactionResponse response = new TransactionResponse();

        response.setTransactionID(transactionService.getOneTransaction(transactionID).getTransactionID());
        response.setAmount(transactionService.getOneTransaction(transactionID).getAmount());
        response.setPowerSrc(transactionService.getOneTransaction(transactionID).getPowerSrc());
        response.setTransactionConfirmed(transactionService.getOneTransaction(transactionID).getTransactionConfirmed());
        response.setTransactionTimeStamp(transactionService.getOneTransaction(transactionID).getTransactionTimestamp());

        return ResponseEntity.ok(response);
    }

}
