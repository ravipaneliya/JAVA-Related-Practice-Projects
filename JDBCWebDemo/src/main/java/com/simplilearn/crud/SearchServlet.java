package com.simplilearn.crud;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		PrintWriter out= response.getWriter();
		response.setContentType("text/html");
		String pid= request.getParameter("pid");
		
		InputStream in= getServletContext().getResourceAsStream("/WEB-INF/config.properties");
		Properties props= new Properties();
		props.load(in);
		Connection con= DBConfig.getConnection(props);
		try {
			PreparedStatement pst= con.prepareStatement("select name from product where id = ?");
			pst.setString(1, pid);
			ResultSet rs = pst.executeQuery();
			if(rs.next())
				out.print("<b>Product Found With ID " + pid + " <br> Product Name : " + rs.getString(1));
			else
				out.print("<b>Product Not Found With ID " + pid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rd=request.getRequestDispatcher("/index.html");  
        rd.include(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
