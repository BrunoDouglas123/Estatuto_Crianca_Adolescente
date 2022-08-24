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
@Table(name = "estado")
public class Estado implements Serializable {
	private static final long serialVersionUID = -7366981411878274159L;

	@Id
	@Column(name = "id_estado")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome", length = 19, nullable = false)
	private String nome;
	
	@Column(name = "uf", length = 2, nullable = false)
	private String uf;
	
	@JsonIgnore
	@OneToMany(mappedBy = "estado")
	private List<Cidade> cidade = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "id_regiao")
	private Regiao regiao;
	
	public Estado() {		
	}

	public Estado(Long id, String nome, String uf, Regiao regiao) {
		this.id = id;
		this.nome = nome;
		this.uf = uf;
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

	public Regiao getRegiao() {
		return regiao;
	}

	public void setRegiao(Regiao regiao) {
		this.regiao = regiao;
	}
}
