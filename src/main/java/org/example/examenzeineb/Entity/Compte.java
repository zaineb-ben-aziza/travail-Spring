package org.example.examenzeineb.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Compte implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idCompte;
    @Enumerated(EnumType.STRING)
   TypeCompte type;
     Long code;
    Double solde;
    @ManyToOne
    @JoinColumn(name = "bank_id")
    Bank bank;


}
