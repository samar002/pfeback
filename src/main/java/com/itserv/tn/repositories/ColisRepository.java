package com.itserv.tn.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.itserv.tn.entities.Client;
import com.itserv.tn.entities.Colis;
@Repository
public interface ColisRepository extends JpaRepository<Colis, Integer> {
	
}
