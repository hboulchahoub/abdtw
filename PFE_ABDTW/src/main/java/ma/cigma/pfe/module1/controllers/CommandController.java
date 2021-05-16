package ma.cigma.pfe.module1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.cigma.pfe.module1.models.Command;
import ma.cigma.pfe.module1.services.ICommandService;

@RestController
@RequestMapping(path="/api/cmds")
public class CommandController {
	@Autowired
	private ICommandService commandService;
	
	@GetMapping("/{id}")
	public Command getOne(@PathVariable("id")   int id ) {
		return commandService.selectOne(id);
	}
	@GetMapping("/all")
	public List<Command> getAll() {
		return commandService.selectAll();	
	}
	
	@PostMapping(path="/create")
	public Command create(@RequestBody  Command cmd) {
		return commandService.insert(cmd);
	}
	@PutMapping("/update")
	public Command update(@RequestBody  Command cmd) {
		return commandService.update(cmd);
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id")   int id ) {
		commandService.delete(id);
	}
}
