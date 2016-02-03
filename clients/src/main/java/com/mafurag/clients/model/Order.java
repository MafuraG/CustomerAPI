package com.mafurag.clients.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * 
 * @author MafuraG
 *
 */

@XmlRootElement
public class Order {
	
	private Long id;	
	private String details ; 
	private Long clientId;
	private Date date;
	
	public Order() {
		super();
	}
	public Order(Long id, String details, long clientId) {
		super();
		this.id = id;
		this.details = details;
		this.setClientId(clientId);
		this.date = new Date();
	}
	public Long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	public Long getClientId() {
		return clientId;
	}
	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

}
