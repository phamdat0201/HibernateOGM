package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product {	
	
	@Id
//	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	@Column(name = "product_name", nullable = false)
	private String name;
	@Column(name = "model_year")
	private int modelYear;
	@Column(name = "list_price")
	private double price;
	
	@ManyToOne
	@JoinColumn(name="brand_id")
	private Brand brand;
	
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;
	
	public Product() {
	}

	public Product(String name, int modelYear, double price) {
		super();
		this.name = name;
		this.modelYear = modelYear;
		this.price = price;
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

	public int getModelYear() {
		return modelYear;
	}

	public void setModelYear(int modelYear) {
		this.modelYear = modelYear;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", modelYear=" + modelYear + ", price=" + price + "]";
	}
}
