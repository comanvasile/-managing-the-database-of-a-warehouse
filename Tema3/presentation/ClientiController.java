package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import bll.ClientBLL;
import model.Client;

public class ClientiController implements ActionListener {
		private ClientiView view;
		public ClientiController(ClientiView view)
		{
			this.view=view;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			Object source=e.getSource();
			view.getTable().setVisible(false);
			ClientBLL cb=new ClientBLL();
			if(source==view.getB1())
			{
				try {
				view.getTable().setVisible(false);
				cb.insertClient(new Client(view.getTf1().getText(),view.getTf2().getText(),view.getTf3().getText()));
				}
				catch(Exception ex)
				{
				 JOptionPane.showMessageDialog(view, "Email invalid");	
				}
			}
			
		
			if(source==view.getB2())
			{
				view.getTable().setVisible(false);
				cb.deleteClient(new Integer(view.getTf4().getText()));
			}
			if(source==view.getB3())
			{
				try {
				view.getTable().setVisible(false);
				Client c=cb.findClientById(new Integer(view.getTf5().getText()));
				c.setNume(view.getTf1().getText());
				c.setEmail(view.getTf2().getText());
				c.setAdresa(view.getTf3().getText());
				cb.updateClient(c,new Integer(view.getTf5().getText()));
				}
				catch(Exception ex)
				{
				 JOptionPane.showMessageDialog(view, "Email invalid");	
				}
				
			}
			if(source==view.getB4());
			{ 	
				List<Object> o=new ArrayList<Object>();
				o.addAll(cb.findAllFromClient());
				view.getTable().setModel(new TableConstruct<Client>(o));
				view.getTable().setVisible(true);
			}
			if(source==view.getB5())
			{
				Client c=cb.findClientById(new Integer(view.getTf6().getText()));
				List<Object> l=new ArrayList<Object>();
				l.add(c);
				
				view.getTable().setModel(new TableConstruct<Client>(l));
				view.getTable().setVisible(true);
			}
		}

}
