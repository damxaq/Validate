package com.damxaq;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.damxaq.logic.Counter;

public class Validate {

	public static void main(String[] args) {
		
		String[][] cardNumbers;
		String d = "y";
		Scanner decision = new Scanner(System.in);
		List<String> names = new ArrayList<String>(); 
		List<String> numbers = new ArrayList<String>(); 
		int count=0;
		
		/*
		Przykladowe numery:
		"Visa","4000-0799-2739-8715"
		"Visa","5000 0000 1234 5678"
		"Visa","40002847193819287"
		*/
		do{
			System.out.println("Podaj nazwe karty:");
			d = decision.nextLine().toString();
			names.add(d);
			System.out.println("Podaj numer karty:");
			d = decision.nextLine().toString();
			numbers.add(d);
			System.out.println("Dodac kolejna karte? [y/n]");
			d = decision.nextLine().toString();
			System.out.println(d);
			count++;
		}
		while(!d.equals("n"));
		
		decision.close();
		cardNumbers = new String[count][2]; 
		
		for (int i=0; i<count; i++){
			cardNumbers[i][0]=names.get(i);
			cardNumbers[i][1]=numbers.get(i);
		}

		Counter counter = new Counter();
		counter.validate(cardNumbers);
	}
}
