package stef.springhibernatecm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDBServlet
 */
@WebServlet("/TestDBServlet")
public class DBConnectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//variables used to setup connection
		String jdbcUrl = "jdbc:mysql://localhost:3306/web_spring_customer_tracker_demo_db?allowPublicKeyRetrieval=true&useSSL=false";
		String user = "springwebappuser";
		String pass = "springwebpass";
		//driver for MySQL
		String driver = "com.mysql.cj.jdbc.Driver";
		
		//get connection to database
		
		try {
			PrintWriter out = response.getWriter();
			out.println("Connecting to database " + jdbcUrl);
			
			Class.forName(driver);
			
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			
			out.println("SUCCESS!!");
			
			myConn.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
