package com.example.Banque.DAO;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Banque.entities.Compte;

public interface CompteRepository extends JpaRepository<Compte, String>{

	void save(Optional<Compte> cp);

}
