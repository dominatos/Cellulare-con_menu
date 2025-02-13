import java.time.LocalDate;
import java.time.Duration;
import java.time.Period;

public class Chiamata {
    public String numeronumchiamata;
    public double durata;
    public String[] listachiamte;



    public Chiamata(String numeronumchiamata ) {
        this.numeronumchiamata = numeronumchiamata;
        this.durata = Math.random();

    }
}
