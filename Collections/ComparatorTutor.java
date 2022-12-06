package com.mert.Collections;

import java.util.Comparator;
import java.util.*;

public class ComparatorTutor {



    public static void main(String[] args) {

        List<Player> pList = new ArrayList();
        pList.add(new Player("Natalie", 350));
        pList.add(new Player("John", 1791));
        pList.add(new Player("Chad", 1250));
        pList.add(new Player("Davis", 1400));
        pList.add(new Player("Vanessa", 700));
        pList.add(new Player("Andy", 1400));
        pList.add(new Player("Gayle", 1903));
        pList.add(new Player("Sarah", 400));
        pList.add(new Player("Peter", 350));
        pList.add(new Player("Tobin", 1400));        


        /* x.compareTo(y):            
         * negative value: if x < y, x appears first
         * zero if x == y, they appear either order
         * positive value: if x > y, x appears second
         */

         Comparator comparator = new Comparator<Player>(){
            @Override
            public int compare(Player p1, Player p2) {
                // if same point, sort by name in asc order
                if(p1.score == p2.score){
                    return p1.name.compareTo(p2.name);// asc order
                }
    
                // if(score1 > score2){
                //     return -1; // score 1 appears first (descending order)
                // } else
                //     return 1;
    
                return p2.score - p1.score;
                // this works exactly the same with above if-else
            }
         };

         Comparator comparator2 = new Comparator<Player>(){
            @Override
            public int compare(Player p1, Player p2) {
                if(p1.score == p2.score){
                    return p2.name.compareTo(p1.name);// descending order
                }
    
                return p1.score - p2.score;
            }
         };

         Collections.sort(pList, comparator); // desc scores, asc name if scores're same
         System.out.println(pList);

         Collections.sort(pList, comparator2); // asc scores, desc name
         System.out.println(pList);
    }

    static class Player {
        String name;
        int score;

        public Player(String name, int score) {
            this.name = name;
            this.score = score;
        }
        public Player() {
        }

        @Override
        public String toString(){
            return name + " - " + score + "\n";
        }

    }
    
}
