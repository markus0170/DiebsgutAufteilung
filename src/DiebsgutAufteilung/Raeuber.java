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
	
	public void remove(Diebsgut diebsgut) {
		diebsgueter.remove(diebsgut);
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
	
	public int getSize() {
		return diebsgueter.size();
	}
	
	public Diebsgut getDiebsgut(int index) {
		return diebsgueter.get(index);
	}
	
	public Raeuber kopiere() {
		Raeuber neu = new Raeuber();
		neu.diebsgueter.addAll(this.diebsgueter);
		neu.wert = this.wert;
		
		return neu;		
	}

}
