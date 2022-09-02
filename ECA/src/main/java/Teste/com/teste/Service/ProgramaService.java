package Teste.com.teste.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Teste.com.teste.DTO.ProgramaDTO;
import Teste.com.teste.Model.Programa;
import Teste.com.teste.Repository.ProgramaRepository;

@Service
public class ProgramaService {
	
	@Autowired
	private ProgramaRepository repository;
	
	public List<ProgramaDTO> findAll() {
		List<Programa> result = repository.findAll();
		return result.stream().map(x -> new
		ProgramaDTO(x)).collect(Collectors.toList());
	}
	
	public Programa findById(Long id) {
		Optional<Programa> v = repository.findById(id);
		return v.get();
	}
	
	public Programa save(Programa Programa) {
		Programa v = repository.save(Programa);
		return v;
	}
	
	@Transactional
	public Programa update(Long id,Programa Programa) {
		Programa v = repository.getById(id);
		v.setId(id); 
		v.setNome(Programa.getNome());
		Programa vendpt = repository.save(v);
		return vendpt;
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
