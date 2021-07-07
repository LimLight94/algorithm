package baekjun;

import java.util.Scanner;

public class exam2747_clear {
    static int max;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        max = sc.nextInt();
        int a = 0;
        int b = 1;
        int tmp = 0;
        while (max>0){
            tmp = a;
            a = b;
            b = a+tmp;
            max--;
        }
        System.out.println(a);
    }

}
