import java.util.Random;
import java.util.Scanner;
import java.util.Collections;
import java.util.Arrays;
import java.util.ArrayList;

public class Nopat {

    int[] nopat;
    int[] tulos;
    int vuorot;

    public Nopat() {
        this.nopat = new int[5];
        this.tulos = new int[2];
    }

    public void tulostaNopat() { // Optimoitu tapa tulostaa nopat
        System.out.println("\n1: " + nopat[0]);
        System.out.println("2: " + nopat[1]);
        System.out.println("3: " + nopat[2]);
        System.out.println("4: " + nopat[3]);
        System.out.println("5: " + nopat[4]);
    }

    public int[] palautaTulos() { // Palauttaa pisteet ja yhdistelmän
        return tulos;
    }

    public int[] palautaNopat() { // Palauttaa nopat
        return nopat;
    }

    public int[] jarjesta(int[] luvut) { // Järjestää nopat yhdistelmä-valikkoa varten
        Arrays.sort(luvut);
        return luvut;
    } // !!! Älä järjestä this.nopat !!!

    public boolean tarkista(Pelaaja x, int indeksi) { // Tarkistaa käytetyt yhdistelmät
        return !(x.onkoTaytetty(indeksi));
    }

    public int[] autoRun(Scanner lukija, Pelaaja x) { // Kopioi tai käytä tätä metodia nopan heittoon
        nollaa();
        heitaNoppa();
        while (tulos[0] != -2) {
            if (tulos[0] == -1) {
                int vastaus = vastaaja(lukija);
                switch (vastaus) {
                case 1:
                    uudelleenHeitto(lukija);
                    break;
                case 2:
                    noppienTulos(lukija, x);
                    break;
                }
            } else {
                return tulos;
            }
        }
        tulos[0] = -2;
        return tulos;
    }

    public void nollaa() { // Nollaa kaiken
        tulos[0] = -1;
        tulos[1] = 0;
        vuorot = 2;
    }

    public void heitaNoppa() { // Heittää kaikki nopat
        System.out.println("\nHeitetään 5 noppaa...");
        uusiHeitto(1);
        uusiHeitto(2);
        uusiHeitto(3);
        uusiHeitto(4);
        uusiHeitto(5);
    }

    public void uusiHeitto(int noppa) { // Heittää uudestaan pelaajan valitseman nopan
        Random random = new Random();
        switch (noppa) {
        case 1:
            nopat[0] = 1 + random.nextInt(6);
            break;
        case 2:
            nopat[1] = 1 + random.nextInt(6);
            break;
        case 3:
            nopat[2] = 1 + random.nextInt(6);
            break;
        case 4:
            nopat[3] = 1 + random.nextInt(6);
            break;
        case 5:
            nopat[4] = 1 + random.nextInt(6);
            break;
        default:
            break;
        }
    }

    public int vastaaja(Scanner lukija) { // Pelaaja valitsee mitä hän tekee tästä
        tulostaNopat();
        while (vuorot != 0) {
            System.out.println("\nUudelleen-heitto vuoroja: " + vuorot);
            System.out.println(
                    "\n1 = heittää uuestaan pelaajan valitsemat nopat\n3 = tarkistaa avoimet noppa yhistelmät\n");
            String vastaus = lukija.nextLine();

            if (vastaus.equals("1")) {
                return 1;
            } else if (vastaus.equals("3")) {
                return 2;
            } else {
                System.out.print("Virheellinen komento...   ");
            }
        }
        System.out.println("\nSinulla ei ole enään vuoroja");
        return 2;
    }

    public void uudelleenHeitto(Scanner lukija) { // Pelaaja valitsee mitkä nopat haluaa heittää

        int uusi01 = 0;
        int heitto01 = 0;
        int heitto02 = 0;
        int heitto03 = 0;
        int heitto04 = 0;

        vuorot--;

        System.out.println(
                "\nMitkä nopat haluat heittää?\n\nValitse 1-5 välillä!\n7 = heittää valitut nopat\n9 = heittää kaikki nopat\nHUOM! valitse yksi kerrallaan\n");
        while (true) {
            tulostaNopat();
            System.out.println("Valitse noppa...\n");
            uusi01 = Integer.valueOf(lukija.nextLine());

            if (uusi01 == 9) {
                break;
            } else if (uusi01 < 6 && uusi01 > 0) {
                heitto01 = uusi01;
                break;
            } else if (uusi01 == 7) {
                System.out.print("Valitse noppa, jonka haluat heittää...   ");
            } else {
                System.out.print("Virheellinen luku...   ");
            }
        }

        while (!(uusi01 == 9)) {
            tulostaNopat();
            System.out.println("\nValittu: " + heitto01 + "\n");
            uusi01 = Integer.valueOf(lukija.nextLine());

            if (uusi01 < 6 && uusi01 > 0 && uusi01 != heitto01) {
                heitto02 = uusi01;
                break;
            } else if (uusi01 == 7 || uusi01 == 9) {
                break;
            } else {
                System.out.print("Virheellinen luku tai olet jo valinnut tämän nopan...   ");
            }
        }

        while (!(uusi01 == 7 || uusi01 == 9)) {
            tulostaNopat();
            System.out.println("\nValittu: " + heitto01 + ", " + heitto02 + "\n");
            uusi01 = Integer.valueOf(lukija.nextLine());

            if (uusi01 < 6 && uusi01 > 0 && uusi01 != heitto01 && uusi01 != heitto02) {
                heitto03 = uusi01;
                break;
            } else if (uusi01 == 7 || uusi01 == 9) {
                break;
            } else {
                System.out.print("Virheellinen luku tai olet jo valinnut tämän nopan...   ");
            }
        }

        while (!(uusi01 == 7 || uusi01 == 9)) {
            tulostaNopat();
            System.out.println("\nValittu: " + heitto01 + ", " + heitto02 + ", " + heitto03 + "\n");
            uusi01 = Integer.valueOf(lukija.nextLine());

            if (uusi01 < 6 && uusi01 > 0 && uusi01 != heitto01 && uusi01 != heitto02 && uusi01 != heitto03) {
                heitto04 = uusi01;
                break;
            } else if (uusi01 == 7 || uusi01 == 9) {
                break;

            } else {
                System.out.print("Virheellinen luku tai olet jo valinnut tämän nopan...   ");
            }
        }

        if (uusi01 == 9) {
            uusiHeitto(1);
            uusiHeitto(2);
            uusiHeitto(3);
            uusiHeitto(4);
            uusiHeitto(5);
        } else {
            uusiHeitto(heitto01);
            uusiHeitto(heitto02);
            uusiHeitto(heitto03);
            uusiHeitto(heitto04);
        }
    }

    public void noppienTulos(Scanner lukija, Pelaaja x) { // Asettaa pisteet ja yhdistelmän

        int[] jarjestaja = palautaNopat();
        jarjesta(jarjestaja);
        int noppa05 = jarjestaja[4];
        int noppa04 = jarjestaja[3];
        int noppa03 = jarjestaja[2];
        int noppa02 = jarjestaja[1];
        int noppa01 = jarjestaja[0];
        ArrayList<Integer> noppia = new ArrayList<>();
        noppia.add(noppa05);
        noppia.add(noppa04);
        noppia.add(noppa03);
        noppia.add(noppa02);
        noppia.add(noppa01);

        int i = 0;
        int ii = 0;
        int iii = 0;
        int iv = 0;
        int v = 0;
        int vi = 0;

        int ipari = 0;
        int iipari = 0;
        int trio = 0;
        int quad = 0;
        int taysKasiLuku = 0;
        int sattumaLuku = 0;

        boolean ykkoset = false;
        boolean kakkoset = false;
        boolean kolmoset = false;
        boolean neloset = false;
        boolean viitoset = false;
        boolean kuutoset = false;

        boolean yksiPari = false;
        boolean kaksiParia = false;
        boolean kolmoisluku = false;
        boolean neloisluku = false;
        boolean pieniSuora = false;
        boolean suuriSuora = false;
        boolean taysKasi = false;
        boolean sattuma = false;
        boolean yatzy = false;

        System.out.println("\nPöytäkirjan yhdistelmät:");

        // Perus-yhdistelmät
        // Ykköset
        if (tarkista(x, 0)) {
            if (noppia.contains(1)) {
                ykkoset = true;

                for (Integer noppa : nopat) {
                    if (noppa == 1) {
                        i++;
                    }
                }
                System.out.println("\nykkoset: " + i);
            }
        }

        // Kakkoset
        if (tarkista(x, 1)) {
            if (noppia.contains(2)) {
                kakkoset = true;

                for (Integer noppa : nopat) {
                    if (noppa == 2) {
                        ii = ii + 2;
                    }
                }

                System.out.println("\nkakkoset: " + ii);
            }
        }

        // Kolmoset
        if (tarkista(x, 2)) {
            if (noppia.contains(3)) {
                kolmoset = true;

                for (Integer noppa : nopat) {
                    if (noppa == 3) {
                        iii = iii + 3;
                    }
                }

                System.out.println("\nkolmoset: " + iii);
            }
        }

        // Neloset
        if (tarkista(x, 3)) {
            if (noppia.contains(4)) {
                neloset = true;

                for (Integer noppa : nopat) {
                    if (noppa == 4) {
                        iv = iv + 4;
                    }
                }

                System.out.println("\nneloset: " + iv);
            }
        }

        // Viitoset
        if (tarkista(x, 4)) {
            if (noppia.contains(5)) {
                viitoset = true;

                for (Integer noppa : nopat) {
                    if (noppa == 5) {
                        v = v + 5;
                    }
                }

                System.out.println("\nviitoset: " + v);
            }
        }

        // Kuutoset
        if (tarkista(x, 5)) {
            if (noppia.contains(6)) {
                kuutoset = true;

                for (Integer noppa : nopat) {
                    if (noppa == 6) {
                        vi = vi + 6;
                    }
                }

                System.out.println("\nkuutoset: " + vi);
            }
        }

        // Erikois-yhdistelmät
        System.out.println("\nErikois-yhdistelmät");

        // Yksipari
        if (tarkista(x, 6)) {
            if (noppa05 == noppa04 || noppa04 == noppa03 || noppa03 == noppa02 || noppa02 == noppa01) {
                yksiPari = true;

                if (noppa05 == noppa04) {
                    ipari = noppa05 + noppa04;
                } else if (noppa04 == noppa03) {
                    ipari = noppa04 + noppa03;
                } else if (noppa03 == noppa02) {
                    ipari = noppa03 + noppa02;
                } else if (noppa02 == noppa01) {
                    ipari = noppa02 + noppa01;
                }

                System.out.println("\nyksipari: " + ipari);
            }
        }

        // Kaksiparia
        if (tarkista(x, 7)) {
            if (noppa05 == noppa04 && noppa03 == noppa02 && noppa05 != noppa03
                    || noppa04 == noppa03 && noppa02 == noppa01 && noppa04 != noppa02
                    || noppa05 == noppa04 && noppa02 == noppa01 && noppa05 != noppa02) {
                kaksiParia = true;

                if (noppa05 == noppa04 && noppa03 == noppa02) {
                    iipari = noppa05 + noppa04 + noppa03 + noppa02;
                } else if (noppa04 == noppa03 && noppa02 == noppa01) {
                    iipari = noppa04 + noppa03 + noppa02 + noppa01;
                } else if (noppa05 == noppa04 && noppa02 == noppa01) {
                    iipari = noppa05 + noppa04 + noppa02 + noppa01;
                }

                System.out.println("\nkaksiparia: " + iipari);
            }
        }

        // Kolmoisluku
        if (tarkista(x, 8)) {
            if (noppa05 == noppa04 && noppa05 == noppa03 || noppa04 == noppa03 && noppa04 == noppa02
                    || noppa03 == noppa02 && noppa05 == noppa01) {
                kolmoisluku = true;

                if (noppa05 == noppa04 && noppa05 == noppa03) {
                    trio = noppa05 + noppa04 + noppa03;
                } else if (noppa04 == noppa03 && noppa04 == noppa02) {
                    trio = noppa04 + noppa03 + noppa02;
                } else if (noppa03 == noppa02 && noppa03 == noppa01) {
                    trio = noppa03 + noppa02 + noppa01;
                }

                System.out.println("\nkolmoisluku: " + trio);
            }
        }

        // Neloisluku
        if (tarkista(x, 9)) {
            if (noppa05 == noppa04 && noppa05 == noppa03 && noppa05 == noppa02
                    || noppa04 == noppa03 && noppa04 == noppa02 && noppa04 == noppa01) {
                neloisluku = true;

                if (noppa05 == noppa04 && noppa05 == noppa03 && noppa05 == noppa02) {
                    quad = noppa05 + noppa04 + noppa03 + noppa02;
                } else if (noppa04 == noppa03 && noppa04 == noppa02 && noppa04 == noppa01) {
                    quad = noppa04 + noppa03 + noppa02 + noppa01;
                }

                System.out.println("\nneloisluku: " + quad);
            }
        }

        // Pieni Suora
        if (tarkista(x, 10)) {
            if (noppa05 == 5 && noppa04 == 4 && noppa03 == 3 && noppa02 == 2 && noppa01 == 1) {
                pieniSuora = true;

                System.out.println("\npienisuora: 15");
            }
        }

        // Suuri Suora
        if (tarkista(x, 11)) {
            if (noppa05 == 6 && noppa04 == 5 && noppa03 == 4 && noppa02 == 3 && noppa01 == 2) {
                suuriSuora = true;

                System.out.println("\nsuurisuora: 20");
            }
        }

        // Täys Käsi
        if (tarkista(x, 12)) {
            if (noppa05 == noppa04 && noppa03 == noppa02 && noppa03 == noppa01 && noppa05 != noppa03
                    || noppa05 == noppa04 && noppa05 == noppa03 && noppa02 == noppa01 && noppa05 != noppa02) {
                taysKasi = true;

                taysKasiLuku = noppa01 + noppa02 + noppa03 + noppa04 + noppa05;

                System.out.println("\ntayskasi: " + taysKasiLuku);
            }
        }

        // Sattuma
        if (tarkista(x, 13)) {
            sattuma = true;

            sattumaLuku = noppa05 + noppa04 + noppa03 + noppa02 + noppa01;

            System.out.println("\nsattuma: " + sattumaLuku);
        }

        // Yatzy
        if (tarkista(x, 14)) {
            if (noppa05 == noppa04 && noppa05 == noppa03 && noppa05 == noppa02 && noppa05 == noppa01) {
                yatzy = true;

                System.out.println("\nyatzy: 50");
            }
        }

        // Yhdistelmän valinta
        System.out.println(
                "\nMinkä yhdistelmän haluat käyttää?\n\n1 = palaa nopan heitto osioon\n3 = lopettaa vuoron ilman pisteitä\n");

        while (true) {
            String yhdistelma = lukija.nextLine();
            if (yhdistelma.equalsIgnoreCase("ykkoset") && ykkoset) {
                tulos[0] = 0;
                tulos[1] = i;
                break;
            } else if (yhdistelma.equalsIgnoreCase("kakkoset") && kakkoset) {
                tulos[0] = 1;
                tulos[1] = ii;
                break;
            } else if (yhdistelma.equalsIgnoreCase("kolmoset") && kolmoset) {
                tulos[0] = 2;
                tulos[1] = iii;
                break;
            } else if (yhdistelma.equalsIgnoreCase("neloset") && neloset) {
                tulos[0] = 3;
                tulos[1] = iv;
                break;
            } else if (yhdistelma.equalsIgnoreCase("viitoset") && viitoset) {
                tulos[0] = 4;
                tulos[1] = v;
                break;
            } else if (yhdistelma.equalsIgnoreCase("kuutoset") && kuutoset) {
                tulos[0] = 5;
                tulos[1] = vi;
                break;
            } else if (yhdistelma.equalsIgnoreCase("yksipari") && yksiPari) {
                tulos[0] = 6;
                tulos[1] = ipari;
                break;
            } else if (yhdistelma.equalsIgnoreCase("kaksiparia") && kaksiParia) {
                tulos[0] = 7;
                tulos[1] = iipari;
                break;
            } else if (yhdistelma.equalsIgnoreCase("kolmoisluku") && kolmoisluku) {
                tulos[0] = 8;
                tulos[1] = trio;
                break;
            } else if (yhdistelma.equalsIgnoreCase("neloisluku") && neloisluku) {
                tulos[0] = 9;
                tulos[1] = quad;
                break;
            } else if (yhdistelma.equalsIgnoreCase("pienisuora") && pieniSuora) {
                tulos[0] = 10; // Pienisuora aina antaa 15 pistettä
                tulos[1] = 15;
                break;
            } else if (yhdistelma.equalsIgnoreCase("suurisuora") && suuriSuora) {
                tulos[0] = 11; // Suurisuora aina antaa 20 pistettä
                tulos[1] = 20;
                break;
            } else if (yhdistelma.equalsIgnoreCase("tayskasi") && taysKasi) {
                tulos[0] = 12; // Kaikki nopat laskettuna yhteen
                tulos[1] = taysKasiLuku;
                break;
            } else if (yhdistelma.equalsIgnoreCase("sattuma") && sattuma) {
                tulos[0] = 13; // Kaikki nopat laskettuna yhteen
                tulos[1] = sattumaLuku;
                break;
            } else if (yhdistelma.equalsIgnoreCase("yatzy") && yatzy) {
                tulos[0] = 14; // Yatzy aina antaa 50 pistettä
                tulos[1] = 50;
                break;
            } else if (yhdistelma.equals("1") && vuorot == 0) {
                System.out.print("Sinulla ei ole enään vuoroja...   ");
            } else if (yhdistelma.equals("1")) {
                tulos[0] = -1;
                break;
            } else if (yhdistelma.equals("3")) {
                System.out.println("\nEi asetettu pisteitä");
                tulos[0] = -2;
                break;
            } else {
                System.out.print("Virheellinen komento...   ");
            }
        }
    }
}
