package com.mycompany.web.jobs;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jobs/longjob")
public class LongJobServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print("1. 開始 Servlet 進入 " + new Date() + " <br>");
        out.flush();
        
        // 商業邏輯 !
        longJob(out);
        
        out.print("3. 自 Servlet 離開 " + new Date() + " <br>");
        out.flush();
    }
    
    private void longJob(PrintWriter out) {
        try {
            Thread.sleep(10000);
            out.print("2. 久等了~ " + new Date() + " <br>");
            out.flush();
        } catch (Exception e) {
        }
    }
    
}
