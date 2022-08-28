package Teste.com.teste.DTO;

import Teste.com.teste.Model.Cidade;

public class CidadeDTO {
	
	private Long id;
	private Double cod_siafi;
	
	private EstadoDTO estado;
	
	public CidadeDTO() {		
	}

	public CidadeDTO(Cidade entity) {
		this.id = entity.getId();
		this.cod_siafi = entity.getCod_siafi();
		this.estado = new EstadoDTO(entity.getEstado());
	}
	
	public CidadeDTO(Long id, Double cod_siafi, EstadoDTO estado) {
		this.id = id;
		this.cod_siafi = cod_siafi;
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getCod_siafi() {
		return cod_siafi;
	}

	public void setCod_siafi(Double cod_siafi) {
		this.cod_siafi = cod_siafi;
	}

	public EstadoDTO getEstado() {
		return estado;
	}

	public void setEstado(EstadoDTO estado) {
		this.estado = estado;
	}
}
