package io.pw.GutierrezReyesAlejo.jee.Logica;



import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class GeneradorHTML {
	private GeneradorHTML() {}
	
	public static String GenerarHTML(HttpServletRequest request) {
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
			"<h3> <a href=\".\"> * Inicio </a> </h3>" +
			"   <h1> --------- Bienvenido ------------ </h1>" +
			"</body>\n" + 
			"</html>"
			);			
				
		return docOut.toString();
	}	
}
