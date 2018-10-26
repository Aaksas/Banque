package com.example.Banque.Metier;

import java.util.Date;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Banque.DAO.CompteRepository;
import com.example.Banque.DAO.OpérationRepository;
import com.example.Banque.entities.Compte;
import com.example.Banque.entities.CompteCourant;
import com.example.Banque.entities.Opération;
import com.example.Banque.entities.Retrait;
import com.example.Banque.entities.Versement;
@Service
 @Transactional
public class BanqueMetierImpl implements IBanqueMetier {
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private OpérationRepository opérationRepository;

	@Override
	public Compte ConsulterCompte(String code) {
		Optional<Compte> cp = compteRepository.findById(code);
		//if (cp == null) { throw new RuntimeException("f");}
		return cp.get() ;
	}

	@Override
	public void verser(String code, double montant) {
		Compte cp = ConsulterCompte(code);
		Versement v = new Versement(new Date(), montant, cp);
		opérationRepository.save(v);
		//cp.setSolde(cp.getSolde()+montant);
		cp.setSolde(cp.getSolde() + montant);
		compteRepository.save(cp);
		
		
	}

	@Override
	public void retirer(String code, double montant) {
		Compte cp = ConsulterCompte(code);
		double a=0;
		if (cp instanceof CompteCourant)
			a=((CompteCourant) cp).getDecouvert();
		if (cp.getSolde()+a < montant)
			throw new RuntimeException("Montant insuffisant");
		Retrait r = new Retrait(new Date(), montant, cp);
		opérationRepository.save(r);
		cp.setSolde(cp.getSolde()-montant);
		compteRepository.save(cp);
		
	}

	@Override
	public void virement(String code1, String code2, double montant) {
		
		if(code1.equals(code2)) {
			throw new RuntimeException("Aaaaaaaaaampossible");
			
		}
		verser(code1, montant);
		retirer(code2, montant);
	}

	@Override
	public Page<Opération> listOpération(String code, int page, int size) {
		// TODO Auto-generated method stub
		return opérationRepository.listOpération(code, PageRequest.of(page, size));
	}

}
