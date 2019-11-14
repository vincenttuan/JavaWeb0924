<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="my" uri="http://my.scwcd" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Tag Page</title>
    </head>
    <body>
        <h1><my:required /></h1>
        <h1><my:greet /></h1>
        <h1><my:greet user="John" /></h1>
        <h1><my:greet user="<%=String.valueOf(1+2) %>" /></h1>
        <h1><my:greet user="${1+2}" /></h1>
    </body>
</html>
