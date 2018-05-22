package net.hunau.goodsmanager.biz;


import net.hunau.goodsmanager.bean.User;
import net.hunau.goodsmanager.dao.UserDAO;
import net.hunau.goodsmanager.exception.UserAuthException;

public class UserBiz {
	private UserDAO ud;
	public UserBiz() {
		ud=new UserDAO();
	}
	public User login(User user) throws UserAuthException {
		User tempUser=ud.getUser(user.getUsername(),user.getPassword());
		if(tempUser!=null) {
			return user;
		}else {
			throw new UserAuthException("”√ªßªÚ√‹¬Î¥ÌŒÛ£°");
		}
	}
	
	
	public void iscancelUser(String userName,int flag) {
		
		User user = ud.getUser(userName);
		if (user!=null) {
			user.setValidateFlag(flag);
			ud.updateUser1(user);
			
		}
		
	}
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserBiz ub=new UserBiz();
		User user=new User();
		user.setUsername("peter");
		user.setPassword("123456");
		
		try {
		   user=ub.login(user);
		   System.out.print(user);
		}catch (UserAuthException e) {
			e.printStackTrace();
		}
	}

}
