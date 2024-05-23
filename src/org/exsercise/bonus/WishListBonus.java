package org.exsercise.bonus;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WishListBonus {

    //Assegno il mio file
    private static final String FILE_PATH = "./resources/wishList.txt";

//    private static final File FILE = new File("./resources/wishList.txt");

    public static void main(String[] args) {
        //Creo il mio ArrayList (wishList) vuoto
        ArrayList<String> wishList = loadWishListFromFile();

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

        saveWishListToFile(wishList);

        scanner.close();
    }

    //Metodi di servizio
    private static ArrayList<String> loadWishListFromFile() throws IllegalArgumentException{ //Metodo per leggere la lista con uno Scanner passando il file
        ArrayList<String> wishList = new ArrayList<>();

        File file = new File(FILE_PATH);

        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNextLine()) {
                wishList.add(scanner.nextLine());
            }

        } catch (FileNotFoundException e) {
            System.out.println("Il file non esiste o non può essere letto: " + e.getMessage());
        }

        return wishList;
    }

    private static void saveWishListToFile(ArrayList<String> wishList) throws IllegalArgumentException{ //Metodo per salvare la lista nel file

        try (FileWriter writer = new FileWriter(FILE_PATH)) {

            for (String regalo : wishList) {
                writer.write(regalo + "\n");
            }

        } catch (IOException e) {
            System.out.println("Errore durante la scrittura del file: " + e.getMessage());
        }
    }

}
