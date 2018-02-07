package com.niit.DaoImpl;

import javax.persistence.criteria.Order;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Dao.OrderDao;
import com.niit.model.Orders;



@Repository("orderDao")
public class OrdersDaoImpl implements OrderDao

{

   @Autowired
   SessionFactory sessionFactory;
	
   
   public OrdersDaoImpl(SessionFactory sessionFactory)
   {
	   this.sessionFactory=sessionFactory;
	   
   }
   
   @Transactional
   public void insertOrder(Orders order)
   {
	   Session session =sessionFactory.openSession();
	   session.persist(order);
	   
	}


}


