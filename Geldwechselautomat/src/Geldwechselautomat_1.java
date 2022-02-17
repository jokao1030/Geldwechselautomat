/*
 * Aufgabe: Ein Algorithm für Geldwechselautomat, Betrag x -> Kleingeld
 *          Möglichst wenig Münzen
 * @author Chin-Wen, Kao
 * @version 1.0
 * @since 17.02.2022
 * */
class Geldwechselautomat_1{
	  public static void main(String args[]) {
		  geldwechseln(100.67);
		  geldwechseln(4.36);
		  geldwechseln(0.90);
		  geldwechseln(17.11);
		  geldwechseln(1625.89);
	  }
	  
	  public static void geldwechseln(double betrag) {
		     int[] muenzetypenincent = { 200 , 100 , 50 , 20 , 10 , 5 , 2 , 1};
		     double[] muenzetypen = {2.0, 1.0 , 0.5 , 0.20 , 0.10 , 0.05 , 0.02 , 0.01};
		     if(betrag > 0) {
		    	 System.out.print("Betrag " + betrag + " Euro kann man wechseln zu:");
		    	 int betragincent = (int)(betrag*100);
		    	 
		    	 for(int i = 0; i < muenzetypenincent.length; i++ ) {
		    		 int anzahl = 0;
		    		 while(betragincent >= muenzetypenincent[i]) {
		    			   anzahl = (int)betragincent/muenzetypenincent[i];
		    			   betragincent = betragincent%muenzetypenincent[i];
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