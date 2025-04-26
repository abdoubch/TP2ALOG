package org.example.tp2alog.services;



import org.example.tp2alog.models.Compte;
import org.example.tp2alog.models.Operation;

import java.util.List;
import java.util.Optional;

public interface CompteService {
    Optional<Compte> getCompteByNumero(String numero);
    List<Operation> getOperationsByCompte(Compte compte);
}