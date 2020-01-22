package it.unina.valerio.acme.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import it.unina.valerio.acme.Main;
import it.unina.valerio.acme.control.GestoreCliente;
import it.unina.valerio.acme.control.GestoreReport;
import it.unina.valerio.acme.entity.Cliente;
import it.unina.valerio.acme.entity.Prodotto;
import it.unina.valerio.acme.entity.Report;
import it.unina.valerio.acme.entity.Sconto;
import it.unina.valerio.acme.entity.Spesa;
import it.unina.valerio.acme.exception.NegativePriceException;

public class GestoreReportTest {
	ArrayList<Cliente> lista_clienti;
	ArrayList<Spesa> lista_spese;
	ArrayList<Prodotto> prodotti1;
	ArrayList<Integer> quantita1;
	GestoreReport gestoreReport;
	GestoreCliente gestoreCliente;
	Report r;

	@Before
	public void setUp() throws Exception {
		// Prima di ogni test
		lista_clienti = new ArrayList<Cliente>();
		lista_spese = new ArrayList<Spesa>();
		prodotti1 = new ArrayList<Prodotto>();
		quantita1 = new ArrayList<Integer>();
		gestoreReport = new GestoreReport();
		gestoreCliente = new GestoreCliente();
		r = new Report();
		Spesa.N=0;

	}

	// TestCaseID:1
	@Test
	public void testNPositivoListaClienteNullListaSpeseNullNSpeseIndefinitoSpesaTotaleIndefinita() {
		Spesa.N=1;
		Report actual = gestoreReport.generaReport(Spesa.N, null, null);
		// gestoreReport.visualizzaReport(r);
		// gestoreReport.visualizzaReport(actual);
		assertEquals(r.toString(), actual.toString());
	}

	// TestCaseID:2
	@Test
	public void testNPositivoListaClienteVuotaListaSpeseVuotaNSpese0SpesaTotale0() {
		Spesa.N=1;
		Report actual = gestoreReport.generaReport(Spesa.N, lista_clienti, lista_spese);
		//gestoreReport.visualizzaReport(r);
		// gestoreReport.visualizzaReport(actual);
		assertEquals(r.toString(), actual.toString());
	}

	// TestCaseID:3
	@Test
	public void testNPositivoListaClienteNonVuotaListaSpeseNonVuotaNSpese0SpesaTotale0() {
		Spesa.N=1;
		Report r = new Report();
		GestoreReport gestoreReport = new GestoreReport();
		Cliente cliente = new Cliente("Valerio", "test123", "+39 5133311231", "4125 6231 1252 5123");
		gestoreCliente.registraCliente(lista_clienti, cliente);
		Report actual = gestoreReport.generaReport(Spesa.N, lista_clienti, lista_spese);
		//gestoreReport.visualizzaReport(r);
		// gestoreReport.visualizzaReport(actual);
		assertEquals(r.toString(), actual.toString());
	}

	// TestCaseID:4
	@Test
	public void testNPositivoListaClienteNonVuotaListaSpeseNonVuotaNSpesePositivoLessNSpesaTotalePositivo()
			throws NegativePriceException {
		Spesa.N=2;
		Cliente cliente = new Cliente("Valerio", "test123", "+39 5133311231", "4125 6231 1252 5123");
		gestoreCliente.registraCliente(lista_clienti, cliente);
		Prodotto p1 = new Prodotto("Detersivo", "Detersivo per lavastoviglie", 5, 50);
		prodotti1.add(p1);
		quantita1.add(1);
		gestoreCliente.registraSpesa(lista_spese, new Spesa(Main.dateOf("23/01/2020"), prodotti1, quantita1, cliente));
		Report actual = gestoreReport.generaReport(Spesa.N, lista_clienti, lista_spese);
		//gestoreReport.visualizzaReport(r);
		// gestoreReport.visualizzaReport(actual);
		assertEquals(r.toString(), actual.toString());
	}

	// TestCaseID:5
	@Test
	public void testNPositivoListaClienteNonVuotaListaSpeseNonVuotaNSpesePositivoGreaterNSpesaTotalePositivo()
			throws NegativePriceException {
		Spesa.N=1;

		Cliente cliente = new Cliente("Valerio", "test123", "+39 5133311231", "4125 6231 1252 5123");
		gestoreCliente.registraCliente(lista_clienti, cliente);

		Prodotto p1 = new Prodotto("Detersivo", "Detersivo per lavastoviglie", 5, 50);
		prodotti1.add(p1);
		quantita1.add(1);

		gestoreCliente.registraSpesa(lista_spese, new Spesa(Main.dateOf("22/01/2020"), prodotti1, quantita1, cliente));
		gestoreCliente.registraSpesa(lista_spese, new Spesa(Main.dateOf("23/01/2020"), prodotti1, quantita1, cliente));

		Report actual = gestoreReport.generaReport(Spesa.N, lista_clienti, lista_spese);
		r.addRecord(0, 2, 10F); // output atteso
		//gestoreReport.visualizzaReport(r);
		// gestoreReport.visualizzaReport(actual);
		assertEquals(r.toString(), actual.toString());
	}

	// TestCaseID:6
	@Test
	public void testN0ListaClienteNonVuotaListaSpeseNonVuotaNSpesePositivoGreaterNSpesaTotalePositiva()
			throws NegativePriceException {
		Spesa.N=0;
		Cliente cliente1 = new Cliente("Valerio", "test123", "+39 5133311231", "4125 6231 1252 5123");
		Cliente cliente2 = new Cliente("Gianluca", "password1", "+39 6135671231", "4444 1412 0000 0001");
		gestoreCliente.registraCliente(lista_clienti, cliente1);
		gestoreCliente.registraCliente(lista_clienti, cliente2);

		Prodotto p1 = new Prodotto("Detersivo", "Detersivo per lavastoviglie", 1, 50);
		prodotti1.add(p1);
		quantita1.add(1);
		gestoreCliente.registraSpesa(lista_spese, new Spesa(Main.dateOf("22/01/2020"), prodotti1, quantita1, cliente1));
		gestoreCliente.registraSpesa(lista_spese, new Spesa(Main.dateOf("23/01/2020"), prodotti1, quantita1, cliente2));

		Report actual = gestoreReport.generaReport(Spesa.N, lista_clienti, lista_spese);
		r.addRecord(0, 1, 1.0F);
		r.addRecord(0, 1, 1.0F);
		//gestoreReport.visualizzaReport(r);
		//gestoreReport.visualizzaReport(actual);
		assertEquals(r.toString(), actual.toString());
	}
	
	// TestCaseID:7
	@Test
	public void testNNegativoListaClienteVuotaListaSpeseVuotaNSpese0NSpesaTotale0()
			throws NegativePriceException {
		Spesa.N=-1;
		
		Report actual = gestoreReport.generaReport(Spesa.N, lista_clienti, lista_spese);
		
		//gestoreReport.visualizzaReport(r);
		//gestoreReport.visualizzaReport(actual);
		
		assertEquals(r.toString(), actual.toString());
	}
	
	// TestCaseID:8.1
	@Test
	public void testNPositivoListaClienteNonVuotaListaSpeseNonVuotaNSpesePositivoNSpesaTotalePositivaScontoPresente()
			throws NegativePriceException {
		
		Spesa.N=2;
		
		Cliente c1 = new Cliente("Valerio", "test123", "+39 3614511238", "4104 4319 3141 6969");
		Cliente c2 = new Cliente("Gennaro", "asd1", "+39 36153143238", "4104 4319 3331 1149");
		Cliente c3 = new Cliente("Raffaello", "asd2", "+39 5437355134", "4311 3444 5111 2311");

		gestoreCliente.registraCliente(lista_clienti,c1);
		gestoreCliente.registraCliente(lista_clienti,c2);
		gestoreCliente.registraCliente(lista_clienti,c3);

		Date now = Calendar.getInstance().getTime();

		Prodotto p1=null;
		Prodotto p2=null;
		Prodotto p3=null;
		
		try {
			p1 = new Prodotto("Detersivo", "Detersivo per lavastoviglie", 5.1F, 100);
			p2 = new Prodotto("Balsamo", "Balsamo per barba", 10, 70);
			p3 = new Prodotto("Asciugamano", "Asciugamano bianco", 2, 50);
		} catch (NegativePriceException e) {
			e.printStackTrace();
		}
		

		// prodotti->Lista di Prodotti Acquistati
		// quantita->Lista di Quantità di ogni Prodotto Acquistato
		
		//simulazione di acquisto prodotti
		prodotti1.add(p1);
		quantita1.add(5);
		prodotti1.add(p2);
		quantita1.add(3);
		prodotti1.add(p3);
		quantita1.add(5);
		ArrayList<Prodotto> prodotti2 = new ArrayList<Prodotto>();
		ArrayList<Integer> quantita2 = new ArrayList<Integer>();
		prodotti2.add(p1);
		quantita2.add(7);
		prodotti2.add(p2);
		quantita2.add(1);
		prodotti2.add(p3);
		quantita2.add(3);

		//sconti
		Sconto sconto1 = new Sconto("RED DISCOUNT", 66, Main.dateOf("13/12/2021"));
		Sconto sconto2 = new Sconto("FIRST DISCOUNT", 33, Main.dateOf("13/12/2021"));
		Sconto sconto3 = new Sconto("80DAYS80DISCOUNT", 80, Main.dateOf("13/12/2022"));
		
		gestoreCliente.inserisciSconto(c1,sconto3);
		
		gestoreCliente.registraSpesa(lista_spese,new Spesa(Main.dateOf("13/12/2019"), prodotti1, quantita1, c1));
		gestoreCliente.registraSpesa(lista_spese,new Spesa(Main.dateOf("23/8/2020"), prodotti1, quantita1, c2));
		gestoreCliente.registraSpesa(lista_spese,new Spesa(Main.dateOf("28/3/2020"), prodotti2, quantita2, c3));
		gestoreCliente.registraSpesa(lista_spese,new Spesa(Main.dateOf("23/1/2020"), prodotti2, quantita2, c1));
		gestoreCliente.registraSpesa(lista_spese,new Spesa(Main.dateOf("13/12/2018"), prodotti1, quantita1, c1));
		
		gestoreCliente.inserisciSconto(c1,sconto1);
		
		gestoreCliente.registraSpesa(lista_spese,new Spesa(now, prodotti2, quantita2, c1, sconto1));
		
		//si tenta di utilizzare uno sconto che il cliente non possiede. Non viene applicato nessuno sconto.
		gestoreCliente.registraSpesa(lista_spese,new Spesa(now, prodotti2, quantita2, c2, sconto2));
		
		Report actual = gestoreReport.generaReport(Spesa.N, lista_clienti, lista_spese);
		
		r.addRecord(0, 4, 200.278F);
		r.addRecord(1, 2, 117.2F);
		//gestoreReport.visualizzaReport(r);
		//gestoreReport.visualizzaReport(actual);
		assertEquals(r.toString(), actual.toString());
	}
	
	// TestCaseID:8.2
		@Test
		public void testNPositivoListaClienteNonVuotaListaSpeseNonVuotaNSpesePositivoNSpesaTotalePositivaScontoScaduto()
				throws NegativePriceException {
			
			Spesa.N=2;
			
			Cliente c1 = new Cliente("Valerio", "test123", "+39 3614511238", "4104 4319 3141 6969");
			Cliente c2 = new Cliente("Gennaro", "asd1", "+39 36153143238", "4104 4319 3331 1149");
			Cliente c3 = new Cliente("Raffaello", "asd2", "+39 5437355134", "4311 3444 5111 2311");

			gestoreCliente.registraCliente(lista_clienti,c1);
			gestoreCliente.registraCliente(lista_clienti,c2);
			gestoreCliente.registraCliente(lista_clienti,c3);

			Date now = Calendar.getInstance().getTime();

			Prodotto p1=null;
			Prodotto p2=null;
			Prodotto p3=null;
			
			try {
				p1 = new Prodotto("Detersivo", "Detersivo per lavastoviglie", 5.1F, 100);
				p2 = new Prodotto("Balsamo", "Balsamo per barba", 10, 70);
				p3 = new Prodotto("Asciugamano", "Asciugamano bianco", 2, 50);
			} catch (NegativePriceException e) {
				e.printStackTrace();
			}
			

			// prodotti->Lista di Prodotti Acquistati
			// quantita->Lista di Quantità di ogni Prodotto Acquistato
			
			//simulazione di acquisto prodotti
			prodotti1.add(p1);
			quantita1.add(5);
			prodotti1.add(p2);
			quantita1.add(3);
			prodotti1.add(p3);
			quantita1.add(5);
			
			//array aggiuntivi per simulare una spesa contenente altri prodotti e altre quantità
			ArrayList<Prodotto> prodotti2 = new ArrayList<Prodotto>();
			ArrayList<Integer> quantita2 = new ArrayList<Integer>();
			prodotti2.add(p1);
			quantita2.add(7);
			prodotti2.add(p2);
			quantita2.add(1);
			prodotti2.add(p3);
			quantita2.add(3);

			//sconti
			Sconto sconto1 = new Sconto("RED DISCOUNT", 66, Main.dateOf("13/12/2019"));
			Sconto sconto2 = new Sconto("80DAYS80DISCOUNT", 33, Main.dateOf("13/12/2021"));
			
			gestoreCliente.registraSpesa(lista_spese,new Spesa(Main.dateOf("13/12/2019"), prodotti1, quantita1, c1));
			gestoreCliente.registraSpesa(lista_spese,new Spesa(Main.dateOf("23/8/2020"), prodotti1, quantita1, c2));
			gestoreCliente.registraSpesa(lista_spese,new Spesa(Main.dateOf("28/3/2020"), prodotti2, quantita2, c3));
			gestoreCliente.registraSpesa(lista_spese,new Spesa(Main.dateOf("23/1/2020"), prodotti2, quantita2, c1));
			gestoreCliente.registraSpesa(lista_spese,new Spesa(Main.dateOf("13/12/2018"), prodotti1, quantita1, c1));
			
			gestoreCliente.inserisciSconto(c1,sconto1);
			
			gestoreCliente.registraSpesa(lista_spese,new Spesa(now, prodotti2, quantita2, c1, sconto1));
			
			//si tenta di utilizzare uno sconto che il cliente non possiede. Non viene applicato nessuno sconto.
			gestoreCliente.registraSpesa(lista_spese,new Spesa(now, prodotti2, quantita2, c2, sconto2));
			
			Report actual = gestoreReport.generaReport(Spesa.N, lista_clienti, lista_spese);
			
			r.addRecord(0, 4, 234.4F);
			r.addRecord(1, 2, 117.2F);
			//gestoreReport.visualizzaReport(r);
			//gestoreReport.visualizzaReport(actual);
			assertEquals(r.toString(), actual.toString());
		}
	

}
