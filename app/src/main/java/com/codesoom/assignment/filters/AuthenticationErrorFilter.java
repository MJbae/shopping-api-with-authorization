package com.codesoom.assignment.filters;

import com.codesoom.assignment.errors.InvalidTokenException;

import javax.servlet.*;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthenticationErrorFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            chain.doFilter(request, response);
        } catch (InvalidTokenException e) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
         }
    }
}
