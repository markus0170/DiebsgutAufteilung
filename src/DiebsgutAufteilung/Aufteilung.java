package DiebsgutAufteilung;


public class Aufteilung {
	static Diebsgueter initialDiebsgueter;

	static Raeuber raeuber1 = new Raeuber();
	static Raeuber raeuber2 = new Raeuber();
	
	public static void main(String[] args) {

	
		initialDiebsgueter = new Diebsgueter("diebsgueter.xml");
		System.out.println("Diebsgutliste");
		initialDiebsgueter.printData();
		
		ersteVerteilung();
		System.out.println("Räuber1");
		raeuber1.print();
		System.out.println("Räuber2");
		raeuber2.print();

	}

	
	public static void ersteVerteilung() {

		int i = 1;
		for (Diebsgut stueck: initialDiebsgueter.getDiesbgueter()) {
			if ((i % 2) == 0) 
				raeuber2.add(stueck);
			else
				raeuber1.add(stueck);
			i++;
		}
	}
	
	
}
