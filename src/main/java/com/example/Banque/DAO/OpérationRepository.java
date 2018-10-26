package com.example.Banque.DAO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Banque.entities.Opération;

public interface OpérationRepository extends JpaRepository<Opération, Long> {
	@Query("select o from Opération o where o.compte.numCompte=:x order by o.date desc")
	public Page<Opération> listOpération(@Param("x")String code, Pageable pageable);

}
