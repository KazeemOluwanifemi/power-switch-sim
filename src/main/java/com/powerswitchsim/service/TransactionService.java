package com.powerswitchsim.service;


import com.powerswitchsim.repository.TransactionRepository;
import com.powerswitchsim.entities.Transaction;
import com.powerswitchsim.service.implementations.TransactionTimeProvider;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;
//    PowerSource powerSource;


    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> getTransactions(){
        return (List<Transaction>) transactionRepository.findAll();
    }

    public void logNewTransactions(Transaction transaction){
        final TransactionTimeProvider transactionTimeProvider = new TransactionTimeProvider();

        transaction.setTransactionReceived(transactionTimeProvider.getCurrentTimeStamp());
        transactionRepository.saveAll(List.of(transaction));

    }
//    function to switch powerSource
    public void switchPowerSource(Long transactionID, PowerSource powerSrc){
        Transaction transaction = transactionRepository.findById(transactionID).orElseThrow(
                () -> new IllegalArgumentException("Transaction with id " +
                        transactionID + " does not exist")
        );

        transaction.setPowerSrc(powerSrc);

        transactionRepository.save(transaction);
    }

    public void getPowerSrcState(Long transactionID){
        Transaction transaction = transactionRepository.findById(transactionID).orElseThrow(
                () -> new IllegalArgumentException("Transaction with id " + transactionID + " does not exist")
        );

//        String powerSrc = transaction.getPowerSrc();
        String powerState = transaction.getTransactionState();

        System.out.println(powerState);
    }
}
