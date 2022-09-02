package Teste.com.teste.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Teste.com.teste.DTO.FonteDTO;
import Teste.com.teste.Model.Fonte;
import Teste.com.teste.Repository.FonteRepository;

@Service
public class FonteService {
	
	@Autowired
	private FonteRepository repository;
	
	public List<FonteDTO> findAll() {
		List<Fonte> result = repository.findAll();
		return result.stream().map(x -> new
		FonteDTO(x)).collect(Collectors.toList());
	}
	
	public Fonte findById(Long id) {
		Optional<Fonte> v = repository.findById(id);
		return v.get();
	}
	
	public Fonte save(Fonte Fonte) {
		Fonte v = repository.save(Fonte);
		return v;
	}
	
	@Transactional
	public Fonte update(Long id,Fonte Fonte) {
		Fonte v = repository.getById(id);
		v.setId(id); 
		v.setMeta(Fonte.getMeta());
		v.setOrigem(Fonte.getOrigem());
		v.setPeriodicidade(Fonte.getPeriodicidade());
		Fonte vendpt = repository.save(v);
		return vendpt;
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
