package DiebsgutAufteilung;


public class Aufteilung {
	static Diebsgueter initialDiebsgueter;
	
	static Verteilung besteVerteilung;
	
	public static void main(String[] args) {

	
		initialDiebsgueter = new Diebsgueter("diebsgueter.xml");
		System.out.println("Diebsgutliste");
		initialDiebsgueter.printData();
		
		Verteilung initialVerteilung = new Verteilung(initialDiebsgueter);
		initialVerteilung.printRaeuber1();
		initialVerteilung.printRaeuber2();
		initialVerteilung.printDifference();
		
		besteVerteilung = initialVerteilung.kopiere();
		
	
	}
	
	
}
