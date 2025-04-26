package org.example.tp2alog.services;



import lombok.RequiredArgsConstructor;
import org.example.tp2alog.models.Compte;
import org.example.tp2alog.models.Operation;
import org.example.tp2alog.repositories.CompteRepository;
import org.example.tp2alog.repositories.OperationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CompteServiceImpl implements CompteService {

    private final CompteRepository compteRepository;
    private final OperationRepository operationRepository;

    @Override
    public Optional<Compte> getCompteByNumero(String numero) {
        return compteRepository.findById(numero);
    }

    @Override
    public List<Operation> getOperationsByCompte(Compte compte) {
        return operationRepository.findByCompteOrderByDateDesc(compte);
    }
}
