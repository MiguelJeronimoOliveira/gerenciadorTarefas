package br.com.entidades;

public enum SituacaoTarefa {
	EmAndamento("Em andamento"),
	Concluida("Concluida");
	
	private final String label;

	SituacaoTarefa(String label) {
        this.label = label;
    }
    
	public String getLabel() {
		
		return label;
	}
	
	
	
	
}
