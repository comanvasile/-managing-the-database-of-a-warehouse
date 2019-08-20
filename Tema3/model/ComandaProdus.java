package model;

public class ComandaProdus {
	private int id;
	private int idComanda;
	private int idProdus;
	private int cantitateComandata;
	public ComandaProdus()
	{
		
	}
	public ComandaProdus(int idComanda,int idProdus,int cantitateComandata)
	{
		this.idComanda=idComanda;
		this.idProdus=idProdus;
		this.cantitateComandata=cantitateComandata;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdComanda() {
		return idComanda;
	}
	public void setIdComanda(int idComanda) {
		this.idComanda = idComanda;
	}
	public int getIdProdus() {
		return idProdus;
	}
	public void setIdProdus(int idProdus) {
		this.idProdus = idProdus;
	}
	public int getCantitateComandata() {
		return cantitateComandata;
	}
	public void setCantitateComandata(int cantitateComandata) {
		this.cantitateComandata = cantitateComandata;
	}
	
	
	
}
