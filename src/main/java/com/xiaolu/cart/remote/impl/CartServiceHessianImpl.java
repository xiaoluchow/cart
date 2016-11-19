package com.xiaolu.cart.remote.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.xiaolu.cart.bean.CartItemBean;
import com.xiaolu.cart.remote.CartServiceHessian;

public class CartServiceHessianImpl implements CartServiceHessian {
	
	@Override
	public List<CartItemBean> queryMemberCartItems(Long memberId){
		List<CartItemBean> list = new ArrayList<CartItemBean>();
		for(int i = 0; i < 100000; i++){
			CartItemBean e = new CartItemBean();
			e.setProductId(new Long(i));
			e.setCreateDate(new Date(System.currentTimeMillis()));
			list.add(e);
		}
		return list;
	}

}
