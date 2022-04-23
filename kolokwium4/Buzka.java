import java.util.Objects;

public class Buzka implements PrzedstawiaEmocje, Skalowalny {
	char mouth;
	Buzka(char character) {
		this.mouth = character;
	}
	@Override
	public String toString() {
		return ":-" + this.mouth;
	}
	@Override
    public void draw() {            
    	System.out.println(this.toString());
    }
    @Override
    public void draw(int times) {
		System.out.print(toString());
		if (times > 1)
			System.out.print(")".repeat(times - 1));
		System.out.println();
	}
	@Override
	public int hashCode() {
		return Objects.hash(mouth);
	}
	@Override
	public boolean equals(Object obj) {
		return this.czySieUsmiecha() == ((Buzka) obj).czySieUsmiecha();
	}
	@Override
	public boolean czySieUsmiecha() {		
		return this.mouth == ')';
	}
	@Override
	public void przestanSieUsmiechac() {
		this.mouth = '(';
	}
}
    
