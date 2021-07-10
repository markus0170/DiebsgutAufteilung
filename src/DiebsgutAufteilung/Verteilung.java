package DiebsgutAufteilung;

import java.util.Random;

public class Verteilung {
	
	Raeuber raeuber1 = new Raeuber();
	Raeuber raeuber2 = new Raeuber(); 
	Double differenz = 0.0;
	

	public void initialVerteilung(Diebsgueter diebsgueter) {
		int i = 1;
		for (Diebsgut stueck: diebsgueter.getDiesbgueter()) {
			if ((i % 2) == 0) 
				raeuber2.add(stueck);
			else
				raeuber1.add(stueck);
			i++;
		}
		calculateDifference();
	}
	
	public void randomVerteilung(Diebsgueter diebsgueter) {
		
		for (Diebsgut stueck: diebsgueter.getDiesbgueter()) {
			Random rd = new Random(); // creating Random object
			if (rd.nextBoolean()) 
				raeuber2.add(stueck);
			else
				raeuber1.add(stueck);
			
		}
	}
	
	public Verteilung kopiere()
	{
		Verteilung neu = new Verteilung();
		neu.raeuber1 = this.raeuber1;
		neu.raeuber2 = this.raeuber2;
		neu.differenz = this.differenz;
		return neu;
		
	}
	
	public void printRaeuber1() {
		System.out.println("Räuber1");
		raeuber1.print();
		raeuber1.printWert();
	}
	
	public void printRaeuber2() {
		System.out.println("Räuber2");
		raeuber2.print();
		raeuber2.printWert();
	}
	
	public void calculateDifference() {
		differenz = raeuber1.getWert() - raeuber2.getWert();
		if (differenz < 0)
			differenz *= -1;
	}
	
	public void printDifference() {
		calculateDifference();
		System.out.println("Differenz:");
		System.out.println(differenz);
	}
	
	public Double getDifference() {
		return differenz;
	}
	
}
