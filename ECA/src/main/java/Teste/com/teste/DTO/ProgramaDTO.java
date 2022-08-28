package Teste.com.teste.DTO;

import Teste.com.teste.Model.Programa;

public class ProgramaDTO {
	
	private Long id;
	private String nome;
	
	public ProgramaDTO() {		
	}
	
	public ProgramaDTO(Programa entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
	}
	
	public ProgramaDTO(Long id, String nome) {
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
