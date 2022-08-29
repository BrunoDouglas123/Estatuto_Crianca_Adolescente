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

import Teste.com.teste.DTO.FuncaoDTO;
import Teste.com.teste.Model.Funcao;
import Teste.com.teste.Service.FuncaoService;

@RestController
@RequestMapping(value = "/funcoes")
public class FuncaoController {
	
	@Autowired
	private FuncaoService service;
	
	@GetMapping
	public ResponseEntity<List<FuncaoDTO>> findAll() {
		System.out.println("List of Functions:");
		List<FuncaoDTO> list = service.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<FuncaoDTO> findById(@PathVariable Long id) {
		System.out.println("Function: " + id);
		FuncaoDTO v = new FuncaoDTO(service.findById(id));
		return ResponseEntity.ok(v);
	}
	
	@PostMapping
	public ResponseEntity<Funcao> save(@RequestBody Funcao Funcao) throws Exception {
		try {
			Funcao save = service.save(Funcao);
			System.out.println("New Function Saved Sucessfully.");
			return new ResponseEntity<>(save, null, HttpStatus.CREATED);
		}
		catch(Exception ex) {
			throw new Exception(ex);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Funcao> update(@PathVariable Long id,@RequestBody Funcao Funcao) {
		System.out.println("Function " + id + " Updated Sucessfully.");
		return ResponseEntity.ok(service.update(id, Funcao));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		System.out.println("Function " + id + " Deleted Sucessfully.");
		service.delete(id);
		return ResponseEntity.ok().build();
	}

}
