package bll;

import java.util.List;
import java.util.NoSuchElementException;


import dao.ComandaDAO;

import model.Comanda;

public class ComandaBLL {

	private ComandaDAO comandaDAO;
	
	public ComandaBLL()
	{
		comandaDAO=new ComandaDAO();
	}
	
	public Comanda findComandaById(int id)
	{
		Comanda c=comandaDAO.findById(id);
		if(c==null)
		{
			throw new NoSuchElementException("Comanda cu id =" + id + " nu a fost gasita");

		}
		return c;
	}
	
	public List<Comanda> findAllFromComanda()
	{
		List<Comanda> c=comandaDAO.findAll();
		return c;
	}
	public void insertComanda(Comanda comanda) {
		
		 comandaDAO.insert(comanda);
	}
	public void updateComanda(Comanda comanda,int id)
	{
		comandaDAO.update(comanda, id);
	}
	public void deleteComanda(int id)
	{
		comandaDAO.delete(id);
	}

	
}
