package org.example.tp2alog.repositories;


import org.example.tp2alog.models.Compte;
import org.example.tp2alog.models.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationRepository extends JpaRepository<Operation, String> {
    List<Operation> findByCompteOrderByDateDesc(Compte compte);
}
