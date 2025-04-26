package org.example.tp2alog.models;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE", length = 2)
public abstract class Compte {
    @Id
    private String numero;

    @Temporal(TemporalType.DATE)
    private Date dateCreation;

    private double solde;

    @ManyToOne
    @JoinColumn(name = "CODE_CLIENT")
    private Client client;

    @OneToMany(mappedBy = "compte", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Operation> operations;
}
