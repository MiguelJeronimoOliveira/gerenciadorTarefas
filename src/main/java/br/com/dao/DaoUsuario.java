package br.com.dao;

import br.com.entidades.Usuario;

public interface DaoUsuario {

	Usuario consultarUsuario(String username, String senha);
	
}
