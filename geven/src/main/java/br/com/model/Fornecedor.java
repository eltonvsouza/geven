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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Past;

import net.sf.trugger.validation.validator.pt.br.CEP;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Fornecedor generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "fornecedor", catalog = "geven")
public class Fornecedor implements java.io.Serializable {

	private Integer codigo;
	private Unidade unidade;
	private String cnpj;
	private String inscestadual;
	private String nome;
	private String cep;
	private Integer uf;
	private String cidade;
	private String bairro;
	private String logradouro;
	private String pais;
	private Integer numero;
	private String complemento;
	private String telefone;
	private String fax;
	private String contato;
	private String email;
	private String representante;
	private String banco;
	private String agencia;
	private String nconta;
	private Boolean cespecial;
	private Date dtabertura;
	private Boolean ccredito;
	private String afinidade;
	private Set<Produto> produtos = new HashSet<Produto>(0);
//	private Set<Contasapagar> contasapagars = new HashSet<Contasapagar>(0);
	private Set<Compra> compras = new HashSet<Compra>(0);

	public Fornecedor() {
	}

	public Fornecedor(Unidade unidade, String cnpj, String inscestadual,
			String nome, String banco, String agencia, String nconta) {
		this.unidade = unidade;
		this.cnpj = cnpj;
		this.inscestadual = inscestadual;
		this.nome = nome;
		this.banco = banco;
		this.agencia = agencia;
		this.nconta = nconta;
	}

	public Fornecedor(Unidade unidade, String cnpj, String inscestadual,
			String nome, String cep, Integer uf, String cidade, String bairro,
			String logradouro, String pais, Integer numero, String complemento,
			String telefone, String fax, String contato, String email,
			String representante, String banco, String agencia, String nconta,
			Boolean cespecial, Date dtabertura, Boolean ccredito,
			String afinidade, Set<Produto> produtos, Set<Compra> compras) {
		this.unidade = unidade;
		this.cnpj = cnpj;
		this.inscestadual = inscestadual;
		this.nome = nome;
		this.cep = cep;
		this.uf = uf;
		this.cidade = cidade;
		this.bairro = bairro;
		this.logradouro = logradouro;
		this.pais = pais;
		this.numero = numero;
		this.complemento = complemento;
		this.telefone = telefone;
		this.fax = fax;
		this.contato = contato;
		this.email = email;
		this.representante = representante;
		this.banco = banco;
		this.agencia = agencia;
		this.nconta = nconta;
		this.cespecial = cespecial;
		this.dtabertura = dtabertura;
		this.ccredito = ccredito;
		this.afinidade = afinidade;
		this.produtos = produtos;
//		this.contasapagars = contasapagars;
		this.compras = compras;
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

	@NotEmpty(message="Campo CNPJ: Obrigat�rio")
	@Length(min=18, max=18, message="Campo CNPJ: Obrigat�rio 18 caracteres")
	@Column(name = "cnpj", nullable = false, length = 18)
	public String getCnpj() {
		return this.cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@NotEmpty(message="Campo Inscri��o Estadual: Obrigat�rio")
	@Length(min=14, max=18, message="Campo Inscri��o Estadual: Tamanho m�nimo de 14 caracteres")
	@Column(name = "inscestadual", nullable = false, length = 18)
	public String getInscestadual() {
		return this.inscestadual;
	}

	public void setInscestadual(String inscestadual) {
		this.inscestadual = inscestadual;
	}

	@NotEmpty(message="Campo Nome: Obrigat�rio")
	@Length(min=3, max=200, message="Campo Nome: Tamanho m�nimo de 3 caracteres")
	@Column(name = "nome", nullable = false, length = 200)
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "cep", length = 11)
	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Column(name = "uf")
	public Integer getUf() {
		return this.uf;
	}

	public void setUf(Integer uf) {
		this.uf = uf;
	}

	@Column(name = "cidade", length = 100)
	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@Column(name = "bairro", length = 100)
	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	@Column(name = "logradouro", length = 100)
	public String getLogradouro() {
		return this.logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	@Column(name = "pais", length = 50)
	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	@Column(name = "numero", length = 5)
	public Integer getNumero() {
		return this.numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	@Column(name = "complemento", length = 100)
	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	@Column(name = "telefone", length = 13)
	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Column(name = "fax", length = 13)
	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	@Column(name = "contato", length = 50)
	public String getContato() {
		return this.contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	@Email(message="Campo E-Mail: Inv�lido")
	@Column(name = "email", length = 20)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "representante", length = 100)
	public String getRepresentante() {
		return this.representante;
	}

	public void setRepresentante(String representante) {
		this.representante = representante;
	}

	@NotEmpty(message="Campo Banco: Obrigat�rio")
	@Length(min=3, max=20, message="Campo Banco: Tamanho m�nimo de 3 caracteres")
	@Column(name = "banco", nullable = false, length = 20)
	public String getBanco() {
		return this.banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	@NotEmpty(message="Campo Ag�ncia: Obrigat�rio")
	@Length(min=3, max=15, message="Campo Ag�ncia: Tamanho m�nimo de 3 caracteres")
	@Column(name = "agencia", nullable = false, length = 15)
	public String getAgencia() {
		return this.agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	@NotEmpty(message="Campo Num Conta: Obrigat�rio")
	@Length(min=3, max=15, message="Campo Num Conta: Tamanho m�nimo de 3 caracteres")
	@Column(name = "nconta", nullable = false, length = 15)
	public String getNconta() {
		return this.nconta;
	}

	public void setNconta(String nconta) {
		this.nconta = nconta;
	}

	@Column(name = "cespecial")
	public Boolean getCespecial() {
		return this.cespecial;
	}

	public void setCespecial(Boolean cespecial) {
		this.cespecial = cespecial;
	}

	@Past(message="Campo Data de Nascimento: Imposs�vel cadastrar datas futuras")
	@Temporal(TemporalType.DATE)
	@Column(name = "dtabertura", length = 10)
	public Date getDtabertura() {
		return this.dtabertura;
	}

	public void setDtabertura(Date dtabertura) {
		this.dtabertura = dtabertura;
	}

	@Column(name = "ccredito")
	public Boolean getCcredito() {
		return this.ccredito;
	}

	public void setCcredito(Boolean ccredito) {
		this.ccredito = ccredito;
	}

	@Column(name = "afinidade", length = 20)
	public String getAfinidade() {
		return this.afinidade;
	}

	public void setAfinidade(String afinidade) {
		this.afinidade = afinidade;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fornecedor")
	public Set<Produto> getProdutos() {
		return this.produtos;
	}

	public void setProdutos(Set<Produto> produtos) {
		this.produtos = produtos;
	}

//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fornecedor")
//	public Set<Contasapagar> getContasapagars() {
//		return this.contasapagars;
//	}
//
//	public void setContasapagars(Set<Contasapagar> contasapagars) {
//		this.contasapagars = contasapagars;
//	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fornecedor")
	public Set<Compra> getCompras() {
		return this.compras;
	}

	public void setCompras(Set<Compra> compras) {
		this.compras = compras;
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
		Fornecedor other = (Fornecedor) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
