package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dbhelper.qual;

/**
 * Servlet implementation class qualification
 */
@WebServlet("/qualification")
public class qualification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public qualification() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String q = request.getParameter("q");
		String q1 = request.getParameter("q1");
		String q2 = request.getParameter("q2");
		String profile_ID = request.getParameter("Hidden_ID");
		
		
	qual qualification = new qual("root","root");
	qualification.qualif(profile_ID,q,q1,q2);
	String url = "profile_complete.jsp";
	request.setAttribute("Hidden_ID",profile_ID);
    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
    dispatcher.forward(request, response);
	}
	}




