package baekjun;

import java.util.Scanner;

public class exam1427_2_clear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        String[] array = n.split("");
        int[] result = new int[array.length];
        for(int i=0 ; i<array.length ; i++){
            result[i] = Integer.parseInt(array[i]);
        }
        for(int i=9 ; i>=0 ;i--){
            for(int tmp : result){
                if(i==tmp)
                    System.out.print(tmp);
            }
        }
    }
}
