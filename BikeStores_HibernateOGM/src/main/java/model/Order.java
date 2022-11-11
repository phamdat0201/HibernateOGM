package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order {	

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	@Column(name="order_status")
	private int orderStatus;	
	@Column(name="order_date")
	private Date orderDate;
	@Column(name="required_date")
	private Date requiredDate;
	@Column(name="shipped_date")
	private Date shippedDate;	
	@Column(name="order_total")
	private double orderTotal;

	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;

	@ManyToOne
	@JoinColumn(name="staff_id")
	private Staff staff;

	@ElementCollection
	@Column(name="order_items")
	private List<OrderItem> orderItems;

	public Order() {
		orderItems = new ArrayList<OrderItem>();
	}

	public Order(int orderStatus, Date orderDate, Date requiredDate, Date shippedDate) {
		super();
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
		this.requiredDate = requiredDate;
		this.shippedDate = shippedDate;
		this.orderItems = new ArrayList<OrderItem>();
		this.orderTotal = getOrderTotal(); //???
	}

	public void addOrderLine(Product product, int quantity, double price, double discount) {
		OrderItem orderItem = new OrderItem(product, quantity, price, discount);
		orderItems.add(orderItem);
	}

	public double getOrderTotal() {

		double total = 0.0;

		for(OrderItem od : orderItems) {
			total += od.getLineTotal();
		}

		return total;

		//		return orderDetails
		//				.stream()
		//				.mapToDouble(or -> or.getLineTotal())
		//				.sum();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getRequiredDate() {
		return requiredDate;
	}

	public void setRequiredDate(Date requiredDate) {
		this.requiredDate = requiredDate;
	}

	public Date getShippedDate() {
		return shippedDate;
	}

	public void setShippedDate(Date shippedDate) {
		this.shippedDate = shippedDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderStatus=" + orderStatus + ", orderDate=" + orderDate + ", requiredDate="
				+ requiredDate + ", shippedDate=" + shippedDate + ", orderTotal=" + orderTotal + ", orderItems="
				+ orderItems + "]";
	}


}
