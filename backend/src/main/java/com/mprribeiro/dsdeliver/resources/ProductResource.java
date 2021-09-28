package com.mprribeiro.dsdeliver.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mprribeiro.dsdeliver.dto.ProductDTO;
import com.mprribeiro.dsdeliver.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

	@Autowired
	private ProductService service;
	
	@GetMapping
	public ResponseEntity<List<ProductDTO>> findAll() {
		var productsDTO = service.findAll();
		return ResponseEntity.ok(productsDTO);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ProductDTO> findAll(@PathVariable Long id) {
		var productDTO = service.findById(id);
		return ResponseEntity.ok(productDTO);
	}
}
