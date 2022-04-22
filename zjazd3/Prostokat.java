import java.util.Objects;

public class Prostokat implements MoznaWyznaczycWielokrotnoscPrzekatnej, MoznaWyznaczycWysokosc {
	float a;
	float b;
	public Prostokat(float a, float b) {
		this.a = a;
		this.b = b;
	}
	@Override
	public double podstawa() {
		return a;
	}
	@Override
	public double katNachylenia() {
		return Math.PI / 2;
	}
	@Override
	public double bok() {
		return b;
	}
	@Override
	public double wysokosc() {
		return bok();
	}
	@Override
	public double przekatna() {
		return Math.sqrt((bok() * bok()) + (2. * bok() * podstawa() * Math.cos(katNachylenia()))
				+ (podstawa() * podstawa()));
	}
	@Override
	public double wielokrotnoscPrzekatnej(double multiply) {
		return Math.sqrt((this.a * this.a) + (this.b * this.b)) * multiply;
	}
	@Override
	public int wielokrotnoscPrzekatnej(int multiply) {
		return (int) (Math.sqrt((this.a * this.a) + (this.b * this.b)) * multiply);
	}
	@Override
	public String toString() {
		return "prostokat";
	}
	@Override
	public int hashCode() {
		return Objects.hash(a, b);
	}
	@Override
	public boolean equals(Object obj) {
		return this.podstawa() == ((MaWlasnosciRownolegloboku) obj).podstawa()
				&& this.bok() == ((MaWlasnosciRownolegloboku) obj).bok()
				&& this.katNachylenia() == ((MaWlasnosciRownolegloboku) obj).katNachylenia();
	}
}
