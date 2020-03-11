

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TP3Assign2
 */
@WebServlet("/TP3Assign2")
public class TP3Assign2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TP3Assign2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		config=getServletConfig();
		String driver=config.getInitParameter("driverName");
		String url=config.getInitParameter("urlName");
		try
		{
			Class.forName(driver);
			Connection connection=DriverManager.getConnection(url,"scott","Wipro123");
			System.out.println("Connection is sucessful");
		}
		catch(Exception e)
		{
			System.out.println("Error in Connection");
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context= getServletContext();
		String driver=context.getInitParameter("driverName1");
		String url=context.getInitParameter("urlName1");
		try
		{
			Class.forName(driver);
			Connection connection=DriverManager.getConnection(url,"scott","Wipro123");
			System.out.println("Connection is sucessful");
		}
		catch(Exception e)
		{
			System.out.println("Error in Connection");
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
