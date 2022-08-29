package Teste.com.teste.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Teste.com.teste.DTO.FuncaoDTO;
import Teste.com.teste.Model.Funcao;
import Teste.com.teste.Repository.FuncaoRepository;

@Service
public class FuncaoService {
	
	@Autowired
	private FuncaoRepository repository;
	
	public List<FuncaoDTO> findAll() {
		List<Funcao> result = repository.findAll();
		return result.stream().map(x -> new
		FuncaoDTO(x)).collect(Collectors.toList());
	}
	
	public Funcao findById(Long id) {
		Optional<Funcao> v = repository.findById(id);
		return v.get();
	}
	
	public Funcao save(Funcao Funcao) {
		Funcao v = repository.save(Funcao);
		return v;
	}
	
	@Transactional
	public Funcao update(Long id,Funcao Funcao) {
		Funcao v = repository.getById(id);
		v.setId(id); 
		v.setNome(Funcao.getNome());
		Funcao vendpt = repository.save(v);
		return vendpt;
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
