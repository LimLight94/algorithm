package baekjun;

import java.util.Arrays;
import java.util.Scanner;

public class exam1427_clear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        String[] array = n.split("");
        int[] result = new int[array.length];
        for(int i=0 ; i<array.length ; i++){
            result[i] = Integer.parseInt(array[i]);
        }
        Arrays.sort(result);
        for(int i=result.length-1 ; i>=0 ; i--){
            System.out.print(result[i]);
        }

    }
}
