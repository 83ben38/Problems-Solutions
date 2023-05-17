package C;

public class Problem {
    public static void main(String[] args) {
        System.out.println("100 100 4");
        for (int i = 0; i < 100; i++) {
            String z = "";
            for (int j = 0; j < 100; j++) {
                if (Math.random() > 0.4){
                    z += "_ ";
                }
                else{
                    if (Math.random() > 0.5) {
                        if (Math.random() > 0.5) {
                            z += "G ";
                        }
                        else{
                            z += "R ";
                        }
                    }
                    else{
                        if (Math.random() > 0.5) {
                            z += "Y ";
                        }
                        else{
                            z += "B ";
                        }
                    }
                }
            }
            z = z.substring(0,z.length()-1);
            if (i == 99){
                z = z.substring(0,z.length()-1) + "G";
            }
            if (i == 0){
                z = "Y" + z.substring(1);
            }
            System.out.println(z);
        }
    }
}
