package br.com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import jpautil.JPAUtil;

public class DaoGenerico<E> {

	protected EntityManager entityManager = JPAUtil.getEntityManager();
	
	//DAO CRUD
	
	//metodo salvar
	public void save(E entidade) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		entityManager.persist(entidade);
		
		entityTransaction.commit();
	}
	
	//metodo editar
	public E edit(E entidade) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		E retorno = entityManager.merge(entidade);
		
		entityTransaction.commit();
		return retorno;
	}

	//metodo deletar
	public void delete(E entidade) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(entidade);
		entityManager.remove(entidade);
		entityTransaction.commit();
	}
	
		
	//lista de tarefas	
	public List<E> listarOrdenado (Class<E> entidade)
	{
		List<E> lista = entityManager.createQuery("from " + entidade.getName() + " order by id ASC").getResultList();
		
		return lista;
		
	}

	public EntityManager getEntityManager() {
		return this.entityManager;
	}

}
