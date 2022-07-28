package mandacaru;

import java.util.List;

import mandacaru.dao.ProductDAO;
import mandacaru.dao.ProductHibernateDAO;
import mandacaru.entities.Product;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Product p1 = new Product(0, "caderno", 10);
		
		ProductDAO productDAO = new ProductHibernateDAO();
		productDAO.save(p1);
		
		Product aux = productDAO.find(1);
		System.out.println(aux);
		
		List<Product> list = productDAO.findAll();
		System.out.println(list);
		
//		productDAO.delete(3);
		
		list = productDAO.findAll();
		System.out.println(list);
		
		aux = productDAO.findByName("notebooka");
		System.out.println(aux);
		
		list = productDAO.findAllByName("notebook");
		System.out.println(list);
		
	}

}
