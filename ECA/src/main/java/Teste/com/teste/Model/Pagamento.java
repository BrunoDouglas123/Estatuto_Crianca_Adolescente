package Teste.com.teste.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pagamento")
public class Pagamento implements Serializable {
	private static final long serialVersionUID = -1771806830514900449L;
	
	@Id
	@Column(name = "id_pagamento")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome", length = 45, nullable = false)
	private Double valor;
	
	@ManyToOne
	@JoinColumn(name = "id_cidade")
	private Cidade cidade;
	
	@ManyToOne
	@JoinColumn(name = "id_funcao")
	private Funcao funcao;
	
	@ManyToOne
	@JoinColumn(name = "id_subfuncao")
	private SubFuncao subfuncao;
	
	@ManyToOne 
	@JoinColumn(name = "id_programa")
	private Programa programa;
	
	@ManyToOne
	@JoinColumn(name = "id_acao")
	private Acao acao;
	
	@ManyToOne
	@JoinColumn(name = "id_beneficiario")
	private Beneficiario beneficiario;
	
	@ManyToOne
	@JoinColumn(name = "id_arquivo")
	private Arquivo arquivo;
	
	@ManyToOne
	@JoinColumn(name = "id_fonte")
	private Fonte fonte;
	
	public Pagamento() {		
	}

	public Pagamento(Long id, Double valor, Cidade cidade, Funcao funcao,
			SubFuncao subfuncao, Programa programa, Acao acao,
			Beneficiario beneficiario, Arquivo arquivo, Fonte fonte) {
		this.id = id;
		this.valor = valor;
		this.cidade = cidade;
		this.funcao = funcao;
		this.subfuncao = subfuncao;
		this.programa = programa;
		this.acao = acao;
		this.beneficiario = beneficiario;
		this.arquivo = arquivo;
		this.fonte = fonte;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Funcao getFuncao() {
		return funcao;
	}

	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}

	public SubFuncao getSubfuncao() {
		return subfuncao;
	}

	public void setSubfuncao(SubFuncao subfuncao) {
		this.subfuncao = subfuncao;
	}

	public Programa getPrograma() {
		return programa;
	}

	public void setPrograma(Programa programa) {
		this.programa = programa;
	}

	public Acao getAcao() {
		return acao;
	}

	public void setAcao(Acao acao) {
		this.acao = acao;
	}

	public Beneficiario getBeneficiario() {
		return beneficiario;
	}

	public void setBeneficiario(Beneficiario beneficiario) {
		this.beneficiario = beneficiario;
	}

	public Arquivo getArquivo() {
		return arquivo;
	}

	public void setArquivo(Arquivo arquivo) {
		this.arquivo = arquivo;
	}

	public Fonte getFonte() {
		return fonte;
	}

	public void setFonte(Fonte fonte) {
		this.fonte = fonte;
	}
}
