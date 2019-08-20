package bll;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import bll.validators.StocCantitateValidator;
import bll.validators.Validator;
import dao.StocDAO;

import model.Stoc;

public class StocBLL {
	private List<Validator<Stoc>> validators;
	private StocDAO stocDAO;
	
	public StocBLL()
	{
		validators=new ArrayList<Validator<Stoc>>();
		validators.add(new StocCantitateValidator());
		stocDAO=new StocDAO();
	}
	public Stoc findStocById(int id)
	{
		Stoc s=stocDAO.findById(id);
		if(s==null)
		{
			throw new NoSuchElementException("Stocul cu id =" + id + " nu a fost gasit!");
		}
		return s;
	}
	public List<Stoc> findAllFromStoc()
	{
		List<Stoc> s=stocDAO.findAll();
		return s;
	}
	public void insertStoc(Stoc stoc) {
		for (Validator<Stoc> v : validators) {
			v.validate(stoc);
		}
		stocDAO.insert(stoc);
	}
	public void updateStoc(Stoc stoc,int id)
	{
		for (Validator<Stoc> v : validators) {
			v.validate(stoc);
		}
		stocDAO.update(stoc, id);
	}
	public void deleteStoc(int id)
	{
		stocDAO.delete(id);
	}

}
