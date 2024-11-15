/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nv.javaproject.mtb.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class SessionFilter implements Filter{
    public void init(FilterConfig filterConfig) throws ServletException {}

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Allow access to public resources
        String uri = httpRequest.getRequestURI();
        if (uri.endsWith("login.jsp") || uri.endsWith("register.jsp") || uri.contains("CustomerController") && httpRequest.getParameter("action").equals("login")) {
            chain.doFilter(request, response);
            return;
        }

        // Check if user is logged in
        if (httpRequest.getSession().getAttribute("customerId") == null) {
            httpResponse.sendRedirect("login.jsp?error=Please login first.");
        } else {
            chain.doFilter(request, response);
        }
    }

    public void destroy() {}
}
    

