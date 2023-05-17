package I;


import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static int toadGroups(int R, int G, int B, ArrayList<Character> S){
        int numGroups = 0;
        for (int i = 1; i <= S.size(); i++) {
            int[] colors = new int[]{0,0,0};
            for (int j = 0; j < i-1; j++) {
                colors[S.get(j) == 'R' ? 0 : S.get(j) == 'G' ? 1 : 2]++;
            }
            for (int j = 0; j <= S.size()-i; j++) {
                colors[S.get(j+i-1) == 'R' ? 0 : S.get(j+i-1) == 'G' ? 1 : 2]++;
                for (; true; ) {
                    {
                        if (colors[0] == 0 && R != 0) {
                            break;
                        }
                        if (colors[1] == 0 && G != 0) {
                            break;
                        }
                        if (colors[2] == 0 && B != 0) {
                            break;
                        }
                        if (colors[0] != 0 && R == 0) {
                            break;
                        }
                        if (colors[1] != 0 && G == 0) {
                            break;
                        }
                        if (colors[2] != 0 && B == 0) {
                            break;
                        }
                    }
                    if (R == 0){
                        if (B==0 || G==0){
                            numGroups++;
                            break;
                        }
                        if ((double)colors[1]/colors[2] == (double)G/B){
                            numGroups++;
                        }
                        break;
                    }
                    if (B == 0){
                        if (G == 0){
                            numGroups++;
                            break;
                        }
                        if ((double)G/R == (double)colors[1]/colors[0]){
                            numGroups++;
                        }
                        break;
                    }
                    if (G == 0){
                        if ((double)B/R == (double)colors[2]/colors[0]){
                            numGroups++;
                        }
                        break;
                    }
                    if ((double)colors[2]/colors[1] == (double)B/G && (double)colors[2]/colors[0] == (double)B/R){
                        numGroups++;
                    }
                    break;
                }
                colors[S.get(j) == 'R' ? 0 : S.get(j) == 'G' ? 1 : 2]--;
            }
        }
        return numGroups;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int r = s.nextInt();
        int g = s.nextInt();
        int b = s.nextInt();
        ArrayList<Character> troops = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            troops.add(s.next().charAt(0));
        }
        System.out.println(toadGroups(r,g,b,troops));
    }
}