package org.exsercise.bonusexercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CharCounter {
    public static void main(String[] args) {

        //Scanner per chiedere la parola all'utente
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci una parola: ");
        String parola = scanner.nextLine(); //Salvo la parola inserita dall'utente e vado alla prossima riga

        Map<Character, Integer> conteggioCaratteri = contaCaretteri(parola); //Creo un Map

        System.out.println("Numero di occorrenza per carattere: ");

        for (Map.Entry<Character, Integer> entry : conteggioCaratteri.entrySet()){ //.Entry fornisce metodi per ottenere la chiave e il valore associati a ciascun elemento della mappa
            System.out.println(entry.getKey() + ":" + entry.getValue());
            //Mi faccio restituire la chiave ad ogni iterazione
            //Mi faccio restituire il value ad ogni iterazione
        }

        //Chiudo lo scanner
        scanner.close();
    }

    //Metodo di servizio
    private static Map<Character, Integer> contaCaretteri(String parola){
        Map<Character, Integer> conteggioCaratteri = new HashMap<>();

        //Itero per ogni c (carattere) della parola
        for (char c : parola.toCharArray()){ //Trasformo la parola in un array di char
            conteggioCaratteri.put(c ,conteggioCaratteri.getOrDefault(c , 0) + 1); //Se il carattere non è presente nella mappa, il valore di default è 0..
            // se presente gia' il valore allora lo faccio partire da 1 e lo aumento ad ogni iterazione
        }
        return conteggioCaratteri;
    }
}
