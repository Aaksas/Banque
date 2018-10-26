package com.example.Banque.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity

public class Client implements Serializable{
	
	@Id @GeneratedValue
	private Long id;
	private String nom;
	private String email;
	@OneToMany(mappedBy="client", fetch=FetchType.LAZY)
	private Collection<Compte> compte;
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Client(String nom, String email) {
		super();
		this.nom = nom;
		this.email = email;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Collection<Compte> getCompte() {
		return compte;
	}
	public void setCompte(Collection<Compte> compte) {
		this.compte = compte;
	}


}
