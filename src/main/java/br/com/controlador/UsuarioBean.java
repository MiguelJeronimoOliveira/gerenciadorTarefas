package br.com.controlador;

import java.sql.SQLOutput;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.servlet.http.HttpSession;

import br.com.dao.DaoGenerico;
import br.com.dao.DaoUsuario;
import br.com.dao.DaoUsuarioimp;
import br.com.entidades.Tarefa;
import br.com.entidades.Usuario;
import jpautil.JPAUtil;

@ManagedBean(name="usuarioBean")
public class UsuarioBean {

	private String username;
	private String senha;
	
	private Usuario usuario = new Usuario();
	private DaoGenerico<Usuario> daoGenerico = new DaoGenerico<Usuario>();
	private DaoUsuario daoUsuario = new DaoUsuarioimp();

	public String logar() {
		Usuario usuarioLogar = daoUsuario.consultarUsuario(usuario.getUsername(), usuario.getSenha());
		
		if(usuarioLogar != null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			ExternalContext externalContext = facesContext.getExternalContext();
			externalContext.getSessionMap().put("usuarioLogado", usuarioLogar.getUsername());
			
			return "paginaPrincipal?faces-redirect=true";
		}
		
		return"index?faces-redirect=true";
	}
	
	//cadastrar usuario
	public String cadastrar() {
		daoGenerico.save(usuario);
		usuario = new Usuario();
		return "";
	}
	

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
