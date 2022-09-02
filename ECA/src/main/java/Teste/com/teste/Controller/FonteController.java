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

import Teste.com.teste.DTO.FonteDTO;
import Teste.com.teste.Model.Fonte;
import Teste.com.teste.Service.FonteService;

@RestController
@RequestMapping(value = "/fontes")
public class FonteController {
	
	@Autowired
	private FonteService service;
	
	@GetMapping
	public ResponseEntity<List<FonteDTO>> findAll() throws Exception {
		try {
			System.out.println("List of Sources:");
			List<FonteDTO> list = service.findAll();
			return ResponseEntity.ok(list);
		}
		catch(Exception ex) {
			throw new Exception(ex);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<FonteDTO> findById(@PathVariable Long id) throws Exception {
		try {
			System.out.println("Source: " + id);
			FonteDTO v = new FonteDTO(service.findById(id));
			return ResponseEntity.ok(v);
		}
		catch(Exception ex) {
			throw new Exception(ex);
		}
	}
	
	@PostMapping
	public ResponseEntity<Fonte> save(@RequestBody Fonte Fonte) throws Exception {
		try {
			Fonte save = service.save(Fonte);
			System.out.println("New Source Saved Sucessfully.");
			return new ResponseEntity<>(save, null, HttpStatus.CREATED);
		}
		catch(Exception ex) {
			throw new Exception(ex);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Fonte> update(@PathVariable Long id,@RequestBody Fonte Fonte) throws Exception {
		try {
		System.out.println("Function " + id + " Updated Sucessfully.");
		return ResponseEntity.ok(service.update(id, Fonte));
		}
		catch(Exception ex) {
			throw new Exception(ex);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) throws Exception {
		try {
			System.out.println("Source " + id + " Deleted Sucessfully.");
			service.delete(id);
			return ResponseEntity.ok().build();
		}
		catch(Exception ex) {
			throw new Exception(ex);
		}
	}

}
