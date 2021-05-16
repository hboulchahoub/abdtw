package ma.cigma.pfe.module1.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.cigma.pfe.module1.dao.CommandRepository;
import ma.cigma.pfe.module1.models.Command;

@Service // Instancier CommandServiceImpl
public class CommandServiceImpl implements ICommandService{
	
	@Autowired // Injection Dependence
	private CommandRepository commandRepository; //=o

	@Override
	@Transactional
	public Command insert(Command c) {
		return commandRepository.save(c);
	}

	@Override
	@Transactional
	public Command update(Command newC) {
		Command old = commandRepository.findById(newC.getId()).get();
		old.setDate(newC.getDate());
		old.setDescription(newC.getDescription());
		return commandRepository.save(old);
	}

	@Override
	@Transactional
	public void delete(int id) {
		commandRepository.deleteById(id);
	}

	@Override
	public Command selectOne(int id) {
		return commandRepository.findById(id).get();
	}

	@Override
	public List<Command> selectAll() {
		return (List<Command>) commandRepository.findAll();
	}

}
