package br.com.filtros;

import br.com.entidades.*;

public class FiltroTarefa {
    private Long numero;
    private String tituloDescricao;
    private SituacaoTarefa situacaoSelecionada;

    // Getters e Setters

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

    public SituacaoTarefa getSituacaoSelecionada() {
        return situacaoSelecionada;
    }

    public void setSituacaoSelecionada(SituacaoTarefa situacaoSelecionada) {
        this.situacaoSelecionada = situacaoSelecionada;
    }
    
}
