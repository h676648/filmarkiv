package klient;
import adt.FilmArkivADT;
import impl.Film;
import impl.Filmarkiv;
import impl.Filmarkiv2;

import java.util.Arrays;

public class FilmarkivMain {
    public static void main(String[] args) {
        long startTime;
        long endTime;
        long elapsedTime;
        FilmArkivADT filma = new Filmarkiv(10);
        Filmarkiv2 filmb = new Filmarkiv2();
        Meny meny1 = new Meny(filma);
        Meny meny2 = new Meny(filmb);

        meny1.start();
        meny2.start();
    }
}
