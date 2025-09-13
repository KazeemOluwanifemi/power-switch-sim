package com.powerswitchsim.helpers;


import com.powerswitchsim.repository.TransactionRepository;
import com.powerswitchsim.entities.Transaction;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.List;

@Configuration
public class TransactionConfig {

    @Bean
    CommandLineRunner commandLineRunner(TransactionRepository transactionRepository){
        return args -> {
            Transaction firstTransaction =
                    Transaction.builder()
                            .amount(BigDecimal.valueOf(540000))
                            .transactionState("True")
                            .powerSrc("Grid")
                            .transactionReceived("12-Sep-2025 10:43 AM")
                            .build();

            Transaction secondTransaction =
                    Transaction.builder()
                            .amount(BigDecimal.valueOf(1500000))
                            .transactionState("False")
                            .powerSrc("Generator")
                            .transactionReceived("12-Sep-2025 10:43 AM")
                            .build();
            transactionRepository.saveAll(List.of(firstTransaction,secondTransaction));
        };
    }
}
