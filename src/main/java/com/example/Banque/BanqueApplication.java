package com.example.Banque;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.Banque.DAO.ClientRepository;
import com.example.Banque.DAO.CompteRepository;
import com.example.Banque.DAO.OpérationRepository;
import com.example.Banque.Metier.IBanqueMetier;
import com.example.Banque.entities.Client;
import com.example.Banque.entities.Compte;
import com.example.Banque.entities.CompteCourant;
import com.example.Banque.entities.CompteEpargne;
import com.example.Banque.entities.Retrait;
import com.example.Banque.entities.Versement;

@SpringBootApplication
public class BanqueApplication implements CommandLineRunner {
	@Autowired
	private ClientRepository clientrepository;
	@Autowired
	private CompteRepository compterepository;
	@Autowired
	private OpérationRepository opérationrepository;
	@Autowired
	private IBanqueMetier banqueMetier;
	 


	public static void main(String[] args) {
		SpringApplication.run(BanqueApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Client c1 = clientrepository.save(new Client("Ayoub", "ayoub01@gmail.com"));
		Client c2 = clientrepository.save(new Client("Ali", "ali01@gmail.com"));
		Client c3 = clientrepository.save(new Client("hamza", "hamza01@gmail.com"));
		
	    Compte p1 = compterepository.save(new CompteCourant("c2", new Date(), 1000.0, c2, 100.0));
	    Compte p2 = compterepository.save(new CompteEpargne("c3", new Date(), 10000.0, c3, 12.0));
		opérationrepository.save(new Versement(new Date(), 40000.5, p1));
		opérationrepository.save(new Versement(new Date(), 400.0, p2));
		opérationrepository.save(new Retrait(new Date(), 500.0, p1));
		opérationrepository.save(new Versement(new Date(), 100.0, p1));
		opérationrepository.save(new Retrait(new Date(), 500.0, p1));
		
		banqueMetier.verser("c2", 4.0);
		
		
		
	}
}
