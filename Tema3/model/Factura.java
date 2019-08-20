package model;

public class Factura {
	int id;
	String numeClient;
	String numeProdus;
	int cantitateComandata;
	int pretProdus;
	int pretTotal;
	public Factura()
	{
		
	}
	public Factura(String numeClient,String numeProdus,int cantitateComandata,int pretProdus,int pretTotal)
	{
		this.numeClient=numeClient;
		this.numeProdus=numeProdus;
		this.cantitateComandata=cantitateComandata;
		this.pretProdus=pretProdus;
		this.pretTotal=pretTotal;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumeClient() {
		return numeClient;
	}
	public void setNumeClient(String numeClient) {
		this.numeClient = numeClient;
	}
	public String getNumeProdus() {
		return numeProdus;
	}
	public void setNumeProdus(String numeProdus) {
		this.numeProdus = numeProdus;
	}
	public int getCantitateComandata() {
		return cantitateComandata;
	}
	public void setCantitateComandata(int cantitateComandata) {
		this.cantitateComandata = cantitateComandata;
	}
	public int getPretProdus() {
		return pretProdus;
	}
	public void setPretProdus(int pretProdus) {
		this.pretProdus = pretProdus;
	}
	public int getPretTotal() {
		return pretTotal;
	}
	public void setPretTotal(int pretTotal) {
		this.pretTotal = pretTotal;
	}
}
