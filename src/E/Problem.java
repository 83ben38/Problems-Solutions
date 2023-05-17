package E;

public class Problem {
    public static void main(String[] args) {
        StringBuilder in = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            in.append((int)(Math.random()*10));
        }
        System.out.println(in);
    }
}
