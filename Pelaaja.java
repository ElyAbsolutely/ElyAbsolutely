public class Pelaaja {
    private String nimi;
    private Poytakirja poytakirja;

    public Pelaaja(String nimi) {
        this.nimi = nimi;
        this.poytakirja = new Poytakirja();

    }

    public void lisaaPisteita(int indeksi, int tulos) {
        System.out.println("Lisätään pisteet kohtaan | " + this.poytakirja.yhdistelmat[indeksi] + ": " + tulos + " |");
        this.poytakirja.lisaaPisteita(indeksi, tulos);
    }

    public void tulostaKortti() {
        System.out.println("--------------------------");
        System.out.println("Pelaajan " + getNimi() + " kortti:");
        System.out.println("--------------------------");

        this.poytakirja.tulostaKortti();
    }

    public boolean onkoTaytetty(int indeksi) {
        if (this.poytakirja.maara[indeksi] == 0) {
            return false;
        } else {
            return true;
        }
    }

    public String getNimi() {
        return nimi;
    }

    public Poytakirja getPoytakirja() {
        return poytakirja;
    }
}