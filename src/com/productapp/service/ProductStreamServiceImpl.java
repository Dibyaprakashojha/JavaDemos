package com.productapp.service;

import java.util.*;
import java.util.stream.Collectors;

import com.productapp.exceptions.IdNotFoundException;
import com.productapp.exceptions.ProductNotFoundException;
import com.productapp.model.Product;

public class ProductStreamServiceImpl implements IProductService {

	@Override
	public List<Product> getAll() {
		return showProducts();
	}

	@Override
	public Product getById(int productId) throws IdNotFoundException{
		return showProducts()
				.stream()
				.filter(product->product.getProductId()==productId)
				.findAny()
				.orElseThrow(()->new IdNotFoundException("Invalid Id"));
	}

	@Override
	public List<Product> getByCategory(String category) throws ProductNotFoundException {
		List<Product> productCategory = showProducts()
				.stream()
				.filter(product->product.getCategory().equalsIgnoreCase(category))
				.sorted((product1,product2)->product1.getName().compareTo(product2.getName()))
				.collect(Collectors.toList());
		if(productCategory.isEmpty())
			throw new ProductNotFoundException();
		return productCategory;
	}

	@Override
	public List<Product> getByBrand(String brand) throws ProductNotFoundException{
		List<Product> productBrand = showProducts()
				.stream()
				.filter(product->product.getBrand().equalsIgnoreCase(brand))
				.sorted((product1,product2)->product1.getName().compareTo(product2.getName()))
				.collect(Collectors.toList());
		if(productBrand.isEmpty())
			throw new ProductNotFoundException();
		return productBrand;
	}

	List<Product> showProducts() {
		return Arrays.asList(new Product("Mobiles", "Apple", 20000, "Electronics", 10),
				new Product("Mobiles", "Asus", 15000, "Electronics", 20),
				new Product("Laptop", "Asus", 55000, "Electronics", 30),
				new Product("Laptop", "Samsung", 15000, "Electronics", 40),
				new Product("Mobiles", "Realme", 18000, "Electronics", 50),
				new Product("Mobiles", "Realme", 15000, "Electronics", 60),
				new Product("Fans", "Usha", 1500, "Electronics", 70),
				new Product("Light", "Usha", 900, "Electronics", 80),
				new Product("Mobiles", "Apple", 70000, "Electronics", 90),
				new Product("Mobiles", "Samsung", 15000, "Electronics", 100),
				new Product("Mobiles", "Asus", 35000, "Electronics",110));

	}

}
