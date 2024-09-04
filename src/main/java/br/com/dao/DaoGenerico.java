package br.com.dao;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.entidades.Tarefa;
import br.com.entidades.Usuario;
import jpautil.JPAUtil;

public class DaoGenerico<E> {

	protected EntityManager entityManager = JPAUtil.getEntityManager();
	
	//DAO CRUD
	public void save(E entidade) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		entityManager.persist(entidade);
		
		entityTransaction.commit();
	}
	
	public E edit(E entidade) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		E retorno = entityManager.merge(entidade);
		
		entityTransaction.commit();
		return retorno;
	}

	public void delete(E entidade) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		entityManager.remove(entidade);
		
		transaction.commit();
	}
	
		
	//lista de tarefas
	public List<E> getListEntity(Class<E> entidade){
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		List<E> retorno = entityManager.createQuery("from " +  entidade.getName()).getResultList();
		
		entityTransaction.commit();
		return retorno;
	}
	
	public List<E> listarOrdenado (Class<E> entidade)
	{
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		List<E> lista = entityManager.createQuery("from " + entidade.getName() + " order by id ASC").getResultList();
		
		transaction.commit();
		return lista;
		
	}

}
