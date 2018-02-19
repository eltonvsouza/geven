package br.com.dao;

import org.springframework.stereotype.Service;

import br.com.model.Contasareceber;

@Service
public class ContasareceberDAOImpl<T> extends GenericDAOImpl<T> implements ContasareceberDAO {
	@SuppressWarnings("unchecked")
	@Override
	protected Class getClasseConsulta() {
		return Contasareceber.class;
	}
}
