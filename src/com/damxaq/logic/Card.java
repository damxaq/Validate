package com.damxaq.logic;
import com.damxaq.logic.Counter;

public class Card {
    String brand;
    String number;
    int length;
    Counter counter = new Counter();
    void insert(String b, String n, int l) {  
        brand=b;  
        number=counter.clean(n);  
        length=number.length();  
    } 
    boolean check(){
        if (counter.validLength(brand,length) && counter.validIN(brand,number) && counter.checkSum(number,length)) 
        	return Boolean.TRUE;
        else return Boolean.FALSE;
    }
    void show(){
        System.out.println("Karta: " + brand + ", o numerze: " + number + ", ilosc znakow: " + length);
    }
}
