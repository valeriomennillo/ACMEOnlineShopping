package it.unina.valerio.acme.entity;

import java.util.Date;

public class Sconto {
	private int ID;
	private int percentuale;
	private Date dataScadenza;
	//private int IDCliente;
	public Sconto(int ID, int percentuale, Date dataScadenza)
	{
		this.ID=ID;
		this.percentuale=percentuale;
		this.dataScadenza=dataScadenza;
	//	this.IDCliente=c.getID();
	}
	
	//public int getIdCliente()
	//{
	//	return IDCliente;
	//}

	public int getPercentuale() {
		return percentuale;
	}
}
