import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HelloWorld {

	public static int readNumber() {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		try {
			return Integer.valueOf(buffer.readLine());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}

	static class zutat {
		final static double REFERNZ_GEWICHT=1000;
		final double amountPerKg;
		final String name;
		final boolean round;
		final String unit;

		public zutat(double amountPerKg, String name, boolean round) {
			this.amountPerKg = amountPerKg;
			this.name = name;
			this.round = round;
			this.unit = "g";
			
		}

		public zutat(double amountPerKg, String name, boolean round, String unit) {
			super();
			this.amountPerKg = amountPerKg;
			this.name = name;
			this.round = round;
			this.unit = unit;
		}
		
		
		public zutat(double amountPerKg, String name) {
			this.amountPerKg = amountPerKg;
			this.name = name;
			this.round = false;
			this.unit = "g";
		}

		double amountPer(double weightInGramms) {
			// TODO calculate
			if (round) {
				return Math.floor(amountPerKg / REFERNZ_GEWICHT * weightInGramms);
			}

			return amountPerKg / REFERNZ_GEWICHT * weightInGramms;
		}

		void zutatPrettyPrint(double weightInGramms) {
			System.out.printf("%-10s %6.1f %4s\n", this.name, amountPer(weightInGramms), this.unit);
		}
	}

	public static void main(String[] args) {
		System.out.println("Kuchenrchner");
		System.out.println("Bitte Anzahl zu erwartenden Gästen eingeben: ");

		int kuchenGewichtProPerson = 60;
		int anzahlPersonen = readNumber();
		int kuchenGewicht = kuchenGewichtProPerson * anzahlPersonen;
		System.out.println("Kuchengewicht für " + anzahlPersonen + " Personen: " + kuchenGewicht + " Gramm");

		
		// Zutaten berechnen

		zutat[] zutatenFuerKuchen = new zutat[] { new zutat(250, "Butter"), new zutat(250, "Zucker"),
				new zutat(4, "Eier", true,"Stk"), new zutat(500, "Mehl"), new zutat(0.125, "Milch",false,"l"),
				new zutat(1, "Backpulver",false,"pk") };

//		double butter,zucker, mehl,milch,backpulver, eier;
//		butter= 250/referenzKuchenGewicht;
//		zucker=250/referenzKuchenGewicht;
//		mehl=500/referenzKuchenGewicht;
//		milch=0.125/referenzKuchenGewicht;
//		backpulver=16.5/referenzKuchenGewicht;
//		eier= 4/referenzKuchenGewicht;

//		double totalButter= butter*kuchenGewicht;
//		double totalZucker= zucker*kuchenGewicht;
//		int totalEier= (int) (eier*kuchenGewicht)+1;
//		double totalMehl=mehl*kuchenGewicht;
//		double totalMilch= milch*kuchenGewicht;
//		double totalBackpulver= backpulver*kuchenGewicht;

		System.out.printf("Einkaufliste\n");
		System.out.printf("============\n");

		for (zutat z : zutatenFuerKuchen) {
			z.zutatPrettyPrint(kuchenGewicht);

		}

//		System.out.printf("%-10s %6.1f\n", "Butter", totalButter);
//		System.out.printf("%-10s %6.1f\n", "Zucker", totalZucker);
//		System.out.printf("%-10s %6d\n", "Eier", totalEier);
//		System.out.printf("%-10s %6.1f\n", "Milch", totalMilch);
//		System.out.printf("%-10s %6.1f\n", "Mehl", totalMehl);
//		System.out.printf("%-10s %6.1f\n", "Backpulver", totalBackpulver);

//		System.out.println("Butter: "+butter+"g,"
//				+ " Zucker: "+zucker
//				+" g, Eier: "+eierAnzahl
//				+", Mehl: "+mehl
//				+"g, Milch: "+milch
//				+"l, Backpulver: "+backpulver+"g." );
//		
//		//*************************************************
//		
//		System.out.println("Wieviele Personen kommen zu Besuch?");
//		int personen=readNumber();
//		System.out.println("Eingabe: "+personen);
//		kuchenGewicht=personen*kuchenGewichtProPerson;
//		butter= 250*kuchenGewicht/1000;
//		zucker=250*kuchenGewicht/1000;
//		mehl=500*kuchenGewicht/1000;
//		milch=0.125*kuchenGewicht/1000;
//		backpulver=16.5*kuchenGewicht/1000;
//		eierAnzahl= (int)(4*kuchenGewicht/1000);
//		
//		System.out.println("Die Einkaufliste:");
//		System.out.println("Butter: "+butter+"g,"
//				+ " Zucker: "+zucker
//				+" g, Eier: "+eierAnzahl
//				+", Mehl: "+mehl
//				+"g, Milch: "+milch
//				+"l, Backpulver: "+backpulver+"g." );
//		
//		
//		
//		
	}

}
