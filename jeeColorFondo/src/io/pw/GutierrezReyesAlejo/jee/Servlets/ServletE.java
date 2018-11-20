package io.pw.GutierrezReyesAlejo.jee.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.pw.GutierrezReyesAlejo.jee.Logica.GeneradorHTML;

@WebServlet(
		urlPatterns = {
			"/ServletE",
			"/servletE"
		}
	)
	public class ServletE extends HttpServlet {
    
    public ServletE() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// -----------------<Settings>----------------------
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		// ----------------.<Reload Page>--------------------
		String docHTML = GeneradorHTML.GenerarHTML(request);
		PrintWriter salida = response.getWriter();
		salida.println(docHTML);
	}

}

