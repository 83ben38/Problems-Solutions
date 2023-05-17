package H;

public class Problem {
    public static void main(String[] args) {
        int z = (int) (Math.random()*1000000000);
        System.out.println(z);
        System.out.println(25);
        int value = (int) (Math.sqrt(Math.random())*z);
        for (int i = 0; i < 24; i++) {
            System.out.println(value);
            value *= Math.random();
        }
        System.out.println(1);
    }
}
