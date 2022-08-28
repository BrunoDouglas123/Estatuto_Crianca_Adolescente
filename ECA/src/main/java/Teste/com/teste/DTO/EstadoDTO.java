package Teste.com.teste.DTO;

import Teste.com.teste.Model.Estado;

public class EstadoDTO {
	
	private Long id;
	private String nome;
	private String uf;
	
	private RegiaoDTO regiao;
	
	public EstadoDTO() {		
	}
	
	public EstadoDTO(Estado entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.uf = entity.getUf();
		this.regiao = new RegiaoDTO(entity.getRegiao());
	}

	public EstadoDTO(Long id, String nome, RegiaoDTO regiao) {
		this.id = id;
		this.nome = nome;
		this.regiao = regiao;
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

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public RegiaoDTO getRegiao() {
		return regiao;
	}

	public void setRegiao(RegiaoDTO regiao) {
		this.regiao = regiao;
	}
}
