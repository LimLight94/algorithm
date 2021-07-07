package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam9663_clear {
    static int[] col;
    static int n;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        col = new int[n];

        for(int i=0 ; i<n ; i++){
            col[0] = i;
            queen(0);
        }

        System.out.println(count);

    }

    static void queen(int index){
        if(promising(index)){
            if(index==n-1){
                count++;
            }else{
                for(int i=0 ;i<n ;i++){
                    col[index+1] = i;
                    queen(index+1);
                }
            }
        }
    }

    static boolean promising(int index){
        if(index==0)
            return true;
        for(int i=0 ; i<index ; i++){
            if(col[i]==col[index] ||  col[i]-col[index]==(index-i) || col[index]-col[i]==(index-i) ){
                return false;
            }
        }
        return true;
    }
}
