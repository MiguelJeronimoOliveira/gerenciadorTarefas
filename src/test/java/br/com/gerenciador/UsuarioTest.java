package br.com.gerenciador;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.entidades.*;

public class UsuarioTest {
	 private Usuario usuario;

	    @BeforeEach
	    public void setUp() {
	        usuario = new Usuario();
	    }

	    @Test
	    public void testGetSetId() {
	        Long id = 1L;
	        usuario.setId(id);
	        assertEquals(id, usuario.getId(), "O ID do usuario deve ser igual ao valor definido");
	    }

	    @Test
	    public void testGetSetUsername() {
	        String username = "fulano33";
	        usuario.setUsername(username);
	        assertEquals(username, usuario.getUsername(), "O nome do usuario deve ser igual ao valor definido");
	    }

	    @Test
	    public void testSetSenha() {
	        String senha = "senha123";
	        usuario.setSenha(senha);
	        assertEquals(senha, usuario.getSenha(), "A senha do usuario deve ser igual ao valor definido");
	    }
	    
	    @Test
	    public void testGetSetTarefas() {
	        List<Tarefa> tarefas = new ArrayList<>();
	        Tarefa tarefa1 = new Tarefa();
	        tarefa1.setTitulo("Titulo");
	        tarefa1.setDescricao("Descrição");
	        tarefas.add(tarefa1);

	        Tarefa tarefa2 = new Tarefa();
	        tarefa2.setTitulo("Titulo 2");
	        tarefa2.setDescricao("Descrição 2");
	        tarefas.add(tarefa2);

	        usuario.setTarefas(tarefas);
	        assertEquals(tarefas, usuario.getTarefas(), "A lista de tarefas deve ser igual à lista definida");
	    }
}
