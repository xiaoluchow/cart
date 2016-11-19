package com.xiaolu.cart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiaolu.cart.bean.CartItemBean;
import com.xiaolu.cart.dao.CartDao;
import com.xiaolu.cart.service.CartService;
import com.xiaolu.common.ServiceType;
import com.xiaolu.common.anotation.RemoteService;

//@RemoteService(serviceName="cartServiceImpl", serviceInterfaces=CartService.class, serviceType = ServiceType.RMI)
@Service
public class CartServiceImpl implements CartService{

	@Autowired
	private CartDao cartDao;
	
	@Transactional
	@Override
	public void add(List<Long> cartItemIdList) {
		cartDao.addCartItems(cartItemIdList);
	}
	
	@Transactional
	@Override
	public void delete(List<Long> cartItemIdList) {
		int a = 1 / 0;
		cartDao.deleteCartItems(cartItemIdList);
	}

	@Override
	public List<CartItemBean> getMemberCartItems(Long memberId) {
		return cartDao.findAll(memberId);
	}

}
