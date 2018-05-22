package net.hunau.goodsmanager.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.hunau.goodsmanager.bean.Goods;
import net.hunau.goodsmanager.biz.GoodsBiz;


public class AddGoodServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddGoodServlet() {
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

		doPost(request,response);
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
		
		request.setCharacterEncoding("UTF-8");
		

		
		String goodName =request.getParameter("ProductName");
		String goodPrice = request.getParameter("productPrice");
		String goodCount = request.getParameter("productNumber");
		String goodDep = request.getParameter("description");
		String goodType = request.getParameter("goodsType");
		
		Goods goods = new Goods();
		goods.setGoodname(goodName);
		goods.setGoodprice(Integer.valueOf(goodPrice));
		goods.setGoodcount(Integer.valueOf(goodCount));
		goods.setGoodtype(Integer.valueOf(goodType));
		goods.setGoodDep(goodDep);
		
		GoodsBiz goodsBiz =new GoodsBiz();
		goodsBiz.addGoods(goods);

		
		String toPage = request.getContentType()+"/content/goodsManager/searchGoods.jsp";
		response.sendRedirect("../content/goodsManager/searchGoods.jsp");
		
		
		
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
