package com.mafurag.clients.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.mafurag.clients.database.DatabaseClass;
import com.mafurag.clients.model.Client;
import com.mafurag.clients.model.Order;

public class OrderService {	
	
	private Map<Long, Order> orders = DatabaseClass.getOrders();
	private Map<Long, Client> clients = DatabaseClass.getClients();
	
	public List<Order> getOrders(Long clientId){
		 /*Map<Integer, String> monthsWithLengthFour = 
		            MONTHS.entrySet()
		            .stream()
		            .filter(p -> p.getValue().length() == 4)
		            .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));*/
		Map<Long, Order> ordersByClients = 
				orders.entrySet()
				.stream()
				.filter(p-> p.getValue().getClientId() == clientId)
				.collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue() ));
				
		return new ArrayList<Order>(ordersByClients.values());
	}
	
	public Order getOrder(Long id){
		return orders.get(id);
	}
	
	public Order addOrder(Order order){
		order.setId(orders.size());
		orders.put(order.getId(), order);
		return order;
	}
	
	public Order updateOrder(Order order){
		if (order.getId() <= 0){
			return null;
		}
		orders.put(order.getId(), order);
		return order;
	}
	
	public void removeOrder(Long orderId){
		clients.remove(orderId);
	}

}
