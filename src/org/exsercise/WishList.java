package org.exsercise;

import java.util.*;

public class WishList {

    public static void main(String[] args) {
        //Creo il mio ArrayList (wishList) vuoto
        ArrayList<String> wishList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        while(true){

            System.out.println("Inserisci il nome del regalo o 'stop' per terminare");
            String regalo = scanner.nextLine();

            //Se inserisco stop esco dal ciclo
            if (regalo.equalsIgnoreCase("stop")) {
                System.out.println("Ciao");
                break;
            }

            //aggiungo all'arrayList il regalo inserito dall'utente
            wishList.add(regalo);

            //mostro la lunghezza dell'arrayList
            System.out.println("Lunghezza della lista: " + wishList.size());

            //Chiedo all'utente se vuole continuare
            System.out.println("Vuoi aggiungere un nuovo regalo? (s/n)");
            String risposta = scanner.nextLine();

            if (risposta.equalsIgnoreCase("n")) {
                break;
            } else if (!risposta.equalsIgnoreCase("s")) {
                System.out.println("Risposta non riconosciuta");
            }

        }

        //Ordino la lista
        Collections.sort(wishList);

        System.out.println("Lista dei regali ordinati: ");
        //Itero con un forEach
        for (String i : wishList){
            System.out.println(" - " + i);
        }

        scanner.close();
    }

}
