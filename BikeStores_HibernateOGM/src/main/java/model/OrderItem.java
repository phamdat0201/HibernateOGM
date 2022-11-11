package model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class OrderItem {	
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	private int quantity;
	@Column(name="list_price")
	private double price;
	private double discount;
	@Column(name="line_total")
	private double lineTotal;
	
	public OrderItem() {
	}

	public OrderItem(Product product, int quantity, double price, double discount) {
		super();
		this.product = product;
		this.quantity = quantity;
		this.price = price;
		this.discount = discount;
		this.lineTotal = quantity * price * (1 - discount);
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getLineTotal() {
		return lineTotal;
	}

	public void setLineTotal(double lineTotal) {
		this.lineTotal = lineTotal;
	}

	@Override
	public String toString() {
		return "OrderItem [product_id=" + product.getId() + ", quantity=" + quantity + ", price=" + price + ", discount="
				+ discount + ", lineTotal=" + lineTotal + "]";
	}
	
	
	
}
