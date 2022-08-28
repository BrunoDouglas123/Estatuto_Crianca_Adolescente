package Teste.com.teste.DTO;

import Teste.com.teste.Model.Arquivo;

public class ArquivoDTO {
	
	private Long id;
	private String nome;
	private String mes;
	private String ano;
	
	public ArquivoDTO() {		
	}

	public ArquivoDTO(Long id, String nome, String mes, String ano) {
		this.id = id;
		this.nome = nome;
		this.mes = mes;
		this.ano = ano;
	}
	
	public ArquivoDTO(Arquivo entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.mes = entity.getMes();
		this.ano = entity.getAno();
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
	
	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}
}
