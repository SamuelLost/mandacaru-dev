package mandacaru;

import java.util.List;

import mandacaru.dao.ProductDAO;
import mandacaru.dao.ProductJDBCDAO;
import mandacaru.entities.Product;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Product p1 = new Product(0, "notebook", 15);
		
		ProductDAO productDAO = new ProductJDBCDAO();
		productDAO.save(p1);
		
		Product aux = productDAO.find(4);
		System.out.println(aux);
		
		List<Product> list = productDAO.findAll();
		System.out.println(list);
		
//		productDAO.delete(3);
		
		list = productDAO.findAll();
		System.out.println(list);
		
		aux = productDAO.findByName("notebook");
		System.out.println(aux);
		
		list = productDAO.findAllByName("notebook");
		System.out.println(list);
		
	}

}
