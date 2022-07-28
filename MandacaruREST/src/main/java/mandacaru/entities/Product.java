package mandacaru.entities;

import jakarta.persistence.*;

@Entity(name = "products")
public class Product {
	@Id //representa chave primária
	@GeneratedValue //faz auto incremento
	@Column(name = "id") //define o nome da coluna e tem outras config
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "price", nullable = false)
	private double price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}

	public Product(int id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public Product() {
		super();
	}
}
