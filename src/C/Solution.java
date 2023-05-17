package C;

import java.util.*;

class Player {
    private String name;
    private int j_b;
    private int j_g;
    private int j_r;
    private int j_y;

    public Player(String name, int b, int g, int r, int y) {
        this.name = name;
        this.j_b = b;
        this.j_g = g;
        this.j_r = r;
        this.j_y = y;
    }

    public String getName() {
        return name;
    }

    public int getB() {
        return j_b;
    }

    public int getG() {
        return j_g;
    }

    public int getR() {
        return j_r;
    }

    public int getY() {
        return j_y;
    }
}


public class Solution {
    public static int solve(ArrayList<ArrayList<String>> course, Player player) {
        int j_b = player.getB();
        int j_g = player.getG();
        int j_r = player.getR();
        int j_y = player.getY();
        ArrayList<ArrayList<Integer>> jumps = new ArrayList<>();
        for (int i = 0; i < course.size(); i++) {
            jumps.add(new ArrayList<>());
            for (int j = 0; j < course.get(0).size(); j++) {
                jumps.get(i).add(-1);
            }
        }
        walk(course,jumps,0,0,0);
        int z = 0;
        while (true){
            boolean jumped = false;
            for (int i = 0; i < jumps.size(); i++) {
                for (int j = 0; j < jumps.get(i).size(); j++) {
                        if (jumps.get(i).get(j) == z){
                            int max = switch(course.get(i).get(j)){
                                case "B"->j_b;
                                case "G" ->j_g;
                                case "R" -> j_r;
                                case "Y" -> j_y;
                                default -> 0;
                            };
                            for (int k = 2; k <= max+1; k++) {
                                boolean zd = false;
                                if (walk(course, jumps, i, j + k, z + 1)){
                                    zd = true;
                                }
                                if (walk(course, jumps, i, j - k, z + 1)){
                                    zd = true;
                                }
                                if (walk(course, jumps, i+k, j, z + 1)){
                                    zd = true;
                                }
                                if (walk(course, jumps, i-k, j, z + 1)){
                                    zd = true;
                                }
                                jumped = jumped || zd;
                            }
                        }
                }
            }
            if (!jumped){
                return -1;
            }
            z++;
            if (jumps.get(course.size()-1).get(course.get(0).size()-1) != -1) {
                return jumps.get(course.size() - 1).get(course.get(0).size()-1);
            }
        }
    }
    public static boolean walk(ArrayList<ArrayList<String>> course, ArrayList<ArrayList<Integer>> jumps, int x, int y, int set){
        if (x < 0 || y < 0 || x >= course.size() || y >= course.get(0).size() || course.get(x).get(y).equals("_") || jumps.get(x).get(y) != -1){
            return false;
        }
        jumps.get(x).set(y,set);
        for (int i = -1; i < 2; i+=2) {
            walk(course,jumps,x,y+i,set);
            walk(course,jumps,x+i,y,set);
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int w = scanner.nextInt();
        int h = scanner.nextInt();
        int c = scanner.nextInt();
        ArrayList<ArrayList<String>> course = new ArrayList<>();
        for (int i = 0; i < h; i++) {
            course.add(new ArrayList<>());
            for (int j = 0; j < w; j++) {
                course.get(i).add(scanner.next());
            }
        }
        ArrayList<Player> players = new ArrayList<>();
        for (int i = 0; i < c; i++) {
            players.add(new Player(scanner.next(),scanner.nextInt(),scanner.nextInt(),scanner.nextInt(),scanner.nextInt()));
        }
        for (int i = 0; i < c; i++) {
            System.out.println(players.get(i).getName() + " " + solve(course,players.get(i)));
        }
    }
}