package H;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static int minCoins(int price, ArrayList<Integer> coinValues){
        int num = 0;
        for (int i = 0; i < coinValues.size(); i++) {
            num += price/coinValues.get(i);
            price %= coinValues.get(i);
        }
        return num;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int price = s.nextInt();
        int num = s.nextInt();
        ArrayList<Integer> coinValues = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            coinValues.add(s.nextInt());
        }
        System.out.println(minCoins(price,coinValues));
    }
}