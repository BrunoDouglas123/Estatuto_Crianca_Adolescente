package Teste.com.teste.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Teste.com.teste.DTO.AcaoDTO;
import Teste.com.teste.Model.Acao;
import Teste.com.teste.Repository.AcaoRepository;

@Service
public class AcaoService {
	
	@Autowired
	private AcaoRepository repository;
	
	public List<AcaoDTO> findAll() {
		List<Acao> result = repository.findAll();
		return result.stream().map(x -> new
		AcaoDTO(x)).collect(Collectors.toList());
	}
	
	public Acao findById(Long id) {
		Optional<Acao> v = repository.findById(id);
		return v.get();
	}
	
	public Acao save(Acao Acao) {
		Acao v = repository.save(Acao);
		return v;
	}
	
	@Transactional
	public Acao update(Long id,Acao Acao) {
		Acao v = repository.getById(id);
		v.setId(id); 
		v.setNome(Acao.getNome());
		Acao vendpt = repository.save(v);
		return vendpt;
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
