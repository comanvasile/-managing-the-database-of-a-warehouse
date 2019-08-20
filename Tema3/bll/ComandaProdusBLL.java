package bll;


import java.util.List;
import java.util.NoSuchElementException;


import dao.ComandaProdusDAO;

import model.ComandaProdus;

public class ComandaProdusBLL {
private ComandaProdusDAO comandaProdusDAO;
	
	public ComandaProdusBLL()
	{
		comandaProdusDAO=new ComandaProdusDAO();
	}
	public ComandaProdus findComandaProdusById(int id)
	{
		ComandaProdus c=comandaProdusDAO.findById(id);
		if(c==null)
		{
			throw new NoSuchElementException("Comanda cu id =" + id + " nu a fost gasita");

		}
		return c;
	}
	
	
	public List<ComandaProdus> findAllFromComandaProdus()
	{
		List<ComandaProdus> c=comandaProdusDAO.findAll();
		return c;
	}
	public void insertComandaProdus(ComandaProdus comandaProdus) {
		
		 comandaProdusDAO.insert(comandaProdus);
	}
	public void updateComandaProdus(ComandaProdus comandaProdus,int id)
	{
		comandaProdusDAO.update(comandaProdus, id);
	}
	public void deleteComandaProdus(int id)
	{
		comandaProdusDAO.delete(id);
	}
}
