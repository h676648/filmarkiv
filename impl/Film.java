package impl;
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
    Film() {
        Film film = new Film();
    }

    int getFilmnr() {
        return filmnr;
    }

    void setFilmnr(int filmnr) {
        this.filmnr = filmnr;
    }
    String getProd() {
        return prod;
    }
    void setProd(String prod) {
        this.prod = prod;
    }
    String getTitle() {
        return prod;
    }
    void setTitle(String title) {
        this.title = title;
    }

    int getYear() {
        return year;
    }
    void setYear(int year) {
        this.year = year;
    }
    String getFilmselskap() {
        return filmselskap;
    }
    void setFilmselskap(String filmselskap) {
        this.filmselskap = filmselskap;
    }
    Sjanger getSjanger() {
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


}
