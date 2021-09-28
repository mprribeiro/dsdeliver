package com.mprribeiro.dsdeliver.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mprribeiro.dsdeliver.dto.ProductDTO;
import com.mprribeiro.dsdeliver.repositories.ProductRepository;
import com.mprribeiro.dsdeliver.services.exceptions.ResourceNotFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	@Transactional(readOnly = true)
	public List<ProductDTO> findAll() {
		var products = repository.findAllByOrderByNameAsc();
		return products.stream().map(product -> new ProductDTO(product)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public ProductDTO findById(Long id) {
		var product = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entity not found for id " + id));
		return new ProductDTO(product);
	}
}
