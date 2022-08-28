package Teste.com.teste.DTO;

import Teste.com.teste.Model.Fonte;

public class FonteDTO {
	
	private Long id;
	private String meta;
	private String origem;
	private String periodicidade;
	
	public FonteDTO() {		
	}

	public FonteDTO(Long id, String meta, String origem, String periodicidade) {
		this.id = id;
		this.meta = meta;
		this.origem = origem;
		this.periodicidade = periodicidade;
	}
	
	public FonteDTO(Fonte entity) {
		this.id = entity.getId();
		this.meta = entity.getMeta();
		this.origem = entity.getOrigem();
		this.periodicidade = entity.getPeriodicidade();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMeta() {
		return meta;
	}

	public void setMeta(String meta) {
		this.meta = meta;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getPeriodicidade() {
		return periodicidade;
	}

	public void setPeriodicidade(String periodicidade) {
		this.periodicidade = periodicidade;
	}
}
