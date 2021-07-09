package DiebsgutAufteilung;




public class Diebsgut {
	
	private String diebsgutName;
	private Double wert;
	
	Diebsgut(String name, Double wert) {
		diebsgutName = name;
		this.wert = wert;

    }
	@Override
    public String toString() {
        return "[" + diebsgutName + ", "+ wert + "]";
    }
	
	public Double getWert() {
		return this.wert;
	}
		
}
