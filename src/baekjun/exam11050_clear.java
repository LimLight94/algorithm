package baekjun;

import java.util.Scanner;

public class exam11050_clear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int result = 1;
        for(int i=n ; i>n-c ; i--){
            result *= i;
        }

        for(int i=c ; i>0 ; i--){
            result /= i;
        }

        System.out.println(result);
    }
}
