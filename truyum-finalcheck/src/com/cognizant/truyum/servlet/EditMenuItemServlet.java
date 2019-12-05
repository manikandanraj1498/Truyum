package com.cognizant.truyum.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.dao.MenuItemDaoCollectionImpl;
import com.cognizant.truyum.dao.MenuItemDaoSqlImpl;
import com.cognizant.truyum.model.MenuItem;

/**
 * 
 * @author ManiKandan V
 *
 */
/**
 * Servlet implementation class EditMenuItemServlet
 */
@WebServlet("/EditMenuItemServlet")
public class EditMenuItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditMenuItemServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean activeFlag;

		String menuItemId = request.getParameter("menuitemid");
		System.out.println(menuItemId);
		String name = request.getParameter("mname");
		System.out.println(name);
		String price = request.getParameter("price");
		System.out.println(price);
		String active = request.getParameter("available");
		if (active.equals("yes")) {
			activeFlag = true;
		} else {
			activeFlag = false;
		}
		System.out.println(active);

		String dateOfLaunch = request.getParameter("date");
		System.out.println(dateOfLaunch);

		String category = request.getParameter("category");
		System.out.println(category);
		boolean freeDelivery = request.getParameter("freedelivery") != null;
		System.out.println(freeDelivery);
		/*
		 * if(freeDelivery==null) { freeDeliveryFlag=false; } else {
		 * freeDeliveryFlag=true; }
		 */
		try {

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date dateLaunch = sdf.parse(dateOfLaunch);
			MenuItem menuItem = new MenuItem(Long.parseLong(menuItemId), name, Float.parseFloat(price), activeFlag,
					dateLaunch, category, freeDelivery);
			System.out.println("MenuItem To be updated is" + menuItem);
			MenuItemDaoSqlImpl menuItemDaoSqlImpl = new MenuItemDaoSqlImpl();
			MenuItemDao menuItemDao = menuItemDaoSqlImpl;
			menuItemDao.modifyMenuItem(menuItem);
			System.out.println("After updated" + menuItemDao.getMenuItemListAdmin());
			request.getRequestDispatcher("edit-menu-item-status.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
