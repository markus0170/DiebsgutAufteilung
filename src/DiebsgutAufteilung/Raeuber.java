package DiebsgutAufteilung;

import java.util.ArrayList;
import java.util.List;

public class Raeuber {
	
	List<Diebsgut> diebsgueter = new ArrayList<>();
	Double wert = 0.0;
	
	public void add(Diebsgut diebsgut) {
		diebsgueter.add(diebsgut);
		calculateWert();
	}
	
	public void print() {
		for (Diebsgut stueck: diebsgueter)
            System.out.println(stueck.toString());
	}
	
	public void printWert() {
		System.out.println(wert);
		
	}
	
	public Double getWert() {
		return wert;
	}
	
	public void calculateWert() {
		wert = 0.0;
		for (Diebsgut stueck: diebsgueter)
			wert += stueck.getWert();		
	}
	

}
