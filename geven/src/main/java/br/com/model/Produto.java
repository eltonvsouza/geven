package br.com.model;

// Generated 08/03/2012 15:36:20 by Hibernate Tools 3.2.4.GA

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Produto generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "produto", catalog = "geven", uniqueConstraints = @UniqueConstraint(columnNames = {
		"unidade", "codprod" }))
public class Produto implements java.io.Serializable {

	private Integer codigo;
	private Fornecedor fornecedor;
	private Unidade unidade;
	private int codprod;
	private String descricao;
	private String medida1;
	private String medida2;
	private double vcompra;
	private double vvenda;
	private double icmscompra;
	private double icmssubst;
	private Set<CompraItem> compraitems = new HashSet<CompraItem>(0);
	private Set<VendaItem> vendaitems = new HashSet<VendaItem>(0);

	public Produto() {
	}

	public Produto(Fornecedor fornecedor, Unidade unidade, int codprod,
			String descricao, String medida1, String medida2, double vcompra,
			double vvenda, double icmscompra, double icmssubst) {
		this.fornecedor = fornecedor;
		this.unidade = unidade;
		this.codprod = codprod;
		this.descricao = descricao;
		this.medida1 = medida1;
		this.medida2 = medida2;
		this.vcompra = vcompra;
		this.vvenda = vvenda;
		this.icmscompra = icmscompra;
		this.icmssubst = icmssubst;
	}

	public Produto(Fornecedor fornecedor, Unidade unidade, int codprod,
			String descricao, String medida1, String medida2, double vcompra,
			double vvenda, double icmscompra, double icmssubst,
			Set<CompraItem> compraitems, Set<VendaItem> vendaitems) {
		this.fornecedor = fornecedor;
		this.unidade = unidade;
		this.codprod = codprod;
		this.descricao = descricao;
		this.medida1 = medida1;
		this.medida2 = medida2;
		this.vcompra = vcompra;
		this.vvenda = vvenda;
		this.icmscompra = icmscompra;
		this.icmssubst = icmssubst;
		this.compraitems = compraitems;
		this.vendaitems = vendaitems;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "codigo", unique = true, nullable = false)
	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	@NotNull(message="Campo Fornecedor: Obrigat�rio")
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

	@NotNull(message="Campo C�digo: Obrigat�rio")
	@Column(name = "codprod", nullable = false)
	public int getCodprod() {
		return this.codprod;
	}

	public void setCodprod(int codprod) {
		this.codprod = codprod;
	}

	@NotEmpty(message="Campo Descri��o: Obrigat�rio")
	@Length(min=3, max=60, message="Campo Descri��o: Tamanho m�nimo de 3 caracteres")
	@Column(name = "descricao", nullable = false, length = 60)
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@NotEmpty(message="Campo Medida1: Obrigat�rio")
	@Length(min=3, max=20, message="Campo Medida1: Tamanho m�nimo de 3 caracteres")
	@Column(name = "medida1", nullable = false, length = 20)
	public String getMedida1() {
		return this.medida1;
	}

	public void setMedida1(String medida1) {
		this.medida1 = medida1;
	}

	@NotEmpty(message="Campo Medida2: Obrigat�rio")
	@Length(min=3, max=20, message="Campo Medida2: Tamanho m�nimo de 3 caracteres")
	@Column(name = "medida2", nullable = false, length = 20)
	public String getMedida2() {
		return this.medida2;
	}

	public void setMedida2(String medida2) {
		this.medida2 = medida2;
	}

	@NotNull(message="Campo V. Compra: Obrigat�rio")
	@Column(name = "vcompra", nullable = false, precision = 9)
	public double getVcompra() {
		return this.vcompra;
	}

	public void setVcompra(double vcompra) {
		this.vcompra = vcompra;
	}

	@NotNull(message="Campo V. Venda: Obrigat�rio")
	@Column(name = "vvenda", nullable = false, precision = 9)
	public double getVvenda() {
		return this.vvenda;
	}

	public void setVvenda(double vvenda) {
		this.vvenda = vvenda;
	}

	@NotNull(message="Campo ICMS Compra: Obrigat�rio")
	@Column(name = "icmscompra", nullable = false, precision = 5)
	public double getIcmscompra() {
		return this.icmscompra;
	}

	public void setIcmscompra(double icmscompra) {
		this.icmscompra = icmscompra;
	}

	@NotNull(message="Campo ICMS Subst: Obrigat�rio")
	@Column(name = "icmssubst", nullable = false, precision = 5)
	public double getIcmssubst() {
		return this.icmssubst;
	}

	public void setIcmssubst(double icmssubst) {
		this.icmssubst = icmssubst;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "produto")
	public Set<CompraItem> getCompraitems() {
		return this.compraitems;
	}

	public void setCompraitems(Set<CompraItem> compraitems) {
		this.compraitems = compraitems;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "produto")
	public Set<VendaItem> getVendaitems() {
		return this.vendaitems;
	}

	public void setVendaitems(Set<VendaItem> vendaitems) {
		this.vendaitems = vendaitems;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Produto other = (Produto) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
