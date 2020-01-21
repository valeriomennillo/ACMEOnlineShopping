package it.unina.valerio.acme.control;

import it.unina.valerio.acme.entity.Report;
import it.unina.valerio.acme.entity.Cliente;

public class GestoreReport {
	public Report generaReport(int num) {
		Report R = new Report();
		int numSpesa = 0;
		for (Cliente c : GestoreCliente.lista_clienti) {
			numSpesa = c.getNumSpese();
			if (numSpesa >= num) {
				R.addRecord(c.getID(), numSpesa, c.getSpesaTotale());
			}

		}
		return R;
	}

	public void visualizzaReport(Report r) {
		System.out.println(r.toString());
	}

}
