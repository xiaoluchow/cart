package com;

import java.net.URLDecoder;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xiaolu.order.bean.OrderBean;
import com.xiaolu.order.service.OrderService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springmvc-servlet.xml")
public class Junit {

	@Resource
	private OrderService orderService;
	
	@Test
	public void test(){
		final OrderBean order = new OrderBean();
		order.setMemberId(1L);
		//orderService.createOrder();
		func(order);
	}
	
	private void func(final OrderBean order) {
		order.setMemberId(2L);;
	}

	public static void main(String[] args) {
		try {
			System.out.println(URLDecoder.decode("orderId=D201611080015695&amp;memberId=77", "utf8"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
