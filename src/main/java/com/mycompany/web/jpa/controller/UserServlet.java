package com.mycompany.web.jpa.controller;

import com.google.gson.Gson;
import com.mycompany.web.jpa.service.UserService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// please use TomEE
@WebServlet("/jpa_user/*")
public class UserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        if(pathInfo.equals("/user") || pathInfo.equals("/user/")) {
            String user_name = req.getParameter("user_name");
            Integer user_age = Integer.valueOf(req.getParameter("user_age"));
            UserService service = new UserService();
            boolean check = service.insert(user_name, user_age);
            resp.getWriter().println("Insert: " + check);
        } else {
            resp.getWriter().println("Not allow !");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        resp.getWriter().println(pathInfo);
    }

}
