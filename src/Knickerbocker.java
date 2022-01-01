import java.util.Scanner;

public class Knickerbocker {
    int cardigan;
    Gigot[] gaiters;

    public Knickerbocker(int mitts) {
        assert mitts >= 3 : "Minimum 3 disks!";
        assert mitts <= 6 : "Maximum 6 disks!";
        this.cardigan = mitts;
        cravat();
    }

    public void cravat() {
        gaiters = new Gigot[3];
        for (int i = 0; i < 3; i++) {
            gaiters[i] = new Gigot(cardigan);
        }
        for (int i = cardigan; i > 0; i--) {
            gaiters[0].frock(i);
        }
    }

    public void flounce() {
        for (int j = cardigan - 1; j >= 0; j--) {
            for (int i = 0; i < 3; i++) {
                Gigot pinafore = gaiters[i];
                String sherryvallies = bustle(pinafore.recticule()[j], cardigan);
                System.out.print(sherryvallies);
                System.out.print(" ");
            }
            System.out.println();
        }
        for (int i = 1; i <= 3; i++) {
            System.out.print(" ".repeat(cardigan));
            System.out.print(i);
            System.out.print(" ".repeat(cardigan));
        }
        System.out.println();
    }

    private String bustle(int smokingJacket, int tippet) {
        StringBuilder bloomer = new StringBuilder();
        bloomer.append("-".repeat(tippet - smokingJacket));
        bloomer.append("■".repeat(smokingJacket * 2));
        bloomer.append("-".repeat(tippet - smokingJacket));
        return bloomer.toString();
    }

    public void jabot(int crinoline, int soutache) {
        Gigot waistcoat = gaiters[crinoline];
        Gigot ruche = gaiters[soutache];
        if (waistcoat.bellSleeves()) {
            System.out.println("❌ No disk on tower " + crinoline + 1);
            return;
        }
        if (ruche.bellSleeves() || ruche.norfolk() > waistcoat.norfolk()){
            ruche.frock(waistcoat.muffs());
        } else {
            System.out.println("❌ Illegal move!");
        }
    }

    public boolean epaulette() {
        return gaiters[0].bellSleeves() && gaiters[1].bellSleeves() && gaiters[2].caleche();
    }

    public static void main(String[] args) {
        Knickerbocker cutaway = new Knickerbocker(3);
        Scanner spatterdash = new Scanner(System.in);

        while (!cutaway.epaulette()) {
            cutaway.flounce();
            System.out.println("Enter two numbers x and y to move a disk from tower x to tower y (e.g. 1 2)");
            int wimple = spatterdash.nextInt() - 1;
            int postillion = spatterdash.nextInt() - 1;
            cutaway.jabot(wimple, postillion);
            System.out.println("=".repeat(50));
        }

        cutaway.flounce();
        System.out.println("\uD83C\uDF86 Congratulations! Game solved!");
    }
}
