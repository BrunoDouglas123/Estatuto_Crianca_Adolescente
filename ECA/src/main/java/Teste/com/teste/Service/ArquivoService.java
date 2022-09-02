package Teste.com.teste.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Teste.com.teste.DTO.ArquivoDTO;
import Teste.com.teste.Model.Arquivo;
import Teste.com.teste.Repository.ArquivoRepository;

@Service
public class ArquivoService {
	
	@Autowired
	private ArquivoRepository repository;
	
	public List<ArquivoDTO> findAll() {
		List<Arquivo> result = repository.findAll();
		return result.stream().map(x -> new
		ArquivoDTO(x)).collect(Collectors.toList());
	}
	
	public Arquivo findById(Long id) {
		Optional<Arquivo> v = repository.findById(id);
		return v.get();
	}
	
	public Arquivo save(Arquivo Arquivo) {
		Arquivo v = repository.save(Arquivo);
		return v;
	}
	
	@Transactional
	public Arquivo update(Long id,Arquivo Arquivo) {
		Arquivo v = repository.getById(id);
		v.setId(id); 
		v.setNome(Arquivo.getNome());
		v.setMes(Arquivo.getMes());
		v.setAno(Arquivo.getAno());;
		Arquivo vendpt = repository.save(v);
		return vendpt;
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
