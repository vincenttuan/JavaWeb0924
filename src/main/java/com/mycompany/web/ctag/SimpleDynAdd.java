package com.mycompany.web.ctag;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SimpleDynAdd extends SimpleTagSupport implements DynamicAttributes {
    Map<String, Object> map = new LinkedHashMap<>();
    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        map.forEach((k, v) -> {
            try {
                out.println(k + " : " + v + "<br>");
            } catch (IOException ex) {
            }
        });
    }

    @Override
    public void setDynamicAttribute(String uri, String key, Object value) throws JspException {
        map.put(key, value);
    }
    
}
