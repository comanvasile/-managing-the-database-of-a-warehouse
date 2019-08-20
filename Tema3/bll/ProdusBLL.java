package bll;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import bll.validators.ProdusPretValidator;
import bll.validators.Validator;
import dao.ProdusDAO;

import model.Produs;

public class ProdusBLL {
	private List<Validator<Produs>> validators;
	private ProdusDAO produsDAO;
	
	public ProdusBLL()
	{
		validators=new ArrayList<Validator<Produs>>();
		validators.add(new ProdusPretValidator());
		produsDAO=new ProdusDAO();
		
	}
	public Produs findProdusById(int id)
	{
		Produs p=produsDAO.findById(id);
		if(p==null)
		{
			throw new NoSuchElementException("Produsul cu id =" + id + " nu a fost gasit!");
		}
		return p;
	}
	
	public List<Produs> findAllFromProdus()
	{
		List<Produs> p=produsDAO.findAll();
		return p;
	}
	public void insertProdus(Produs produs) {
		for (Validator<Produs> v : validators) {
			v.validate(produs);
		}
		 produsDAO.insert(produs);
	}
	public void updateProdus(Produs produs,int id)
	{
		for (Validator<Produs> v : validators) {
			v.validate(produs);
		}
		produsDAO.update(produs, id);
	}
	public void deleteProdus(int id)
	{
		produsDAO.delete(id);
	}
	public Produs findProdusByName(String nume)
	{
		Produs p=produsDAO.findByName(nume);
		if(p==null)
			{
				throw new NoSuchElementException("Produsul cu nume =" + nume + " nu a fost gasit!");
			}
		return p;
	}
}
