package br.com.controlador;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import br.com.dao.DaoGenerico;
import br.com.dao.DaoTarefa;
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
	private FiltroTarefa filtro = new FiltroTarefa();
	private List<Tarefa> tarefasFiltradas = new ArrayList<Tarefa>();
	private DaoTarefa daoTarefa = new DaoTarefa();
	//lista de tarefas 
	
	
	@PostConstruct
	public void exibirLista() {
		this.tarefas = new ArrayList<Tarefa>();
		this.tarefas.addAll(getTarefasOrdenadas());
	}
	
	public void filtrar ()
	{
		tarefas = new ArrayList<Tarefa>();
		this.tarefas.addAll(daoTarefa.filtrar(filtro, daoGenericoT.getEntityManager())); 
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
		tarefa.setSituacao(SituacaoTarefa.EmAndamento);
		daoGenericoT.save(tarefa);
		tarefa = new Tarefa();
		filtrar(); 
		return "";
	}
	
	//editar tarefa
	public String editar() {
		tarefa = daoGenericoT.edit(tarefa);
		filtrar();
		return "";
	}

	//deletar tarefa
	public String deletar(Tarefa tarefa) {
		daoGenericoT.delete(tarefa);
		this.tarefa = new Tarefa();
		filtrar();
		return "";
	}	
	
	//mudar situação da tarefa
	public String concluir() {
		
		tarefa.setSituacao(SituacaoTarefa.Concluida);
		editar();
		tarefa = new Tarefa();
		
		return "";
	}
	
	//get ENUM situacao
    public List<SelectItem> getSituacoes() {
        List<SelectItem> items = new ArrayList<SelectItem>();
        for (SituacaoTarefa situacao : SituacaoTarefa.values()) {
            items.add(new SelectItem(situacao, situacao.getLabel()));
        }
        return items;
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

	public FiltroTarefa getFiltro() {
		return filtro;
	}

	public void setFiltro(FiltroTarefa filtro) {
		this.filtro = filtro;
	}

	public List<Tarefa> getTarefasFiltradas() {
		return tarefasFiltradas;
	}

	public void setTarefasFiltradas(List<Tarefa> tarefasFiltradas) {
		this.tarefasFiltradas = tarefasFiltradas;
	}

	public DaoTarefa getDaoTarefa() {
		return daoTarefa;
	}

	public void setDaoTarefa(DaoTarefa daoTarefa) {
		this.daoTarefa = daoTarefa;
	}
	

}
