<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="my" uri="/WEB-INF/tlds/my_library" %>
<!DOCTYPE html>
<%
    pageContext.setAttribute("money", 10);
    request.setAttribute("money", 5000);
    session.setAttribute("money", 10000);
    application.setAttribute("money", 99999);
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Tag Page</title>
    </head>
    <body>
        <h1>
            <my:add x="10" y="20" />
        </h1>
        
    </body>
</html>
