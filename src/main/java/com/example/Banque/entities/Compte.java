package com.example.Banque.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



@Inheritance( strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name ="TYPE_CPTE" , length = 2 , discriminatorType =DiscriminatorType.STRING )
@Entity
public  abstract class Compte implements Serializable {
	@Id
	private String numCompte;
	private Date date;
	private Double solde;
	@ManyToOne
	@JoinColumn( name = "CODE_CLI")
	private Client client;
	@OneToMany(mappedBy="compte" , fetch= FetchType.LAZY)
	private Collection<Opération> operation;
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Compte(String numCompte, Date date, Double solde, Client client) {
		super();
		this.numCompte = numCompte;
		this.date = date;
		this.solde = solde;
		this.client = client;
	}
	public String getNumCompte() {
		return numCompte;
	}
	public void setNumCompte(String numCompte) {
		this.numCompte = numCompte;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Double getSolde() {
		return solde;
	}
	public void setSolde(Double solde) {
		this.solde = solde;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Collection<Opération> getOperation() {
		return operation;
	}
	public void setOperation(Collection<Opération> operation) {
		this.operation = operation;
	}
	

}
