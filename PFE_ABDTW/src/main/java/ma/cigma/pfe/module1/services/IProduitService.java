package ma.cigma.pfe.module1.services;

import java.util.List;

import ma.cigma.pfe.module1.models.Produit;

public interface IProduitService {
	Produit insert(Produit c);
	Produit update(Produit c);
	void delete(int id);
	Produit selectOne(int id);
	List<Produit> selectByName(String name);
	List<Produit> selectAll();
}
