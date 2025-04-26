package org.example.tp2alog.models;



import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("CC")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompteCourant extends Compte {
    private double decouvert;
}
