package Teste.com.teste.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Teste.com.teste.DTO.BeneficiarioDTO;
import Teste.com.teste.Model.Beneficiario;
import Teste.com.teste.Repository.BeneficiarioRepository;

@Service
public class BeneficiarioService {
	
	@Autowired
	private BeneficiarioRepository repository;
	
	public List<BeneficiarioDTO> findAll() {
		List<Beneficiario> result = repository.findAll();
		return result.stream().map(x -> new
		BeneficiarioDTO(x)).collect(Collectors.toList());
	}
	
	public Beneficiario findById(Long id) {
		Optional<Beneficiario> v = repository.findById(id);
		return v.get();
	}
	
	public Beneficiario save(Beneficiario Beneficiario) {
		Beneficiario v = repository.save(Beneficiario);
		return v;
	}
	
	@Transactional
	public Beneficiario update(Long id,Beneficiario Beneficiario) {
		Beneficiario v = repository.getById(id);
		v.setId(id); 
		v.setNome(Beneficiario.getNome());
		Beneficiario vendpt = repository.save(v);
		return vendpt;
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
