package impl;

public class Film {
    private int filmnr;
    private String prod;
    private String title;
    private int year;
    private String filmselskap;

    // TODO
    // Sjanger av type enum.
    Film(int filmnr, String prod, String title, int year, String filmselskap) {
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


}
