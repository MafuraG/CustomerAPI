package com.mafurag.clients.database;

import java.util.HashMap;
import java.util.Map;

import com.mafurag.clients.model.Client;
import com.mafurag.clients.model.Order;
/**
 * 
 * @author MafuraG
 *
 */
public class DatabaseClass {
	
	private static Map<Long,Client> clients = new HashMap<>();
	private static Map<Long,Order> orders = new HashMap<>();
	
	public static Map<Long, Client> getClients() {
		return clients;
	}
	public static Map<Long, Order> getOrders() {
		return orders;
	}
	
	public static void createMocks(){
		Client c;
		Order o;
		Long order_count = (long) 0;
		for(int i = 0; i < 10 ; i++){
			c = new Client((long)i,"First "+ i, "Middle " + i, "Last "+ i);
			clients.put((long)i, c);
			for (int j = 0 ; j < 10 ; j++){
				o = new Order(order_count,"Order from client " + i + ". Order number: " + order_count+".",c.getId());
				orders.put(order_count, o);
				order_count++;
			}
		}
	}

}
