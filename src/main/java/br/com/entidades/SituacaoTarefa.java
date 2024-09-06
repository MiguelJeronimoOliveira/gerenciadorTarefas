package br.com.entidades;

public enum SituacaoTarefa {
	EmAndamento("EmAndamento"),
	Concluida("Concluida");
	
	private String label;

	SituacaoTarefa(String label) {
        this.label = label;
    }
    
	public String getLabel() {
		
		return label;
	}
	
	
	
	
}
