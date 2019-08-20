package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class MenuController implements ActionListener{
	private MenuView view;
	public MenuController(MenuView view)
	{
		this.view=view;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source=e.getSource();
		if(source==view.getB1())
		{
			JFrame frame=new ClientiView("Clienti");
		}
		if(source==view.getB2())
		{
			JFrame frame=new ProduseView("Produse");
		}
		if(source==view.getB3())
		{
			JFrame frame=new ComenziView("Comenzi");
		}
		
	}
	
	
}

