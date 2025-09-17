package com.powerswitchsim.entities;

import com.powerswitchsim.service.PowerSource;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Builder
public class Transaction {

    @Id
    @SequenceGenerator(
            name = "transaction_sequence",
            sequenceName = "transaction_sequence",
            allocationSize = 50
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "transaction_sequence"
    )
    private long transactionID;

    @NonNull
    private BigDecimal amount;

    @NonNull
    private String transactionState;

    @Enumerated
    @NonNull
    private PowerSource powerSrc;

    @NonNull
    private String transactionReceived;
}

