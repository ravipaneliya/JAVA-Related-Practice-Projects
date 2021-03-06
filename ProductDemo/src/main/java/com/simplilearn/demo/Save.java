package com.simplilearn.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@WebServlet("/save")
public class Save extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		try {
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.openSession();
			Transaction tx = session.beginTransaction();

			String prodname = request.getParameter("pname");
			double price = Double.parseDouble(request.getParameter("price"));
			String desc = request.getParameter("pdesc");

			session.save(new Products(prodname, price, desc));
			tx.commit();
			
			out.print("Product Inserted Successfully");
			
			List<Products> productList = session.createQuery("from Products").list();
			
			request.setAttribute("products", productList);
			
			RequestDispatcher rd = request.getRequestDispatcher("product.jsp");
		    rd.forward(request, response);
		    
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
