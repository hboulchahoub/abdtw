package ma.cigma.pfe.module1.services;

import java.util.List;

import ma.cigma.pfe.module1.models.Command;

public interface ICommandService {
	
	Command insert(Command c);
	Command update(Command c);
	void delete(int id);
	Command selectOne(int id);
	List<Command> selectAll();

}
