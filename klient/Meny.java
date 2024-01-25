package klient;

import impl.Film;
import impl.Filmarkiv;
import adt.FilmArkivADT;
public class Meny {
    private Tekstgrensesnitt tekstgr;
    public FilmArkivADT filmarkiv;

    public Meny(FilmArkivADT filmarkiv) {
        tekstgr = new Tekstgrensesnitt();
        this.filmarkiv = filmarkiv;
    }

    public void start() {
        //legg inn en del forhåndsdefinerte filmer for å teste metodene
        Film film1 = new Film(1, "Produsent 1", "The Matrix", 2002, "Selskap 1", Film.Sjanger.ACTION);
        Film film2 = new Film(2, "Produsent 1", "The Matrix Reloaded", 2002, "Selskap 1", Film.Sjanger.ACTION);
        Film film3 = new Film(3, "Produsent 1", "The Matrix Revolution", 2002, "Selskap 1", Film.Sjanger.ACTION);
        Film film4 = new Film(4, "Produsent 2", "Barbie", 2002, "Selskap 2", Film.Sjanger.DRAMA);
        Film film5 = new Film(5, "Produsent 3", "Oppenheimer", 2002, "Selskap 3", Film.Sjanger.SCIFI);
        Film film6 = new Film(6, "Produsent 4", "Shrek 3", 2002, "Selskap 4", Film.Sjanger.ACTION);
        filmarkiv.leggTilFilm(film1);
        filmarkiv.leggTilFilm(film2);
        filmarkiv.leggTilFilm(film3);
        filmarkiv.leggTilFilm(film4);
    }
}
