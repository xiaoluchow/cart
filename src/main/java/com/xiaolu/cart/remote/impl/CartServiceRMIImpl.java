package com.xiaolu.cart.remote.impl;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.xiaolu.cart.bean.CartItemBean;
import com.xiaolu.cart.remote.CartServiceRMI;

public class CartServiceRMIImpl extends UnicastRemoteObject implements CartServiceRMI{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4051250331460586255L;

	public CartServiceRMIImpl() throws RemoteException{
		super();
	}

	@Override
	public List<CartItemBean> queryMemberCartItems(Long memberId) throws RemoteException{
		List<CartItemBean> list = new ArrayList<CartItemBean>();
		for(int i = 0; i < 100000; i++){
			CartItemBean e = new CartItemBean();
			e.setProductId(new Long(i));
			e.setCreateDate(new Date(System.currentTimeMillis()));
			list.add(e);
		}
		return list;
	}

	public static void main(String[] args) {
		try {
			CartServiceRMIImpl rmiServer = new CartServiceRMIImpl();
			LocateRegistry.createRegistry(1099);
			java.rmi.Naming.rebind("rmi://172.16.11.30:1099/cart/rmi/query", rmiServer);
			System.out.print("Ready......");
		} catch (RemoteException | MalformedURLException e) {
			e.printStackTrace();
		}	
		
	}
}
