package br.com.model;

// Generated 08/03/2012 15:36:20 by Hibernate Tools 3.2.4.GA

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

/**
 * Contasapagar generated by hbm2java
 */
@Entity
@Table(name = "contasareceber", catalog = "geven")
public class Contasareceber implements java.io.Serializable {

	private Integer codigo;
	private Cliente cliente;
	private Unidade unidade;
	private Date mesreferencia;
	private String tipodoc;
	private Venda venda;
	private Double valor;
	private Date datavencimento;
	private Integer parcela;
	private Integer dia;
	private Set<Parcelasareceber> parcelasarecebers = new HashSet<Parcelasareceber>(0);

	public Contasareceber() {
	}

	public Contasareceber(Unidade unidade, Cliente cliente, Date datavencimento,
			Integer parcela, Integer dia) {
		this.unidade = unidade;
		this.cliente = cliente;
		this.datavencimento = datavencimento;
		this.parcela = parcela;
		this.dia = dia;
	}

	public Contasareceber(Unidade unidade, Integer opcaocategoria,
			String categoria, Date mesreferencia, String tipodoc,
			Venda venda, Double valor, Date datavencimento, Integer parcela,
			Integer dia, Set<Parcelasareceber> parcelasarecebers, Cliente cliente) {
		this.cliente = cliente;
		this.unidade = unidade;
		this.mesreferencia = mesreferencia;
		this.tipodoc = tipodoc;
		this.venda = venda;
		this.valor = valor;
		this.datavencimento = datavencimento;
		this.parcela = parcela;
		this.dia = dia;
		this.parcelasarecebers = parcelasarecebers;
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

	@LazyToOne(LazyToOneOption.FALSE)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cliente")
	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "unidade", nullable = false)
	public Unidade getUnidade() {
		return this.unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "mesreferencia", length = 10)
	public Date getMesreferencia() {
		return this.mesreferencia;
	}

	public void setMesreferencia(Date mesreferencia) {
		this.mesreferencia = mesreferencia;
	}

	@NotEmpty(message="Campo Tipo Documento: Obrigat�rio")
	@Length(min=1, max=20, message="Campo Tipo Documento: Tamanho m�nimo de 1 caracteres")
	@Column(name = "tipodoc", length = 20)
	public String getTipodoc() {
		return this.tipodoc;
	}

	public void setTipodoc(String tipodoc) {
		this.tipodoc = tipodoc;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "venda")
	public Venda getVenda() {
		return this.venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	@NotNull(message="Campo Valor: Obrigat�rio")
	@Range(min=1, message="Campo Valor: Digite um valor maior que 0,00")
	@Column(name = "valor", precision = 13)
	public Double getValor() {
		return this.valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@NotNull(message="Campo Data Vencimento: Obrigat�rio")
	@Temporal(TemporalType.DATE)
	@Column(name = "datavencimento", nullable = false, length = 10)
	public Date getDatavencimento() {
		return this.datavencimento;
	}

	public void setDatavencimento(Date datavencimento) {
		this.datavencimento = datavencimento;
	}

	@NotNull(message="Campo Parcelas: Obrigat�rio")
	@Column(name = "parcela", nullable = false)
	public Integer getParcela() {
		return this.parcela;
	}

	public void setParcela(Integer parcela) {
		this.parcela = parcela;
	}

	@NotNull(message="Campo Dia: Obrigat�rio")
	@Column(name = "dia", nullable = false)
	public Integer getDia() {
		return this.dia;
	}

	public void setDia(Integer dia) {
		this.dia = dia;
	}

	@LazyToOne(LazyToOneOption.FALSE)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "contasareceber", cascade = CascadeType.ALL)
	public Set<Parcelasareceber> getParcelasarecebers() {
		return this.parcelasarecebers;
	}

	public void setParcelasarecebers(Set<Parcelasareceber> parcelasarecebers) {
		this.parcelasarecebers = parcelasarecebers;
	}

}