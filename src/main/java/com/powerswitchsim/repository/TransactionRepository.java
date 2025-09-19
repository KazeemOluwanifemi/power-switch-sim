package com.powerswitchsim.repository;

import com.powerswitchsim.entities.Transaction;
import com.powerswitchsim.service.PowerSource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {
    Optional<Transaction>  findTransactionByPowerSrc (PowerSource powerSrc);

    List<Transaction> findTransactionByTransactionID(long transactionID);
}
