package com.mafurag.clients.resources;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mafurag.clients.model.Order;
import com.mafurag.clients.resources.beans.OrderFilterBean;
import com.mafurag.clients.service.OrderService;

@Path("/orders")
public class OrderResource {
	
	OrderService os = new OrderService();

	/**
	 * 
	 * @param year
	 * @param start
	 * @param size
	 * @return list of orders
	 */
	@GET	
	@Produces(MediaType.APPLICATION_JSON)
	public List<Order> getOrders(@BeanParam OrderFilterBean filterBean){	
		//ObjectMapper mapper = new ObjectMapper();
		if (filterBean.getYear() > 0) return os.getOrdersForYear(filterBean.getYear());
		if (filterBean.getStart() > 0 && filterBean.getSize() > 0) return os.getAllOrdersPaginated(filterBean.getStart(), filterBean.getSize());
		
		return os.getAllOrders();
	}

}
