package com.mafurag.clients.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * 
 * @author MafuraG
 *
 */

@XmlRootElement
public class Client {
	private  long id;
	private String firstname;
	private String middlename;
	private String lastname;
	private List<Link> links = new ArrayList<Link>();
	
	public Client(){
		
	}
	
	public Client(long id, String firstname, String middlename, String lastname) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getMiddlename() {
		return middlename;
	}
	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}
	
	public void addLink(String url, String rel){
		Link l = new Link(url,rel);
		links.add(l);
	}
}
