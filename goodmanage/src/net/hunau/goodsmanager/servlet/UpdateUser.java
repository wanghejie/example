package net.hunau.goodsmanager.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.hunau.goodsmanager.bean.User;
import net.hunau.goodsmanager.dao.UserDAO;

public class UpdateUser extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UpdateUser() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName =request.getParameter("userName");
		String password =request.getParameter("password");
		String roleType =request.getParameter("roleType");
		String flag =request.getParameter("validateFlag");
		int intFlag=0;
		if(flag!=null)
			intFlag = Integer.parseInt(flag);
		
		User user =new User();
		user.setUsername(userName);
		user.setPassword(password);
		user.setValidateFlag(intFlag);
		user.setRoles(Integer.parseInt(roleType));
		
		UserDAO userDao=new UserDAO();
		userDao.updateUser(user);
		
		String toPage =request.getContextPath()+"/content/userManager/userManager.jsp";
		response.sendRedirect(toPage);
		
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
