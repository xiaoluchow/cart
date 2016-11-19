package com.xiaolu.order.service.impl;

import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;

import com.xiaolu.cart.service.CartService;
import com.xiaolu.order.bean.OrderBean;
import com.xiaolu.order.dao.OrderDao;
import com.xiaolu.order.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private CartService cartService;
	
	@Autowired
	private OrderDao orderDao;
	
	private BeanFactory beanFactory;
	
	@Override
	public void createOrder() {
		
		PlatformTransactionManager txManager = beanFactory.getBean(PlatformTransactionManager.class);
		
		TransactionStatus txStatus = txManager.getTransaction(null);
		System.out.println(txStatus.isCompleted());
		
		try {
			saveOrder();
			
			cartService.delete(Arrays.asList(new Long[]{1L, 2L}));
		} catch (Exception e) {
			System.out.println(txStatus.isCompleted());
			txManager.rollback(txStatus);
			throw new RuntimeException(e.getMessage());
		} finally {
			
			System.out.println("1111111");
		}
		System.out.println(txStatus.isCompleted());
		txManager.commit(txStatus);
	}

	private void saveOrder() {
		OrderBean order = new OrderBean();
		order.setMemberId(1L);
		order.setOrderId("2016081600000001");
		order.setOrgId(0L);
		order.setStatus('1');
		orderDao.saveOrder(order);
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory  = beanFactory;
		
	}

	
	
}
