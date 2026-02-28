<%-- 
    Document   : register
    Created on : Feb 27, 2026, 9:14:37 PM
    Author     : Dzung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String error = (String)request.getAttribute("e");
            if (error!=null){
            %>
            <p style="color: red"><%=error%></p>
            <%
            }
            String username = request.getParameter("username");
            String password = request.getParameter("password");
        %>
        <form name="register" action="Register" method="POST">
            Username: <input type="text" name="username" value="<%=username==null?"":username%>" /><br/>
            Password: <input type="password" name="password" value="<%=password==null?"":password%>" /><br/>
            Confirm Password: <input type="password" name="cf_password" value="<%=password==null?"":password%>" />
            Phone Number: <input type="number" name="phone_number" value="phone_number" />
            <input type="submit" value="register" name="register" />
        </form>
    </body>
</html>
