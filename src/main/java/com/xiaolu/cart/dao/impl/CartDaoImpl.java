package com.xiaolu.cart.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.xiaolu.cart.bean.CartItemBean;
import com.xiaolu.cart.dao.CartDao;

@Repository
public class CartDaoImpl implements CartDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void addCartItems(List<Long> ids) {
		String sql = "insert into M_CART (MEMBER_ID, GOOD_ID, PRODUCT_ID, NUM, STATUS, SELECT_FLAG) values (?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, new Object[]{1, 1, 1, 1, 1, 1});
	}

	@Override
	public void deleteCartItems(List<Long> ids) {
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < ids.size(); i++) {
			sb.append(ids.get(i)).append(",");
		}
		if(sb.length() > 0){
			sb.deleteCharAt(sb.length() - 1);
		}
		String sql = "delete from M_CART where CART_ID in ("+sb.toString()+")";
		jdbcTemplate.update(sql);
	}

	@Override
	public List<CartItemBean> findAll(Long memberId) {
		String sql = "select * from M_CART where MEMBER_ID = ?";
		return jdbcTemplate.query(sql, new Object[]{memberId}, new RowMapper<CartItemBean>(){

			@Override
			public CartItemBean mapRow(ResultSet rs, int rowNum) throws SQLException {
				CartItemBean bean = new CartItemBean();
				bean.setCreateDate(rs.getDate("CREATE_DATE"));
				bean.setId(rs.getLong("CART_ID"));
				bean.setIsSelected(rs.getString("SELECT_FLAG"));
				bean.setProductId(rs.getLong("PRODUCT_ID"));
				bean.setNum(rs.getInt("NUM"));
				return bean;
			}});
	}

}
