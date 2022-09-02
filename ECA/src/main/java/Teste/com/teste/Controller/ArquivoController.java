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

import Teste.com.teste.DTO.ArquivoDTO;
import Teste.com.teste.Model.Arquivo;
import Teste.com.teste.Service.ArquivoService;

@RestController
@RequestMapping(value = "/arquivos")
public class ArquivoController {
	
	@Autowired
	private ArquivoService service;
	
	@GetMapping
	public ResponseEntity<List<ArquivoDTO>> findAll() {
		System.out.println("List of Files:");
		List<ArquivoDTO> list = service.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ArquivoDTO> findById(@PathVariable Long id) {
		System.out.println("File: " + id);
		ArquivoDTO v = new ArquivoDTO(service.findById(id));
		return ResponseEntity.ok(v);
	}
	
	@PostMapping
	public ResponseEntity<Arquivo> save(@RequestBody Arquivo Arquivo) throws Exception {
		try {
			Arquivo save = service.save(Arquivo);
			System.out.println("New File Saved Sucessfully.");
			return new ResponseEntity<>(save, null, HttpStatus.CREATED);
		}
		catch(Exception ex) {
			throw new Exception(ex);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Arquivo> update(@PathVariable Long id,@RequestBody Arquivo Arquivo) {
		System.out.println("File " + id + " Updated Sucessfully.");
		return ResponseEntity.ok(service.update(id, Arquivo));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		System.out.println("File " + id + " Deleted Sucessfully.");
		service.delete(id);
		return ResponseEntity.ok().build();
	}

}
