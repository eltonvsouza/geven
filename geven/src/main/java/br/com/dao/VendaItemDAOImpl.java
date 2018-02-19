package br.com.dao;

import java.util.Collection;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.dao.utility.HibernateUtility;
import br.com.model.VendaItem;

@Service
public class VendaItemDAOImpl<T> extends GenericDAOImpl<T> implements VendaItemDAO {
	@SuppressWarnings("unchecked")
	@Override
	protected Class getClasseConsulta() {
		return VendaItem.class;
	}
	
	@Transactional
	public Collection<T> listarVendaItem(Integer venda) throws Exception {
		Collection<T> lista = null;
		try {
			Query consulta = getSessionFactory().getCurrentSession().createQuery("from " + getClasseConsulta().getName() + " c WHERE c.venda = :venda");
			consulta.setParameter("venda", venda);
			lista = consulta.list();
		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			System.gc();
		}
		return lista;
	}
}
