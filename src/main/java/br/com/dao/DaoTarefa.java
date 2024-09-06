package br.com.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.entidades.*;
import br.com.filtros.*;
import br.com.controlador.*;

public class DaoTarefa extends DaoGenerico<Tarefa>{
	 public List<Tarefa> filtrar(FiltroTarefa filtro) {
		 
		 
		 Usuario usuarioLogado = UsuarioBean.getUsuarioLogado();
		 
	        StringBuilder sb = new StringBuilder("FROM Tarefa t WHERE 1=1 ");
	        
	        if (filtro.getNumero() != null && filtro.getNumero() > 0) {
	            sb.append("AND t.id = :numero ");
	        }
	        
	        if(usuarioLogado != null) {
	        	sb.append("AND t.responsavel.id = :responsavelId ");
	        }
	        
	        if (filtro.getSituacaoSelecionada() != null) {
	            sb.append("AND t.situacao = :situacao ");
	        }
	        if (filtro.getTituloDescricao() != null && !filtro.getTituloDescricao().isEmpty()) {
	            sb.append("AND (t.titulo LIKE :tituloDescricao OR t.descricao LIKE :tituloDescricao) ");
	        }

	        sb.append("ORDER BY t.id ASC");
	        
	        Query query = super.entityManager.createQuery(sb.toString());
	        
	        if (filtro.getNumero() != null && filtro.getNumero() > 0) {
	            query.setParameter("numero", filtro.getNumero());
	        }
	        if(usuarioLogado != null) {
	        	query.setParameter("responsavelId", usuarioLogado.getId());
	        }
	        if (filtro.getSituacaoSelecionada() != null) {
	            query.setParameter("situacao", filtro.getSituacaoSelecionada());
	        }
	        if (filtro.getTituloDescricao() != null && !filtro.getTituloDescricao().isEmpty()) {
	            query.setParameter("tituloDescricao", "%" + filtro.getTituloDescricao() + "%");
	        }

	        return query.getResultList();
	    }
	}

