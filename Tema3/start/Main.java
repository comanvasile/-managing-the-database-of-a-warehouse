package start;



import java.sql.SQLException;
import java.util.logging.Logger;

import javax.swing.JFrame;




import presentation.MenuView;

public class Main {
	protected static final Logger LOGGER = Logger.getLogger(Main.class.getName());
	public static void main(String[] args) throws SQLException {
		JFrame frame=new MenuView("Baza de date");
		
	}
	
}
