package com.example.Banque.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("R")

public class Retrait extends Opération {

	public Retrait(Date date, Double montant, Compte compte) {
		super(date, montant, compte);
		// TODO Auto-generated constructor stub
	}

	public Retrait() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
