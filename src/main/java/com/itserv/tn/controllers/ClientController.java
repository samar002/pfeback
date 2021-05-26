package com.itserv.tn.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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
import com.itserv.tn.repositories.ClientRepository;

import ch.qos.logback.core.status.Status;



@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping({ "/clients" })   
public class ClientController {
	@Autowired
	private ClientRepository clientRepo;
	
	
	@GetMapping("/all")
	public List<Client> getAllClientss() {
		return clientRepo.findAll();
	}
	
	@PostMapping("/create")
	public Client createClient(@RequestBody Client client) {
		/*Client cl = new Client();
		cl.setfName("foulena");
		cl.setlName("Ben foulena");
		cl.setEmail("fouena@gmail.com");
		*/
		return clientRepo.save(client);
	}
	@PutMapping("/modif/{Id}")
	public Client modif(@RequestBody Client user, @PathVariable Integer Id){
	    user.setId(Id);
	    Client cl= clientRepo.saveAndFlush(user);
	    return cl;
	}
	@DeleteMapping("/delet/{Id}")
	public HashMap<String,String> deleteCustomer(@PathVariable Integer Id){
	    HashMap hashMap=new HashMap();
	    try{
	    	clientRepo.deleteById(Id);
	        hashMap.put("etat","client  supprimé");
	        return hashMap;
	    }
	    catch (Exception e){
	        hashMap.put("etat","client  non supprimé"+e.getMessage());
	        return hashMap;
	    }
	}

	 @PostMapping("/login")
	    public Client loginUser(@Validated @RequestBody Client client ) {
	        List<Client> cl = clientRepo.findByEmailAndMdp(client.getEmail(),client.getMdp());
	        System.out.print(cl.size());
	 
	        return cl.get(0) ; 
	    }
	 
	 @GetMapping("/find/{email}")
	 public Optional<Client>  find(@PathVariable String email) {
	return  clientRepo.findByEmail(email);
	  
	 }
	 //  @PostMapping("/logout")
//	 public Status logUserOut(@Validated @RequestBody Client client) {
	//        List<Client> cl = clientRepo.findAll();
	  //     for (Client other : cl) {
	    //       if (other.equals(client)) {
	      //         client.setLoggedIn(false);
	        //      clientRepo.save(client);
	          //      return Status.SUCCESS;
	            //}
//	        }
	//        return Status.FAILURE;
	  // }
	
}
