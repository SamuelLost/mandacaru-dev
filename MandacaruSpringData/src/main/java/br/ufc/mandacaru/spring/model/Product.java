package br.ufc.mandacaru.spring.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Product {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private double price;

	@OneToMany (mappedBy = "product")
	private List<Feedback> feedbacks ;
	
	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

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
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", feedbacks=" + feedbacks + "]";
	}

	public Product(int id, String name, double price, List<Feedback> feedbacks) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.feedbacks = feedbacks;
	}

	public Product() {
		super();
	}

}
