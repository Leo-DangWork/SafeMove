/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filter;

import jakarta.servlet.Filter;
import model.Account;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author Dzung
 */
public class AuthorizationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        HttpSession session = req.getSession(false);
        String contextPath = req.getContextPath();
        String uri = req.getRequestURI().substring(req.getContextPath().length());
        
        if (uri.equals("") || uri.equals("/")) {
            resp.sendRedirect(contextPath + "/home");
            return;
        }
        // Cho phép truy cập login và register
        if (    uri.equals("/home") 
                || uri.equals("/login") 
                || uri.equals("/register")) {
            chain.doFilter(request, response);
            return;
        }

        // Nếu chưa login
        if (session == null || session.getAttribute("currentUser") == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        Account user = (Account) session.getAttribute("currentUser");
        String role = user.getRole();

        // Phân quyền theo role
        if (uri.startsWith("/admin") && !"ADMIN".equals(role)) {
            resp.sendError(HttpServletResponse.SC_FORBIDDEN);
            return;
        }

        if (uri.startsWith("/staff") && !"STAFF".equals(role)) {
            resp.sendError(HttpServletResponse.SC_FORBIDDEN);
            return;
        }

        if (uri.startsWith("/customer") && !"CUSTOMER".equals(role)) {
            resp.sendError(HttpServletResponse.SC_FORBIDDEN);
            return;
        }
        
        chain.doFilter(request, response);
    }   
}

