package com.headfirst.pacmanface;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class MyServletA extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String message = "Поехали!!!";
        out.println("<HTML><BODY>");
        out.println("<H1>"+message+"<H1>");
        out.println("</BODY></HTML>");
        out.close();
    }
}
