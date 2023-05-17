package D;

import java.util.ArrayList;

public class Problem {
    public static void main(String[] args) {
        System.out.print(500);
        int z = 0;
        ArrayList<Integer> used = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            used.add(z);
            z += 1 + Math.random()*5;
        }
        used.add(z);
        for (int i = 0; i < 500; i++) {
            System.out.print("\n" + used.remove(0));
            int v = (int) (Math.random()*used.size());
            System.out.print(" " + v);
            ArrayList<Integer> use = new ArrayList<>();
            for (int j = 0; j < v; j++) {
                int connected = used.get((int) (Math.random()*used.size()));
                while (use.contains(connected)){
                    connected = used.get((int) (Math.random()*used.size()));
                }
                use.add(connected);
                System.out.print(" " +connected);
                System.out.print(" " +((int)(Math.random()*4)+ 1));
            }
        }
    }
}
