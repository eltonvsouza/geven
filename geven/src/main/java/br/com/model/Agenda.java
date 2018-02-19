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
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

/**
 * Agenda generated by hbm2java
 */
@Entity
@Table(name = "agenda", catalog = "geven")
public class Agenda implements java.io.Serializable {

	private Integer codigo;
	private Unidade unidade;
	private String assunto;
	private String mensagem;
	private Date datahora;
	private Date alarme;
	private String email;

	public Agenda() {
	}

	public Agenda(Unidade unidade, String assunto, Date datahora, String email) {
		this.unidade = unidade;
		this.assunto = assunto;
		this.datahora = datahora;
		this.email = email;
	}

	public Agenda(Unidade unidade, String assunto, String mensagem,
			Date datahora, Date alarme, String email) {
		this.unidade = unidade;
		this.assunto = assunto;
		this.mensagem = mensagem;
		this.datahora = datahora;
		this.alarme = alarme;
		this.email = email;
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
	@JoinColumn(name = "unidade", nullable = false)
	public Unidade getUnidade() {
		return this.unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	@NotNull(message="Campo Assunto: Campo Obrigatório")
	@Column(name = "assunto", nullable = false, length = 20)
	public String getAssunto() {
		return this.assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	@Column(name = "mensagem", length = 200)
	public String getMensagem() {
		return this.mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	@NotNull(message="Campo Data/Hora: Campo Obrigatório")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "datahora", nullable = false, length = 19)
	public Date getDatahora() {
		return this.datahora;
	}

	public void setDatahora(Date datahora) {
		this.datahora = datahora;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "alarme", length = 8)
	public Date getAlarme() {
		return this.alarme;
	}

	public void setAlarme(Date alarme) {
		this.alarme = alarme;
	}

	@NotNull(message="Campo E-Mail: Campo Obrigatório")
	@Email(message="Campo Email: Incorreto")
	@Column(name = "email", nullable = false, length = 200)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
