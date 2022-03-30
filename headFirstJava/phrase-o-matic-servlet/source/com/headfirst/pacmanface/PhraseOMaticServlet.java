package com.headfirst.pacmanface;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class PhraseOMaticServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = "PhraseOMatic has generated the following phrase.";
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<HTML><HEAD><TITLE>");
        out.println("PhraseOmatic");
        out.println("</TITLE></HEAD><BODY>");
        out.println("<H1>"+title+"</H1>");
        out.println("<p>"+PhraseOMatic.makePhrase()+"</p>");
        out.println("<p><a href=\"PhraseOMaticServlet\">Make new phrase</a></p>");
        out.println("</BODY></HTML>");
        out.close();
    }    
}
