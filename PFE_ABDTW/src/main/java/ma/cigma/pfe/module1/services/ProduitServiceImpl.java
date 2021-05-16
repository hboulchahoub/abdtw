package ma.cigma.pfe.module1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.cigma.pfe.module1.dao.ProduitRepository;
import ma.cigma.pfe.module1.models.Produit;

@Service
public class ProduitServiceImpl implements IProduitService{
	
	@Autowired
	private ProduitRepository produitRepository;
	
	@Override
	public Produit insert(Produit c) {
		// RG1
		// RG2
		// RG3
		return produitRepository.save(c);
	}

	@Override
	public Produit update(Produit nouveau) {
		Produit old = produitRepository.findById(nouveau.getId()).get();
		old.setName(nouveau.getName());
		return produitRepository.save(old);
	}

	@Override
	public void delete(int id) {
		produitRepository.deleteById(id);
	}

	@Override
	public Produit selectOne(int id) {
		return produitRepository.findById(id).get();
	}

	@Override
	public List<Produit> selectAll() {
		return (List<Produit>) produitRepository.findAll();
	}

	@Override
	public List<Produit> selectByName(String name) {
		return produitRepository.findByName(name);
	}

}
