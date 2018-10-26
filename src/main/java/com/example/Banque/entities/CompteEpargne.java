package com.example.Banque.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("CE")
public class CompteEpargne extends Compte {
	private double taux;

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

	public CompteEpargne() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompteEpargne(String numCompte, Date date, Double solde, Client client, double taux) {
		super(numCompte, date, solde, client);
		this.taux = taux;
	}
	

}
