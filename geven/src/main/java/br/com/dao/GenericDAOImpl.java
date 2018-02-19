package br.com.dao;

import java.sql.BatchUpdateException;
import java.sql.SQLException;
import java.util.Collection;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.hibernate.HibernateException;
import org.hibernate.JDBCException;
import org.hibernate.NonUniqueObjectException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.BatchUpdateUtils;
import org.springframework.orm.hibernate3.HibernateJdbcException;
import org.springframework.orm.hibernate3.HibernateQueryException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.model.Unidade;

//@Repository - persistencia, @Service - servi�o e @Controller - apresenta��o, s�o especializa��es de @Component 
//@Service
@Repository
public abstract class GenericDAOImpl<T> implements GenericDAO<T> {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public T carregar(Integer id) {
//		Session session = HibernateUtility.getSession();
		Object object = null;
		try {
			Query select = sessionFactory.getCurrentSession()
					.createQuery("SELECT c FROM " + getClasseConsulta().getName() + " c WHERE c.id = :id");
			select.setParameter("id", id);
			object = select.uniqueResult();
		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
//			session.close();
//			session.getSessionFactory().close();
			System.gc();
		}
		return (T) object;
	}
	
	@Transactional
	public Collection<T> listar(Unidade unidade) throws Exception {

		Collection<T> lista = null;
//		Session session = HibernateUtility.getSession();
		
		try {
			Query consulta = sessionFactory.getCurrentSession().createQuery("from " + getClasseConsulta().getName() + " c WHERE c.unidade = :unidade");
			consulta.setParameter("unidade", unidade);
			lista = consulta.list();
		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
//			session.close();
//			session.getSessionFactory().close();
			System.gc();
		}
		return lista;
	}

	/**
	 * Retorna a classe que ser� utilizada para consulta ou listagem.
	 * @return a classe que ser� utilizada para consulta ou listagem.
	 */
	protected abstract Class<T> getClasseConsulta();
	
	@Transactional
	public void salvar(T object){
//		Session session = HibernateUtility.getSession();
//		Transaction tx = session.beginTransaction();
		FacesMessage message = null;
		try {
			sessionFactory.getCurrentSession().save(object);
			message = new FacesMessage(FacesMessage.SEVERITY_INFO,	"CADASTRO EFETUADO COM SUCESSO", "CADASTRO EFETUADO COM SUCESSO!");
//			FacesContext.getCurrentInstance().addMessage("cadastro", message);
//			tx.commit();
//			sessionFactory.getCurrentSession().getTransaction().commit();
		}catch (ConstraintViolationException e) {
			e.printStackTrace();
			sessionFactory.getCurrentSession().clear();
//			tx.rollback();
			if (e.getErrorCode() == 1062) {
				message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "J� EXISTE UM REGISTRO COM ESTE C�DIGO", null);
			}else{
				if (e.getErrorCode() == 1452) {
					message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "DEPEND�NCIA DE DADOS", "DEPEND�NCIA DE DADOS!");
				}else{
					message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO AO EFETUAR O CADASTRO", "ERRO AO EFETUAR O CADASTRO!");
				}
			}
		}catch (HibernateException e) {
			e.printStackTrace();
			sessionFactory.getCurrentSession().clear();
//			tx.rollback();
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO AO EFETUAR O CADASTRO", "ERRO AO EFETUAR O CADASTRO!");
		}finally {
			FacesContext.getCurrentInstance().addMessage("cadastro", message);
//			session.close();
			System.gc();
		}
	}

		 
		@Transactional
		public void salvarOuAtualizar(T object) {
		// Session session = HibernateUtility.getSession();
		// Transaction tx = session.beginTransaction();
		try {
		// session.saveOrUpdate(object);
		// tx.commit();
		sessionFactory.getCurrentSession().saveOrUpdate(object);
		sessionFactory.getCurrentSession().flush();
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "ALTERA��O EFETUADA COM SUCESSO", "ALTERA��O EFETUADA COM SUCESSO!");
		FacesContext.getCurrentInstance().addMessage("cadastro", message);
		} catch (NonUniqueObjectException e) {
		// session.merge(object);
		// tx.rollback();
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "REGISTRO N�O PODE SER ALTERADO", "REGISTRO N�O PODE SER ALTERADO!");
		FacesContext.getCurrentInstance().addMessage("cadastro", message);
		}catch (ConstraintViolationException e) {
		e.printStackTrace();
		// tx.rollback();
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "DUPLICIDADE DE DADOS", "DUPLICIDADE DE DADOS!");
		FacesContext.getCurrentInstance().addMessage("cadastro", message);
		}
		// Envia as altera��es do objeto para o banco e retira o objeto da
		// sess�o.
		// session.flush();
		// session.evict(object);
		// session.getSessionFactory().close();

		}
		 
		@Transactional
		public void excluir(T object) {
		// Session session = HibernateUtility.getSession();
		// Transaction tx = session.beginTransaction();
		try {
		// session.delete(object);
		// tx.commit();
		sessionFactory.getCurrentSession().delete(object);
		sessionFactory.getCurrentSession().flush();
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "REGISTRO EXCLU�DO COM SUCESSO", "REGISTRO EXCLU�DO COM SUCESSO!");
		FacesContext.getCurrentInstance().addMessage("cadastro", message);
		}catch (ConstraintViolationException e) {
		e.printStackTrace();
		// tx.rollback();
		FacesMessage message;
		if (e.getErrorCode() == 1451) {
		message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "REGISTRO EM USO, N�O PODE SER EXCLU�DO", "REGISTRO EM USO, N�O PODE SER EXCLU�DO!");
		}else{
		message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "REGISTRO N�O PODE SER EXCLU�DO", "REGISTRO N�O PODE SER EXCLU�DO!");
		}
		FacesContext.getCurrentInstance().addMessage("cadastro", message);
		} finally {
		// session.close();
		// session.getSessionFactory().close();
		System.gc();
		}
		}
}
