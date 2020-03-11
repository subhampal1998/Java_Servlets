

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
 * Servlet implementation class TP2Assign3
 */
@WebServlet("/details")
public class TP2Assign3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TP2Assign3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String ID=request.getParameter("ID");
			String tnname=request.getParameter("trainname");
			String strtdate=request.getParameter("startdate");
			String enddate=request.getParameter("enddate");
			String Tmode=request.getParameter("trainingmode");
			String Bunit=request.getParameter("businessunit");
			String CPID=request.getParameter("contactID");
			PrintWriter out=response.getWriter();
			String data="INSERT INTO Trainings(TRAINING_ID, TRAINING_NAME, START_DATE, END_DATE, TRAINING_MODE, BUSINESS_UNIT, CONTACT_PERSON_ID)" +
					"VALUES('"+ID+"','"+tnname+"','"+strtdate+"','"+enddate+"','"+Tmode+"','"+Bunit+"','"+CPID+"')";
			try
			{
				Connection connection=DBUtil.getDBConnection();
				Statement stmt=connection.createStatement();
				stmt.executeUpdate(data);
				out.println("Data Inserted");
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			
			
			String delid=request.getParameter("delid");
			try {
				Connection con = DBUtil.getDBConnection();
				Statement stmt = con.createStatement();
				String search="SELECT FROM Trainings WHERE TRAINING_ID='"+delid+"'";
				ResultSet rs=stmt.executeQuery(search);
				if(rs!=null)
				{
					String deleteTraining = "DELETE FROM Trainings WHERE TRAINING_ID='"+delid+"'";
					stmt.executeUpdate(deleteTraining);
					out.println("Training Deleted");
				}
				else
					out.println("Enter Valid Training ID");	
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
