package com.example.unleashapp.listeners;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;
@WebListener
public class MyServletRequestListener implements ServletRequestListener{

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("In request initialized");
		sre.getServletRequest().setAttribute("author", "Pankaj");
	}
	

}
