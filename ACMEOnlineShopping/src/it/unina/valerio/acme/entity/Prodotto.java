package it.unina.valerio.acme.entity;

import it.unina.valerio.acme.exception.NegativePriceException;

public class Prodotto {
	private static int contID=0;
	@SuppressWarnings("unused")
	private int ID;
	@SuppressWarnings("unused")
	private String nome;
	@SuppressWarnings("unused")
	private String descrizione;
	private float prezzo;
	@SuppressWarnings("unused")
	private int quantita;


	public Prodotto(String nome, String descrizione, float prezzo, int quantita) throws NegativePriceException
	{
		this.ID=contID++;
		this.nome=nome;
		this.descrizione=descrizione;
		if(prezzo<=0)
		{
			throw new NegativePriceException();
		}
		this.prezzo=prezzo;
		this.quantita=quantita;
	}

	public float getPrezzo() {
		return prezzo;
	}
	

}
