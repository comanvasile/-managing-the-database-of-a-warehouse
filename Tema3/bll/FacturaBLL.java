package bll;



import java.util.List;
import java.util.NoSuchElementException;

import dao.FacturaDAO;
import model.Factura;




public class FacturaBLL {
	private FacturaDAO facturaDAO;
	public FacturaBLL()
	{
		facturaDAO=new FacturaDAO();
	}
	public List<Factura> findAllFromFactura()
	{
		List<Factura> p=facturaDAO.findAll();
		return p;
	}
	public void insertFactura(Factura f) {
	
		facturaDAO.insert(f);
	}
	public Factura findFacturaById(int id)
	{
		Factura f=facturaDAO.findById(id);
		if(f==null)
		{
			throw new NoSuchElementException("Factura cu id =" + id + " nu a fost gasit!");
		}
		return f;
	}
		
}
