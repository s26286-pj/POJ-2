import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		MaWlasnosciRownolegloboku prostokat1x1 = new Prostokat(1, 1);
		Prostokat prostokat1x2 = new Prostokat(1, 2);

		MaWlasnosciRownolegloboku kwadrat1x1 = new Kwadrat(1);
		Prostokat kwadrat2x2 = new Kwadrat(2, 2);

		MaWlasnosciRownolegloboku kwadrat1x1inline = new MaWlasnosciRownolegloboku() {
			@Override
			public double podstawa() {
				return 1;
			}

			@Override
			public double katNachylenia() {
				return Math.PI / 2;
			}

			@Override
			public double bok() {
				return 1;
			}
		};
		MaWlasnosciRownolegloboku romb1x1inline = new MoznaWyznaczycPrzekatna() {

			@Override
			public double podstawa() {
				return 1;
			}

			@Override
			public double katNachylenia() {
				return Math.PI / 6;
			}

			@Override
			public double bok() {
				return 1;
			}

			@Override
			public double przekatna() {
				return Math.sqrt((bok() * bok()) + (2. * bok() * podstawa() * Math.cos(katNachylenia()))
						+ (podstawa() * podstawa()));
			}

		};
		MaWlasnosciRownolegloboku prostokat1x2inline = new MoznaWyznaczycWysokosc() {

			@Override
			public double wysokosc() {
				return bok();
			}

			@Override
			public double podstawa() {
				return 1;
			}

			@Override
			public double katNachylenia() {
				return Math.PI / 2;
			}

			@Override
			public double bok() {
				return 2;
			}
		};

		int poprawnie = 0;

		// podtawowe testy
		if (kwadrat1x1.bok() == kwadrat1x1.podstawa())
			System.out.println("TEST 1 To powinno sie drukowac. Poprawnych " + ++poprawnie);
		if (kwadrat1x1.katNachylenia() == Math.PI / 2) // kat nachylenia == 90st. == pi/2 rad
			System.out.println("TEST 2 To powinno sie drukowac. Poprawnych " + ++poprawnie);
		if (prostokat1x2.katNachylenia() == kwadrat2x2.katNachylenia())
			System.out.println("TEST 3 To powinno sie drukowac. Poprawnych " + ++poprawnie);
		if (kwadrat1x1.katNachylenia() != romb1x1inline.katNachylenia())
			System.out.println("TEST 4 To powinno sie drukowac. Poprawnych " + ++poprawnie);

		// liczenie własności równoległoboków
		if (((MoznaWyznaczycPrzekatna) prostokat1x2).przekatna() == Math.sqrt((1 * 1) + (2 * 2)))
			System.out.println("TEST 5 To powinno sie drukowac. Poprawnych " + ++poprawnie);
		if (((MoznaWyznaczycPrzekatna) prostokat1x1).przekatna() == Math.sqrt(2))
			System.out.println("TEST 6 To powinno sie drukowac. Poprawnych " + ++poprawnie);
		if (((MoznaWyznaczycPrzekatna) kwadrat2x2).przekatna() == 2 * Math.sqrt(2))
			System.out.println("TEST 7 To powinno sie drukowac. Poprawnych " + ++poprawnie);
		if (((MoznaWyznaczycWysokosc) kwadrat2x2).wysokosc() == kwadrat2x2.bok())
			System.out.println("TEST 8 To powinno sie drukowac. Poprawnych " + ++poprawnie);
		if (((MoznaWyznaczycWysokosc) prostokat1x2).wysokosc() == prostokat1x2.bok())
			System.out.println("TEST 9 To powinno sie drukowac. Poprawnych " + ++poprawnie);
		if (((MoznaWyznaczycPrzekatna) romb1x1inline).przekatna() != ((MoznaWyznaczycPrzekatna) prostokat1x1)
				.przekatna())
			System.out.println("TEST 10 To powinno sie drukowac. Poprawnych " + ++poprawnie);
		if (prostokat1x1.katNachylenia() == Math.PI / 2)
			System.out.println("TEST 11 To powinno sie drukowac. Poprawnych " + ++poprawnie);
		double najdluzszaPrzekatna = 0;
		for (MaWlasnosciRownolegloboku rownoleglobok : List.of(prostokat1x1, kwadrat1x1, romb1x1inline, kwadrat2x2,
				prostokat1x2)) {
			MoznaWyznaczycPrzekatna zcastowany = (MoznaWyznaczycPrzekatna) rownoleglobok;
			if (zcastowany.przekatna() > najdluzszaPrzekatna)
				najdluzszaPrzekatna = zcastowany.przekatna();
		}
		if (najdluzszaPrzekatna == ((MoznaWyznaczycPrzekatna) kwadrat2x2).przekatna())
			System.out.println("TEST 12 To powinno sie drukowac. Poprawnych " + ++poprawnie);

		// zaleznosci w dziedziczeniu
		if (((MaWlasnosciRownolegloboku) ((MoznaWyznaczycWielokrotnoscPrzekatnej) ((MoznaWyznaczycPrzekatna) ((Prostokat) kwadrat1x1))))
				.podstawa() > 0)
			System.out.println("TEST 13 To powinno sie drukowac. Poprawnych " + ++poprawnie);
		if (Prostokat.class.getInterfaces().length > 1)
			System.out.println("TEST 14 To powinno sie drukowac. Poprawnych " + ++poprawnie);

		// przeciążanie metod
		if (((MoznaWyznaczycWielokrotnoscPrzekatnej) prostokat1x2).wielokrotnoscPrzekatnej(1.) == Math
				.sqrt((1 * 1) + (2 * 2)))
			System.out.println("TEST 15 To powinno sie drukowac. Poprawnych " + ++poprawnie);
		if (((MoznaWyznaczycWielokrotnoscPrzekatnej) prostokat1x1).wielokrotnoscPrzekatnej(1.) == Math.sqrt(2))
			System.out.println("TEST 16 To powinno sie drukowac. Poprawnych " + ++poprawnie);
		if (((MoznaWyznaczycWielokrotnoscPrzekatnej) kwadrat2x2).wielokrotnoscPrzekatnej(.5) == Math.sqrt(2))
			System.out.println("TEST 17 To powinno sie drukowac. Poprawnych " + ++poprawnie);
		if (((MoznaWyznaczycWielokrotnoscPrzekatnej) prostokat1x2)
				.wielokrotnoscPrzekatnej(1) == (int) Math.sqrt((1 * 1) + (2 * 2)))
			System.out.println("TEST 18 To powinno sie drukowac. Poprawnych " + ++poprawnie);
		if (((MoznaWyznaczycWielokrotnoscPrzekatnej) prostokat1x1).wielokrotnoscPrzekatnej(1) == (int) Math.sqrt(2))
			System.out.println("TEST 19 To powinno sie drukowac. Poprawnych " + ++poprawnie);
		if (((MoznaWyznaczycWielokrotnoscPrzekatnej) kwadrat2x2).wielokrotnoscPrzekatnej(1) == 2 * (int) Math.sqrt(2))
			System.out.println("TEST 20 To powinno sie drukowac. Poprawnych " + ++poprawnie);

		// nadpisanie toString
		if (kwadrat1x1.toString().equals("kwadrat"))
			System.out.println("TEST 21 To powinno sie drukowac. Poprawnych " + ++poprawnie);
		if (prostokat1x1.toString().equals("prostokat"))
			System.out.println("TEST 22 To powinno sie drukowac. Poprawnych " + ++poprawnie);
		if ((prostokat1x1 + "ny").length() == 11)
			System.out.println("TEST 23 To powinno sie drukowac. Poprawnych " + ++poprawnie);
		if (!("" + kwadrat1x1).equals("" + prostokat1x1))
			System.out.println("TEST 24 To powinno sie drukowac. Poprawnych " + ++poprawnie);

		// equals i hashcode
		if (!kwadrat2x2.equals(prostokat1x1))
			System.out.println("TEST 25 To powinno sie drukowac. Poprawnych " + ++poprawnie);
		if (prostokat1x1.equals(kwadrat1x1))
			// powinniśmy być w stanie porównać dwie klasy implementujące
			// MaWlasnosciRownolegloboku
			System.out.println("TEST 26 To powinno sie drukowac. Poprawnych " + ++poprawnie);
		if (prostokat1x1.equals(kwadrat1x1inline))
			System.out.println("TEST 27 To powinno sie drukowac. Poprawnych " + ++poprawnie);
		if (!kwadrat1x1inline.equals(prostokat1x1))
			System.out.println("TEST 28 To powinno sie drukowac. Poprawnych " + ++poprawnie);
		if (prostokat1x2.equals(prostokat1x2inline))
			System.out.println("TEST 29 To powinno sie drukowac. Poprawnych " + ++poprawnie);
		if (!prostokat1x1.equals(romb1x1inline)) // kopnięty prostokąt to nie prostokąt
			System.out.println("TEST 30 To powinno sie drukowac. Poprawnych " + ++poprawnie);
		if (!kwadrat2x2.equals(romb1x1inline)) 
			System.out.println("TEST 31 To powinno sie drukowac. Poprawnych " + ++poprawnie);
		ArrayList lista1 = new ArrayList();
		lista1.add((Prostokat) kwadrat2x2);
		lista1.add((Prostokat) prostokat1x1);
		lista1.add((Prostokat) kwadrat1x1);
		lista1.remove(kwadrat1x1);
		if (lista1.contains(kwadrat1x1))
			System.out.println("TEST 32 To powinno sie drukowac. Poprawnych " + ++poprawnie);

		System.out.println("Testy przeszły " + poprawnie + "/32");

	}

}
