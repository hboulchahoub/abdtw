package ma.cigma.pfe.module1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.cigma.pfe.module1.models.Client;
import ma.cigma.pfe.module1.services.IClientService;

// /clients/delete/3 -> supprimer le client 2
@RestController
@RequestMapping("/clients")
public class ClientController {
	@Autowired
	private IClientService clientService;
	
	@PostMapping(path="/create")
	public Client create(@RequestBody Client c) {
		return clientService.create(c);
	}
	@PutMapping(path="/update")
	public Client update(@RequestBody Client c) {
		return clientService.update(c);
	}
	
	@DeleteMapping(path="/{id}")
	public void delete(@PathVariable("id") int clientId) {
		clientService.delete(clientId);
	}
	@GetMapping(path="/{id}")
	public Client getOne(@PathVariable("id") int clientId) {
		return clientService.selectOne(clientId);
	}
	
	@GetMapping(path="/all")
	public List<Client> getAll(){
		return clientService.selectAll();
	}

}
