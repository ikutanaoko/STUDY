public class Java230924_25 {
    public static void main(String[] args) throws Exception {
        // int i;
        // for (i = 0; i < 10; i++) {
        //     if (i == 5) {
        //         break;
        //     }
        //     System.out.println(i);
        // }
        // System.out.println("finish!");

        int a;
        int j;
        loop1:
            for (a = 0; a < 10; a++ ) {
                for (j = 0; j < 10; j++) {
                    if ((a == 1) && (j == 5)) {
                        break loop1;
                    }
                    System.out.println("a is" + a);
                    System.out.println("j is" +j);
                }
                System.out.println("contenue!");
            }

        }
        
}
