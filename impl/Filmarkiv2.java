package impl;
import adt.FilmArkivADT;
import adt.LinearNode;
import java.util.LinkedList;
public class Filmarkiv2 implements FilmArkivADT {
    private final LinearNode<Film> filmer;


    public Filmarkiv2() {
        //filmer = new LinkedList<>();
        filmer = new LinearNode<>();
    }

    @Override
    public Film finnFilm(int nr) {
       for (Film film: filmer) {
           if (film.getFilmnr() == nr) {
               return film;
           }
       }
       return null;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {
        filmer.add(nyFilm);
    }


    public void leggTilFilm(Film film, Film film1) {
        filmer.add(film);
        filmer.add(film1);
    }

    public void leggTilFilm(Film film0, Film film1, Film film2) {
        filmer.add(film0);
        filmer.add(film1);
        filmer.add(film2);
    }
    @Override
    public boolean slettFilm(int filmNr) {
        Film filmToRemove = null;

        for (Film film : filmer) {
            if (film.getFilmnr() == filmNr) {
                filmToRemove = film;
                break;
            }
        }

        if (filmToRemove != null) {
            filmer.remove(filmToRemove);
            return true;
        }
        return false;
    }

    public Film[] soekTittel(String delstreng) {
        LinkedList<Film> resultList = new LinkedList<>();
        for (Film film : filmer) {
            if (film != null && film.getTitle().contains(delstreng)) {
                resultList.add(film);
            }
        }
        return resultList.toArray(new Film[0]);
    }

    @Override
    public Film[] soekProdusent(String delstreng) {
        LinkedList<Film> resultList = new LinkedList<>();
        for (Film film : filmer) {
            if (film != null && film.getProd().contains(delstreng)) {
                resultList.add(film);
            }
        }
        return resultList.toArray(new Film[0]);
    }

    public int antall(Film.Sjanger sjanger) {
        int antallSjanger = 0;
        for (Film film : filmer) {
            if (film.getSjanger() == sjanger) {
                antallSjanger++;
            }
        }
        return antallSjanger;
    }

    @Override
    public int antall() {
        int antall = 0;

        for (Film film : filmer) {
            antall++;
        }
        return antall;
    }

}
