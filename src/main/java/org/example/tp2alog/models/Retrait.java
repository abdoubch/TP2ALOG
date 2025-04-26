package org.example.tp2alog.models;



import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("R")
@NoArgsConstructor
public class Retrait extends Operation {
}
