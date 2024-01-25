package impl;

import adt.FilmArkivADT;

import java.util.ArrayList;
import java.util.List;

public class Filmarkiv implements FilmArkivADT {
    Film[] filmer;
    public Filmarkiv(int antall) {
        filmer = new Film[antall];
    }

    @Override
    public Film finnFilm(int nr) {
        for (Film film : filmer) {
            if (film.getFilmnr() == nr) {
                return film;
            }
        }
        return null;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {
        if (filmer[filmer.length-1] != null) {
            utvid();
        }
        for (int i=0; i < filmer.length; i++) {
            if (filmer[i] == null) {
                filmer[i] = nyFilm;
                break;
            }
        }
    }
    private void utvid() {
        Film[] nyFilmer = new Film[filmer.length *2 ];
        System.arraycopy(filmer, 0,nyFilmer,0,filmer.length);
        filmer = nyFilmer;
    }

    @Override
    public boolean slettFilm(int filmnr) {
        for (int i = 0; i < filmer.length; i++) {
            if (filmer[i] != null && filmer[i].getFilmnr() == filmnr) {
                filmer[i] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public Film[] soekTittel(String delstreng) {
        List<Film> resultFilms = new ArrayList<Film>();

        for (Film film : filmer) {
            if (film != null && film.getTitle().contains(delstreng)) {
                resultFilms.add(film);
            }
        }
        return  resultFilms.toArray(new Film[0]);
    }

    @Override
    public Film[] soekProdusent(String delstreng) {
        List<Film> resultProd = new ArrayList<>();

        for (Film film : filmer) {
            if (film != null && film.getProd().contains(delstreng)) {
                resultProd.add(film);
            }
        }
        return resultProd.toArray(new Film[0]);
    }

    @Override
    public int antall(Film.Sjanger sjanger) {
        int antallSjanger = 0;

        for (Film film : filmer) {
            if (film != null && film.getSjanger() == sjanger) {
                antallSjanger++;
            }
        }
        return antallSjanger;
    }

    @Override
    public int antall() {
        int count = 0;

        for (Film film : filmer) {
            if (film != null) {
                count++;
            }
        }
        return count;
    }

    private Film[] trimTab(Film[] tab, int n) {
        // n er antall elementer
        Film[] nytab = new Film[n];
        int i = 0;
        while (i < n) {
            nytab[i] = tab[i];
            i++;
        }
        return nytab;
    }

}

