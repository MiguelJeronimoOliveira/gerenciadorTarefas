package br.com.filtros;

import br.com.entidades.*;

public class FiltroTarefa {
	private Long numero;
	private String tituloDescricao;
	private String situacaoSelecionada;
	private Long responsavelSelecionadoId;
	
	
	
	//getters setters
	
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public String getTituloDescricao() {
		return tituloDescricao;
	}
	public void setTituloDescricao(String tituloDescricao) {
		this.tituloDescricao = tituloDescricao;
	}
	public String getSituacaoSelecionada() {
		return situacaoSelecionada;
	}
	public void setSituacaoSelecionada(String situacaoSelecionada) {
		this.situacaoSelecionada = situacaoSelecionada;
	}
	public Long getResponsavelSelecionadoId() {
		return responsavelSelecionadoId;
	}
	public void setResponsavelSelecionadoId(Long responsavelSelecionadoId) {
		this.responsavelSelecionadoId = responsavelSelecionadoId;
	}
	
	

}
