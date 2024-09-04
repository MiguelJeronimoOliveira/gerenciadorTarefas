package br.com.controlador;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.dao.DaoGenerico;
import br.com.dao.DaoTarefa;
import br.com.entidades.Tarefa;
import br.com.filtros.*;
import br.com.dao.DaoTarefa;
import br.com.entidades.SituacaoTarefa;

@ManagedBean(name = "tarefaBean")
@ViewScoped
public class TarefaBean {

	private Tarefa tarefa = new Tarefa();
	private DaoGenerico<Tarefa> daoGenericoT = new DaoGenerico<Tarefa>();
	private List<Tarefa> tarefas = new ArrayList<Tarefa>();
	private FiltroTarefa filtro = new FiltroTarefa();
	
	//lista de tarefas 
	@PostConstruct
	public void exibirLista() {
		tarefas = daoGenericoT.getListEntity(Tarefa.class);
	}
	
	
	//operacoes CRUD
	
	public String filtrar ()
	{
		DaoTarefa dao = new DaoTarefa();
		tarefas = dao.filtrar(filtro);
		return "";
	}
	
	//salvar tarefa
	public String salvar() {
		daoGenericoT.save(tarefa);
		tarefa = new Tarefa();
		exibirLista();
		return "";
	}
	
	//editar tarefa
	public String editar() {
		tarefa = daoGenericoT.edit(tarefa);
		exibirLista();
		return "";
	}

	//deletar tarefa
	public String deletar() {
		daoGenericoT.delete(tarefa);
		tarefa = new Tarefa();
		exibirLista();
		return "";
	}
	
	
	public String concluir() {
		
		tarefa.setSituacao(SituacaoTarefa.concluida);
		editar();
		
		return "";
	}
	
	public void novo() {
		tarefa = new Tarefa();
	}
	
	//getters setters
	public Tarefa getTarefa() {
		return tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

	public DaoGenerico<Tarefa> getDaoGenericoT() {
		return daoGenericoT;
	}

	public void setDaoGenericoT(DaoGenerico<Tarefa> daoGenericoT) {
		this.daoGenericoT = daoGenericoT;
	}


	public List<Tarefa> getTarefas() {
		return tarefas;
	}


	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}

	

}
