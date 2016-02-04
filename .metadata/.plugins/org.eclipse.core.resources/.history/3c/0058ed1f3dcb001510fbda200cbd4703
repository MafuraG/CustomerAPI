package com.mafurag.clients.resources;

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

import com.mafurag.clients.model.Order;
import com.mafurag.clients.service.OrderService;

public class ClientOrdersResource {
	
	OrderService os = new OrderService();

	
	
	/**
	 * Method gets list of orders by client
	 * @param clientId
	 * @return list of orders made by client
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Order> getOrders(@PathParam("clientId") Long clientId){	
		//ObjectMapper mapper = new ObjectMapper();
		return os.getOrders(clientId);
	}
	
	/**
	 * Method updates a client order
	 * @param clientId
	 * @param order
	 * @return
	 */
	@POST	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Order addOrder(@PathParam("clientId") Long clientId, Order order){		
		order.setClientId(clientId);
		return os.addOrder(order);
	}
	
	/**
	 * Get order by ID
	 * @param clientId
	 * @param orderId
	 * @return order 
	 */
	@GET
	@Path("/{orderId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Order getOrder(@PathParam("clientId") Long clientId, @PathParam("orderId") Long orderId){
		Order o = os.getOrder(orderId);
		if (o != null && o.getClientId() == clientId) return o;
		else
			return null; 
	}
	
	/**
	 * Method updates given order
	 * @param clientId
	 * @param orderId
	 * @param order
	 * @return updated order
	 */
	
	@PUT
	@Path("/{orderId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Order updateOrder(@PathParam("clientId") Long clientId, @PathParam("orderId") Long orderId, Order order){
		order.setClientId(clientId);
		order.setId(orderId);
		return os.updateOrder(order);
	}
	
	/**
	 * Method deletes given order
	 * @param clientId
	 * @param orderId
	 * @return message confirming deletion
	 */
	@DELETE
	@Path("/{orderId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteOrder(@PathParam("clientId") Long clientId, @PathParam("orderId") Long orderId){
		os.removeOrder(orderId);
		return "Deleted order id = " + orderId;
	}

}
