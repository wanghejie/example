package net.hunau.goodsmanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.hunau.goodsmanager.bean.GoodsType;
import net.hunau.goodsmanager.utils.JDBCUtils;

public class TypeDAO {
	
	private Connection conn = null;
	private PreparedStatement pst =null;
	private ResultSet rs =null;
	
	
	public List<GoodsType> scanAllGoodsType() {
		
		List<GoodsType> goodsType =new ArrayList<GoodsType>();
		
		String sql = "select id,typename,typedes from goodstype";
		
		try {
			conn =JDBCUtils.getConnection();
			pst =conn.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while (rs.next()) {
				GoodsType goodstype = new GoodsType();
				goodstype.setId(rs.getInt("id"));
				goodstype.setTypeName(rs.getString("typename"));
				goodstype.setTypeDec(rs.getString("typedes"));
				
				goodsType.add(goodstype);
				
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtils.release(pst, conn);
			
		}
		
		
		
		return goodsType;
	}
	
	

}
