

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TP4Assign1
 */
@WebServlet("/val")
public class TP4Assign1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TP4Assign1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] ck=request.getCookies();
		String username="";
		String password="";
		PrintWriter out=response.getWriter();
		for(int i=0;i<ck.length;i++)
		{
			String name=ck[i].getName();
			String value=ck[i].getValue();
			if(name.equals("Username"))
				username=value;
			else if(name.equals("Password"))
				password=value;
		}
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
						out.println("Login Sucessful");
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
