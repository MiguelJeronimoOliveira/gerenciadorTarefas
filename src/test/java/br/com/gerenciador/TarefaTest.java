package br.com.gerenciador;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.entidades.SituacaoTarefa;
import br.com.entidades.Tarefa;

public class TarefaTest {
	private Tarefa tarefa;
	
	@BeforeEach
	public void setUp() {
		tarefa = new Tarefa();
	}
	
	@Test
	public void testGetSetTitulo() {
		String titulo = "Testes";
		tarefa.setTitulo(titulo);
        assertEquals(titulo, tarefa.getTitulo(), "O título da tarefa deve ser igual ao valor definido");
	}
	
	@Test
	public void testGetSetDescricao() {
		String descricao = "Testes";
		tarefa.setDescricao(descricao);
		assertEquals(descricao, tarefa.getDescricao(), "A descricao da tarefa deve ser igual ao valor definido");
	}
	
	@Test
	public void testGetSetDeadline() {
		Date deadline = new Date();
		tarefa.setDeadline(deadline);
		assertEquals(deadline, tarefa.getDeadline(), "A data da tarefa deve ser igual ao valor definido");
	}
	
	@Test
	public void testGetSetSituacao() {
		tarefa.setSituacao(SituacaoTarefa.EmAndamento);
		assertEquals(SituacaoTarefa.EmAndamento, tarefa.getSituacao(), "A situacao da tarefa deve ser igual ao valor definido" );
	}
	
}
