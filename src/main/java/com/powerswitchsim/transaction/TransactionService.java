package com.powerswitchsim.transaction;


import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> getTransactions(){
        return (List<Transaction>) transactionRepository.findAll();
    }

    public void logNewTransactions(Transaction transaction){
        LocalDateTime timestamp = LocalDateTime.now();
        String formattedTimestamp = timestamp.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy hh:mm a"));

        transaction.setTransactionReceived(formattedTimestamp);
        transactionRepository.saveAll(List.of(transaction));

    }
}
