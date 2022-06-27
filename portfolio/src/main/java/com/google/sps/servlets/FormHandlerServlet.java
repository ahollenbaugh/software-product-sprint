package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form-handler")
public class FormHandlerServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    // Get the values entered in the form.
    String fname = request.getParameter("fname");
    String lname = request.getParameter("lname");
    String email = request.getParameter("email");
    String message = request.getParameter("message");

    // Print the values so you can see them in the server logs.
    System.out.println("First name: " + fname);
    System.out.println("Last name: " + lname);
    System.out.println("Email: " + email);
    System.out.println("Message: " + message);

    // Write the values to the response so the user can see them.
    response.getWriter().println("First name: " + fname);
    response.getWriter().println("Last name: " + lname);
    response.getWriter().println("Email: " + email);
    response.getWriter().println("Message: " + message);
  }
}