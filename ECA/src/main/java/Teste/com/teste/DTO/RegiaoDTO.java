package Teste.com.teste.DTO;

import Teste.com.teste.Model.Regiao;

public class RegiaoDTO {
	
	private Long id;
	private String nome;
	
	public RegiaoDTO() {
	}

	public RegiaoDTO(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public RegiaoDTO(Regiao entity) {
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
