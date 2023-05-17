package B;

import java.util.Scanner;

class Result {

    /*
     * Complete the 'get_shell_color' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING gene as parameter.
     */

    public static String get_shell_color(String gene) {
        if (gene.charAt(gene.length()-1) == gene.charAt(0)){
            for (int i = 1; i < gene.length()/2; i++) {
                if (gene.charAt(i) != gene.charAt(gene.length()-1-i)){
                    return "green-shelled";
                }
            }
            return "blue-shelled";
        }
        else if ((gene.charAt(gene.length()-1) == 'T' && gene.charAt(0) == 'R')||(gene.charAt(gene.length()-1) == 'R' && gene.charAt(0) == 'T')||(gene.charAt(gene.length()-1) == 'S' && gene.charAt(0) == 'A')||(gene.charAt(gene.length()-1) == 'A' && gene.charAt(0) == 'S')){
            if (gene.length()%2==1){
                return "green-shelled";
            }
            for (int i = 0; i < gene.length()/2; i++) {
                char c = gene.charAt(gene.length() - 1 - i);
                if (gene.charAt(i) == 'R' && c != 'T'){
                    return "green-shelled";
                }
                if (gene.charAt(i) == 'T' && c != 'R'){
                    return "green-shelled";
                }
                if (gene.charAt(i) == 'S' && c != 'A'){
                    return "green-shelled";
                }
                if (gene.charAt(i) == 'A' && c != 'S'){
                    return "green-shelled";
                }
            }
            return "red-shelled";
        }
        return "green-shelled";
    }

}
public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println(Result.get_shell_color(s.next()));
    }
}
