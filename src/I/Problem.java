package I;

public class Problem {
    public static void main(String[] args) {
        int R = (int) (Math.random()*16)*16;
        int G = (int) (Math.random()*16)*16;
        int B = (int) (Math.random()*16)*16;
        System.out.println("10000 " + R + " " + G + " " + B);
        for (int i = 0; i < 10000; i++) {
            if (Math.random() > 1.0/3){
                if (Math.random() > 0.5){
                    System.out.print("B ");
                }
                else{
                    System.out.print("G ");
                }
            }
            else{
                System.out.print("R ");
            }
        }
    }
}
