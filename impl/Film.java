package impl;
import java.io.IOException;
import java.util.Objects;
public class Film {
    public enum Sjanger {
        ACTION, DRAMA, HISTORY, SCIFI;
        public static Sjanger finnSjanger(String navn) {
            for (Sjanger s : Sjanger.values()) {
                if (s.toString().equals(navn.toUpperCase())) {
                    return s;
                }
            }
            return null;
        }
    }
    private int filmnr;
    private String prod;
    private String title;
    private int year;
    private String filmselskap;
    private Sjanger sjanger;



    // TODO
    // Sjanger av type enum.
    public Film(int filmnr, String prod, String title, int year, String filmselskap, Sjanger sjanger) {
        this.filmnr = filmnr;
        this.prod = prod;
        this.title = title;
        this.year = year;
        this.filmselskap = filmselskap;
    }
    public Film() {
        Film film = new Film();
    }

    public int getFilmnr() {
            return filmnr;
    }

    void setFilmnr(int filmnr) {
        this.filmnr = filmnr;
    }
    public String getProd() {
        return prod;
    }
    void setProd(String prod) {
        this.prod = prod;
    }
    public String getTitle() {
        return title;
    }
    void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }
    void setYear(int year) {
        this.year = year;
    }
    public String getFilmselskap() {
        return filmselskap;
    }
    void setFilmselskap(String filmselskap) {
        this.filmselskap = filmselskap;
    }
    public Sjanger getSjanger() {
        return sjanger;
    }
    void setSjanger(Sjanger sjanger) {
        this.sjanger = sjanger;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Film film = (Film) obj;
        return filmnr == film.filmnr;
    }
    @Override
    public int hashCode() {
        return Objects.hash(filmnr);
    }

    public String toString(Film[] film) {
        return "" + film[0].getTitle();
    }
    public String toString(Film film) {
        return "" + film.getTitle();
    }
}
