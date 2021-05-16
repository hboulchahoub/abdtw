package ma.cigma.pfe.module1.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ma.cigma.pfe.module1.models.Command;

@Repository // Instancier o
public interface CommandRepository extends CrudRepository<Command, Integer>{

}
