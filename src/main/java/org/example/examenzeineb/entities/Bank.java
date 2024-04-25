package org.example.examenzeineb.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@ToString
public class Bank implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long idBank;
    String nom;
    String agence;
    String adresse ;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Compte> Comptes;


}
