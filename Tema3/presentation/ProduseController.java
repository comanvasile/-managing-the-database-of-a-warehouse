package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import bll.ProdusBLL;
import bll.StocBLL;
import model.Produs;
import model.Stoc;

public class ProduseController implements ActionListener {
	private ProduseView view;
	public ProduseController(ProduseView view)
	{
		this.view=view;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source=e.getSource();
		ProdusBLL pb=new ProdusBLL();
		StocBLL sb=new StocBLL();
		view.getTable().setVisible(false);
		view.getTable2().setVisible(false);
		if(source==view.getB1())
		{
			try {
			view.getTable2().setVisible(false);
			view.getTable().setVisible(false);	
			pb.insertProdus(new Produs(view.getTf1().getText(),new Integer(view.getTf2().getText())));
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(view, "Pret negativ");
			}
			try {
			int size=pb.findAllFromProdus().size();
			int id=pb.findAllFromProdus().get(size-1).getId();
			sb.insertStoc(new Stoc(id,new Integer(view.getTf3().getText())));
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(view,"Cantitate negativ");
			}
			
		}
		if(source==view.getB2())
		{
			view.getTable2().setVisible(false);
			view.getTable().setVisible(false);
			pb.deleteProdus(new Integer(view.getTf4().getText()));
			sb.deleteStoc(new Integer(view.getTf4().getText()));
		}
		if(source==view.getB3())
		{
			view.getTable2().setVisible(false);
			view.getTable().setVisible(false);
			Produs p=pb.findProdusById(new Integer(view.getTf5().getText()));
			p.setNume(view.getTf1().getText());
			p.setPret(new Integer(view.getTf2().getText()));
			Stoc s=sb.findStocById(new Integer(view.getTf5().getText()));
			s.setCantitate(new Integer(view.getTf3().getText()));
			try {
			pb.updateProdus(p, new Integer(view.getTf5().getText()));
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(view, "Pret negativ");
			}
			try {
			sb.updateStoc(s,new Integer(view.getTf5().getText()));
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(view,"Cantitate negativ");
			}
			
		}
		if(source==view.getB4())
		{
			List<Object> o= new ArrayList<Object>();
			o.addAll(pb.findAllFromProdus());
			view.getTable().setModel(new TableConstruct<Produs>(o));
			List<Object> o2=new ArrayList<Object>();
			o2.addAll(sb.findAllFromStoc());
			view.getTable2().setModel(new TableConstruct<Stoc>(o2));
			
			view.getTable().setVisible(true);
			view.getTable2().setVisible(true);
			
		}
		if(source==view.getB5())
		{
			List<Object> o=new ArrayList<Object>();
			o.add(pb.findProdusById(new Integer(view.getTf6().getText())));
			view.getTable().setModel(new TableConstruct<Produs>(o));
			List<Object> o2=new ArrayList<Object>();
			o2.add(sb.findStocById(new Integer(view.getTf6().getText())));
			view.getTable2().setModel(new TableConstruct<Stoc>(o2));
			
			view.getTable().setVisible(true);
			view.getTable2().setVisible(true);
			
		}
		
	}

}
