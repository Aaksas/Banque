package com.example.Banque.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("V")
public class Versement extends Opération{

	public Versement(Date date, Double montant, Compte compte) {
		super(date, montant, compte);
		// TODO Auto-generated constructor stub
	}

	public Versement() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
