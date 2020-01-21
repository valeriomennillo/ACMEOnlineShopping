package it.unina.valerio.acme.entity;

import java.util.ArrayList;


public class Report {
	//riferimento a ClientID piuttosto che Client 
	private ArrayList<Integer> clientID = new ArrayList<Integer>();
	private ArrayList<Integer> numSpese = new ArrayList<Integer>();
	private ArrayList<Float> costoTotale = new ArrayList<Float>();

	public void addRecord(int clientID, int numSpese, float costoTotale)
	{
		this.numSpese.add(numSpese);
		this.costoTotale.add(costoTotale);
		this.clientID.add(clientID);
	}
	
	@Override
	public String toString()
	{
		String out = new String("************REPORT************\n");
		if(clientID.size()==0)
		{
			out+="NO CLIENT HAS BEEN FOUND";
		}
		for(int i=0;i<clientID.size();i++)
		{
			//clientID.get(i)
			out+="CLIENT	     #"+i+"			NUM-SPESE	"+numSpese.get(i)+" 		COSTO-TOTALE	"+costoTotale.get(i)+"\n";
		}
		return out;
	}
}
