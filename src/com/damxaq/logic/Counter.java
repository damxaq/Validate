package com.damxaq.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


public class Counter {
	
	String[] lista = new String[] {"Visa", "MasterCard", "Maestro", "JCB", "Discover Card", "American Express", "Laser", "InterPayment"};

	//tworzenie klasy karty i uruchomienie klasy sprawdzajacej
	public Boolean[] validate(String[][] list) {
	    List<Boolean> res = new ArrayList<Boolean>();
	    Card card = new Card();
	    for (String[] l:list){
	        card.insert(l[0],l[1],1);
	        card.show();
	        res.add(card.check());
	        System.out.println(res.get(res.size()-1)+"\n");
	    }
	    return (Boolean[]) res.toArray(new Boolean[0]);
	}

	//czyszczenie numeru karty ze zbednych znakow
	String clean(String n){
	    n=n.replace("-","");
	    n=n.replace(" ","");
	    return n;
	}

	//sprawdzanie,czy liczba znakow numeru karty odpowiada typowi karty
	boolean validLength(String b, int l){
	    switch (b) {
	        case "Visa": return (l == 13 || l == 16 || l == 19);
	        case "MasterCard": return (l == 16);
	        case "Maestro": return (l >= 12 && l <= 19);
	        case "JCB": return (l == 16);
	        case "Discover Card": return (l == 16 || l == 19);
	        case "American Express": return (l == 15);
	        case "Laser": return (l >= 16 && l <= 19);
	        case "InterPayment": return (l >= 16 && l <= 19);
	        default: return false;
	    }
	}

	//sprawdzanie czy numer karty odpowiada rzeczywistemu szablonowi numeru identyfikacji, 
	//oraz czy nie koliduje ze wzorcami innych przedsiebiorstw 
	boolean validIN(String b, String n){
	    String[] paty = new String[] {
	        "^4[0-9]+", 
	        "(^5[1-5]{1}[0-9]+)|(^2([3-6]|(2([3-9]|(2[1-9]))|7([0-1]|(20))))[0-9]+)",
	        "^((50)|((6))|(5[5-8]))[0-9]+",
	        "^(35)(([3-8][0-9])|(2[8-9]))[0-9]+",
	        "(^(6011)[0-9]+)|(^(65)[0-9]+)|(^((64)[4-9])[0-9]+)|(^((622)(([2-8])|(1(([3-9])|(2)[6-9]))|(9(([0-1])|(2[0-5])))))[0-9]+)",
	        "^((34)|(37))[0-9]+",
	        "^((6304)|(6706)|(6771)|(6709))[0-9]+",
	        "^(636)[0-9]+",
	        };
	     if (b.equals("Maestro") && Pattern.matches(paty[2], n)) {
	         boolean matchesAnythingElse = false;
	         for (int i =0; i < paty.length; i++) {
	             if (i == 2) { continue; }
	             matchesAnythingElse = matchesAnythingElse || Pattern.matches(paty[i], n);  
	         }
	         return !matchesAnythingElse;
	     }
	    for (int i=0; i<8; i++)
	        if (b.equals(lista[i]) && Pattern.matches(paty[i], n)) return true;
	    return false;
	}

	//porownywanie sumy liczb numeru karty z liczba kontrolna
	boolean checkSum(String n, int l){
	    int tab[] = new int[l];
	    int par = l%2;
	    for (int i=0; i<l; i++) tab[i] = n.charAt(i) - '0';
	    if (count(tab,l-1,par)==tab[l-1]) return true;

	    return false;
	}

	//liczenie sumy lczb numeru karty dla porownania z liczba kontrolna
	int count(int[] t, int l, int p){
	    int suma=0,wartosc;
	    if (p==0) p=2;
	    else p=1;
	    for (int i=0; i<l; i++){
	        wartosc=t[i]*p;
	        if (wartosc>9) wartosc-=9;
	        suma+=wartosc;
	        p++;
	        if (p==3) p=1;
	    }
	    if (10-suma%10==10) return 0;
	    return (10-suma%10);
	}
}
