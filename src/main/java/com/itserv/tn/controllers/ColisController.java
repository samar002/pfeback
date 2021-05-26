package com.itserv.tn.controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itserv.tn.entities.Client;
import com.itserv.tn.entities.Colis;
import com.itserv.tn.repositories.ClientRepository;
import com.itserv.tn.repositories.ColisRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping({ "/colis" })

public class ColisController {
	@Autowired
	private ColisRepository colisRepo;
	
	@GetMapping("/all")
	public List<Colis> getAllColis() {
		return colisRepo.findAll();
	}
	
	@PostMapping("/create")
	public Colis createColis(@RequestBody Colis colis) {
		/*Colis c = new Colis();
		c.setpoids("2kg");
		c.setlargeur("20cm");
		c.sethaut("20cm");
		*/
		return colisRepo.save(colis);
	}
	
	@PutMapping("/modif/{Id}")
	public Colis modif(@RequestBody Colis colis, @PathVariable Integer Id){
	    colis.setId(Id);
	    Colis c= colisRepo.saveAndFlush(colis);
	    return c;
	}
	@DeleteMapping("/delet/{Id}")
	public HashMap<String,String> deleteCustomer(@PathVariable Integer Id){
	    HashMap hashMap=new HashMap();
	    try{
	    	colisRepo.deleteById(Id);
	        hashMap.put("etat","colis supprimé");
	        return hashMap;
	    }
	    catch (Exception e){
	        hashMap.put("etat","colis non supprimé"+e.getMessage());
	        return hashMap;
	    }
	}


}
