import java.util.Scanner;
import java.time.LocalDate;

public class SIM {
static Scanner sc=new Scanner(System.in);


    public String numero;
    public double credito=0;
    public Chiamata[] chiamate;
    public boolean ric;
    public double prmin=0.05;
//;kl;k;lk;l

    public SIM(String numero) {
        this.ric=false;
        this.numero = numero;
        this.credito = 0;
        this.chiamate = new Chiamata[5];
        for (int i = 0; i < this.chiamate.length; i++) {
            this.chiamate[i] = new Chiamata(); // Создаем объект для каждой ячейки
        }


        this.prmin = 0.05;
    }

    public void info() {
        System.out.println("SIM: " + this.numero + " con credito: " + this.credito);
        System.out.println("Credito: " + this.credito);
        System.out.println("Il prezzo pr minuta di chiamata : " + this.prmin);
        System.out.println("Lista di chiamati:");
        boolean nessunaChiamata = true;

// Controlla se tutti gli elementi dell'array contengono "non e fatta la chiamata 0.0"
        for (int i = 0; i < this.chiamate.length; i++) {
            if (chiamate[i] != null && !chiamate[i].stampchiamata().equals("non e fatta la chiamata 0.0")) {
                nessunaChiamata = false;
                break; // Interrompe il ciclo appena troviamo almeno una chiamata effettuata
            }
        }

// Se tutti gli elementi contengono "non e fatta la chiamata 0.0", stampa il messaggio una sola volta
        if (nessunaChiamata) {
            System.out.println("Cliente non ha ancora effetuato nessuno chiamata");
        } else {
            // In caso contrario, stampa l'elenco delle chiamate
            for (int i = 0; i < this.chiamate.length; i++) {
                if (chiamate[i] != null && !chiamate[i].stampchiamata().equals("non e fatta la chiamata 0.0")) {
                    System.out.println((i + 1) + " " + chiamate[i].stampchiamata());
                }
            }
        }

        if(this.credito==0 || this.ric)
        {ricarica();}

        else { effeturachiamta();
        }

    }



    public void ricarica()
    {
        if(this.credito==0 || this.ric ||this.credito<0)
        {
            System.out.println("Vuoi fare ricarica?(si/no)");
            boolean sino;
            String sinoval = sc.nextLine();
            double somma;
            if(sinoval.equals("si"))
            {
                System.out.println("Inserisci il valore di ricarica: ");
                 somma = Double.parseDouble(sc.nextLine());

                this.credito=this.credito+somma;
                this.ric=false;
                info();
            }
            else if (sinoval.equals("no") && this.credito>0)
            {
                this.ric=false;
                info();
            }
            else if (sinoval.equals("no") && this.credito==0)
            {
                System.out.println("In questo caso non riusiresti di chiamre piu!");
                info();
            }
            else{
                System.out.println("commanda sconoscuta. Prova ancora");
                System.out.println();
                info();

            }

        }


    }




    public void effeturachiamta() {
        if (this.credito > 0) { // Verifica se c'è abbastanza credito
            System.out.println("Vuoi fare una chiamata o la ricarica? (si/no/ricarica)");
            String sinoval = sc.nextLine();

            if (sinoval.equalsIgnoreCase("si")) { // Confronto case-insensitive per "sì"
                System.out.println("Inserisci il numero di telefono: ");
                String numero = sc.nextLine();

                // Crea una nuova chiamata
                Chiamata c = new Chiamata(numero);

                boolean added = false; // Flag per indicare se la chiamata è stata aggiunta

                for (int i = 0; i < chiamate.length; i++) {
                    // Se troviamo uno slot vuoto o non ancora usato, aggiungiamo la chiamata
                    if (chiamate[i] == null || chiamate[i].getNumeronumchiamata().equals("non e fatta la chiamata")) {
                        if(c.getDurata()*this.prmin<=this.credito){
                            chiamate[i] = c; // Aggiunge la nuova chiamata allo slot
                            added = true; // Indica che la chiamata è stata aggiunta
                            acreditarechiamata(c);
                            break; // Interrompe il ciclo dopo l'aggiunta
                        }
                        else{
                            System.out.println("Non hai abbastanza credito per effeture la chiamata1");

                            break;
                        }

                    }
                }

                // Se l'array è pieno, sovrascrive la chiamata più vecchia
                if (!added) {
                    if(c.getDurata()*this.prmin<=this.credito){
                    System.out.println("L'elenco delle chiamate è pieno. Sovrascrivo la chiamata più vecchia.");

                    chiamate[0] = c; // Sovrascrive il primo elemento
                    // Opzionalmente, si può implementare una sovrascrittura ciclica tramite un indice
                    acreditarechiamata(c);}
                    else{
                        System.out.println("Non hai abbastanza credito per effeture la chiamata2");



                    }
                }
                this.ric=true;
                ricarica();
                //info(); // Mostra le informazioni aggiornate
            } else if (sinoval.equalsIgnoreCase("no")) {
                info(); // Mostra semplicemente le informazioni attuali
            }else if (sinoval.equalsIgnoreCase("ricarica")) {
                this.ric=true;
                info(); // Mostra semplicemente le informazioni attuali
                //ricarica();
            }
            else {
                System.out.println("Comando sconosciuto. Riprova.");

                info(); // Ripete la richiesta
            }
        } else {
            System.out.println("Credito insufficiente per effettuare una chiamata.");
            ricarica();
        }
    }
    public void acreditarechiamata(Chiamata chiamata) {

        this.credito = this.credito - (chiamata.getDurata() * this.prmin);
        //System.out.println(this.credito);

    }
}


