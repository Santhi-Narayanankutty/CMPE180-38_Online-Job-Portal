package controllers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbhelper.Add_profile;

/**
 * Servlet implementation class Profile
 */
@WebServlet("/profile")
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Profile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String mname = request.getParameter("mname");
		String city = request.getParameter("city");
		String zip =  request.getParameter("zip");
		String dob = request.getParameter("dob");
		String pcell = request.getParameter("pcell");
		String phome = request.getParameter("phome");
		String poffice = request.getParameter("poffice");
		String resume = request.getParameter("resume");
		String salary_exp = request.getParameter("salary_exp");
		String relocate = request.getParameter("relocate");
		String state = request.getParameter("state");
		String country = request.getParameter("country");
		String position = request.getParameter("position");	
		String profile_ID = request.getParameter("Hidden_ID");
		
	Add_profile add = new Add_profile("root","Ramanathan@1988");
	add.add_entries(profile_ID,fname,lname,mname,dob,
			pcell,phome,poffice,resume,salary_exp,
			relocate,state,country,city,zip,position);
	String url = "skills.jsp";
	request.setAttribute("Hidden_ID",profile_ID);
	
    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
    dispatcher.forward(request, response);
	}

}
