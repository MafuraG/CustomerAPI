package com.mafurag.clients.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.mafurag.clients.database.DatabaseClass;
import com.mafurag.clients.model.Client;
import com.mafurag.clients.model.ErrorMessage;
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
	
	public List<Order> getAllOrders(){
		return new ArrayList<Order>(orders.values());
	}
	
	public List<Order> getOrdersForYear(int year){
		List<Order> ordersByYear = new ArrayList<Order>();
		Calendar cal = Calendar.getInstance();
		for(Order order:orders.values()){
			cal.setTime(order.getDate());
			if (cal.get(Calendar.YEAR) == year){
				ordersByYear.add(order);
			}
		}
		return ordersByYear;
	}
	
	public List<Order> getAllOrdersPaginated(int start, int size){
		List<Order> list= getAllOrders();
		if (start + size > list.size()) return new ArrayList<Order>();
		return list.subList(start, start + size);
	}
	
	public Order getOrder(Long id){
		ErrorMessage errorMessage = new ErrorMessage("Not Found",404,"http://mysite.org");
		Response response = Response.status(Status.NOT_FOUND)
				.entity(errorMessage)
				.build();
		Order order = orders.get(id);
		
		if (order == null) 
			throw new WebApplicationException(response);
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
