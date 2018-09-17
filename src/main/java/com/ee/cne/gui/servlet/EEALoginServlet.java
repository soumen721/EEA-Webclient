package com.ee.cne.gui.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/eea")
@ServletSecurity(@HttpConstraint(rolesAllowed = { "cc-user", "ccl-user", "soc-user" }))
public class EEALoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("context");
		System.out.println(id);

		PrintWriter writer = response.getWriter();

		// build HTML code
		String htmlRespone = "<html>";
		htmlRespone += "<h2>Your username is : " + request.getHeader("HTTP_SM_UID") + "<br/>";
		htmlRespone += "And Your ROLEs are : " + request.getHeader("HTTP_SM_ROLES") + "<br/>";
		htmlRespone += "And Your MSISDN is : " + request.getAttribute("HTTP_TK_MSISDN") + "</h2>";
		htmlRespone += "</html>";

		System.out.println("User:: " + request.getHeader("HTTP_SM_UID"));
		System.out.println("SMISDN:: " + request.getUserPrincipal());

		request.getSession(true).invalidate();
		// return response
		writer.println(htmlRespone);
	}

}
