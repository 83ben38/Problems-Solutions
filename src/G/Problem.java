package G;

public class Problem {
    public static void main(String[] args) {
        System.out.println("100 100");
        StringBuilder stringBuilder = new StringBuilder();
        boolean mario = false;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (Math.random() > 0.5){
                    stringBuilder.append(".");
                }
                else{
                    if (Math.random() > 0.5){
                        stringBuilder.append("C");
                    }
                    else{
                        stringBuilder.append("#");
                        if (!mario && Math.random() < 0.1 && i > 0){
                            stringBuilder.setCharAt(stringBuilder.length()-(100*2 + 2),'M');
                            mario = true;
                        }
                    }
                }
                stringBuilder.append(" ");
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }
}
