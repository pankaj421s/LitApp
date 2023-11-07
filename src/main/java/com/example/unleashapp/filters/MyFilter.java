package com.example.unleashapp.filters;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;
@WebFilter("/hello")
public class MyFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
System.out.println("In filter");

HttpServletRequestWrapper requestwrapper=new HttpServletRequestWrapper((HttpServletRequest) request);

//requestwrapper.
chain.doFilter(request, response);
HttpServletResponse httpServletResponse=(HttpServletResponse) response;
System.out.println("in filter out"+httpServletResponse.getStatus());
	}

}
