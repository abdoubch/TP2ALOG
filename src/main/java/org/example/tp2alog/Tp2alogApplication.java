package org.example.tp2alog;

import org.example.tp2alog.models.*;
import org.example.tp2alog.repositories.ClientRepository;
import org.example.tp2alog.repositories.CompteRepository;
import org.example.tp2alog.repositories.OperationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class Tp2alogApplication {

    public static void main(String[] args) {
        SpringApplication.run(Tp2alogApplication.class, args);
    }
    @Bean
    CommandLineRunner start(ClientRepository clientRepository,
                            CompteRepository compteRepository,
                            OperationRepository operationRepository) {
        return args -> {
            // Create clients
            Client client1 = new Client();
            client1.setCode(1);
            client1.setNom("Ahmed Ben Ali");
            client1.setEmail("ahmed@gmail.com");
            clientRepository.save(client1);

            Client client2 = new Client();
            client2.setCode(2);
            client2.setNom("Fatma Salah");
            client2.setEmail("fatma@gmail.com");
            clientRepository.save(client2);

            // Create accounts
            CompteCourant compteCourant = new CompteCourant();
            compteCourant.setNumero("CC1");
            compteCourant.setDateCreation(new Date());
            compteCourant.setSolde(9000);
            compteCourant.setClient(client1);
            compteCourant.setDecouvert(5000);
            compteRepository.save(compteCourant);

            CompteEpargne compteEpargne = new CompteEpargne();
            compteEpargne.setNumero("CE1");
            compteEpargne.setDateCreation(new Date());
            compteEpargne.setSolde(16000);
            compteEpargne.setClient(client2);
            compteEpargne.setTaux(5.5);
            compteRepository.save(compteEpargne);

            // Create operations
            Versement v1 = new Versement();
            v1.setNumero(UUID.randomUUID().toString());
            v1.setDate(new Date());
            v1.setMontant(5000);
            v1.setCompte(compteCourant);
            operationRepository.save(v1);

            Versement v2 = new Versement();
            v2.setNumero(UUID.randomUUID().toString());
            v2.setDate(new Date());
            v2.setMontant(3000);
            v2.setCompte(compteCourant);
            operationRepository.save(v2);

            Retrait r1 = new Retrait();
            r1.setNumero(UUID.randomUUID().toString());
            r1.setDate(new Date());
            r1.setMontant(2000);
            r1.setCompte(compteCourant);
            operationRepository.save(r1);

            Versement v3 = new Versement();
            v3.setNumero(UUID.randomUUID().toString());
            v3.setDate(new Date());
            v3.setMontant(10000);
            v3.setCompte(compteEpargne);
            operationRepository.save(v3);
        };
    }

}
