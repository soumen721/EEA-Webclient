package com.ee.cne.gui.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/eea")
//@ServletSecurity(@HttpConstraint(rolesAllowed = {"cc-user", "ccl-user", "soc-user","cne_ericsson_support"}))
public class CEALoginServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    System.out.println("Inside EEA Servlet ::");
    String eeaURL = "/eea";
    System.out.println("EEA Redirected URL : " + eeaURL);
    response.sendRedirect(eeaURL);
  }

}
