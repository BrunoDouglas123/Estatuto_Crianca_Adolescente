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

import Teste.com.teste.DTO.AcaoDTO;
import Teste.com.teste.Model.Acao;
import Teste.com.teste.Service.AcaoService;

@RestController
@RequestMapping(value = "/acoes")
public class AcaoController {
	
	@Autowired
	private AcaoService service;
	
	@GetMapping
	public ResponseEntity<List<AcaoDTO>> findAll() throws Exception {
		try {
			System.out.println("List of Actions:");
			List<AcaoDTO> list = service.findAll();
			return ResponseEntity.ok(list);
		}
		catch(Exception ex) {
			throw new Exception(ex);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AcaoDTO> findById(@PathVariable Long id) throws Exception {
		try {
			System.out.println("Action: " + id);
			AcaoDTO v = new AcaoDTO(service.findById(id));
			return ResponseEntity.ok(v);
		}
		catch(Exception ex) {
			throw new Exception(ex);
		}
	}
	
	@PostMapping
	public ResponseEntity<Acao> save(@RequestBody Acao Acao) throws Exception {
		try {
			Acao save = service.save(Acao);
			System.out.println("New Action Saved Sucessfully.");
			return new ResponseEntity<>(save, null, HttpStatus.CREATED);
		}
		catch(Exception ex) {
			throw new Exception(ex);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Acao> update(@PathVariable Long id,@RequestBody Acao Acao) throws Exception {
		try {
		System.out.println("Action " + id + " Updated Sucessfully.");
		return ResponseEntity.ok(service.update(id, Acao));
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
