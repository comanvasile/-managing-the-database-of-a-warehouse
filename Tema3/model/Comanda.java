package model;


public class Comanda {
	private int id;
	//private Date data;
	private int pretTotal;
	private int idClient;
	
	public Comanda()
	{
		
	}
	public Comanda(int pretTotal,int idClient)
	{
	//	this.data=data;
		this.pretTotal=pretTotal;
		this.idClient=idClient;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
/*
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	*/

	public int getPretTotal() {
		return pretTotal;
	}

	public void setPretTotal(int pretTotal) {
		this.pretTotal = pretTotal;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

}
