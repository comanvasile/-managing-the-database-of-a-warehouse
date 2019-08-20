package presentation;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import bll.ClientBLL;
import bll.ProdusBLL;
import model.Client;
import model.Produs;

import javax.swing.*;

public class ComenziView extends JFrame {
	private static final long serialVersionUID=1L;
	private JPanel panel=new JPanel(new GridBagLayout());
	GridBagConstraints c=new GridBagConstraints();
	public JButton getB1() {
		return b1;
	}
	public JButton getB2() {
		return b2;
	}
	public JButton getB3() {
		return b3;
	}
	
	private ComenziController controller=new ComenziController(this);
	private JButton b1=new JButton("Adauga Comanda");
	
	private JButton b3=new JButton("Vezi Comenzi");
	private JButton b2=new JButton("Vezi dupa id");
	private JComboBox<String> cb1=new JComboBox<String>();
	private JComboBox<String> cb2=new JComboBox<String>();
	private JLabel l1=new JLabel("Client");
	private JLabel l2=new JLabel("Produs");
	private JLabel l3=new JLabel("Cantitate");
	private JTextField tf1=new JTextField(10);
	private JTextField tf2=new JTextField(5);
	private JLabel l4=new JLabel("Id cauta");
	public JTable getTable() {
		return table;
	}
	private JTable table=new JTable();
	public JComboBox<String> getCb1() {
		return cb1;
	}
	public JComboBox<String> getCb2() {
		return cb2;
	}
	public JTextField getTf1() {
		return tf1;
	}
	public ComenziView(String name)
	{
		
	
		super(name);
		ClientBLL cb=new ClientBLL();
		for(Client c: cb.findAllFromClient())
		{
			cb1.addItem(c.getNume());
		}
		ProdusBLL pb=new ProdusBLL();
		for(Produs p: pb.findAllFromProdus())
		{
			cb2.addItem(p.getNume());
		}
		c.gridx=0;
		c.gridy=0;
		panel.add(l1,c);
		c.gridx=1;
		c.gridy=0;
		panel.add(cb1,c);
		c.gridx=0;
		c.gridy=1;
		panel.add(l2,c);
		c.gridx=1;
		c.gridy=1;
		panel.add(cb2,c);
		c.gridx=0;
		c.gridy=2;
		panel.add(l3,c);
		c.gridx=1;
		c.gridy=2;
		panel.add(tf1,c);
		c.gridx=2;
		c.gridy=0;
		b1.addActionListener(controller);
		panel.add(b1,c);
		c.gridx=3;
		c.gridy=0;
		b2.addActionListener(controller);
		panel.add(b2,c);
		c.gridx=4;
		c.gridy=0;
		b3.addActionListener(controller);
		panel.add(b3,c);

		
		c.gridx=5;
		c.gridy=3;
		
		JScrollPane p=new JScrollPane(table);
		panel.add(p,c);
		
		c.gridx=3;
		c.gridy=1;
		panel.add(l4,c);
		c.gridx=3;
		c.gridy=2;
		panel.add(tf2,c);
		
		this.add(panel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);	
	}
	public JTextField getTf2() {
		return tf2;
	}

}
