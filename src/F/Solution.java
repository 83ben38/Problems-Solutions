package F;


import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static long minDistance(ArrayList<int[]> locations, int skips){
        ArrayList<Integer> skipAmounts = new ArrayList<>();
        for (int i = 1; i < locations.size(); i+=2) {
            skipAmounts.add(Math.abs(locations.get(i-1)[0]-locations.get(i)[0]) + Math.abs(locations.get(i+1)[0]-locations.get(i)[0]) - Math.abs(locations.get(i-1)[0]-locations.get(i+1)[0]) + Math.abs(locations.get(i-1)[1]-locations.get(i)[1]) + Math.abs(locations.get(i+1)[1]-locations.get(i)[1]) - Math.abs(locations.get(i-1)[1]-locations.get(i+1)[1]));
        }
        int[] max = new int[skips];
        if (skips > 0) {
            for (int i = 0; i < skipAmounts.size(); i++) {
                if (skipAmounts.get(i) > max[0]) {
                    int k = 0;
                    for (int j = 0; j < max.length; j++) {
                        if (skipAmounts.get(i) > max[j]) {
                            k = j;
                        }
                    }
                    for (int j = k; j > 0; j--) {
                        max[j - 1] = max[j];
                    }
                    max[k] = skipAmounts.get(i);
                }
            }
        }
        int total = 0;
        for (int i = 0; i < locations.size()-1; i++) {
            total += Math.abs(locations.get(i)[0]-locations.get(i+1)[0]);
            total += Math.abs(locations.get(i)[1]-locations.get(i+1)[1]);
        }
        for (int i = 0; i < max.length; i++) {
            total -= max[i];
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int z = s.nextInt();
        int skips = s.nextInt();
        ArrayList<int[]> locations = new ArrayList<>();
        locations.add(new int[]{0,0});
        for (int i = 0; i < z; i++) {
            locations.add(new int[]{s.nextInt(),s.nextInt()});
        }
        System.out.println(minDistance(locations,skips));
    }
}