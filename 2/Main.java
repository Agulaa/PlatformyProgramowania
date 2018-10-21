package Labpratorium_2_15_10;

import java.util.Iterator;

public class Main {

    public static void main(String[] args){
        Firma firma = new Firma();
        firma.addNewPracownik(new Pracownik("Aga", "Maga", Pracownik.Stanowisko.DYREKTOR, 350000));
        firma.addNewPracownik(new Pracownik("Ada", "Pada", Pracownik.Stanowisko.DYREKTOR, 320000));
        firma.addNewPracownik(new Pracownik("Ola", "Pola", Pracownik.Stanowisko.KIEROWNIK, 35000));
        firma.addNewPracownik(new Pracownik("Ala", "Mala", Pracownik.Stanowisko.PRACOWNIK, 3500));
        firma.addNewPracownik(new Pracownik("Marek", "Farek", Pracownik.Stanowisko.SEKRETARKA, 350));
        firma.addNewPracownik(new Pracownik("Gotek", "Fotek", Pracownik.Stanowisko.SPRZATACZKA, 350));

        firma.listAllPracownik();
        System.out.println();

        for(Pracownik p : firma){
            System.out.println(p);
        }

        System.out.println();

        System.out.println("Wypisanie tylko dyrektorów:");
        Iterator<Pracownik> it = firma.iterator(Pracownik.Stanowisko.DYREKTOR);
        while (it.hasNext()){
            System.out.println(it.next());
        }

        System.out.println();
        System.out.println("Średnia pensja wszytskich: "+firma.sredniaPensjaWszytskich());

        System.out.println("Średnia tylko dla dyrektorów: "+firma.sredniaPensjaWszytskich(Pracownik.Stanowisko.DYREKTOR));

    }
}
