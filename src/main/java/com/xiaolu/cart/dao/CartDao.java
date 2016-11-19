package com.xiaolu.cart.dao;

import java.util.List;

import com.xiaolu.cart.bean.CartItemBean;

public interface CartDao {
	
	void addCartItems(List<Long> ids);
	
	void deleteCartItems(List<Long> ids);
	
	List<CartItemBean> findAll(Long memberId);
}
