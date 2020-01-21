package it.unina.valerio.acme.control;

import java.util.ArrayList;

import it.unina.valerio.acme.entity.Cliente;
import it.unina.valerio.acme.entity.Sconto;
import it.unina.valerio.acme.entity.Spesa;

public class GestoreCliente {
	public static ArrayList<Cliente> lista_clienti = new ArrayList<Cliente>();
	public static ArrayList<Spesa> lista_spese = new ArrayList<Spesa>();

	public void registraCliente(Cliente c) {
		lista_clienti.add(c);
	}

	public void inserisciSconto(Spesa s, Cliente c) {
		s.setCosto(s.getCosto() * (100 - c.getSconto().getPercentuale()) / 100);
	}


	public void registraSpesa(Spesa s, Cliente c) {
		lista_spese.add(s);

		if (c.isHabitual()) {
			if (s.getApplicaSconto()) {
				int sIndex = lista_spese.indexOf(s);
				float costo = s.getCosto();
				inserisciSconto(s, c);
				System.out.println("NOTIFICA SCONTO: Pagato "+s.getCosto()+" invece che "+costo +" per CLIENT-ID "+c.getID()+" causato da SCONTO del "+c.getSconto().getPercentuale()+"% ");
				lista_spese.remove(sIndex);
				lista_spese.add(s);
				
			}
		} else {
			if (c.getNumSpese() > Spesa.N)
				c.setHabitual(true);
		}
	}
}
