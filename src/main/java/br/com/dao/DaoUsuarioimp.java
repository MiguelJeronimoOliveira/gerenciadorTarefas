package br.com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.entidades.Usuario;
import jpautil.JPAUtil;

public class DaoUsuarioimp implements DaoUsuario {

	@Override
	public Usuario consultarUsuario(String username, String senha) {
		
		Usuario usuario = null;
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
        usuario = (Usuario) entityManager.createQuery(
                "select u from Usuario u where u.username = :username and u.senha = :senha", Usuario.class)
                .setParameter("username", username)
                .setParameter("senha", senha)
                .getSingleResult();
		
		
		entityTransaction.commit();
		
		return usuario;
	}

}
