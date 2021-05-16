package ma.cigma.pfe.module1.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ma.cigma.pfe.module1.models.Produit;

@Repository // Spring data
public interface ProduitRepository extends CrudRepository<Produit, Integer>{
	List<Produit> findByName(String name);
	void deleteByName(String name);
}
