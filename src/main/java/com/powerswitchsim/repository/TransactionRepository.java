package com.powerswitchsim.repository;

import com.powerswitchsim.entities.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {
    Optional<Transaction>  findTransactionByPowerSrc (String powerSrc);
}
