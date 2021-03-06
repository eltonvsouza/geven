package br.com.model;

// Generated 08/03/2012 15:36:20 by Hibernate Tools 3.2.4.GA

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Parcelasareceber generated by hbm2java
 */
@Entity
@Table(name = "parcelasareceber", catalog = "geven")
public class Parcelasareceber implements java.io.Serializable {

	private Integer codigo;
	private Contasareceber contaareceber;
	private Unidade unidade;
	private Date datavencimento;
	private Double valorparcela;
	private String formapagamento;
	private Date datapagamento;
	private Double valorpago;
	private Boolean lote;

	public Parcelasareceber() {
	}

	public Parcelasareceber(Contasareceber contasareceber, Unidade unidade,
			Date datavencimento, String formapagamento) {
		this.contaareceber = contasareceber;
		this.unidade = unidade;
		this.datavencimento = datavencimento;
		this.formapagamento = formapagamento;
	}

	public Parcelasareceber(Contasareceber contaareceber, Unidade unidade,
			Date datavencimento, Double valorparcela, String formapagamento,
			Date datapagamento, Double valorpago, Boolean lote) {
		this.contaareceber = contaareceber;
		this.unidade = unidade;
		this.datavencimento = datavencimento;
		this.valorparcela = valorparcela;
		this.formapagamento = formapagamento;
		this.datapagamento = datapagamento;
		this.valorpago = valorpago;
		this.lote = lote;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "contaareceber", nullable = false)
	public Contasareceber getContasareceber() {
		return this.contaareceber;
	}

	public void setContasareceber(Contasareceber contasareceber) {
		this.contaareceber = contasareceber;
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
	@Column(name = "datavencimento", nullable = false, length = 10)
	public Date getDatavencimento() {
		return this.datavencimento;
	}

	public void setDatavencimento(Date datavencimento) {
		this.datavencimento = datavencimento;
	}

	@Column(name = "valorparcela", nullable = false, precision = 13)
	public Double getValorparcela() {
		return this.valorparcela;
	}

	public void setValorparcela(Double valorparcela) {
		this.valorparcela = valorparcela;
	}

	@Column(name = "formapagamento", length = 20)
	public String getFormapagamento() {
		return this.formapagamento;
	}

	public void setFormapagamento(String formapagamento) {
		this.formapagamento = formapagamento;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "datapagamento", length = 10)
	public Date getDatapagamento() {
		return this.datapagamento;
	}

	public void setDatapagamento(Date datapagamento) {
		this.datapagamento = datapagamento;
	}

	@Column(name = "valorpago", precision = 13)
	public Double getValorpago() {
		return this.valorpago;
	}

	public void setValorpago(Double valorpago) {
		this.valorpago = valorpago;
	}

	@Column(name = "lote")
	public Boolean getLote() {
		return this.lote;
	}

	public void setLote(Boolean lote) {
		this.lote = lote;
	}

}
