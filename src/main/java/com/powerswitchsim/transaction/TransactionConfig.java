package com.powerswitchsim.transaction;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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
                            .timeStamp(LocalDateTime.now())
                            .build();

            Transaction secondTransaction =
                    Transaction.builder()
                            .amount(BigDecimal.valueOf(1500000))
                            .transactionState("False")
                            .powerSrc("Generator")
                            .timeStamp(LocalDateTime.now())
                            .build();

            transactionRepository.saveAll(List.of(firstTransaction,secondTransaction));
        };
    }
}
