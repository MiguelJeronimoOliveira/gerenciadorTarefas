package br.com.controlador;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.servlet.http.HttpSession;

import br.com.dao.DaoGenerico;
import br.com.entidades.Usuario;
import jpautil.JPAUtil;

@ManagedBean(name="usuarioBean")
public class UsuarioBean {

	private String username;
	private String senha;
	
	private Usuario usuario = new Usuario();
	private DaoGenerico<Usuario> daoGenerico = new DaoGenerico<Usuario>();


	//getters e setters
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public DaoGenerico<Usuario> getDaoGenerico() {
		return daoGenerico;
	}
	public void setDaoGenerico(DaoGenerico<Usuario> daoGenerico) {
		this.daoGenerico = daoGenerico;
	}


	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}


	
}
