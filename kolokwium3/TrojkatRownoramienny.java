import java.util.Objects;

public class TrojkatRownoramienny {
	double podstawa = 0.0;
	double ramie = 0.0;
	public TrojkatRownoramienny(double podstawa, double ramie) {
		this.podstawa = podstawa;
		this.ramie = ramie;
	}
	
	public double wysokosc() {
		return Math.sqrt((this.ramie * this.ramie) - (this.podstawa * this.podstawa / 4.));
	}
	
	public double wysokosc(double wys) {
		return wys * Math.sqrt((this.ramie * this.ramie) - (this.podstawa * this.podstawa / 4.));
	}
	
	public int wysokosc(int wys) {
		return (int) (wys * Math.sqrt((this.ramie * this.ramie) - (this.podstawa * this.podstawa / 4.)));
	}

	@Override
	public int hashCode() {
		return Objects.hash(podstawa, ramie);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TrojkatRownoramienny other = (TrojkatRownoramienny) obj;
		return Double.doubleToLongBits(podstawa) == Double.doubleToLongBits(other.podstawa)
				&& Double.doubleToLongBits(ramie) == Double.doubleToLongBits(other.ramie);
	}
}
