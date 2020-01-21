package it.unina.valerio.acme.entity;

import java.util.ArrayList;
import java.util.Date;

import it.unina.valerio.acme.control.GestoreCliente;

public class Spesa {
	public static int N = 1;
	private static int contID = 0;
	@SuppressWarnings("unused")
	private int ID;
	@SuppressWarnings("unused")
	private Date data;
	private float costo;
	@SuppressWarnings("unused")
	private ArrayList<Prodotto> prodotti;
	@SuppressWarnings("unused")
	private ArrayList<Integer> quantitaProdotti;
	private int IDCliente;
	
	
	private Cliente cliente;
	
	
	GestoreCliente gestoreCliente = new GestoreCliente();
	private boolean applicaSconto;

	public Cliente getClient()
	{
		return cliente;
	}
	public Spesa(Date data, ArrayList<Prodotto> prodotti, ArrayList<Integer> quantitaProdotti, Cliente c,
			boolean applicaSconto) {
		if (IDCliente < Cliente.contID) {
			this.IDCliente = c.getID();
		} else {
			System.err.println("ERROR: IDCliente " + IDCliente + " non esiste! Spesa non instanziata!");
			return;
		}
		this.ID = contID++;
		this.data = data;
		this.prodotti = prodotti;
		this.quantitaProdotti = quantitaProdotti;
		this.cliente=c;
		/*System.out.println(c.getNumSpese());
		if(c.getNumSpese()>Spesa.N)
		{
			System.out.println("test");
			c.setHabitual(true);
		}*/
		this.applicaSconto = applicaSconto;
		this.costo = calcolaCostoTotale(c, prodotti, quantitaProdotti);
	}

	public float calcolaCostoTotale(Cliente c, ArrayList<Prodotto> p, ArrayList<Integer> q) {
		float costo = 0;
		for (int i = 0; i < p.size(); i++) {
			costo += p.get(i).getPrezzo() * q.get(i);
		}
		/*System.out.println(c.isHabitual());
		if (c.isHabitual() && applicaSconto) {
			System.out.println("test");
			// applica sconto
			//costo = gestoreCliente.inserisciSconto(costo, c);
		}*/
		return costo;
	}

	public int getIdCliente() {
		return IDCliente;
	}

	
	public float getCosto() {
		return costo;
	}

	public boolean getApplicaSconto() {
		// TODO Auto-generated method stub
		return applicaSconto;
	}

	public void setCosto(float costo) {
		this.costo=costo;
		
	}
}
