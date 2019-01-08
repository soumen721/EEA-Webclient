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

@WebServlet("/logout")
public class LogOutServlet extends HttpServlet {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    PrintWriter writer = response.getWriter();

    // build HTML code
    String htmlRespone = "<html>";
    htmlRespone +=
        "<h2 align='center'>Your username is : " + request.getRemoteUser() + "<br/>";
    htmlRespone += " Logout Successful</h2>";
    htmlRespone += "</html>";

    request.getSession().invalidate();
    request.getSession(true).invalidate();
    // return response
    writer.println(htmlRespone);
  }

}
