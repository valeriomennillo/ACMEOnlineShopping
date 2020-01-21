package it.unina.valerio.acme.control;

import java.util.ArrayList;

import it.unina.valerio.acme.entity.Cliente;
import it.unina.valerio.acme.entity.Sconto;
import it.unina.valerio.acme.entity.Spesa;

public class GestoreCliente {
	
	public void registraCliente(ArrayList<Cliente> lista_clienti, Cliente cliente) {
		lista_clienti.add(cliente);
	}

	public void inserisciSconto(Cliente cliente, Sconto sconto) {
		cliente.addSconto(sconto);
	}

	public void registraSpesa(ArrayList<Spesa> lista_spese, Spesa spesa) {
		lista_spese.add(spesa);
		if (spesa.getClient().getNumSpese(lista_spese) > Spesa.N) 
			spesa.getClient().setHabitual(true);
	}
}
