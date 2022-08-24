package Teste.com.teste.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "arquivo")
public class Arquivo implements Serializable {
	private static final long serialVersionUID = -8851682389381421284L;

	@Id
	@Column(name = "id_arquivo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome", length = 45, nullable = false)
	private String nome;
	
	@Column(name = "mes", length = 2, nullable = false)
	private String mes;
	
	@Column(name = "ano", length = 4, nullable = false)
	private String ano;
	
	@JsonIgnore
	@OneToMany(mappedBy = "arquivo")
	private List<Pagamento> pagamento = new ArrayList<>();
	
	public Arquivo() {		
	}

	public Arquivo(Long id, String nome, String mes, String ano) {
		this.id = id;
		this.nome = nome;
		this.mes = mes;
		this.ano = ano;
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

	public List<Pagamento> getPagamento() {
		return pagamento;
	}
}
