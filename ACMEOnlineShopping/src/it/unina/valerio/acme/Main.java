package it.unina.valerio.acme;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import it.unina.valerio.acme.control.GestoreCliente;
import it.unina.valerio.acme.control.GestoreReport;
import it.unina.valerio.acme.entity.Cliente;
import it.unina.valerio.acme.entity.NegativePriceException;
import it.unina.valerio.acme.entity.Prodotto;
import it.unina.valerio.acme.entity.Sconto;
import it.unina.valerio.acme.entity.Spesa;

public class Main {

	public static void main(String[] args) {
		/*
		// istanza dei controller
		GestoreReport gestoreReport = new GestoreReport();
		GestoreCliente gestoreCliente = new GestoreCliente();
		
		ArrayList<Cliente> lista_clienti = new ArrayList<Cliente>();
		ArrayList<Spesa> lista_spese = new ArrayList<Spesa>();
		
		Cliente c1 = new Cliente("Valerio", "test123", "+39 3614511238", "4104 4319 3141 6969");
		Cliente c2 = new Cliente("Gennaro", "asd1", "+39 36153143238", "4104 4319 3331 1149");
		Cliente c3 = new Cliente("Raffaello", "asd2", "+39 5437355134", "4311 3444 5111 2311");

		// All'atto di registrazione dell'utente, viene richiamato registraCliente
		gestoreCliente.registraCliente(lista_clienti,c1);
		gestoreCliente.registraCliente(lista_clienti,c2);
		gestoreCliente.registraCliente(lista_clienti,c3);

		Date now = Calendar.getInstance().getTime();

		Prodotto p1=null;
		Prodotto p2=null;
		Prodotto p3=null;
		
		try {
			p1 = new Prodotto("Detersivo", "Detersivo per lavastoviglie", 5, 50);
			p2 = new Prodotto("Balsamo", "Balsamo per barba", 10, 70);
			p3 = new Prodotto("Asciugamano", "Asciugamano bianco", 2, 20);
		} catch (NegativePriceException e) {
			e.printStackTrace();
		}
		

		// prodotti->Lista di Prodotti Acquistati
		// quantita->Lista di Quantità di ogni Prodotto Acquistato
		ArrayList<Prodotto> prodotti1 = new ArrayList<Prodotto>();
		ArrayList<Integer> quantita1 = new ArrayList<Integer>();
		
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
		Sconto sconto1 = new Sconto("RED DISCOUNT", 66, dateOf("13/12/2021"));
		Sconto sconto2 = new Sconto("FIRST DISCOUNT", 33, dateOf("13/12/2021"));
		//Sconto sconto3 = new Sconto("80DAYS80DISCOUNT", 80, dateOf("13/12/2022"));
		
		gestoreCliente.registraSpesa(lista_spese,new Spesa(dateOf("13/12/2019"), prodotti1, quantita1, c1));
		gestoreCliente.registraSpesa(lista_spese,new Spesa(dateOf("23/8/2020"), prodotti1, quantita1, c2));
		gestoreCliente.registraSpesa(lista_spese,new Spesa(dateOf("28/3/2020"), prodotti2, quantita2, c3));
		gestoreCliente.registraSpesa(lista_spese,new Spesa(dateOf("23/1/2020"), prodotti2, quantita2, c1));
		gestoreCliente.registraSpesa(lista_spese,new Spesa(dateOf("13/12/2018"), prodotti1, quantita2, c1));
		
		gestoreCliente.inserisciSconto(c1,sconto1);
		
		gestoreCliente.registraSpesa(lista_spese,new Spesa(now, prodotti2, quantita2, c1, sconto1));
		gestoreCliente.registraSpesa(lista_spese,new Spesa(now, prodotti2, quantita2, c2, sconto2));

		gestoreReport.visualizzaReport(gestoreReport.generaReport(Spesa.N,lista_clienti,lista_spese));
		*/
	}
	
	public static Date dateOf(String toParseString)
	{
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		try {
			d = sdf.parse(toParseString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}
}
