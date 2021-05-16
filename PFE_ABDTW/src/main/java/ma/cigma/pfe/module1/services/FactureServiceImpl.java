package ma.cigma.pfe.module1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.cigma.pfe.module1.dao.FactureRepository;
import ma.cigma.pfe.module1.models.Facture;

@Service
public class FactureServiceImpl implements IFactureService {
	@Autowired 
	private FactureRepository factureRepository; 

	@Override
	@Transactional
	public Facture create(Facture f) {
		return factureRepository.save(f);
	}
	
	@Override
	@Transactional
	public Facture update(Facture nouvelle) {
		Facture old  = factureRepository.findById(nouvelle.getId()).get();
		old.setDescription(nouvelle.getDescription());
		old.setMontant(nouvelle.getMontant());
		return factureRepository.save(old);
	}

	@Override
	@Transactional
	public void delete(int id) {
		factureRepository.deleteById(id);
	}

	@Override
	public List<Facture> findAll() {
		return (List<Facture>) factureRepository.findAll();
	}

}
