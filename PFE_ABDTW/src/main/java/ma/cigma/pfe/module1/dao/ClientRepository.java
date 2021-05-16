package ma.cigma.pfe.module1.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ma.cigma.pfe.module1.models.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer>{

}
