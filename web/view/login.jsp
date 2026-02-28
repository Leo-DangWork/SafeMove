<%-- 
    Document   : login
    Created on : Feb 27, 2026, 9:14:20 PM
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
            String error = (String)request.getAttribute("error");
            if (error!=null){
            %>
            <p style="color: red"><%=error%></p>
            <%
            }
            String username = request.getParameter("username");
            String password = request.getParameter("password");
        %>
        <form id="formLogin" action="Login">
            Username: <input type="text" name="username" id="user" value="<%=username==null?"":username%>"/><br/>
            Password: <input type="password" name="password" id="pass" value="<%=password==null?"":password%>"/><br/>
            <input type="submit" value="Login" id="btnLogin"/>
        </form>
    </body>
</html>
