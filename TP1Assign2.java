

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TP1Assign2
 */
@WebServlet("/welcome")
public class TP1Assign2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TP1Assign2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     LocalTime time = LocalTime.now();
	     String name=request.getParameter("name");
	     int hours = time.getHour();
	     PrintWriter out=response.getWriter();
	     if(hours<12)
	    	 out.println("Good Morning "+name);
	     if(hours>=12&&hours<18)
	    	 out.println("Good Afternoon "+name);
	     if(hours>18&&hours<=24)
	    	 out.println("Good Evening "+name);
	     
	     }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
