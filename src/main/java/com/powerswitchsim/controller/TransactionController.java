package com.powerswitchsim.controller;

import com.powerswitchsim.entities.Transaction;
import com.powerswitchsim.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/transactions")
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
    public void logTransactions(@RequestBody Transaction transaction) {
        transactionService.logNewTransactions(transaction);
    }
}
