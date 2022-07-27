package mandacaru.dao;

import java.util.List;

import mandacaru.entities.Product;

public interface ProductDAO {

	public void save(Product entity); //INSERT

	public void delete(int id); //DELETE

	public Product find(int id);

	public List<Product> findAll();
	
	public Product findByName(String str);

	public List<Product> findAllByName(String str);
}
