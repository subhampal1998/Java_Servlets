

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TP2Assign2
 */
@WebServlet("/TP2Assign2")
public class TP2Assign2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TP2Assign2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String getData="SELECT PASSWORD, USERTYPE FROM Users WHERE USERNAME='"+username+"'";
		PrintWriter out=response.getWriter();
		try
		{
			String pass="",type="";
			Connection connection=DBUtil.getDBConnection();
			Statement stmt=connection.createStatement();
			ResultSet rs=stmt.executeQuery(getData);
			if(rs==null)
				out.println("User does not exist");
			else
			{
				while(rs.next())
				{
					 pass=rs.getString("PASSWORD");
					 type=rs.getString("USERTYPE");
				}
				if(pass.equals(password)&&type.equals("A"))
					response.sendRedirect("AdminHomePage.jsp");
				else if(pass.equals(password)&&type.equals("E"))
					response.sendRedirect("EmployeeHomePage.jsp");
				else
					out.println("Incorrect Password");
			}	
		}
		
			catch(Exception e)
			{
				System.out.println(e.getMessage());
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
