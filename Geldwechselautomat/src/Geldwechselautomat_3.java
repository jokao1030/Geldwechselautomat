/*
 * Aufgabe: Ein Algorithm für Geldwechselautomat, Betrag x -> Kleingeld
 *          Möglichst wenig Münzen
 * @author Chin-Wen, Kao
 * @version 3.0
 * @since 17.02.2022
 * */
 
import java.math.*;
import java.util.ArrayList;
import java.util.List;

class Geldwechselautomat_3{
	  
	  public static void main(String args[]) {
		  //Testen mit bsp. Eingaben
		  geldwechseln("21,9");
		  geldwechseln("2,93");
		  geldwechseln("0,53");
		  geldwechseln("1,32");
		  geldwechseln("72,50");
		  geldwechseln("0,990");
		  geldwechseln("123,78");
		  geldwechseln(" ");
		  geldwechseln("!");
		  geldwechseln("10283,91");
	  }
	  //Hilfsfunktion:Ersetzen Komma mit Punkt
	  private static String kommazupunkt(String nummer) {
		  if(nummer.indexOf(",")!=-1) { 
			  nummer = nummer.replaceAll(",","."); 
		  }
		  return nummer;
	  }
	  //Hilfsfunktion:Ersetzen Punkt mit Komma
	  private static String punktzukomma(String nummer) {
		  if(nummer.indexOf(".")!=-1) { 
			  nummer = nummer.replaceAll("\\.",","); 
		  }
		  return nummer;
	  }
	  //Hilfsfunktion:Prüfen,ob die Eingabe eine Zahl ist
	  private static boolean isNumeric(String betrag) {
		    if (betrag == null) {//Erst prüfen, ob das NULL ist
		        return false;
		    }
		    try {
		        double d = Double.parseDouble(betrag);
		    } catch (NumberFormatException e) {
		        return false;
		    }
		    return true;
	  }
	  
	  public static void geldwechseln(String betrag) {
		     
		     //Hier kann man andere Kombination von Muenzetypen haben wenn man andere Währungen benutzen wollte
		     BigDecimal[] muenzetypen = {new BigDecimal(Double.toString(2.0)) 
		    		 ,new BigDecimal(Double.toString(1.0)) ,new BigDecimal(Double.toString(0.5))
		    		 ,new BigDecimal(Double.toString(0.2)) ,new BigDecimal(Double.toString(0.1)) 
		    		 ,new BigDecimal(Double.toString(0.05)) ,new BigDecimal(Double.toString(0.02))
		    		 ,new BigDecimal(Double.toString(0.01))};
		     List<String> ausgaben = new ArrayList<String>();
		     if( isNumeric(kommazupunkt(betrag)) && Double.parseDouble(kommazupunkt(betrag)) > 0.0) {
		    	 BigDecimal b = new BigDecimal(kommazupunkt(betrag));
		    	 for(int i = 0; i < muenzetypen.length; i++ ) {
		    		 int anzahl = 0;
		    		 while(b.compareTo(muenzetypen[i]) >=0) {
		    			   anzahl = b.divide(muenzetypen[i]).intValue();
		    			   b = b.divideAndRemainder(muenzetypen[i])[1];
		    		 }
		    		 if(anzahl!=0) {
		    		    String zukomma = punktzukomma(muenzetypen[i].toString());
		    		    ausgaben.add(anzahl + "x" + zukomma);
		    		 }
		    	 }
		    	 System.out.print(betrag + "€ kann man zu: ");
		    	 for(int i=0; i<ausgaben.size();i++) {
			    	 
			    	 if(i<ausgaben.size()-1) {
			    		 System.out.print(" " + ausgaben.get(i) + "€,");//Kann man hier auch andere Währungen benutzen
			    	 }else {
			    		 System.out.print(" " + ausgaben.get(i) + "€ wechseln." + "\n");
			    	 }
			     }	 
		     }else {
		    	 System.out.println("Kein gültiger Betrag !");
		     }
		     

	  }
}