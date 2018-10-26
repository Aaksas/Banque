package com.example.Banque.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Banque.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
