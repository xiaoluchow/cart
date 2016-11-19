package com.xiaolu.order.service;

import org.springframework.beans.factory.BeanFactoryAware;


public interface OrderService extends BeanFactoryAware {

	void createOrder();
}
