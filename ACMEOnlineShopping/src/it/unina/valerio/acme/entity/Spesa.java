package it.unina.valerio.acme.entity;

import java.util.ArrayList;
import java.util.Date;


public class Spesa {
	public static int N;
	private static int contID = 0;
	private float costo;
	
	//riferimenti
	private Cliente cliente;
	@SuppressWarnings("unused")
	private Sconto sconto;

	@SuppressWarnings("unused")
	private ArrayList<Prodotto> prodotti;
	@SuppressWarnings("unused")
	private ArrayList<Integer> quantitaProdotti;
	@SuppressWarnings("unused")
	private int ID;
	@SuppressWarnings("unused")
	private Date data;
	
	//2 costruttori: con e senza sconto
	public Spesa(Date data, ArrayList<Prodotto> prodotti, ArrayList<Integer> quantitaProdotti, Cliente cliente) {
		this.cliente = cliente;
		this.ID = contID++;
		this.data = data;
		this.prodotti = prodotti;
		this.quantitaProdotti = quantitaProdotti;
		this.costo = calcolaCostoTotale(prodotti, quantitaProdotti);
	}

	public Spesa(Date data, ArrayList<Prodotto> prodotti, ArrayList<Integer> quantitaProdotti, Cliente cliente, Sconto sconto) {
		this.cliente = cliente;
		this.ID = contID++;
		this.data = data;
		this.prodotti = prodotti;
		this.quantitaProdotti = quantitaProdotti;
		
		this.sconto=sconto;
		//float oldCosto=calcolaCostoTotale(prodotti, quantitaProdotti);
		//this.costo=oldCosto;
		this.costo=calcolaCostoTotale(prodotti, quantitaProdotti);
		if(cliente.getSconti().contains(sconto))
		{
			if(sconto.getDataScadenza().compareTo(data)>0)
			{
				//this.costo = oldCosto
				this.costo = calcolaCostoScontato(cliente,this.costo,sconto);
			}else
			{
				//System.err.println("Sconto scaduto! Inutilizzabile! Lo sconto non viene applicato al costo totale..");
			}
		}else
		{
			//System.err.println("Il Cliente non possiede quello sconto! Non viene applicato nessuno sconto.");
		}
	}
	
	public float calcolaCostoTotale(ArrayList<Prodotto> prodotti, ArrayList<Integer> quantita) {
		float costo = 0;
		for (int i = 0; i < prodotti.size(); i++) {
			costo += prodotti.get(i).getPrezzo() * quantita.get(i);
		}
		return costo;
	}
	
	public float calcolaCostoScontato(Cliente cliente, float costo, Sconto sconto)
	{
		float out = costo*(100-sconto.getPercentuale())/100;
		cliente.removeSconto(sconto);
		return out;
	}
	public float getCosto() {
		return costo;
	}

	public Cliente getClient()
	{
		return cliente;
	}

}
