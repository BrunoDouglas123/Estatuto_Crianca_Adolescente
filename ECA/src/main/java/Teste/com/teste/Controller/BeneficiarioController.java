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

import Teste.com.teste.DTO.BeneficiarioDTO;
import Teste.com.teste.Model.Beneficiario;
import Teste.com.teste.Service.BeneficiarioService;

@RestController
@RequestMapping(value = "/beneficiarios")
public class BeneficiarioController {
	
	@Autowired
	private BeneficiarioService service;
	
	@GetMapping
	public ResponseEntity<List<BeneficiarioDTO>> findAll() {
		System.out.println("List of Beneficiaries:");
		List<BeneficiarioDTO> list = service.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BeneficiarioDTO> findById(@PathVariable Long id) {
		System.out.println("Beneficiary: " + id);
		BeneficiarioDTO v = new BeneficiarioDTO(service.findById(id));
		return ResponseEntity.ok(v);
	}
	
	@PostMapping
	public ResponseEntity<Beneficiario> save(@RequestBody Beneficiario Beneficiario) throws Exception {
		try {
			Beneficiario save = service.save(Beneficiario);
			System.out.println("New Beneficiary Saved Sucessfully.");
			return new ResponseEntity<>(save, null, HttpStatus.CREATED);
		}
		catch(Exception ex) {
			throw new Exception(ex);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Beneficiario> update(@PathVariable Long id,@RequestBody Beneficiario Beneficiario) {
		System.out.println("Beneficiary " + id + " Updated Sucessfully.");
		return ResponseEntity.ok(service.update(id, Beneficiario));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		System.out.println("Beneficiary " + id + " Deleted Sucessfully.");
		service.delete(id);
		return ResponseEntity.ok().build();
	}

}
