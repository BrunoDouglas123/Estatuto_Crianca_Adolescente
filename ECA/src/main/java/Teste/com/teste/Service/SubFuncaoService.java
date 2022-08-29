package Teste.com.teste.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Teste.com.teste.DTO.SubFuncaoDTO;
import Teste.com.teste.Model.SubFuncao;
import Teste.com.teste.Repository.SubFuncaoRepository;

@Service
public class SubFuncaoService {
	
	@Autowired
	private SubFuncaoRepository repository;
	
	public List<SubFuncaoDTO> findAll() {
		List<SubFuncao> result = repository.findAll();
		return result.stream().map(x -> new
		SubFuncaoDTO(x)).collect(Collectors.toList());
	}
	
	public SubFuncao findById(Long id) {
		Optional<SubFuncao> v = repository.findById(id);
		return v.get();
	}
	
	public SubFuncao save(SubFuncao SubFuncao) {
		SubFuncao v = repository.save(SubFuncao);
		return v;
	}
	
	@Transactional
	public SubFuncao update(Long id,SubFuncao SubFuncao) {
		SubFuncao v = repository.getById(id);
		v.setId(id); 
		v.setNome(SubFuncao.getNome());
		SubFuncao vendpt = repository.save(v);
		return vendpt;
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
