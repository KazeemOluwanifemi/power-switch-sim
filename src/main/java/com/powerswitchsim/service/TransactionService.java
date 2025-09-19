package com.powerswitchsim.service;


import com.powerswitchsim.repository.TransactionRepository;
import com.powerswitchsim.entities.Transaction;
import com.powerswitchsim.service.implementations.TransactionTimeProvider;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;
//    PowerSource powerSource;
    private final TimeStampProvider transactionTimeProvider = new TransactionTimeProvider();

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> getTransactions(){
        return (List<Transaction>) transactionRepository.findAll();
    }

    public void saveNewTransactions(Transaction transaction){
        transaction.setTransactionTimestamp(transactionTimeProvider.getCurrentTimeStamp());
//        String powerSrc = String.valueOf(transaction.getPowerSrc());
//
//        transaction.setPowerSrc(PowerSource.valueOf(powerSrc.toUpperCase()));

        transactionRepository.saveAll(List.of(transaction));

        long transactionID = transaction.getTransactionID();
        transactionRepository.findTransactionByTransactionID(transactionID);
    }


//    function to switch powerSource
    public List<Transaction> switchPowerSource(Long transactionID, PowerSource powerSrc){
        Transaction transaction = transactionRepository.findById(transactionID).orElseThrow(
                () -> new IllegalArgumentException("Transaction with id " +
                        transactionID + " does not exist")
        );

        transaction.setPowerSrc(powerSrc);
        transactionRepository.save(transaction);

        long switchedTransactionID = transaction.getTransactionID();
        return transactionRepository.findTransactionByTransactionID(switchedTransactionID);
    }



    public String getPowerSrcState(Long transactionID) {
        Transaction transaction = transactionRepository.findById(transactionID).orElseThrow(
                () -> new IllegalArgumentException("Transaction with id " + transactionID + " does not exist")
        );

        return("The " + transaction.getPowerSrc() +
                " is " + transaction.getPowerSrc().getSourceState());
    }
}
