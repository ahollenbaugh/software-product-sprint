package com.google.sps.servlets;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/** Handles requests sent to the /hello URL. Try running a server and navigating to /hello! */
@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {
  String[] listOfFacts = {"Fact #1: I'm a vegetarian.", 
  "Fact #2: My hobbies include jailbreaking/modding, crochet, and playing video games.",
  "Fact #3: I speak French (poorly)."
};

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String json = convertToJsonUsingGson(listOfFacts);

    response.setContentType("application/json;");
    response.getWriter().println(json);
  }

  private String convertToJsonUsingGson(String[] stringList) {
    Gson gson = new Gson();
    String json = gson.toJson(stringList);
    return json;
  }
}
