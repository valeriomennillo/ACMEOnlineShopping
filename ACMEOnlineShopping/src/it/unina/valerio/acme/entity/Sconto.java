package it.unina.valerio.acme.entity;

import java.util.Date;

public class Sconto {
	@SuppressWarnings("unused")
	private String codice;
	private int percentuale;
	private Date dataScadenza;
	
	public Sconto(String codice, int percentuale, Date dataScadenza)
	{
		this.codice=codice;
		if(percentuale<=0 || percentuale>100)
		{
			System.err.println("Valore di sconto "+percentuale+" non valido!");
			return;
		}
		this.percentuale=percentuale;
		this.dataScadenza=dataScadenza;
	}

	public Date getDataScadenza() {
		return dataScadenza;
	}

	public int getPercentuale() {
		return percentuale;
	}
}
