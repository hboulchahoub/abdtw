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

import ma.cigma.pfe.module1.models.Facture;
import ma.cigma.pfe.module1.services.IFactureService;

// NAVIGATOR : URL = http://localhost:8080/PFE_ABDTW/factures/all
@RestController
@RequestMapping("/factures")
public class FactureController {
	
	/*
	CREATE RESOURCE ==> @PostMapping
	READ RESOURCE   ==> @GetMapping
	UPDATE RESOURCE ==> @PutMapping
	DELETE RESOURCE ==> @DeleteMapping
	*/
	
	@Autowired
	private IFactureService service; // #null (i) @Service (ii) @Autowired

	@PostMapping("/add")
	public Facture create(@RequestBody Facture f) {
		return service.create(f);
	}
	
	@PutMapping("/update")
	public Facture update(@RequestBody Facture f) {
		return service.update(f);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") int id) {
		service.delete(id);
	}

	@GetMapping("/all")
	public List<Facture> findAll() {
		return service.findAll();
	}


}
