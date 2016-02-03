package com.mafurag.clients.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mafurag.clients.database.DatabaseClass;
import com.mafurag.clients.model.Client;

/**
 * 
 * @author MafuraG
 *
 */

public class ClientService {
	private Map<Long, Client> clients = DatabaseClass.getClients();	
	
	
	public ClientService() {		
	}	
	
	public void createMocks(){
		DatabaseClass.createMocks();
	}

	public List<Client> getAllClients(){		
		return new ArrayList<Client>(clients.values());		
	}
	
	public Client getClient(Long id){
		return clients.get(id);
	}
	
	public Client addClient(Client client){
		client.setId(clients.size());
		clients.put(client.getId(), client);
		return client;
	}
	
	public Client updateClient(Client client){
		if (client.getId() <= 0){
			return null;
		}
		clients.put(client.getId(), client);
		return client;
	}
	
	public void removeClient(Long clientId){
		clients.remove(clientId);
	}
	
	

}
