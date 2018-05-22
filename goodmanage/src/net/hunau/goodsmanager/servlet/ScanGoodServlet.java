package net.hunau.goodsmanager.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.hunau.goodsmanager.bean.Goods;
import net.hunau.goodsmanager.biz.GoodsBiz;

public class ScanGoodServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ScanGoodServlet() {
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
		String goodsID=request.getParameter("productID");
		String goodName=request.getParameter("productName");
		List<Goods> goodscan =new ArrayList<Goods>();
		GoodsBiz goodsBiz =new GoodsBiz();
		
		if((goodsID==null||goodsID.equals("")) && (goodName==null||goodName.equals("")) ){
			goodscan = goodsBiz.getGoods();
		}else{
			Goods goods =new Goods();
			if (goodsID!=null && !goodsID.equals("")) {
				goods.setId(Integer.valueOf(goodsID));
			}
			
			if(goodName!=null && !goodName.equals("")) {
				goods.setGoodname(goodName);
				
			}
			
			
			goodscan = goodsBiz.findGoods(goods);
		}
		
		
		HttpSession session =request.getSession();
		session.setAttribute("goods", goodscan);
		
		String toPage="/content/goodsManager/searchGoods.jsp";
		
		RequestDispatcher rd = request.getRequestDispatcher(toPage);
		rd.forward(request, response);
		
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
