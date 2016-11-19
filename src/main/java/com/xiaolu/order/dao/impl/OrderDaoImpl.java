package com.xiaolu.order.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.xiaolu.order.bean.OrderBean;
import com.xiaolu.order.dao.OrderDao;

@Repository
public class OrderDaoImpl implements OrderDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public void saveOrder(OrderBean order) {
		String sql = "insert into M_ORDER_MAIN (ORDER_ID,MEMBER_ID,ORG_ID,STATUS) values (?,?,?,?)";
		jdbcTemplate.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, order.getOrderId());
				ps.setLong(2, order.getMemberId());
				ps.setLong(3, order.getOrgId());
				ps.setString(4, order.getStatus()+"");
			}
		});
		
	}

}
