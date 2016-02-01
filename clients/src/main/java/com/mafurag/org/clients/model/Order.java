package com.mafurag.org.clients.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Order {
	
	private Long id;	
	private String details ; 
	private Client client;
	
	
	public Order(Long id, String details, Client client) {
		super();
		this.id = id;
		this.details = details;
		this.client = client;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}

}
