package com.example.simbirsoft_test.model;

import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "word")
@Entity
public class Word {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "WORD_SEQ")
    @SequenceGenerator(name = "WORD_SEQ", sequenceName = "WORD_SEQ", allocationSize = 1)
    private Long Id;

    @Column(name = "word")
    private String word;

    @Column(name = "cnt")
    private int cnt;
}
