package com.torre.model;

public class Invoice {
	private int id;
	private int pos;
	private int invoice;
	private String product;
	private int quantity;
	private float price;
	private String total;
	
	public Invoice(int id, int pos, int invoice, String product, int quantity, float price, String total) {
		super();
		this.id = id;
		this.pos = pos;
		this.invoice = invoice;
		this.product = product;
		this.quantity = quantity;
		this.price = price;
		this.total = total;
	}

	public Invoice() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getInvoice() {
		return invoice;
	}

	public void setInvoice(int invoice) {
		this.invoice = invoice;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}
	
	
}
