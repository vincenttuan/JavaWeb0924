package com.mycompany.web.jms;

import java.io.PrintWriter;
import javax.jms.*;

public class ExampleMessageReceiver implements MessageListener {

    private Connection con;
    private PrintWriter out;

    public ExampleMessageReceiver() {
    }

    public ExampleMessageReceiver(PrintWriter out) {
        this.out = out;
    }
    public void startListener () throws JMSException {
        ConnectionFactory factory = JmsProvider.getConnectionFactory();
        this.con = factory.createConnection();
        con.start();

        Session session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Queue queue = session.createQueue("example.queue");
        MessageConsumer consumer = session.createConsumer(queue);
        consumer.setMessageListener(this);
    }

    @Override
    public void onMessage (Message message) {
        if (message instanceof TextMessage) {
            TextMessage tm = (TextMessage) message;
            try {
                String msg = String.format("Message received: %s, Thread: %s%n",
                                  tm.getText(),
                                  Thread.currentThread().getName());
                System.out.println(msg);
                if(out != null) {
                    out.println(msg);
                    out.flush();
                }
            } catch (JMSException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void destroy () throws JMSException {
        con.close();
    }
}