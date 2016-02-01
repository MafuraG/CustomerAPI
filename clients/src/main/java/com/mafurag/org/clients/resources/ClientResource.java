package com.mafurag.org.clients.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mafurag.org.clients.model.Client;
import com.mafurag.org.clients.service.ClientService;

@Path("/clients")
public class ClientResource {
	
	ClientService cs= new ClientService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Client> getClients(){		
		return cs.getAllClients();
	}
	
	@GET
	@Path("/{clientId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Client getClient(@PathParam("clientId") Long clientId){
		return cs.getClient(clientId);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Client addClient(Client client){
		return cs.addClient(client);
	}
	
	@PUT
	@Path("/{clientId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public  Client updateClient(@PathParam("clientId") Long clientId, Client client){
		client.setId(clientId);
		return cs.updateClient(client);
	}
	
	@DELETE
	@Path("/{clientId}")
	@Produces(MediaType.APPLICATION_JSON)
	public  String deleteClient(@PathParam("clientId") Long clientId){		
		cs.removeClient(clientId);
		return "Deleted client id = " + clientId;
	}

}
