package bll;

import model.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import dao.ClientDAO;
import bll.validators.*;

public class ClientBLL {
	private List<Validator<Client>> validators;
	private ClientDAO clientDAO;
	
	public ClientBLL()
	{
		validators=new ArrayList<Validator<Client>>();
		validators.add(new EmailValidator());
		clientDAO=new ClientDAO();
		
	}
	public Client findClientById(int id)
	{
		Client c=clientDAO.findById(id);
		if(c==null)
		{
			throw new NoSuchElementException("The client with id =" + id + " was not found!");
		}
		return c;
	}
	public List<Client> findAllFromClient()
	{
		List<Client> c=clientDAO.findAll();
		return c;
		
	}
	public void insertClient(Client client) {
		for (Validator<Client> v : validators) {
			v.validate(client);
		}
		clientDAO.insert(client);
	}
	public void updateClient(Client client,int id)
	{
		for (Validator<Client> v : validators) {
			v.validate(client);
		}
		clientDAO.update(client, id);
	}
	public void deleteClient(int id)
	{
		clientDAO.delete(id);
	}
	public Client findClientByName(String nume)
	{
		Client c=clientDAO.findByName(nume);
		if(c==null)
		{
			throw new NoSuchElementException("The client with nume =" + nume + " was not found!");
		}
		return c;
	}
	
}
