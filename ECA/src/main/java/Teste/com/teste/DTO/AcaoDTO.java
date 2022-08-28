package Teste.com.teste.DTO;

import Teste.com.teste.Model.Acao;

public class AcaoDTO {
	
	private Long id;
	private String nome;
	
	public AcaoDTO() {		
	}
	
	public AcaoDTO(Acao entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
	}
	
	public AcaoDTO(Long id, String nome) {
		this.id = id;
		this.nome = nome;
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
