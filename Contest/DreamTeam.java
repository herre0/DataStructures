package com.mert.Contest;

import java.util.*;

public class DreamTeam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Team> maxHeap = new PriorityQueue<>(new Comparator<Team>() {
            public int compare(Team t1, Team t2) {
                if(t1.cost == t2.cost) {
                    // sort by player list
                    for(int i = 0; i < t1.players.size(); i++){
                        String n1 = t1.players.get(i).name;
                        String n2 = t2.players.get(i).name;
                        if(!n1.equals(n2))
                            return n1.compareTo(n2);                        
                    }
                    
                    return -1;
                } else
                    return t2.cost - t1.cost;
            }
        });

        int budget = 235000;///sc.nextInt();

        List<Player> pList = new ArrayList();
        List<Player> gList = new ArrayList();
        List<Player> sList = new ArrayList();
        List<Player> fList = new ArrayList();
        List<Player> cList = new ArrayList();

        pList.add(new Player("curry", 40000));
        pList.add(new Player("nash", 20000));
        pList.add(new Player("johnson", 10000));


        gList.add(new Player("jordan", 50000));
        gList.add(new Player("wade", 20000));
        gList.add(new Player("bryant", 80000));

        sList.add(new Player("james", 30000));

        fList.add(new Player("duncan", 60000));

        cList.add(new Player("oneal",100000));

        // fill the lists from the input like that
        
        for(Player p: pList) {
            int sum = p.salary;
            if(sum > budget) {
                sum -= p.salary;    
                continue;
            }
            for(Player g: gList) {
                sum += g.salary;
                if(sum > budget) {
                    sum -= g.salary;    
                    continue;
                }
                for(Player s: sList) {
                    sum += s.salary;
                    if(sum > budget) {
                        sum -= s.salary;    
                        continue;
                    }
                    for(Player f: fList) {
                        sum += f.salary;
                        if(sum > budget) {
                            sum -= f.salary;    
                            continue;
                        }
                        for(Player c: cList) {
                            sum += c.salary;
                            if(sum > budget) {
                                sum -= c.salary;    
                                continue;
                            }
                            
                            
                            Team curTeam = new Team();
                            curTeam.cost = sum;
                            curTeam.players.add(p);
                            curTeam.players.add(g);
                            curTeam.players.add(s);
                            curTeam.players.add(f);
                            curTeam.players.add(c);

                            maxHeap.add(curTeam); 
                            sum -= c.salary;                           
                        }           
                        sum -= f.salary;               
                    }          
                    sum -= s.salary;          
                }
                sum -= g.salary;
            }
        }
        
        for(Player p: maxHeap.peek().players)
            System.out.println(p.name);
    }       

    static class Team {
        int cost;
        List<Player> players;
        public Team(){
            players = new ArrayList();
        }        
    }
    
    static class Player {
        String name;
        int salary;
        public Player(){}
        public Player(String name, int salary){
            this.name = name;
            this.salary = salary;
        }

        @Override
        public String toString(){
            return name + ": " + salary;
        }
    }


}

/*
235000
3
curry 40000
nash 20000
johnson 10000
3
jordan 50000
wade 20000
bryant 80000
1
james 30000
1
duncan 60000
1
oneal 100000

 */
