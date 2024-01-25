package klient;

import adt.FilmArkivADT;
import impl.Filmarkiv;

public class FilmarkivMain {
    public static void main(String[] args) {
        FilmArkivADT filma = new Filmarkiv(100);
        Meny meny = new Meny(filma);
        meny.start();
    }
}
