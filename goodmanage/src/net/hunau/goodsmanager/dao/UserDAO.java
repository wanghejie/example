package net.hunau.goodsmanager.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.util.ArrayList;
import java.util.List;

import net.hunau.goodsmanager.bean.User;
import net.hunau.goodsmanager.utils.JDBCUtils;

public class UserDAO {
	private Connection conn;
	private ResultSet rs;
	private PreparedStatement pst;
	
	public User getUser(String userName, String password) {
		User user=null;
		String sql="select userName, pwd, roles from users where userName=? and pwd=md5(?)";
		
		
	
		try {
			conn=JDBCUtils.getConnection();
			
			pst=conn.prepareStatement(sql);
			pst.setString(1,userName);
			pst.setString(2,password);
			rs=pst.executeQuery();
			
			if (rs.next()) {
				user=new User();
				user.setUsername(rs.getString("userName"));
				user.setPassword(rs.getString("pwd"));
				user.setRoles(rs.getInt("roles"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (ClassNotFoundException e){
			e.printStackTrace();
			
		}finally{
			JDBCUtils.release(rs, pst,conn);
		}
		
		
		return user;
	}
	
	public User getUser(String userName) {
		User user=null;
		String sql="select userName, pwd,validateFlag, roles from users where userName=? ";
		
		
	
		try {
			conn=JDBCUtils.getConnection();
			
			pst=conn.prepareStatement(sql);
			pst.setString(1,userName);
			
			rs=pst.executeQuery();
			
			if (rs.next()) {
				user=new User();
				user.setUsername(rs.getString("userName"));
				user.setPassword(rs.getString("pwd"));
				user.setRoles(rs.getInt("roles"));
				user.setValidateFlag(rs.getInt("validateFlag"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (ClassNotFoundException e){
			e.printStackTrace();
			
		}finally{
			JDBCUtils.release(rs, pst,conn);
		}
		
		
		return user;
	}
	
	
	
	public List<User> getUsers() {
		List<User> users =new ArrayList<User>();
		
		String sql="select userName, pwd,validateFlag, roles from users ";
		
		User tempUser=null;
		
		try {
			conn=JDBCUtils.getConnection();
			pst =conn.prepareStatement(sql);
			rs=pst.executeQuery();
			
			while(rs.next()){
				tempUser=new User();
				tempUser.setUsername(rs.getString("userName"));
				tempUser.setValidateFlag(rs.getInt("validateFlag"));
				tempUser.setPassword(rs.getString("pwd"));
				tempUser.setRoles(rs.getInt("roles"));
				
				users.add(tempUser); 
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return users;
		
	}
	
	public void updateUser(User user) {
		String sql ="update users set validateFlag=?,pwd=md5(?),roles=? where userName=?";
		
		try {
			conn=JDBCUtils.getConnection();
			pst=conn.prepareStatement(sql);
			pst.setInt(1,user.getValidateFlag());
			pst.setString(2, user.getPassword());
			pst.setInt(3, user.getRoles());
			pst.setString(4, user.getUsername());
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
	
	
	public void updateUser1(User user) {
		String sql ="update users set validateFlag=? where userName=?";
		
		try {
			conn=JDBCUtils.getConnection();
			pst=conn.prepareStatement(sql);
			pst.setInt(1,user.getValidateFlag());
			pst.setString(2, user.getUsername());
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
	
	
	public void addUser(User user) {
		
		String sql = "insert into users (userName,pwd,validateFlag,roles) values(?,md5(?),?,?)";
		
		try {
			conn=JDBCUtils.getConnection();
			pst=conn.prepareStatement(sql);
			
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			pst.setInt(3,user.getValidateFlag());
			pst.setInt(4,user.getRoles());
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
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDAO ud=new UserDAO();
		//User user =ud.getUser("peter", "123456");
		//System.out.println(user);
		
		List<User> users=ud.getUsers();
		for(int i=0;i<users.size();i++) {
			User user=users.get(i);
			System.out.println(user);
		}

	}

}
