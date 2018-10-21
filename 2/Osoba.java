package Labpratorium_2_15_10;

public class Osoba {
    private String name;
    private String lastName;

    public Osoba(String name, String lastName){
        this.name = name;
        this.lastName = lastName;
    }
    public String getName() {
        return this.name;
    }
    public String getLastName() {
        return this.lastName;
    }
    public String getInfo(){
        return  "Imie: "+ getName() + ", nazwisko: "+ getLastName()+", ";
    }
}
