package com.mert.Strings;

import java.util.ArrayList;
import java.util.List;

public class StringTutorial {

    public static void main(String[] args) {

        String str = "Geeks";// String constant pool
        String str1 = new String("herre");// in heap

        StringBuffer s = new StringBuffer("GeeksforGeeks");
        StringBuilder str3 = new StringBuilder();
        str3.append("herre");

        // String ifadeleri birlestirme
        String ex1 = "Mert";
        String ex2 = "Kabadayi";
        String merge = ex1 + ex2;
        String merge2 = ex1.concat(ex2);

        // == operatoru nesneleri karsilastirdigi icin sringler icin kullanamayiz.

        ex1.equals(ex2);
        ex2.equalsIgnoreCase(ex2);

        // hangisinin daha buyuk oldugunu gosterir
        "sezen".compareTo("sezer"); // pozitif: sezen buyuk, negatif: sezer buyuk, 0: esit
        System.out.println("sezen".compareTo("sezer"));

        //getChars() : stringin belli kismini char dizisine cevriri
        String ex3 = "KABADAYI";
        char[] charArray = new char[8];
        ex3.getChars(0, 8, charArray, 0);
        for (int i = 0; i < charArray.length; i++)
            System.out.print(charArray[i] + " - ");

        System.out.println();
        // charAt()
        System.out.println(ex3.charAt(4));

        //tocharArray() : Stringi char dizisine cevirir
        char[] chars = ex3.toCharArray();
        for (int i = 0; i < chars.length; i++)
            System.out.print(chars[i] + " - ");

        System.out.println();
        // indexOf() : verilen karakterin bulundugu ilk index i geri dondurur
        // lastIndexOf() : verilen karakterin bulundugu son index i geri verir
        System.out.println(ex3.indexOf("A"));
        // System.out.println(ex3.indexOf("A", 3));//3. indexten sonra arar
        System.out.println(ex3.lastIndexOf("A"));
        // System.out.println(ex3.lastIndexOf("A", 4));

        // substring()
        System.out.println(ex3.substring(4, 8));
        System.out.println("herre herre herre".substring(0, 3));

        // replace()
        String text = "TATA";
        System.out.println(text.replace("A", "AT"));

        //toUpperCase() & toLowerCase()
        System.out.println(text.toLowerCase());
        System.out.println(text.toUpperCase());

        // valueof()
        int it = 10;
        String.valueOf(it);

        // split()
        String text1 = "Life is beautiful";
        String[] texts = text1.split(" ");
        for (String st : texts)
            System.out.println(st);

        //contains
        System.out.println(text1.contains("Life"));

        // isEmpty()
        // length()
        // new String(array) : ile bir diziyi stringe cevirebilirsin

        //todo Chars
        char a = 'b';// sadece 1 karakter atanabilir
        System.out.println(a);

        char char1 = 65;// ascii karsiliklari yazildiginda alfabe karsiligini basar
        char char2 = 97;
        int num = 'A';
        System.out.println("char1: " + char1);
        System.out.println("char2: " + char2);
        System.out.println("num: " + num);

        int num1 = 97;
        char char3 = (char) num1;// int ten cevrilir
        System.out.println("char3: " + char3);

        char char4 = 'K';// +1 ile alfabede bir sonraki elemani getirir
        char4 = (char) (char4 + 1);
        char char5 = ('Z' - 1);

        System.out.println("char4: " + char4);
        System.out.println("char5: " + char5);

        String herre = "343";

        List list = new ArrayList();
        list.size();
        // list icin size()
        // string icin length()
        // dizi icin length

        String here = "herre";
        char[] alphabet = new char[26];
        // genelde int array uzerinden yapilir cunku burda countlarini tutuyoruz her bir harfin
        // index numaralari harf degerleri ise count oldugundan int tutmak daha mantikli
        int[] alphabetInt = new int[26];
        for(char c: here.toCharArray()){
            alphabet[c - 'a']++;
            alphabetInt[c - 'a']++;
        }
            

            // (int)alphabet[i] // prints counts in numeric
        System.out.println();
        for(int i = 0; i < alphabet.length; i++)
            System.out.print((char)(i+'a') + " -> " + (int)alphabet[i] + "\n");
        

    }

}