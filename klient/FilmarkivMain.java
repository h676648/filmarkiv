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

        Filmarkiv2 filmc = new Filmarkiv2();
        Film film0 = new Film(0, "Quentin Tarantino", "Pulp Fiction", 1994, "A Band Apart", Film.Sjanger.THRILLER);
        Film film1 = new Film(1,"Quentin Tarantino", "Django Unchained", 2012, "Columbia Pictures", Film.Sjanger.ACTION);
        Film film2 = new Film(2, "Joel Silver", "The Matrix", 1999, "Warner Bros", Film.Sjanger.ACTION);
        filmc.leggTilFilm(film0, film1, film2);
        System.out.println("Filmnr:\t" + filmc.finnFilm(0).getFilmnr());
        System.out.println("Title:\t" + filmc.finnFilm(0).getTitle());
        System.out.println("Producer:\t" + filmc.finnFilm(0).getProd());
        System.out.println("Year:\t" + filmc.finnFilm(0).getYear());
        System.out.println("Production company:\t" + filmc.finnFilm(0).getFilmselskap());
        System.out.println("Genre:\t" + filmc.finnFilm(0).getSjanger());

        for (int i = 1; i < 10000; i++) {
            filmc.leggTilFilm(film0,film1,film2);
        }

        System.out.println("\nAntall filmer a sooke gjennom: " + filmc.antall());
        startTime = System.nanoTime(); //Starter tid
        Arrays.toString(filmc.soekProdusent("Quent")); //Søker gjennom alle med Quent i produsent
        endTime = System.nanoTime();
        elapsedTime = endTime-startTime;
        System.out.println("Tid: " + elapsedTime); //Printer ut kalkulert tid
    }
}
