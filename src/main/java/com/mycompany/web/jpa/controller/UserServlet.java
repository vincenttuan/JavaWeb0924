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
@WebServlet("/jpa/controller/user/*")
public class UserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService service = new UserService();
        Integer user_id, user_age;
        String user_name;
        
        String pathInfo = req.getPathInfo();
        resp.getWriter().println(pathInfo);
        switch(pathInfo) {
            case "/insert":
                user_name = req.getParameter("user_name");
                user_age = Integer.parseInt(req.getParameter("user_age"));
                resp.getWriter().print(service.insert(user_name, user_age));
                return;
            case "/update":
                user_id = Integer.parseInt(req.getParameter("user_id"));
                user_name = req.getParameter("user_name");
                user_age = Integer.parseInt(req.getParameter("user_age"));
                resp.getWriter().print(service.update(user_id, user_name, user_age));
                return;
            case "/delete":
                user_id = Integer.parseInt(req.getParameter("user_id"));
                resp.getWriter().print(service.delete(user_id));
                return;
        }
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new Gson();
        UserService service = new UserService();
        resp.getWriter().print(gson.toJson(service.query()));
    }

}
