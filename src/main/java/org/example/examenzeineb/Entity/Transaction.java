package com.example.examanhoussemhosni.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)

@Entity
public class Transaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idTransaction;
     Double montant;
    @Enumerated(EnumType.STRING)
     TypeTransaction type;
    Date dateTransaction;

    @ManyToOne
    @JoinColumn(name = "compte_exp_id")
    private Compte compteExpiediteur;

    @ManyToOne
    @JoinColumn(name = "compte_dest_id")
    private Compte compteDestinataire;
}
