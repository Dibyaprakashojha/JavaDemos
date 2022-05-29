package com.productapp.service;

import java.util.*;

import com.productapp.exceptions.IdNotFoundException;
import com.productapp.exceptions.ProductNotFoundException;
import com.productapp.model.Product;

public interface IProductService {
	List<Product> getAll();
	Product getById(int productId) throws IdNotFoundException;
	List<Product> getByCategory(String category) throws ProductNotFoundException;
	List<Product> getByBrand(String brand) throws ProductNotFoundException;
}
