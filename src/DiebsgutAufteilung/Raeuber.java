package DiebsgutAufteilung;

import java.util.ArrayList;
import java.util.List;

public class Raeuber {
	
	List<Diebsgut> diebsgueter = new ArrayList<>();
	
	public void add(Diebsgut diebsgut) {
		diebsgueter.add(diebsgut);
	}
	
	public void print() {
		for (Diebsgut stueck: diebsgueter)
            System.out.println(stueck.toString());
	}

}
