package Labpratorium_2_15_10;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Collectors;

public class Firma implements Iterable<Pracownik> {
    private ArrayList<Pracownik> wszyscyPracownicy;

    public Firma(){
        this.wszyscyPracownicy = new ArrayList<>();
    }

    public void addNewPracownik(Pracownik nowy){
        wszyscyPracownicy.add(nowy);
    }

    public int numberOfPracownik(){
        return wszyscyPracownicy.size();
    }
    public void listAllPracownik(){
        for (Pracownik p : wszyscyPracownicy) {
            System.out.println(p.getInfo());
        }
    }

    @Override
    public Iterator iterator(){
        return this.wszyscyPracownicy.iterator();
    }

    public Iterator iterator(Pracownik.Stanowisko s){
        return this.wszyscyPracownicy.stream().filter(p -> p.getStanowisko().equals(s)).collect(Collectors.toList()).iterator();
    }

    public float sredniaPensjaWszytskich(){
        float sum = 0;
        for(Pracownik p: this.wszyscyPracownicy){
            sum+= p.getPensja();
        }
        return sum/numberOfPracownik();
    }

    public float sredniaPensjaWszytskich(Pracownik.Stanowisko s){
        float sum = 0;
        int all = 0;
        for(Pracownik p: this.wszyscyPracownicy){
            if (p.getStanowisko().equals(s)) {
                sum += p.getPensja();
                all+=1;
            }
        }
        return sum/all;
    }



}
