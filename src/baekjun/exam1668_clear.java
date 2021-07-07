package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam1668_clear {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n];
        for(int i=0 ; i<n ; i++){
            arr[i] = Integer.parseInt(bf.readLine());
        }

        int count = 0;
        int max = 0;
        for(int i=0 ; i<arr.length ; i++){
            if(arr[i]>max){
                count++;
                max= arr[i];
            }
        }
        System.out.println(count);
        count =0;
        max = 0;
        for(int i=arr.length-1 ; i>=0 ; i--){
            if(arr[i]>max){
                count++;
                max= arr[i];
            }
        }
        System.out.println(count);
    }
}
