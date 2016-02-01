package com.mafurag.org.clients.database;

import java.util.HashMap;
import java.util.Map;

import com.mafurag.org.clients.model.Client;
import com.mafurag.org.clients.model.Order;

public class DatabaseClass {
	
	private static Map<Long,Client> clients = new HashMap<>();
	private static Map<Long,Order> orders = new HashMap<>();
	
	public static Map<Long, Client> getClients() {
		return clients;
	}
	public static Map<Long, Order> getOrders() {
		return orders;
	}

}
