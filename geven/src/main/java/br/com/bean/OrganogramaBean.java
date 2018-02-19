package br.com.bean;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.dao.FuncionarioDAOImpl;
import br.com.dao.UsuarioDAOImpl;
import br.com.model.Funcionario;
import br.com.model.Unidade;
import br.com.model.Usuario;
//import br.com.util.Graph;


@Component
@Scope("session")
public class OrganogramaBean {
	
	private BufferedImage imagem;
//	private Graph graph;
	private String text;
	@Autowired
	private FuncionarioDAOImpl<Funcionario> funcionarioDAOImpl;
	@Autowired
	UsuarioDAOImpl<Usuario> usuarioDAOImpl;
	@Autowired
	LoginBean loginBean;

//	http://th3silverlining.com/2011/12/01/jquery-org-chart-a-plugin-for-visualising-data-in-a-tree-like-structure/
	@Transactional
	public String getText() throws Exception {
		String org = "";
		text = "";
		Collection<Funcionario> funcionario = funcionarioDAOImpl.listar(getUnidade());
		for (Funcionario c : funcionario) {
			String filho = "";
			if(c.getFilho() != null){
				filho = c.getFilho().getNome();
			}
			text += "[{v:'"+c.getNome()+"', f:'"+c.getNome()+ "<div style=\"color:red; font-style:italic\">"+c.getTipofuncionario().getDescricao()+"</div>'}, '"+ filho +"', ''],";
		}
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public FuncionarioDAOImpl<Funcionario> getFuncionarioDAOImpl() {
		return funcionarioDAOImpl;
	}

	public void setFuncionarioDAOImpl(
			FuncionarioDAOImpl<Funcionario> funcionarioDAOImpl) {
		this.funcionarioDAOImpl = funcionarioDAOImpl;
	}

	public UsuarioDAOImpl<Usuario> getUsuarioDAOImpl() {
		return usuarioDAOImpl;
	}

	public void setUsuarioDAOImpl(UsuarioDAOImpl<Usuario> usuarioDAOImpl) {
		this.usuarioDAOImpl = usuarioDAOImpl;
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	@Transactional
	public Unidade getUnidade() {
		return usuarioDAOImpl.carregarUsuario(loginBean.getUsuario().getUsuario()).getUnidade();
	}
	
	//	JFREECHART
//		<h:commandButton action="#{organogramaBean.abrirOrganograma}" value="abrir" />
//		<a4j:mediaOutput element="img" cacheable="false" createContent="#{organogramaBean.abrirOrganograma}" mimeType="image/png" ></a4j:mediaOutput>
//	public void abrirOrganograma(OutputStream outputStream, Object data) {
//		 try {
//			Graph graph = new Graph(outputStream, data, "teste1", "teste2", "teste3");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
}
