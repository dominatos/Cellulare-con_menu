import java.time.LocalDate;
import java.time.Duration;
import java.time.Period;

public class Chiamata {
    public String numeronumchiamata;
    public double durata;

    public Chiamata() {
        this.numeronumchiamata = "non e fatta la chiamata";
        this.durata = 0;

    }


    public Chiamata(String numeronumchiamata ) {
        this.numeronumchiamata = numeronumchiamata;
        this.durata = Math.random();

    }

    public double getDurata() {
        return durata;
    }

    public void setDurata(double durata) {
        this.durata = durata;
    }

    public String getNumeronumchiamata() {
        return numeronumchiamata;
    }

    public void setNumeronumchiamata(String numeronumchiamata) {
        this.numeronumchiamata = numeronumchiamata;
    }
    public  String stampchiamata() {
        //System.out.println(this.numchiamata);
        return this.numeronumchiamata+" "+this.durata;
    }
}
