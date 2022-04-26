package com.acn.homework.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data //getter setter to string
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "buckets")

public class Bucket {
    private static final String SEQUENCE_NAME = "buckets_sequence";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(name = SEQUENCE_NAME, sequenceName = SEQUENCE_NAME, allocationSize = 1)
    private long id;
    @OneToOne
    @JoinColumn(name = "user_id") //prisojedinitsa k kolonke
    private User user;
    //mnogog tovara mozet bitj v mnogo korzin poetomu mtom
    @ManyToMany
    @JoinTable(name = "buckets_products",
    joinColumns = @JoinColumn(name = "bucket_id"),
    inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> product;
}
