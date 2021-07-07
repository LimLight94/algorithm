package baekjun;

import java.util.Scanner;

public class exam1568_clear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int count = 1;
        int result = 0;
        while (n!=0){
            if(n>=count){
                n -= count++;
                result++;
            }else{
                count = 1;
            }
        }
        System.out.println(result);
    }
}
