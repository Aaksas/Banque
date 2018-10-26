package com.example.Banque.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("CC")
public class CompteCourant extends Compte{

	private Double decouvert;

	public Double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(Double decouvert) {
		this.decouvert = decouvert;
	}



	public CompteCourant(String numCompte, Date date, Double solde, Client client, Double decouvert) {
		super(numCompte, date, solde, client);
		this.decouvert = decouvert;
	}

	public CompteCourant() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
