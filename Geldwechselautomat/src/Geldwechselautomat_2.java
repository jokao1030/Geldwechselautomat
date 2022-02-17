/*
 * Aufgabe: Ein Algorithm für Geldwechselautomat, Betrag x -> Kleingeld
 *          Möglichst wenig Münzen
 * @author Chin-Wen, Kao
 * @version 2.0
 * @since 17.02.2022
 * */

import java.math.*;

class Geldwechselautomat_2{
	  public static void main(String args[]) {
		  geldwechseln("100.67");
		  geldwechseln("4.36");
		  geldwechseln("0.90");
		  geldwechseln("17.11");
		  geldwechseln("1625.89");
	  }
	  
	  public static void geldwechseln(String betrag) {
		     BigDecimal[] muenzetypen = {new BigDecimal(Double.toString(2.0)) 
		    		 ,new BigDecimal(Double.toString(1.0)) ,new BigDecimal(Double.toString(0.5))
		    		 ,new BigDecimal(Double.toString(0.2)) ,new BigDecimal(Double.toString(0.1)) 
		    		 ,new BigDecimal(Double.toString(0.05)) ,new BigDecimal(Double.toString(0.02))
		    		 ,new BigDecimal(Double.toString(0.01))};
		    		
		     if(Double.parseDouble(betrag) > 0.0) {
		    	 BigDecimal b = new BigDecimal(betrag);
		    	 for(int i = 0; i < muenzetypen.length; i++ ) {
		    		 int anzahl = 0;
		    		 while(b.compareTo(muenzetypen[i]) >=0) {
		    			   anzahl = b.divide(muenzetypen[i]).intValue();
		    			   b = b.divideAndRemainder(muenzetypen[i])[1];
		    		 }
		    		 if(anzahl!=0) {
		    		    System.out.print(" " + anzahl + "x" + muenzetypen[i] + "Euro");
		    		 }
		    	 }
		    	 System.out.print("\n");
		    		 
		     }else {
		    	 System.out.println("Kein gueltiger Betrag !");
		     }
		  
	  }
}