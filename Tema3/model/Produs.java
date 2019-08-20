package model;

public class Produs {
	private int id;
	private String nume;
	private int pret;
	public Produs()
	{
		
	}
	public Produs(int id,String nume,int pret)
	{
		this.id=id;
		this.nume=nume;
		this.pret=pret;
	}
	
	public int getPret() {
		return pret;
	}
	public void setPret(int pret) {
		this.pret = pret;
	}
	public Produs(String nume,int pret)
	{
		this.nume=nume;
		this.pret=pret;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	
	public String toString()
	{
		return "Produsul cu id="+id+" nume="+nume+" pret= "+pret+" ";
	}
}
