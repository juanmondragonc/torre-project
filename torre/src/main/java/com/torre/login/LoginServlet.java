package com.torre.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/torre_project","root","");
			PreparedStatement query = conn.prepareStatement("SELECT * FROM tb_users WHERE username = ? and password = ?");
			query.setString(1, username);
			query.setString(2, password);
			ResultSet result = query.executeQuery();
			if(result.next()) {
				session.setAttribute("username", result.getString("username"));
				response.sendRedirect("index.jsp");
			}
			else {
				response.sendRedirect("login.jsp");
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}

}
