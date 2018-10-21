package Labpratorium_2_15_10;

public class Pracownik extends Osoba{

    public enum Stanowisko{
        DYREKTOR("Dyrektor",1, "Rządzi wszytkimi"),
        KIEROWNIK("Kieronwik",2, "Kieruje wszystkimi"),
        PRACOWNIK("Pracownik",3, "Wykonuje zadania zaplanowane przez kierownika"),
        SEKRETARKA("Sekretarka",4, "Odbiera telefony, umawia na spotkania"),
        SPRZATACZKA("Sprzataczka",5, "Sprzata wszytsko");

        private final String nazwa;
        private final int hierarchia;
        private final String krotkiOpis;

        Stanowisko(String nazwa, int hierarchia, String krotkiOpis){
            this.nazwa = nazwa;
            this.hierarchia = hierarchia;
            this.krotkiOpis = krotkiOpis;
        }
        String getNazwa(){
            return nazwa;
        }
        int getHierarchia(){
            return hierarchia;
        }
        String getKrotkiOpis(){
            return krotkiOpis;
        }

        @Override
        public String toString() {
            return getNazwa()+": " + getKrotkiOpis()+", "+"w hierarchii: "+getHierarchia();
        }
    }
    private float pensja;
    private Stanowisko stanowisko;

    public Pracownik(String name, String lastName, Stanowisko stanowisko, float pensja) {
        super(name, lastName);
        this.pensja = pensja;
        this.stanowisko = stanowisko;
    }
    public float getPensja(){
        return this.pensja;
    }

    public Stanowisko getStanowisko(){
        return this.stanowisko;
    }
    public String getInfo(){
        return super.getInfo() + stanowisko+ ", pensja: "+ getPensja();
    }

    @Override
    public String toString() {
        return getInfo();
    }
}
