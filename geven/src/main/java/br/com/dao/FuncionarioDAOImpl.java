package br.com.dao;

import java.util.Collection;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.dao.utility.HibernateUtility;
import br.com.model.Funcionario;
import br.com.model.TipoFuncionario;
import br.com.model.Unidade;

@Service
public class FuncionarioDAOImpl<T> extends GenericDAOImpl<T> implements FuncionarioDAO {
	@Override
	protected Class getClasseConsulta() {
		return Funcionario.class;
	}
	
	@Transactional
	public Collection<T> listarTipo(Unidade unidade, TipoFuncionario tipoFuncionario) throws Exception {
		Collection<T> lista = null;
		try {
			Query consulta = getSessionFactory().getCurrentSession()
					.createQuery("from " + getClasseConsulta().getName() + " c WHERE c.tipofuncionario = :tipoFuncionario AND" +
								 "													 c.unidade = :unidade");
			consulta.setParameter("tipoFuncionario", tipoFuncionario);
			consulta.setParameter("unidade", unidade);
			lista = consulta.list();
		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			System.gc();
		}
		return lista;
	}
}
