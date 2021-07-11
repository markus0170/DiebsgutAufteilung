package DiebsgutAufteilung;


public class Aufteilung {
	static Diebsgueter initialDiebsgueter;
	
	static Verteilung besteVerteilung;
	
	public static void main(String[] args) {

	
		initialDiebsgueter = new Diebsgueter("diebsgueter.xml");
		System.out.println("Diebsgutliste");
		initialDiebsgueter.printData();
		
		Verteilung initialVerteilung = new Verteilung();
		initialVerteilung.initialVerteilung(initialDiebsgueter);
		initialVerteilung.printRaeuber1();
		initialVerteilung.printRaeuber2();
		initialVerteilung.printDifference();
		
		besteVerteilung = initialVerteilung.kopiere();
		
		double temp = 1000.0;
		double cooling = 0.5;

// mit zufaelliger veraenderung		
/*		while (temp > 1) {
			Verteilung neueVerteilung = new Verteilung();
			neueVerteilung.randomVerteilung(initialDiebsgueter);
			System.out.println("neue Verteilung");
			neueVerteilung.printRaeuber1();
			neueVerteilung.printRaeuber2();
			neueVerteilung.printDifference();
			
			if (neueVerteilung.getDifference() < besteVerteilung.getDifference())
				besteVerteilung = neueVerteilung.kopiere();
			
			temp -= cooling;
		} */
		
// mit Permutation von der letzten verteilung
	Verteilung alteVerteilung = besteVerteilung.kopiere();
		while (temp > 1) {
			Verteilung neueVerteilung = new Verteilung();
			neueVerteilung = alteVerteilung.kopiere();
			neueVerteilung.permutationVerteilung();
			System.out.println("neue Verteilung");
			neueVerteilung.printRaeuber1();
			neueVerteilung.printRaeuber2();
			neueVerteilung.printDifference();
			
			if (neueVerteilung.getDifference() < besteVerteilung.getDifference())
				besteVerteilung = neueVerteilung.kopiere();
			
			temp -= cooling;
			alteVerteilung = neueVerteilung.kopiere();
		} 
		
		System.out.println("beste Verteilung");
		besteVerteilung.printRaeuber1();
		besteVerteilung.printRaeuber2();
		besteVerteilung.printDifference();
	
	}
	
	
}
