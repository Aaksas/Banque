package com.example.Banque.Metier;

import java.util.Optional;

import org.springframework.data.domain.Page;

import com.example.Banque.entities.Compte;
import com.example.Banque.entities.Opération;

public interface IBanqueMetier {
	public Compte ConsulterCompte (String code);
	public void verser(String code ,double  montant);
	public void retirer(String code ,double  montant);
	public void virement(String code1 ,String code2,double montant);
	public Page<Opération> listOpération(String code, int page, int size);
	
	
}
