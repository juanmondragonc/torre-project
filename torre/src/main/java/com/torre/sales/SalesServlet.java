package com.torre.sales;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.torre.model.Invoice;

@WebServlet("/sales")
public class SalesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SalesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String invoice = request.getParameter("invoice");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/torre_project","root","");
			PreparedStatement query = conn.prepareStatement("SELECT * FROM tb_sales WHERE invoice = ?");
			query.setString(1, invoice);
			ResultSet result = query.executeQuery();
			List<Invoice> list = new ArrayList<>();
			int pos = 1;
			int items = 0;
			float sale = 0;
			DecimalFormat df = new DecimalFormat();
			df.setMaximumFractionDigits(2);
			while (result.next()) {
				Invoice inv = new Invoice();
				inv.setId(result.getInt(1));
				inv.setPos(pos++);
				inv.setInvoice(result.getInt(2));
				inv.setProduct(result.getString(3));
				inv.setQuantity(result.getInt(4));
				inv.setPrice(result.getFloat(5));
				inv.setTotal(df.format(result.getInt(4) * result.getFloat(5)));
				list.add(inv);
				items = items + result.getInt(4);
				sale = sale + (result.getInt(4) * result.getFloat(5));
			}
			request.setAttribute("Products", list);
			request.setAttribute("Items", items);
			request.setAttribute("Sale", sale);
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
