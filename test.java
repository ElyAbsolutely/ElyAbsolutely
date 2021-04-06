import java.util.Scanner;

public class test {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        Nopat nopat = new Nopat();
        Pelaaja x = new Pelaaja("Tony");
        int[] tulos = new int[2];
        int luku = 3;
        while (luku > 0) {
            tulos = nopat.autoRun(lukija, x);
            luku--;
            if (tulos[0] == -2) {
                continue;
            }
            x.lisaaPisteita(tulos[0], tulos[1]);
            System.out.println("Yhdistelmä: " + tulos[0] + " ja pisteet: " + tulos[1]);
        }
        lukija.close();
    }
}
