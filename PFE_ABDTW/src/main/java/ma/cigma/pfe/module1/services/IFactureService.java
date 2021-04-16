package ma.cigma.pfe.module1.services;

import java.util.List;

import ma.cigma.pfe.module1.models.Facture;

public interface IFactureService {
	
	Facture create(Facture d);
	Facture update(Facture d);
	void delete(int id);
	List<Facture> findAll();

}
