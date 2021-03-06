package br.com.model;

// Generated 08/03/2012 15:36:20 by Hibernate Tools 3.2.4.GA

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Compra generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "compra", catalog = "geven", uniqueConstraints = @UniqueConstraint(columnNames = {
		"unidade", "nNF" }))
public class Compra implements java.io.Serializable {

	private Integer nnf;
	private Fornecedor fornecedor;
	private Unidade unidade;
	private Transportadora transportadora;
	private Integer serie;
	private Integer tpNf;
	private String natOp;
	private String infCpl;
	private Date data;
	private Double valor;
	private Set<CompraItem> compraitems = new HashSet<CompraItem>(0);

	public Compra() {
	}

	public Compra(Integer nnf, Fornecedor fornecedor, Unidade unidade, Integer serie,
			Integer tpNf, String natOp, Date data, Double valor) {
		this.nnf = nnf;
		this.fornecedor = fornecedor;
		this.unidade = unidade;
		this.serie = serie;
		this.tpNf = tpNf;
		this.natOp = natOp;
		this.data = data;
		this.valor = valor;
	}

	public Compra(Integer nnf, Fornecedor fornecedor, Unidade unidade,
			Transportadora transportadora, Integer serie, Integer tpNf, String natOp,
			String infCpl, Date data, Set<CompraItem> compraitems) {
		this.nnf = nnf;
		this.fornecedor = fornecedor;
		this.unidade = unidade;
		this.transportadora = transportadora;
		this.serie = serie;
		this.tpNf = tpNf;
		this.natOp = natOp;
		this.infCpl = infCpl;
		this.data = data;
		this.compraitems = compraitems;
	}

	@NotNull(message="Campo N�mero: Obrigat�rio")
	@Id
	@Column(name = "nNF", unique = true, nullable = false)
	public Integer getNnf() {
		return this.nnf;
	}

	public void setNnf(Integer nnf) {
		this.nnf = nnf;
	}

	@LazyToOne(LazyToOneOption.FALSE)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fornecedor", nullable = false)
	public Fornecedor getFornecedor() {
		return this.fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "unidade", nullable = false)
	public Unidade getUnidade() {
		return this.unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "transportadora")
	public Transportadora getTransportadora() {
		return this.transportadora;
	}

	public void setTransportadora(Transportadora transportadora) {
		this.transportadora = transportadora;
	}

	@NotNull(message="Campo S�rie: Obrigat�rio")
	@Column(name = "serie", nullable = false)
	public Integer getSerie() {
		return this.serie;
	}

	public void setSerie(Integer serie) {
		this.serie = serie;
	}

	@NotNull(message="Campo Tipo: Obrigat�rio")
//	@Size(max = 1, min = 1, message = "Campo Tipo: Obrigatorio 1 d�gito")
	@Column(name = "tpNF", nullable = false)
	public Integer getTpNf() {
		return this.tpNf;
	}

	public void setTpNf(Integer tpNf) {
		this.tpNf = tpNf;
	}

	@NotEmpty(message="Campo Nat. da Opera��o: Obrigat�rio")
	@Length(min=3, max=60, message="Campo Nat. da Opera��o: Tamanho m�nimo de 3 caracteres")
	@Column(name = "natOp", nullable = false, length = 60)
	public String getNatOp() {
		return this.natOp;
	}

	public void setNatOp(String natOp) {
		this.natOp = natOp;
	}

	@Column(name = "infCpl", length = 5000)
	public String getInfCpl() {
		return this.infCpl;
	}

	public void setInfCpl(String infCpl) {
		this.infCpl = infCpl;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "data", nullable = false, length = 10)
	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Column(name = "valor", nullable = false)
	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@LazyToOne(LazyToOneOption.FALSE)
//	@LazyToOne(LazyToOneOption.PROXY)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "compra", cascade = CascadeType.ALL)
	public Set<CompraItem> getCompraitems() {
		return this.compraitems;
	}

	public void setCompraitems(Set<CompraItem> compraitems) {
		this.compraitems = compraitems;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nnf == null) ? 0 : nnf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compra other = (Compra) obj;
		if (nnf == null) {
			if (other.nnf != null)
				return false;
		} else if (!nnf.equals(other.nnf))
			return false;
		return true;
	}



}
