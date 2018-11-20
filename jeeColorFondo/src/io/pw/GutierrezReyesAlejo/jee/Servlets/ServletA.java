package io.pw.GutierrezReyesAlejo.jee.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.awt.Color;

import io.pw.GutierrezReyesAlejo.jee.Logica.*;
@WebServlet(
		urlPatterns = {
			"/ServletA",
			"/servletA"
		}
	)
	public class ServletA extends HttpServlet {
    
    public ServletA() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// -----------------<Settings>----------------------
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		// ----------------.<Reload Page>--------------------
		String docHTML = generarDocumentoHTML(request);
		PrintWriter salida = response.getWriter();
		salida.println(docHTML);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// -----------------<Settings>----------------------
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		// -----------------<Change Cookie>-----------------		
		System.out.println("Color Value: " + Util.CookieValueOf(request.getCookies(), "color"));
		
		// Get the color
		System.out.println("request.getParameter():" + request.getParameter("input-color"));
		String cookieColor  = DeString.aStringColor( request.getParameter("input-color") );
		Cookie color =  new Cookie("color", cookieColor);
		// ----------------.<Add Cookies>--------------------
		response.addCookie(color);		
		// ----------------.<Reload Page>--------------------
		
		response.sendRedirect("ServletA");
		/**
		//String docHTML = generarDocumentoHTML(request);		
		//PrintWriter salida = response.getWriter();		
		//salida.println(docHTML);
		 * */
	}
	
	
	
	private String generarDocumentoHTML(HttpServletRequest request) {
		// ------------< Variables >------------------------
		StringBuffer docOut = new StringBuffer();
		
		// ------------< Cookies >------------------------------
		Cookie[] cookies = request.getCookies();
		String color = Util.CookieValueOf(cookies, "color");
		
		// -------------< Generate HTML Document >--------------------------------------		
		docOut.append(
				"<!DOCTYPE html>\n" + 
				"<head>\n" + 
				"    <meta charset=\"UTF-8\">\n" + 
				"    <title>Servlet</title>\n" + 
				"    <link href=\"assets/css/normalize.css\" rel=\"stylesheet\" type=\"text/css\">\n" + 
				"    <link href=\"assets/css/main.css\" rel=\"stylesheet\">\n" + 
				GeneradorCSS.generarCSS(request) +
				"</head>\n" + 
				"<body>\n" + 
				"<h3> <a href=\".\"> Inicio </a> </h3>" +
				"    <form action=\"ServletA\" method=\"POST\" class=\"Formulario\">\n" + 
				"        <fieldset>\n" + 
				"            <legend>Bienvenido</legend>\n" + 
				"            <div>\n" + 
				"                <label for=\"input-color\">Color</label>\n" + 
				"                <input type=\"color\" id=\"input-color\" name=\"input-color\" value=\"\" placeholder=\"Ingresa algo...\" />\n" + 
				"            </div>\n" + 
				"            <div>\n" + 
				"                <button type=\"submit\" id=\"button-submit\" name=\"button-submit\" value=\"boton SUBMIT\">Aceptar</button>\n" + 
				"            </div>\n" + 
				"        </fieldset>\n" + 
				"    </form>\n" + 
				"</body>\n" + 
				"</html>"
				);
		
		
		return docOut.toString();
		
	}
}

