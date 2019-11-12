package com.mycompany.web.jpa.controller;

import com.mycompany.web.jpa.entity.User;
import com.mycompany.web.jpa.service.UserService;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
        UserService service = new UserService();
        String pathInfo = req.getPathInfo();
        resp.getWriter().println(pathInfo);
        // 多筆查詢
        if(pathInfo.equals("/users") || pathInfo.equals("/users/")) {
            List<User> users = service.query();
            resp.getWriter().println(users);
        } else { // 單筆查詢
            Matcher matcher = Pattern.compile("/user/[0-9]+").matcher(pathInfo);
            resp.getWriter().println(matcher.matches());
            if(matcher.matches()) {
                Integer id = Integer.valueOf(pathInfo.split("/")[2]);
                User user = service.findById(id);
                resp.getWriter().println(user);
            }
        }
    }

}
