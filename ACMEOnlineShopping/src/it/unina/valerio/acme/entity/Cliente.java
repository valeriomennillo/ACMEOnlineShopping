package it.unina.valerio.acme.entity;

import java.util.ArrayList;
import java.util.Stack;

import it.unina.valerio.acme.control.GestoreCliente;

public class Cliente {
	public static int contID = 0;
	@SuppressWarnings("unused")
	private String nomeUtente;
	@SuppressWarnings("unused")
	private String password;
	@SuppressWarnings("unused")
	private String numeroTelefono;
	@SuppressWarnings("unused")
	private String cartaCredito;
	private int ID;
	private boolean habitual;
	// private ArrayList<Sconto> ;
	private Stack<Sconto> sconti;

	public Cliente(String nomeUtente, String password, String numeroTelefono, String cartaCredito) {
		this.nomeUtente = nomeUtente;
		this.password = password;
		this.numeroTelefono = numeroTelefono;
		this.cartaCredito = cartaCredito;
		this.ID = contID++;
		this.habitual = false;
		this.sconti = new Stack<Sconto>();
	}

	public int getID() {
		return ID;
	}
	public void addSconto( Sconto s) {
		if (this.habitual && s.getPercentuale() > 0 && s.getPercentuale() <= 100)
			this.sconti.push(s);
	}

	public Sconto getSconto() {
		if (this.habitual && !sconti.isEmpty())
			return this.sconti.pop();
		else
			return new Sconto(1, 0, null);
	}

	public int getNumSpese() {
		int numSpese = 0;
		for (Spesa s : GestoreCliente.lista_spese) {
			if (s.getIdCliente() == this.ID) {
				numSpese++;
			}
		}
		return numSpese;
	}

	public float getSpesaTotale() {
		float money = 0;
		for (Spesa s : GestoreCliente.lista_spese) {
			if (s.getIdCliente() == this.ID) {
				money += s.getCosto();
			}
		}
		return money;
	}

	public boolean isHabitual() {
		return habitual;
	}

	public void setHabitual(boolean habitual) {
		this.habitual = habitual;
	}
}
