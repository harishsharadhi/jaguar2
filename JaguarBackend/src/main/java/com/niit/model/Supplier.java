package com.niit.model;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set; 

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Supplier
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int sid;
	
	private String sname;

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}
	


	@OneToMany(targetEntity=Product.class, fetch=FetchType.EAGER ,mappedBy="supplier")
	private Set<Product> product;

	public Set<Product> getProduct() {
		return product;
	}

	public void setProduct(Set<Product> product) {
		this.product = product;
	}
	 
}



