package DiebsgutAufteilung;

import java.util.Random;

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
		while ((temp > 1) && (count < 10000)) {
			Verteilung neueVerteilung = new Verteilung();
			neueVerteilung = alteVerteilung.kopiere();
			neueVerteilung.permutationVerteilung();
			if ((neueVerteilung.raeuber1.getWert() == alteVerteilung.raeuber1.getWert())
				&& (neueVerteilung.raeuber2.getWert() == alteVerteilung.raeuber2.getWert())) {
				System.out.println("Nix getauscht");
			}
			else {	
			System.out.println("neue Verteilung der Räuber");
			neueVerteilung.printRaeuber1();
			neueVerteilung.printRaeuber2();
			neueVerteilung.printDifference();
			
			if (neueVerteilung.getDifference() < besteVerteilung.getDifference())
				besteVerteilung = neueVerteilung.kopiere();
			
			 // Decide if we should accept the neighbour
			Random rd = new Random(); // creating Random object
			double rand = rd.nextDouble();
            if (alteVerteilung.acceptanceProbability(neueVerteilung, temp) < rand) {
            	System.out.println("neue Verteilung akzeptiert");
                alteVerteilung = neueVerteilung.kopiere();
                // only decrease temp if neueVerteilung is taken
                temp *= (1-cooling);
            }
			}
            count++;
		} 
		
		System.out.println("beste Verteilung");
		besteVerteilung.printRaeuber1();
		besteVerteilung.printRaeuber2();
		besteVerteilung.printDifference();
	
	}
	
	
}
