package ma.cigma.pfe.module1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.cigma.pfe.module1.dao.ClientRepository;
import ma.cigma.pfe.module1.models.Client;

@Service    // c = new ClientServiceImpl()
public class ClientServiceImpl implements IClientService{
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Override
	public Client create(Client c) {
		return clientRepository.save(c);
	}

	@Override
	public Client update(Client newC) {
		Client old = clientRepository.findById(newC.getId()).get();
		old.setCin(newC.getCin());
		old.setNom(newC.getNom());
		return clientRepository.save(old);
	}

	@Override
	public void delete(int id) {
		clientRepository.deleteById(id);
	}

	@Override
	public List<Client> selectAll() {
		return (List<Client>) clientRepository.findAll();
	}

	@Override
	public Client selectOne(int id) {
		return clientRepository.findById(id).get();
	}

}
