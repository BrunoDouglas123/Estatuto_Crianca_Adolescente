package Teste.com.teste.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cidade")
public class Cidade implements Serializable {
	private static final long serialVersionUID = -5591996612155579738L;

	@Id
	@Column(name = "id_cidade")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "cod_siafi", length = 11, nullable = false)
	private Double cod_siafi;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cidade")
	private List<Pagamento> pagamento = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "id_estado")
	private Estado estado;
	
	public Cidade() {		
	}

	public Cidade(Long id, Double cod_siafi, Estado estado) {
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

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
}
