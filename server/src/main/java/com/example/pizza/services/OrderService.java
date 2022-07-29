package com.example.pizza.services;

import com.example.pizza.dto.OrderDto;
import com.example.pizza.entities.Order;
import com.example.pizza.repositories.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class OrderService {
    private OrderRepository orderRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Optional<OrderDto> createOrder(OrderDto orderDto) {
        String currentDateTime = LocalDateTime.now().toString();
        orderDto.setOrderedDateTime(currentDateTime);
        Order result = toEntity(orderDto);
        result = orderRepository.save(result);
        OrderDto newOrder = toModel(result);
        return Optional.of(newOrder);
    }

    public Optional<OrderDto> getOrderById(Long orderId) {
        Optional<Order> result = orderRepository.findById(orderId);
        if (result.isPresent()) {
            OrderDto orderDto = toModel(result.get());
            return Optional.of(orderDto);
        } else {
            return Optional.empty();
        }
    }

    private Order toEntity(OrderDto request) {
        Order requestEntity = modelMapper.map(request, Order.class);
        return requestEntity;
    }

    private OrderDto toModel(Order requestEntity) {
        OrderDto request = modelMapper.map(requestEntity, OrderDto.class);
        return request;
    }
}
