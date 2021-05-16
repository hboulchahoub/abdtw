package ma.cigma.pfe.module1.services;

import java.util.List;

import ma.cigma.pfe.module1.models.Client;

public interface IClientService {
	Client create(Client c);
	Client update(Client c);
	void delete(int id);
	List<Client> selectAll();
	Client selectOne(int id);
}
