package com.itserv.tn.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itserv.tn.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
	List<Client> findByEmailAndMdp(String email, String mdp);
	Optional<Client> findByEmail(String adr);
	Optional<Client>  findById(Integer id);

}
