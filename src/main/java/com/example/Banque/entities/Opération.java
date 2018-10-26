package com.example.Banque.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Optional;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name ="TYPE_OPE" , length = 1 , discriminatorType = DiscriminatorType.STRING)
public abstract class Opération implements Serializable {
	@Id @GeneratedValue
	private Long numOperation;
	private Date date;
	private Double montant;
	@ManyToOne
	@JoinColumn(name = "CODE")
	private Compte compte;
	public Opération() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getNumOperation() {
		return numOperation;
	}
	public void setNumOperation(Long numOperation) {
		this.numOperation = numOperation;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Double getMontant() {
		return montant;
	}
	public void setMontant(Double montant) {
		this.montant = montant;
	}
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	public Opération(Date date, Double montant, Compte cp) {
		super();
		this.date = date;
		this.montant = montant;
		this.compte = cp;
	}

}
