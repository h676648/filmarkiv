package impl;

import adt.FilmArkivADT;

public class Filmarkiv implements FilmArkivADT {
    Film[] filmer;
    void FilmArkivADT(int antall) {
        Film[] filmer = new Film[antall];
    }

    @Override
    public Film finnFilm(int nr) {
        for (int i=0; i<filmer.length; i++) {
           if (filmer[i].getFilmnr()==nr) {
               return filmer[i];
           }
        }
        return null;
    }

    //TODO Kommet hit
    @Override
    public void leggTilFilm(Film nyFilm) {
    Film ny = new Film();

    }

    @Override
    public boolean slettFilm(int filmnr) {
        return false;
    }

    @Override
    public Film[] soekTittel(String delstreng) {
        return new Film[0];
    }

    @Override
    public Film[] soekProdusent(String delstreng) {
        return new Film[0];
    }

    @Override
    public int antall(Film.Sjanger sjanger) {
        return 0;
    }

    @Override
    public int antall() {
        return 0;
    }
}

