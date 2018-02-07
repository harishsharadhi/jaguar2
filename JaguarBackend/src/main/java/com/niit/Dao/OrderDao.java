package com.niit.Dao;

import org.springframework.stereotype.Repository;

import com.niit.model.Orders;

@Repository("orderDao")
public interface OrderDao {
	
	public void insertOrder(Orders order);

}
