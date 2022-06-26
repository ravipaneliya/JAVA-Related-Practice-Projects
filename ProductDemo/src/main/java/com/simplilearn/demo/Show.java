package com.simplilearn.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@WebServlet("/show")
public class Show extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.openSession();
			List<Products> productList = session.createQuery("from Products").list();

			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			out.println("<h3>Showing Added Products</h3><br>");
			
			out.println("<table border='2'>");
			
			out.println("<tr>");
			out.println("<td><b>ID</td>");
			out.println("<td><b>Product Name</td>");
			out.println("<td><b>Price</td>");
			out.println("<td><b>Description</td>");
			out.println("</tr>");
			
			for (Products product : productList) {
				out.println("<tr>");
				out.println("<td>" + product.getId() + " </td>");
				out.println("<td>" + product.getName() + "</td>");
				out.println("<td>" + product.getPrice() + "</td>");
				out.println("<td>" + product.getDescription() + "</td>");
				out.println("</tr>");
			}
			out.println("</table>");
			
			out.println("<br/><h3> <a href='addProduct.jsp'>ADD PRODUCT</a> </h3>");
			session.close();

			out.println("</body></html>");

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
