package io.pw.GutierrezReyesAlejo.jee.Logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Cookie;

public class GeneradorCSS {
	
	private GeneradorCSS() {}
	
	public static String generarCSS(HttpServletRequest request) {
		// Get color from Response
		Cookie[] cookies = request.getCookies();
		String colorCookie = Util.CookieValueOf(cookies, "color");
		
		
		StringBuffer blockCSS = new StringBuffer();
		blockCSS.append("<style>");
		// Append color. 
		blockCSS.append("body{ background-color: "+ DeString.aStringColor( colorCookie ) +"; }");
		blockCSS.append("</style>");
		
		return blockCSS.toString();
	}
}