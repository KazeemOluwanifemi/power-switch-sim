package com.powerswitchsim.controller;

import com.powerswitchsim.entities.Transaction;
import com.powerswitchsim.service.PowerSource;
import com.powerswitchsim.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/log-transaction")
    public List<Transaction> logTransactions(@RequestBody Transaction transaction) {
        return transactionService.logNewTransactions(transaction);
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
