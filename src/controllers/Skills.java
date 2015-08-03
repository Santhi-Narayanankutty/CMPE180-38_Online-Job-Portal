package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dbhelper.Add_skill;

/**
 * Servlet implementation class Skills
 */
@WebServlet("/skills")
public class Skills extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Skills() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String skill1 = request.getParameter("skill1");
		String exp1 = request.getParameter("exp1");
		String skill2 = request.getParameter("skill2");
		String exp2 = request.getParameter("exp2");
		String skill3 = request.getParameter("skill3");
		String exp3 = request.getParameter("exp3");
		String profile_ID = request.getParameter("Hidden_ID");
		System.out.println(profile_ID);
	Add_skill add = new Add_skill("root","root");
	add.add_skillset(profile_ID,skill1,exp1,skill2,exp2,skill3,exp3);
	String url = "qualification.jsp";
	request.setAttribute("Hidden_ID",profile_ID);
    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
    dispatcher.forward(request, response);
	}

}
