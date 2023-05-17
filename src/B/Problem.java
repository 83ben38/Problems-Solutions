package B;


public class Problem {
    public static void main(String[] args) {
        String s = "T";
        for (int i = 0; i < 100; i++) {
            if (Math.random() > 0.5){
                if (Math.random() > 0.5){
                    s = 'T' + s + 'R';
                }
                else{
                    s = 'R' + s + 'T';
                }
            }
            else{
                if (Math.random() > 0.5){
                    s = 'S' + s + 'A';
                }
                else{
                    s = 'A' + s + 'S';
                }
            }
        }
        System.out.println(s);
    }
}
