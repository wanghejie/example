package net.hunau.goodsmanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.hunau.goodsmanager.bean.Goods;
import net.hunau.goodsmanager.bean.GoodsType;
import net.hunau.goodsmanager.bean.User;
import net.hunau.goodsmanager.utils.JDBCUtils;

public class GoodsDAO {
		private Connection conn = null;
		private PreparedStatement pst = null;
		private ResultSet rs=null;
		
	public void addGoods(Goods goods) {
		
		String sql ="insert into goods(goodsName,goodsPrice,goodsCount,goodsDep,goodsType)"
				+"values(?,?,?,?,?)";
		
		try {
			conn =JDBCUtils.getConnection();
			pst = conn.prepareStatement(sql);
			//pst.setInt(1, goods.getId());   //我改动过
			pst.setString(1, goods.getGoodname());
			pst.setDouble(2, goods.getGoodprice());
			pst.setInt(3, goods.getGoodcount());
			pst.setString(4, goods.getGoodDep());
			pst.setLong(5, goods.getGoodtype());
			
			pst.executeUpdate();
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtils.release(pst, conn);
			
		}
		
	}
	
	public List<Goods> getGoods() {
		
		List<Goods> goods = new ArrayList<Goods>();
		
		String sql = "select * from goods";
		
		
		try {
			conn =JDBCUtils.getConnection();
			pst =conn.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while (rs.next()) {
				Goods Goods = new Goods();
				Goods.setId(rs.getInt("goodsID"));
				Goods.setGoodname(rs.getString("goodsName"));
				Goods.setGoodprice(rs.getDouble("goodsPrice"));
				
				Goods.setGoodcount(rs.getInt("goodsCount"));
				Goods.setGoodDep(rs.getString("goodsDep"));
				Goods.setGoodtype(rs.getInt("goodsType"));
				goods.add(Goods);
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
		
		return goods;
	}
	
	
public List<Goods> getGoods(String goodsName) {
		
		List<Goods> goods = new ArrayList<Goods>();
		
		String sql = "select * from goods where goodsName like '%"+goodsName+"%'";
		
		
		
		
		try {
			conn =JDBCUtils.getConnection();
			pst =conn.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while (rs.next()) {
				Goods Goods = new Goods();
				Goods.setId(rs.getInt("goodsID"));
				Goods.setGoodname(rs.getString("goodsName"));
				Goods.setGoodprice(rs.getDouble("goodsPrice"));
				
				Goods.setGoodcount(rs.getInt("goodsCount"));
				Goods.setGoodDep(rs.getString("goodsDep"));
				Goods.setGoodtype(rs.getInt("goodsType"));
				goods.add(Goods);
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
		
		return goods;
	}
	
public Goods getGoods(int id) {
	

	
	String sql = "select * from goods where goodsID ="+id;
	
	Goods Goods = null;
	
	try {
		conn =JDBCUtils.getConnection();
		pst =conn.prepareStatement(sql);
		rs = pst.executeQuery();
		
		while (rs.next()) {
			Goods = new Goods();
			Goods.setId(rs.getInt("goodsID"));
			Goods.setGoodname(rs.getString("goodsName"));
			Goods.setGoodprice(rs.getDouble("goodsPrice"));
			
			Goods.setGoodcount(rs.getInt("goodsCount"));
			Goods.setGoodDep(rs.getString("goodsDep"));
			Goods.setGoodtype(rs.getInt("goodsType"));
		
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
	
	return Goods;
}


	public void delGoods(int id) {
		
		String sql = "delete from goods where goodsID="+id;
		
		try {
			conn = JDBCUtils.getConnection();
			pst = conn.prepareStatement(sql);
			pst.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtils.release(pst, conn);
			
		}
		
	}
//我改动的
/*public void updateGoods(Goods goods) {
 		String sql="update goods set goodsPrice=?,goodsCount=?,goodsType=?,goodsDep=? where goodsName=?";
 	
	try {
			conn=JDBCUtils.getConnection();
			pst=conn.prepareStatement(sql);
			
			pst.setDouble(1, goods.getGoodprice());
			pst.setInt(2, goods.getGoodcount());
			pst.setInt(3, goods.getGoodtype());
			pst.setString(4, goods.getGoodDep());
		
			pst.setString(5, goods.getGoodname());
			
			pst.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtils.release(pst,conn);
		}
  }
	*/

	
	//我改动的

	


	public static void main(String[] args) {
		
	}

}
