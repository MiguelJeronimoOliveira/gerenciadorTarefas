package br.com.controlador;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.dao.DaoGenerico;
import br.com.dao.DaoUsuarioimp;
import br.com.entidades.Tarefa;
import br.com.filtros.*;
import br.com.entidades.SituacaoTarefa;

@ManagedBean(name = "tarefaBean")
@ViewScoped
public class TarefaBean {

	private Tarefa tarefa = new Tarefa();
	private DaoGenerico<Tarefa> daoGenericoT = new DaoGenerico<Tarefa>();
	private List<Tarefa> tarefas = new ArrayList<Tarefa>();
	
	//lista de tarefas 
	@PostConstruct
	public void exibirLista() {
		this.tarefas = new ArrayList<Tarefa>();
		this.tarefas.addAll(getTarefasOrdenadas());
	}
	
	@SuppressWarnings("unchecked")
	public List<Tarefa> getTarefasOrdenadas() {
        List<Tarefa> listaTarefas = daoGenericoT.getEntityManager().createNamedQuery("Tarefas.de")
                .setParameter("responsavel", DaoUsuarioimp.getUsuario())
                .getResultList();

        return listaTarefas;
	}
	
	//operacoes CRUD
	
	
	//atribuir usuario a coluna responsavel
	public void setarResponsavel() {
		tarefa.setResponsavel(DaoUsuarioimp.getUsuario());
	}
	
	//salvar tarefa
	public String salvar() {
		setarResponsavel();
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
	public String deletar(Tarefa tarefa) {
		System.out.println(tarefa);
		daoGenericoT.delete(tarefa);
		this.tarefa = new Tarefa();
		exibirLista();
		return "";
	}	
	
	//mudar situação da tarefa
	public String concluir() {
		
		tarefa.setSituacao(SituacaoTarefa.concluida);
		editar();
		tarefa = new Tarefa();
		
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
