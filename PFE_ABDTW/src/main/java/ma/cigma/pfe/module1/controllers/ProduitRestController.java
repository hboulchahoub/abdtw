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

import ma.cigma.pfe.module1.models.Produit;
import ma.cigma.pfe.module1.services.IProduitService;

// annotation
@RestController
@RequestMapping("/api/produits")
public class ProduitRestController {
	
	// attribut
	@Autowired
	private IProduitService service;
	
	// INSERT -> POST
	@PostMapping("/create")
	public Produit insert(@RequestBody Produit p) {
			return service.insert(p);
	}
	// UPDATE -> PUT
	@PutMapping("/update")
	public Produit update(@RequestBody Produit p) {
		return service.update(p);
	}
	// SELECT ONE -> GET
	@GetMapping(path="/{id}")
	public Produit getOne(@PathVariable("id") int id) {
		return service.selectOne(id);
	}
	
	@GetMapping("/search")
	public List<Produit>  getByName(@RequestBody Produit p) {
		return service.selectByName(p.getName());
	}
	
	// SELECT ALL -> GET
	@GetMapping("/all")
	public List<Produit> getAll() {
		return service.selectAll();
	}
	// DELETE -> DELETE
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") int id) {
		 service.delete(id);
	}

}
