package com.mprribeiro.dsdeliver.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mprribeiro.dsdeliver.constant.OrderStatus;
import com.mprribeiro.dsdeliver.dto.OrderDTO;
import com.mprribeiro.dsdeliver.dto.ProductDTO;
import com.mprribeiro.dsdeliver.entities.Order;
import com.mprribeiro.dsdeliver.entities.Product;
import com.mprribeiro.dsdeliver.repositories.OrderRepository;
import com.mprribeiro.dsdeliver.repositories.ProductRepository;
import com.mprribeiro.dsdeliver.repositories.UserRepository;
import com.mprribeiro.dsdeliver.services.exceptions.ResourceNotFoundException;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Transactional(readOnly = true)
	public List<OrderDTO> findAll() {
		var orders = repository.findOrdersWithProducts();
		return orders.stream().map(order -> new OrderDTO(order)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public OrderDTO findById(Long id) {
		var order = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entity not found for id " + id));
		return new OrderDTO(order);
	}

	@Transactional
	public OrderDTO insert(OrderDTO dto) {
		Order order = new Order();
		getOrderFromDTO(order, dto);
		order = repository.save(order);
		//emailService.sendEmail(order);
		return new OrderDTO(order);
	}
	
	@Transactional
	public OrderDTO setDelivered(Long id) {
		Order order = repository.getById(id);
		order.setStatus(OrderStatus.DELIVERED);
		order = repository.save(order);
		return new OrderDTO(order);
	}

	private void getOrderFromDTO(Order order, OrderDTO dto) {
		order.setAddress(dto.getAddress());
		order.setLatitude(dto.getLatitude());
		order.setLongitude(dto.getLongitude());
		order.setMoment(Instant.now());
		order.setStatus(OrderStatus.PENDING);
		
		//User client = userRepository.getById(dto.getClient().getId());
		//order.setClient(client);
		
		for (ProductDTO p : dto.getProducts()) {
			Product product = productRepository.getById(p.getId());
			order.getProducts().add(product);
		}
	}
}
