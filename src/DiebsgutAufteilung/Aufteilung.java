package DiebsgutAufteilung;

import java.util.Random;

public class Aufteilung {
	static Diebsgueter initialDiebsgueter;
	
	static Verteilung besteVerteilung;
	
	public static void main(String[] args) {
		if (args.length >=1) {
            if (args[0].equals("generate")) {
            	XMLFiles generierteXMLFiles = new XMLFiles(1);
            	
            }
        }
	
		initialDiebsgueter = new Diebsgueter("coolediebsgueter4.xml");
		System.out.println("Diebsgutliste");
		initialDiebsgueter.printData();
		
		Verteilung initialVerteilung = new Verteilung();
		initialVerteilung.initialVerteilung(initialDiebsgueter);
		initialVerteilung.printRaeuber1();
		initialVerteilung.printRaeuber2();
		initialVerteilung.printDifference();
		
		besteVerteilung = initialVerteilung.kopiere();
		
		double temp = initialVerteilung.getDifference();
		double cooling = 0.0005;

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
	int count = 0;
		while ((temp > 1) && (count < 1000)) {
			Verteilung neueVerteilung = new Verteilung();
			neueVerteilung = alteVerteilung.kopiere();
			neueVerteilung.permutationVerteilung();
			System.out.println("neue Verteilung der Räuber");
			neueVerteilung.printRaeuber1();
			neueVerteilung.printRaeuber2();
			neueVerteilung.printDifference();
			
			if (neueVerteilung.getDifference() < besteVerteilung.getDifference()) {
				System.out.println("beste Verteilung akzeptiert");
				besteVerteilung = neueVerteilung.kopiere();
			}
			
			 // Decide if we should accept the neueVerteilung
			Random rd = new Random(); // creating Random object
			double rand = rd.nextDouble(); // creates random double between 0 and 1
			// keep neueVerteilung as alteVerteilung if the probability > the random double
            if (alteVerteilung.acceptanceProbability(neueVerteilung, temp) > rand) {
            	System.out.println("neue Verteilung akzeptiert");
                alteVerteilung = neueVerteilung.kopiere();
                // only decrease temp if neueVerteilung is taken
                temp *= (1-cooling);
			}
            count++;
		} 
		
		System.out.println("beste Verteilung");
		besteVerteilung.printRaeuber1();
		besteVerteilung.printRaeuber2();
		besteVerteilung.printDifference();
	
	}
	
	
}
