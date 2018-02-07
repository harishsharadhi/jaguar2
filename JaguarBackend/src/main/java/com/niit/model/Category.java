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
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="CategoryTable")
public class Category
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cid;
	private String cname;
	private String cfeaturesofmodel;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCfeaturesofmodel() {
		return cfeaturesofmodel;
	}
	public void setCfeaturesofmodel(String cfeaturesofmodel) {
		this.cfeaturesofmodel = cfeaturesofmodel;
	}
	
	
	
	@OneToMany(targetEntity=Product.class, fetch=FetchType.EAGER ,mappedBy="category")
	private Set<Product> product;
	public Set<Product> getProduct() {
		return product;
	}
	public void setProduct(Set<Product> product) {
		this.product = product;
	}

}