package klient;

import impl.Film;
import impl.Filmarkiv;
import adt.FilmArkivADT;
public class Meny {
    private Tekstgrensesnitt tekstgr;
    private FilmArkivADT filmarkiv;

    public Meny(FilmArkivADT filmarkiv) {
        tekstgr = new Tekstgrensesnitt();
        this.filmarkiv = filmarkiv;
    }

    public void start() {
        //legg inn en del forhåndsdefinerte filmer for å teste metodene
        Film film1 = new Film(1, "Produsent 1", "Film 1", 2002, "Selskap 1", Film.Sjanger.ACTION);
        Film film2 = new Film(2, "Produsent 2", "Film 2", 2002, "Selskap 2", Film.Sjanger.ACTION);
        filmarkiv.leggTilFilm(film1);
        filmarkiv.leggTilFilm(film2);
    }
}
