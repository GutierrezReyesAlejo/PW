package io.pw.GutierrezReyesAlejo.jee.Logica;


import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class DeString {

    private DeString() {}

    public static int aInt(String value) {
        int outValue = 0;
        try {
            outValue = Integer.parseInt(value);
        } catch (NumberFormatException ex) {
            outValue = 0;
        }
        return outValue;
    }

    public static int aInt(String value, int def) {
        int outValue = 0;
        try {
            outValue = Integer.parseInt(value);
        } catch (NumberFormatException ex) {
            outValue = def;
        }
        return outValue;
    }

    public static String aString(String value) {
        String defaultValue = "";
        if (value == null)
            return defaultValue;
        else
            return value;
    }

    public static char aChar(String valorEntrada, char inicio) {
        char valorSalida;
        try {
            valorSalida = valorEntrada.charAt(0);
        } catch (IllegalArgumentException e) {
            valorSalida = inicio;
        } catch (NullPointerException b) {
            valorSalida = inicio;
        }
        return valorSalida;
    }

    public static char aChar(String valorEntrada) {
        char valorSalida;
        valorSalida = valorEntrada.charAt(0);
        return valorSalida;
    }

    public static boolean aBoolean(String valorEntrada, boolean inicio) {
        boolean valorSalida;
        try {
            valorSalida = Boolean.valueOf(valorEntrada);
        } catch (IllegalArgumentException e) {
            valorSalida = false;
        } catch (NullPointerException b) {
            valorSalida = false;
        }
        return valorSalida;
    }

    public static boolean aBolean(String valorEntrada) {
        boolean valorSalida;
        valorSalida = Boolean.valueOf(valorEntrada);
        return valorSalida;
    }

    public static float aFloat(String valorEntrada, float inicio) {
        float valorSalida;
        try {
            valorSalida = Float.parseFloat(valorEntrada);
        } catch (NumberFormatException e) {
            valorSalida = inicio;
        }
        return valorSalida;
    }

    public static float aFloat(String valorEntrada) {
        float valorSalida;
        valorSalida = Float.parseFloat(valorEntrada);
        return valorSalida;
    }

    public static double aDouble(String valorEntrada, double inicio) {
        double valorSalida;
        try {
            valorSalida = Double.parseDouble(valorEntrada);
        } catch (NumberFormatException e) {
            valorSalida = inicio;
        }
        return valorSalida;
    }

    public static double aDouble(String valorEntrada) {
        double valorSalida;
        valorSalida = Double.parseDouble(valorEntrada);
        return valorSalida;
    }

    public static String aStringColor(String in) {
        if (in != null) {
        	// Color int int int
        	// 		 hex hex hex
        	//
        	Pattern p = Pattern.compile("(#[0-9a-fA-F]{6}$)") ;//|(#[0-9]{9})$
        	Matcher matcher = p.matcher(in);
        	boolean isColor = matcher.matches();
        	System.out.println(isColor);
        	if (isColor) {
        		return in; 
        	}        	
        }        	
        return "#ffffff";
    }

}
