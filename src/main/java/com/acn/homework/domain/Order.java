package com.acn.homework.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data //getter setter to string
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "orders")
public class Order {
    private static final String SEQUENCE_NAME = "order_sequence";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(name = SEQUENCE_NAME, sequenceName = SEQUENCE_NAME, allocationSize = 1)
    private long id;
    @CreationTimestamp //data sozdanija srazu zapisivajetsa v pole
    private LocalDateTime created;
    @UpdateTimestamp //vo vrema obnovlenija avtomatom shtob bilo
    private LocalDateTime updated;
    @ManyToOne //mnogo zakazov u odnogo chela
    @JoinColumn(name = "user_id")
    private User user;
    private double finalPrice;
    private String address;

}
