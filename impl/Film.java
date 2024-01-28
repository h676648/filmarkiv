package impl;
import java.util.Objects;
public class Film {
    public enum Sjanger {
        ACTION, DRAMA, HISTORY, SCIFI, THRILLER, COMEDY
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
        this.sjanger = sjanger;
    }

    public int getFilmnr() {
            return filmnr;
    }

    public void setFilmnr(int filmnr) {
        this.filmnr = filmnr;
    }
    public String getProd() {
        return prod;
    }
    public void setProd(String prod) {
        this.prod = prod;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public String getFilmselskap() {
        return filmselskap;
    }
    public void setFilmselskap(String filmselskap) {
        this.filmselskap = filmselskap;
    }
    public Sjanger getSjanger() {
        return sjanger;
    }
    public void setSjanger(Sjanger sjanger) {
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

    public String toString() {
        String result = "Filmnr: "+ getFilmnr();
        result += "\nTitle: " + getTitle();
        result += "\nProducer: " + getProd();
        result += "\nYear: " + getYear();
        result += "\nProduction: " + getFilmselskap();
        result += "\nGenre: " + getSjanger()+"\n";
        return result;
    }

    public String toString(Film film) {
        String result = "Filmnr: "+ film.getFilmnr();
        result += "\nTitle: " + film.getTitle();
        result += "\nProducer: " + film.getProd();
        result += "\nYear: " + film.getYear();
        result += "\nProduction: " + film.getFilmselskap();
        result += "\nGenre: " + film.getSjanger()+"\n";
        return result;
    }
}
