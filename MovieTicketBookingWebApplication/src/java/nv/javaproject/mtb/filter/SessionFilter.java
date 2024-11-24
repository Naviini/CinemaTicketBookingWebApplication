/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nv.javaproject.mtb.filter;

import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class SessionFilter implements Filter{

    /**
     *
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
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

    @Override
    public void destroy() {}
}
    

