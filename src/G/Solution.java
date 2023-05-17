package G;

import java.util.ArrayList;
import java.util.Scanner;
class location{
    int x, y;
    location N, E, S, W;
    int restriction;
    boolean coin;
    boolean visited = false;
    public location(int x, int y, char coin){
        if (coin == 'C'){
            this.coin = true;
        }
        if (coin == '#'){
            restriction = -1;
        }
        if (coin == 'M'){
            Solution.mario = this;
        }
        this.x=x;
        this.y=y;
    }
    public void setUp(ArrayList<ArrayList<location>> locations){
        if (restriction == -1){
            return;
        }
        if (y-1 >= 0){
            S = locations.get(x).get(y-1);
        }
        if (y+1 < locations.get(0).size()){
            N = locations.get(x).get(y+1);
        }
        if (x-1 >= 0){
            W = locations.get(x-1).get(y);
        }
        if (x+1< locations.size()){
            E = locations.get(x+1).get(y);
        }
    }
    public void doRestrictions(){
        if (restriction == -1){
            return;
        }
        if (E == null){
            restriction = 2;
            return;
        }
        restriction = E.restriction+1;
    }

    public int coins(){
        if (restriction == -1 || visited){
            return 0;
        }
        visited = true;
        int coins = coin ? 1 : 0;
        if (W != null && restriction < 2){
            coins += W.coins();
        }
        if (N != null && restriction < 3){
            coins += N.coins();
        }
        if (S != null && restriction < 3){
            coins += S.coins();
        }
        if (E != null){
            coins += E.coins();
        }
        return coins;
    }
}
public class Solution {
    public static location mario;
    public static int coins(ArrayList<ArrayList<Character>> map){
        ArrayList<ArrayList<location>> map2 = new ArrayList<>();
        for (int i = 0; i < map.size(); i++) {
            map2.add(new ArrayList<>());
            for (int j = 0; j < map.get(i).size(); j++) {
                map2.get(i).add(new location(i,j,map.get(i).get(j)));
            }
        }
        for (int i = 0; i < map2.size(); i++) {
            for (int j = 0; j < map2.get(i).size(); j++) {
                map2.get(i).get(j).setUp(map2);
            }
        }
        for (int i = map2.size()-1; i >= 0; i--) {
            for (int j = 0; j < map2.get(i).size(); j++) {
                map2.get(i).get(j).doRestrictions();
            }
        }
        return mario.coins();
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Character>> map = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        int w = s.nextInt();
        int h = s.nextInt();
        for (int i = 0; i < h; i++) {
            map.add(new ArrayList<>());
            for (int j = 0; j < w; j++) {
                map.get(i).add(s.next().charAt(0));
            }
        }
        System.out.println(coins(map));
    }
}