package com.productapp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.productapp.exceptions.IdNotFoundException;
import com.productapp.exceptions.ProductNotFoundException;
import com.productapp.model.Product;

public class ProductServiceImpl implements IProductService{

	@Override
	public List<Product> getAll() {
		return showProducts();
	}

	@Override
	public Product getById(int productId) throws IdNotFoundException{
		List<Product> products = showProducts();
		for (Product product : products) {
			if(product.getProductId()==productId)
			return product;
		}
		throw new IdNotFoundException("Id Not Found");	
	}

	@Override
	public List<Product> getByCategory(String category) throws ProductNotFoundException{
		List<Product> products = showProducts();
		List<Product> productsByCategory = new ArrayList<Product>();
		for (Product product : products) {
			if(product.getCategory().equalsIgnoreCase(category))
			productsByCategory.add(product);
		}
		if(productsByCategory.isEmpty())
				throw new ProductNotFoundException("Product Not Found. Search Again!");
		return productsByCategory;
	}

	@Override
	public List<Product> getByBrand(String brand) throws ProductNotFoundException{
		List<Product> products = showProducts();
		List<Product> productsByBrand = new ArrayList<Product>();
		for (Product product : products) {
			if(product.getBrand().equalsIgnoreCase(brand))
			productsByBrand.add(product);
		}
		if(productsByBrand.isEmpty())
			throw new ProductNotFoundException("Product Not Found. Search Again!");
		return productsByBrand;
	}
	
	List<Product> showProducts(){
		
		return Arrays.asList(new Product("Mobiles", "Apple", 20000, "Electronics", 10),
				new Product("Mobiles", "Samsung", 15000, "Electronics", 20),
				new Product("Mobiles", "Asus", 18000, "Electronics", 30));
		
	}
}
