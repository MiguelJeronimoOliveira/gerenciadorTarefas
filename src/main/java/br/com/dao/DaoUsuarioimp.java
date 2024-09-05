package br.com.dao;

import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.http.HttpSession;

import br.com.entidades.Usuario;
import jpautil.JPAUtil;

public class DaoUsuarioimp implements DaoUsuario {

	@Override
	public Usuario consultarUsuario(String username, String senha) {
		
		Usuario usuario = null;
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		
        usuario = (Usuario) entityManager.createQuery(
                "select u from Usuario u where u.username = :username and u.senha = :senha", Usuario.class)
                .setParameter("username", username)
                .setParameter("senha", senha)
                .getSingleResult();
		
		return usuario;
	}
	
	public static String getUsuarioNome() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		return usuario.getUsername();
	}
	
	public static Usuario getUsuario() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		return usuario;
	}

	public static void logout() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.invalidate();
	}

}
