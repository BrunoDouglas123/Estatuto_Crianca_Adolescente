package Teste.com.teste.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Teste.com.teste.DTO.ProgramaDTO;
import Teste.com.teste.Model.Programa;
import Teste.com.teste.Service.ProgramaService;

@RestController
@RequestMapping(value = "/programas")
public class ProgramaController {
	
	@Autowired
	private ProgramaService service;
	
	@GetMapping
	public ResponseEntity<List<ProgramaDTO>> findAll() {
			System.out.println("List of Actions:");
			List<ProgramaDTO> list = service.findAll();
			return ResponseEntity.ok(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProgramaDTO> findById(@PathVariable Long id) throws Exception {
		try {
			System.out.println("Action: " + id);
			ProgramaDTO v = new ProgramaDTO(service.findById(id));
			return ResponseEntity.ok(v);
		}
		catch(Exception ex) {
			throw new Exception(ex);
		}
	}
	
	@PostMapping
	public ResponseEntity<Programa> save(@RequestBody Programa Programa) throws Exception {
		try {
			Programa save = service.save(Programa);
			System.out.println("New Action Saved Sucessfully.");
			return new ResponseEntity<>(save, null, HttpStatus.CREATED);
		}
		catch(Exception ex) {
			throw new Exception(ex);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Programa> update(@PathVariable Long id,@RequestBody Programa Programa) throws Exception {
		try {
		System.out.println("Action " + id + " Updated Sucessfully.");
		return ResponseEntity.ok(service.update(id, Programa));
		}
		catch(Exception ex) {
			throw new Exception(ex);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) throws Exception {
		try {
			System.out.println("Action " + id + " Deleted Sucessfully.");
			service.delete(id);
			return ResponseEntity.ok().build();
		}
		catch(Exception ex) {
			throw new Exception(ex);
		}
	}
}
