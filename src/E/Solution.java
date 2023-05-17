package E;


import java.util.Scanner;

public class Solution {

    public static int minHits(String bowserLife){
        int hits = 0;
        while (bowserLife.length() > 0) {
            StringBuilder answer = new StringBuilder();
            boolean addFive = false;
            for (int i = 0; i < bowserLife.length(); i++) {
                char c = bowserLife.charAt(i);
                answer.append(Integer.parseInt(c + "") / 2 + (addFive ? 5 : 0));
                addFive = c % 2 == 1;
            }
            if (answer.toString().startsWith("0")){
                answer.delete(0,1);
            }
            bowserLife = answer.toString();
            hits++;
        }
        return hits;
    }

    public static void main(String[] args) {
        System.out.println(minHits(new Scanner(System.in).next()));
    }
}