package br.com.bean;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.dao.ContasareceberDAOImpl;
import br.com.dao.UsuarioDAOImpl;
import br.com.model.Contasareceber;
import br.com.model.Parcelasareceber;
import br.com.model.Unidade;
import br.com.model.Usuario;
import br.com.relatorio.GenericRelatorio;

@Component
@Scope("session")
public class ContasareceberBean {

	private Contasareceber contasareceber;
	private Parcelasareceber parcelasareceber;
	private LoginBean loginBean;
	private UsuarioDAOImpl<Usuario> usuarioDAOImpl;
	private DataModel<Parcelasareceber> tbParcela;
	@Autowired
	private ContasareceberDAOImpl<Contasareceber> contasareceberDAOImpl;
	private Collection<Contasareceber> contasarecebers;
	private List<SelectItem> listaContasareceber;
	private List<Parcelasareceber> listaParcelasaReceber;
	private Integer idBusca;
	private String mensagem;
	private Date today = new Date();
	private boolean disabled;
	
	public Contasareceber getContasareceber() {
		return contasareceber;
	}

	public void setContasareceber(Contasareceber contasareceber) {
		this.contasareceber = contasareceber;
	}

	public Parcelasareceber getParcelasareceber() {
		return parcelasareceber;
	}

	public void setParcelasareceber(Parcelasareceber parcelasareceber) {
		this.parcelasareceber = parcelasareceber;
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public UsuarioDAOImpl<Usuario> getUsuarioDAOImpl() {
		return usuarioDAOImpl;
	}

	public void setUsuarioDAOImpl(UsuarioDAOImpl<Usuario> usuarioDAOImpl) {
		this.usuarioDAOImpl = usuarioDAOImpl;
	}

	public DataModel<Parcelasareceber> getTbParcela() {
		return tbParcela;
	}

	public void setTbParcela(DataModel<Parcelasareceber> tbParcela) {
		this.tbParcela = tbParcela;
	}

	public ContasareceberDAOImpl<Contasareceber> getContasareceberDAOImpl() {
		return contasareceberDAOImpl;
	}

	public void setContasareceberDAOImpl(ContasareceberDAOImpl<Contasareceber> contasareceberDAOImpl) {
		this.contasareceberDAOImpl = contasareceberDAOImpl;
	}

	public Collection<Contasareceber> getContasarecebers() throws Exception {
		contasarecebers = contasareceberDAOImpl.listar(getUnidade());
		return contasarecebers;
	}

	public void setContasarecebers(Collection<Contasareceber> contasarecebers) {
		this.contasarecebers = contasarecebers;
	}

	@Transactional
	public List<SelectItem> getListaContasareceber() throws Exception {
		listaContasareceber = new ArrayList<SelectItem>();
//		ContasareceberDAOImpl<Contasareceber> contasareceberDAOImpl = new ContasareceberDAOImpl<Contasareceber>();
		Collection<Contasareceber> contasareceber = contasareceberDAOImpl.listar(getUnidade());
		for (Contasareceber c : contasareceber) {
			listaContasareceber.add(new SelectItem(c, c.getDatavencimento() + " - " + c.getCliente()));
		}
		return listaContasareceber;
	}
	
	public Integer getIdBusca() {
		return idBusca;
	}

	public void setIdBusca(Integer idBusca) {
		this.idBusca = idBusca;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public Unidade getUnidade() {
		return usuarioDAOImpl.carregarUsuario(loginBean.getUsuario().getUsuario()).getUnidade();
	}
	
	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public String carregarCadastrar() {
		limpar();
		return "/tela/contasareceber/cadastrarContasareceber";
	}

	public String carregarAlterar() {
		contasareceber = contasareceberDAOImpl.carregar(idBusca);
 		return "/tela/contasareceber/alterarContasareceber";
	}

	public String cadastrar() {
		if(!listaVazia()){
			contasareceber.setUnidade(getUnidade());
			contasareceberDAOImpl.salvar(contasareceber);
			limpar();
		}
		return "/tela/contasareceber/cadastrarContasareceber";
	}
	
	public String alterar() {
		if(!listaVazia()){
			contasareceberDAOImpl.salvarOuAtualizar(contasareceber);
			return "/tela/contasareceber/listarContasareceber";
		}else{
			return "/tela/contasareceber/alterarContasareceber";
		}
	}

	public void excluir() {
		contasareceber = contasareceberDAOImpl.carregar(idBusca);
		contasareceberDAOImpl.excluir(contasareceber);
	}

	public boolean listaVazia(){
		if(contasareceber.getParcelasarecebers().size() > 0){
			return false;
		}else{
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "NENHUMA PARCELA GERADA", "NENHUMA PARCELA GERADA!");
			FacesContext.getCurrentInstance().addMessage("cadastro", message);
			return true;
		}
	}
	
	public void gerarParcelas(){
		Double parcela = contasareceber.getValor()/contasareceber.getParcela();
		for (int i = 0; i < contasareceber.getParcela(); i++){
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(contasareceber.getDatavencimento());
			calendar.add(Calendar.DAY_OF_MONTH, contasareceber.getDia() * i);
			
			parcelasareceber.setContasareceber(contasareceber);
			parcelasareceber.setUnidade(getUnidade());
			parcelasareceber.setDatavencimento(calendar.getTime());
			parcelasareceber.setValorparcela(parcela);
			contasareceber.getParcelasarecebers().add(parcelasareceber);
			listaParcelasaReceber.add(parcelasareceber);
			limparParcela();
		}
		disabled = true;
		tbParcela = new ListDataModel<Parcelasareceber>(listaParcelasaReceber);
	}
	
	public void limpar() {
		contasareceber = null;
		contasareceber = new Contasareceber();
		limparListaParcelasaReceber();
		limparParcela();
		disabled = false;
		contasareceber.setDatavencimento(today);
		limparListaParcelasaReceber();
		limparParcela();
	}
	
	public void limparListaParcelasaReceber(){
		contasareceber.getParcelasarecebers().clear();
		listaParcelasaReceber = null;
		listaParcelasaReceber = new ArrayList<Parcelasareceber>();
		tbParcela = null;
	}
	
	public void limparParcela() {
		parcelasareceber = null;
		parcelasareceber = new Parcelasareceber();
	}

	 public void relatorioGeral() throws Exception {
		 GenericRelatorio relatorio = new GenericRelatorio();
		 Map parametro = new HashMap();
		 parametro.put("unidade", getUnidade().getCodigo());
		 parametro.put("geral", "cpcategoria");
		 try {
			 relatorio.gerarRelatorio("/br/com/relatorio/jasper/relatorioContasareceber.jasper", "salvarPdf", parametro);
		 } catch (Exception e) {
		 e.printStackTrace();
		 }
	 }
}
