package baekjun;

import java.util.Scanner;

public class exam2609_clear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int i = 2;
        int min =1;
        while (i <= a && i <= b) {
            if (a % i == 0 && b % i == 0) min = i;
            i++;
        }
        int max = a * b / min; //최소 공배수 구하는 식

        System.out.println(min);
        System.out.println(max);

    }
}
