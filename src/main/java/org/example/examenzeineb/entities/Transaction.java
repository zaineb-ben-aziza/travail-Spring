package org.example.examenzeineb.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.query.TypedTupleTransformer;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@ToString
public class Transaction implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long idTransaction;
    Double montant;
    @Enumerated(EnumType.STRING)
    TypeTransaction type;
    LocalDate dateTransaction;
    @ManyToOne
    Compte compteExpediteur;
    @ManyToOne
    Compte compteDestinataire;



}
