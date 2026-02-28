/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filter;

import jakarta.servlet.Filter;
import model.Account;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;
/**
 *
 * @author Dzung
 */
@WebFilter(urlPatterns = {"/customer/*", "/staff/*", "/admin/*"})
public class AuthorizationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);

        if (session == null || session.getAttribute("currentUser") == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        Account u = (Account) session.getAttribute("currentUser");
        String uri = req.getRequestURI();
        if (uri.contains("/customer/") && !"CUSTOMER".equals(u.getRole())) {
            resp.sendError(403);
            return;
        }
        if (uri.contains("/staff/") && !"STAFF".equals(u.getRole())) {
            resp.sendError(403);
            return;
        }
        if (uri.contains("/admin/") && !"ADMIN".equals(u.getRole())) {
            resp.sendError(403);
            return;
        }

        chain.doFilter(request, response);
    }
    
}
