package model;

public class Stoc {
	private int id;
	private int cantitate;
	public Stoc()
	{
		
	}
	public Stoc(int cantitate)
	{
		this.cantitate=cantitate;
	}
	public Stoc(int id,int cantitate)
	{
		this.id=id;
		this.cantitate=cantitate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCantitate() {
		return cantitate;
	}
	public void setCantitate(int cantitate) {
		this.cantitate = cantitate;
	}
	public String toString()
	{
		return "Stoc cu id="+ id+" cantitate= "+cantitate+" ";
	}
}
