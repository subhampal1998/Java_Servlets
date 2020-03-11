

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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TP4Assign4
 */
@WebServlet("/check")
public class TP4Assign4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TP4Assign4() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		session.setAttribute("Username", username);
		session.setAttribute("Password", password);
		
		String data="SELECT PASSWORD FROM Login WHERE USERNAME='"+username+"'";
		try
		{
			Connection connection=DBUtil.getDBConnection();
			Statement stmt=connection.createStatement();
			ResultSet rs=stmt.executeQuery(data);
			if(rs==null)
				out.println("Invalid User");
			else
			{
				while(rs.next())
				{
					String pas=rs.getString("PASSWORD");
					if(pas.equals(password))
					{
						String getData="SELECT * FROM Salary WHERE USERNAME='"+username+"'";
						rs=null;
						rs=stmt.executeQuery(getData);
						while(rs.next())
						{
							String salary=rs.getString("SALARY");
							String acctype=rs.getString("ACCOUNT_TYPE");
							session.setAttribute("salary", salary);
							session.setAttribute("acctype", acctype);
						}
						response.sendRedirect("HomePage1.html");
					}
					else
						out.println("Invalid Password");
				}
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
