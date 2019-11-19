package com.mycompany.web.jms;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jms/SingleJMS")
public class SingleJMSServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.print("<pre>");
        try {
            final ExampleMessageSender sender = new ExampleMessageSender();
            final ExampleMessageReceiver receiver = new ExampleMessageReceiver(out);
            receiver.startListener();

            for (int i = 1; i <= 5; i++) {
                String m = "Hello world! " + i;
                sender.sendMessage(m);
                Thread.sleep(1000);
            }

            sender.destroy();
            receiver.destroy();
        } catch (Exception e) {
        }
        out.print("</pre>");
    }

}
