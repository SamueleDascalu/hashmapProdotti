package org.generation.italy;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String prodotto;
		float prezzo, prezzoTotale, totaleScontrino=0;
		int unità;
		
		HashMap<String, Float> listaProdotti = new HashMap<String, Float>();
		
		//inserimento prodotti commerciante
		do {
			System.out.print("Inserisci un prodotto: ");
			prodotto = scanner.nextLine();
			
			if(listaProdotti.containsKey(prodotto)) {
				System.out.println("Prodotto già esistente.");
			} else {
				System.out.print("Inserisci il prezzo per 1 unità di "+prodotto+": ");
				prezzo = Float.parseFloat(scanner.nextLine());
				listaProdotti.put(prodotto, prezzo);	
			}
			
			System.out.println("Vuoi inserire un altro prodotto? (s,n) ");
		}while(scanner.nextLine().equals("s"));
		
		//acquisto prodotti cliente
		do {
			System.out.print("Inserisci un prodotto da acquistare: ");
			prodotto = scanner.nextLine();
			
			if(listaProdotti.containsKey(prodotto)) {
				System.out.println("Stai acquistando "+prodotto);
				System.out.println("Quante unità vuoi acquistare? ");
				unità = Integer.parseInt(scanner.nextLine());
				prezzoTotale = listaProdotti.get(prodotto)*unità;
				System.out.println("Il prezzo é: " + String.format("%.2f",prezzoTotale)+"€");
				totaleScontrino+=prezzoTotale;
			} else {
				System.out.println("Prodotto non disponibile.");
			}
			
			System.out.println("Vuoi inserire un altro prodotto? (s,n) ");
		}while(scanner.nextLine().equals("s"));
		
		//stampo il totale da pagare
		System.out.println("Il totale é: "+totaleScontrino);
		
		scanner.close();

	}

}
