package ma.cigma.pfe.module1.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ma.cigma.pfe.module1.models.Facture;

@Repository
public interface IFactureDao extends CrudRepository<Facture, Integer>{
	
}
