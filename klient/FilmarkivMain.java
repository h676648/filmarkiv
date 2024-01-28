package klient;
import adt.FilmArkivADT;
import impl.Filmarkiv;
import impl.Filmarkiv2;

public class FilmarkivMain {
    public static void main(String[] args) {
        Filmarkiv filma = new Filmarkiv(10);
        Filmarkiv2 filmb = new Filmarkiv2();
        Meny meny1 = new Meny(filma);
        Meny meny2 = new Meny(filmb);

        meny1.start();
    }
}
