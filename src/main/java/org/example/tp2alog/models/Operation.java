package org.example.tp2alog.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_OP", length = 1)
public abstract class Operation {
    @Id
    private String numero;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    private double montant;

    @ManyToOne
    @JoinColumn(name = "NUMERO_COMPTE")
    private Compte compte;
}
