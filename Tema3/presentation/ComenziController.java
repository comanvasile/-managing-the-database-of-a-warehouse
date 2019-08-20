package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import java.text.SimpleDateFormat;

import java.util.List;

import javax.swing.JOptionPane;

import java.util.ArrayList;
import java.util.Date;
import bll.ClientBLL;
import bll.ComandaBLL;
import bll.ComandaProdusBLL;
import bll.FacturaBLL;
import bll.ProdusBLL;
import bll.StocBLL;

import model.Comanda;
import model.ComandaProdus;
import model.Factura;
import model.Stoc;

public class ComenziController implements ActionListener {
	private ComenziView view;
	
	public ComenziController(ComenziView view)
	{
		this.view=view;
	}
	private void write(String txt,String name)
	{
		PrintWriter writer;
		try {
			writer = new PrintWriter(name+".txt", "UTF-8");
			writer.println(txt);
			writer.close();

		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source=e.getSource();
		ClientBLL cb=new ClientBLL();
		ProdusBLL pb=new ProdusBLL();
		int idClient=cb.findClientByName((String) view.getCb1().getSelectedItem()).getId();
		int idProdus=pb.findProdusByName((String)view.getCb2().getSelectedItem()).getId();
		ComandaBLL comb=new ComandaBLL();
		ComandaProdusBLL compb=new ComandaProdusBLL();
		StocBLL sb=new StocBLL();
		FacturaBLL fb=new FacturaBLL();
		view.getTable().setVisible(false);
		if(source==view.getB1())
		{
			view.getTable().setVisible(false);
			if((new Integer( view.getTf1().getText()))>sb.findStocById(idProdus).getCantitate())
			{
				JOptionPane.showMessageDialog(view, "Stoc indisponibil");
			}
			else
			{
			
				fb.insertFactura(new Factura((String)view.getCb1().getSelectedItem(),(String)view.getCb2().getSelectedItem(),new Integer(view.getTf1().getText()),pb.findProdusById(idProdus).getPret(),(new Integer(view.getTf1().getText()))*pb.findProdusById(idProdus).getPret()));
				SimpleDateFormat format=new SimpleDateFormat("MM/DD/YYYY");
				Date date = new Date();
				format.format(date);
				comb.insertComanda(new Comanda((new Integer(view.getTf1().getText()))*pb.findProdusById(idProdus).getPret(),idClient));
				int idComanda=0;
				for(Comanda c: comb.findAllFromComanda())
				{
					idComanda=c.getId();
				}
				compb.insertComandaProdus(new ComandaProdus(idComanda,idProdus,new Integer( view.getTf1().getText())));
				Stoc s=sb.findStocById(idProdus);
				s.setCantitate(s.getCantitate()-(new Integer( view.getTf1().getText())));
				sb.updateStoc(s,idProdus);
				Factura f=new Factura();
				for(Factura fac: fb.findAllFromFactura())
				{
					f=fac;
				}
				write(" Factura numarul "+ f.getId()+ " client: "+ f.getNumeClient()+" produs: "+f.getNumeProdus()+" pret produs: "+f.getPretProdus()+" cantitate comandata: "+f.getCantitateComandata()+" pret total "+f.getPretTotal()+" data: "+new Date(),"Factura "+f.getId());
			}
		}
		if(source==view.getB2())
		{
			view.getTable().setVisible(false);
			List<Object> o=new ArrayList<Object>();
			o.add(fb.findFacturaById(new Integer(view.getTf2().getText())));
			view.getTable().setModel(new TableConstruct<Factura>(o));
			view.getTable().setVisible(true);
			
		}
		if(source==view.getB3())
		{
			List<Object> o=new ArrayList<Object>();
			o.addAll(fb.findAllFromFactura());
			view.getTable().setModel(new TableConstruct<Factura>(o));
			view.getTable().setVisible(true);
		}
		
	}

}
