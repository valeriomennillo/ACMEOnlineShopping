package it.unina.valerio.acme.entity;

import java.util.ArrayList;


public class Cliente {
	public static int contID = 0;
	private int ID;
	private boolean habitual;
	private ArrayList<Sconto> sconti;

	@SuppressWarnings("unused")
	private String nomeUtente;
	@SuppressWarnings("unused")
	private String password;
	@SuppressWarnings("unused")
	private String numeroTelefono;
	@SuppressWarnings("unused")
	private String cartaCredito;

	public Cliente(String nomeUtente, String password, String numeroTelefono, String cartaCredito) {
		this.nomeUtente = nomeUtente;
		this.password = password;
		this.numeroTelefono = numeroTelefono;
		this.cartaCredito = cartaCredito;
		this.ID = contID++;
		this.habitual = false;
		this.sconti = new ArrayList<Sconto>();
	}

	public void addSconto(Sconto sconto) {
		if (this.habitual)
			this.sconti.add(sconto);
		//else
		//	System.err.println("Errore nell'aggiunta dello sconto! Cliente non è abituale!");
	}

	public void removeSconto(Sconto sconto) {
		this.sconti.remove(sconto);
	}


	public int getNumSpese(ArrayList<Spesa> lista_spese) {
		int numSpese = 0;
		for (Spesa s : lista_spese) {
			//confronto i riferimenti
			//equals(this) è un opzione
			if (s.getClient()==this) {
				numSpese++;
			}
		}
		return numSpese;
	}


	public ArrayList<Sconto> getSconti() {
		return sconti;
	}
	
	public float getSpesaTotale(ArrayList<Spesa> lista_spese) {
		float money = 0;
		for (Spesa s : lista_spese) {
			//confronto i riferimenti
			//equals(this) è un opzione
			if (s.getClient()==this) {
				money += s.getCosto();
			}
		}
		return money;
	}

	public int getID() {
		return ID;
	}

	public void setHabitual(boolean habitual) {
		this.habitual = habitual;
	}

}
