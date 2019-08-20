package presentation;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.*;

public class ProduseView extends JFrame {
	private static final long serialVersionUID=1L;
	private JPanel panel=new JPanel(new GridBagLayout());
	GridBagConstraints c=new GridBagConstraints();
	private ProduseController controller=new ProduseController(this);
	private JLabel l1=new JLabel("Nume Produs");
	private JLabel l2=new JLabel("Pret");
	private JLabel l3=new JLabel("Cantitate");
	private JTextField tf1=new JTextField(10);
	private JTextField tf2=new JTextField(10);
	private JTextField tf3=new JTextField(10);
	private JButton b1=new JButton("Adauga");
	private JButton b2=new JButton("Sterge");
	private JButton b3=new JButton("Modifica");
	private JButton b4=new JButton("Vezi tot");
	private JButton b5=new JButton("Vezi dupa id");
	private JTable table=new JTable();
	private JTextField tf4=new JTextField(5);
	private JTextField tf5=new JTextField(5);
	private JTextField tf6=new JTextField(5);
	private JLabel l4=new JLabel("Id sterge");
	private JLabel l5=new JLabel("Id update");
	private JLabel l6=new JLabel("Id cauta");
	private JTable table2=new JTable();
	public JTextField getTf1() {
		return tf1;
	}
	public JTextField getTf2() {
		return tf2;
	}
	public JTextField getTf3() {
		return tf3;
	}
	public JButton getB1() {
		return b1;
	}
	public JButton getB2() {
		return b2;
	}
	public JButton getB3() {
		return b3;
	}
	public JButton getB4() {
		return b4;
	}
	public JButton getB5() {
		return b5;
	}
	public JTable getTable() {
		return table;
	}
	public JTextField getTf4() {
		return tf4;
	}
	public JTextField getTf5() {
		return tf5;
	}
	public JTextField getTf6() {
		return tf6;
	}
	public ProduseView(String name)
	{
		super(name);
		
		
		c.gridx=2;
		c.gridy=0;
		panel.add(b1,c);
		b1.addActionListener(controller);
		c.gridx=3;
		c.gridy=0;
		panel.add(b2,c);
		b2.addActionListener(controller);
		c.gridx=4;
		c.gridy=0;
		panel.add(b3,c);
		b3.addActionListener(controller);
		c.gridx=5;
		c.gridy=0;
		panel.add(b4,c);
		b4.addActionListener(controller);
		c.gridx=6;
		c.gridy=0;
		panel.add(b5,c);
		b5.addActionListener(controller);
		c.gridx=1;
		c.gridy=0;
		panel.add(l1,c);
		c.gridx=1;
		c.gridy=2;
		panel.add(l2,c);
		c.gridx=1;
		c.gridy=4;
		panel.add(l3,c);
		c.gridx=1;
		c.gridy=1;
		panel.add(tf1,c);
		c.gridx=1;
		c.gridy=3;
		panel.add(tf2,c);
		c.gridx=1;
		c.gridy=5;
		panel.add(tf3,c);
		c.gridx=0;
		c.gridy=6;
		
		JScrollPane p=new JScrollPane(table);
		panel.add(p,c);
		
		c.gridx=1;
		c.gridy=6;
		JScrollPane p2=new JScrollPane(table2);
		panel.add(p2,c);
		
		
		c.gridx=3;
		c.gridy=1;
		panel.add(l4,c);
		c.gridx=3;
		c.gridy=2;
		panel.add(tf4,c);
		
		c.gridx=4;
		c.gridy=1;
		panel.add(l5,c);
		c.gridx=4;
		c.gridy=2;
		panel.add(tf5,c);
		
		c.gridx=6;
		c.gridy=1;
		panel.add(l6,c);
		c.gridx=6;
		c.gridy=2;
		panel.add(tf6,c);
		this.add(panel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);	
	}
	public JTable getTable2() {
		return table2;
	}
}
