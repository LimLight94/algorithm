package baekjun;

import java.util.Scanner;

public class exam2164_clear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n*2+1];
        for (int i = 0; i < n; i++) {
            arr[i] = i+1;
        }

        if(n==1){
            System.out.println(1);
            return;
        }

        int removeCount = 0;
        int cur = 0;
        int last = n;
        while(true){
            removeCount+=1;
            cur+=1;
            if(removeCount>=n-1){
                System.out.println(arr[cur]);
                break;
            }
            arr[last++] = arr[cur];
            cur+=1;
        }

    }
}
