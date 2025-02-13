import java.util.Scanner;
import java.time.LocalDate;

public class SIM {
static Scanner sc=new Scanner(System.in);


    public String numero;
    public double credito=0;
    public String[] chiamate=new String[5];
    public double prmin=0.05;
//;kl;k;lk;l

    public SIM(String numero) {
        this.numero = numero;
        this.credito = 0;
        this.chiamate = chiamate;
        this.chiamate=null;
        this.prmin = prmin;
        this.prmin = 0.05;
    }

    public void info() {
        System.out.println("SIM: " + this.numero + " con credito: " + this.credito);
        System.out.println("Credito: " + this.credito);
        System.out.println("Il prezzo pr minuta di chiamata : " + this.prmin);
        if(this.chiamate==null)
        {
            System.out.println("La lista di chiamate: il client non ha ancora effetuato nessuna chiamata");
        }
        else{
            System.out.println("qui ci saraa lista di chiamata");
        }
        if(this.credito==0)
        {ricarica();}
        else { effeturachiamta();
        }

    }



    public void ricarica()
    {
        if(this.credito==0)
        {
            System.out.println("Vuoi fare ricarica?(si/no)");
            boolean sino;
            String sinoval = sc.nextLine();
            int somma;
            if(sinoval.equals("si"))
            {
                System.out.println("Inserisci il valore di ricarica: ");
                 somma = Integer.parseInt(sc.nextLine());

                this.credito=this.credito+somma;
                info();
            }
            else if (sinoval.equals("no") && this.credito>0)
            {
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




    public void effeturachiamta()
    {if(this.credito!=0) {
        System.out.println("Vuoi fare la chiamata?(si/no)");
        boolean sino;
        String sinoval = sc.nextLine();
        String numero;

        if(sinoval.equals("si"))
        {


            System.out.println("Inserisci il numero di telefono: ");
            //numero = sc.nextLine();
            numero="+391234561234";
            Chiamata c3 = new Chiamata(numero);


        }
        else if (sinoval.equals("no") && this.credito>0)
        {
            info();
        }
        else{
            System.out.println("commanda sconoscuta. Prova ancora");
            System.out.println();
            info();

        }
    }
    }
}


