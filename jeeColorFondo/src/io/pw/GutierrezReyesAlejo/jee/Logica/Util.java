package io.pw.GutierrezReyesAlejo.jee.Logica;

import javax.servlet.http.Cookie;

public class Util {
	public static String CookieValueOf(Cookie[] cookies, String attribute) {		
		Cookie cookieSelected = null;
		// Looking for color choosen
		if (cookies != null) {
			for (Cookie cookie: cookies) {
				if ( attribute.equals(cookie.getName() ) ) {
					cookieSelected = cookie;
					break;
				}
			}
			return cookieSelected.getValue();
		}
		return null;
		
	}
}
