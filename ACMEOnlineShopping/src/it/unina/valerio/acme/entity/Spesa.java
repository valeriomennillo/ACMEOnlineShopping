package it.unina.valerio.acme.entity;

import java.util.ArrayList;
import java.util.Date;


public class Spesa {
	public static int N = 1;
	private static int contID = 0;
	private float costo;
	//private int IDCliente;
	
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
		float tempCosto=calcolaCostoTotale(prodotti, quantitaProdotti);
		this.costo=tempCosto;
		if(cliente.getSconti().contains(sconto))
		{
			if(sconto.getDataScadenza().compareTo(data)>0)
			{
				this.costo = calcolaCostoScontato(cliente,tempCosto,sconto);
				//System.out.println("Costo finale= "+tempCosto+" COsto finale scontato: "+costo + " del "+sconto.getPercentuale()+"%");
			}else
			{
				System.err.println("Sconto scaduto! Inutilizzabile! Lo sconto non viene applicato al costo totale..");
				//this.costo=tempCosto;
			}
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
		//applica sconto
		float out = costo*(100-sconto.getPercentuale())/100;
		//System.out.println("AA"+out);
		//rimuovi lo sconto dalla lista degli sconti del cliente
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
