package klient;

import adt.FilmArkivADT;
import impl.Film;
import impl.Filmarkiv;

import java.util.Arrays;

public class FilmarkivMain {
    public static void main(String[] args) {
        FilmArkivADT filma = new Filmarkiv(4);
        Meny meny = new Meny(filma);
        meny.start();
        Film[] result = filma.soekTittel("Mat");
        if (result.length > 0) {
            for (Film film : result) {
                System.out.println("Fant film: " + film.getTitle());
            }
        } else {
            System.out.println("No matching film found.");
        }

    }
}
