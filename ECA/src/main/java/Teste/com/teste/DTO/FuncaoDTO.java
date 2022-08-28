package Teste.com.teste.DTO;

import Teste.com.teste.Model.Funcao;

public class FuncaoDTO {
	
	private Long id;
	private String nome;
	
	public FuncaoDTO() {		
	}

	public FuncaoDTO(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public FuncaoDTO(Funcao entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
