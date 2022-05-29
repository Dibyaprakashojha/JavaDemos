package com.productapp.main;

import java.util.*;

import com.productapp.exceptions.IdNotFoundException;
import com.productapp.exceptions.ProductNotFoundException;
import com.productapp.model.Product;
import com.productapp.service.IProductService;
import com.productapp.service.ProductServiceImpl;

public class ProductMain {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		IProductService productServiceImpl = new ProductServiceImpl();
		List<Product> productList = productServiceImpl.getAll();
		for (Product products : productList) {
			System.out.println(products + "\n");
		}
		System.out.println("Enter C for Category, B for Brand, I for Id");
		String choice = scn.next().toUpperCase();
		switch (choice) {
		case "C":
			System.out.println("Enter the category: ");
			String category = scn.next();
			try {
				List<Product> productByCategory;
				productByCategory = productServiceImpl.getByCategory(category);
				for (Product product : productByCategory)
					System.out.println(product + "\n");
				break;
			} catch (ProductNotFoundException e) {
				System.out.println(e.getMessage());
			}

		case "B":
			System.out.println("Enter the brand: ");
			String brand = scn.next();
			try {
				List<Product> productByBrand = productServiceImpl.getByBrand(brand);
				for (Product product : productByBrand)
					System.out.println(product + "\n");
				break;
			} catch (ProductNotFoundException e) {
				System.out.println(e.getMessage());
			}

		case "I":
			System.out.println("Enter the product id: ");
			int id = scn.nextInt();
			try {
				Product productById = productServiceImpl.getById(id);
				System.out.println(productById);
				break;
			} catch (IdNotFoundException e) {
				System.out.println(e.getMessage());
			}

		default:
			System.out.println("Invalid Choice");
			break;
		}

		scn.close();
	}

}
