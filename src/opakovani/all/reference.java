package opakovani.all;

public class reference {
    public static void main(String[] args) {
        int a = 5;
        int[] b = {5,8};
        System.out.println("a " + a);
        System.out.println("b0 " + b[0]);
        System.out.println("b1 " + b[1]);
        square(a);
        square(b);
        System.out.println("a " + a);
        System.out.println("b0 " + b[0]);
        System.out.println("b1 " + b[1]);
        retardation(b);
        System.out.println("b1 " + b[1]);
        System.out.println("b0 " + b[0]);

    }
    static void square(int a){
        int s = a * a;
        System.out.println(s);
        a = s;
    }
    static void square(int[] b){
        int s = b[0] * b[0];
        System.out.println(s);
        b[0] = s;
    }
    static void retardation(int[] b){
        System.out.println(b[1]);
        for (int i = 2; i < Math.pow(2, 24); i = i*i) {
            if (b[1]*i > 0) {
                System.out.println(b[1] + "*" + i + "=" + (b[1] * i));
                b[1] = b[1] * i;
                b[0] = i;
            }else break;
        }
    }
}
