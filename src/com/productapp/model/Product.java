package com.productapp.model;

public class Product {
	private String name;
	private String brand;
	private double price;
	private String category;
	private Integer productId;
	
	
	public Product() {
		super();
	}

	public Product(String name, String brand, double price, String category, Integer productId) {
		super();
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.category = category;
		this.productId = productId;
		
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", brand=" + brand + ", price=" + price + ", category=" + category
				+ ", productId=" + productId + "]";
	}
	
	
	
}
