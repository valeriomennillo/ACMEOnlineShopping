package it.unina.valerio.acme.control;

import it.unina.valerio.acme.entity.Report;
import it.unina.valerio.acme.entity.Spesa;

import java.util.ArrayList;

import it.unina.valerio.acme.entity.Cliente;

public class GestoreReport {
	public Report generaReport(int N, ArrayList<Cliente> lista_clienti, ArrayList<Spesa> lista_spese) {
		Report R = new Report();
		int numSpesa = 0;
		try {
			for (Cliente c : lista_clienti) {
				numSpesa = c.getNumSpese(lista_spese);
				if (numSpesa >= N) {
					R.addRecord(c.getID(), numSpesa, c.getSpesaTotale(lista_spese));
				}
			}
		}catch(NullPointerException e){
			//e.printStackTrace();
		}
			//System.out.println(c.getN)
		return R;
	}

	public void visualizzaReport(Report report) {
		System.out.println(report.toString());
	}

}
