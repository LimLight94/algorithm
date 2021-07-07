package baekjun;

import java.util.Scanner;

public class exam1074_clear {
    static int count=0;
    static int r=0;
    static int c=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
        recur(0,0,n);

    }

    static void recur(double row, double col, int n){
        if(n==1){
            if(row==r && col==c){
                System.out.println(count);
                return;
            }
            count+=1;
            if(row==r && col+1 == c){
                System.out.println(count);
                return;
            }
            count+=1;
            if(row+1==r && col == c){
                System.out.println(count);
                return;
            }
            count+=1;
            if(row+1==r && col+1 == c){
                System.out.println(count);
                return;
            }
            count+=1;
        }else {
            if(row +  Math.pow(2, n - 1)<=r && col +  Math.pow(2, n - 1)<=c) {
                count+= 3*Math.pow(4,n-1);
                recur(row +  Math.pow(2, n - 1), col + Math.pow(2, n - 1), n-1);
            }else if( row +  Math.pow(2, n - 1) > r && col +  Math.pow(2, n - 1)<=c){
                count+= 1*Math.pow(4,n-1);
                recur(row, col + Math.pow(2, n - 1), n - 1);
            }else if(row +  Math.pow(2, n - 1) <= r && col +  Math.pow(2, n - 1)>c){
                count+= 2*Math.pow(4,n-1);
                recur(row +  Math.pow(2, n - 1), col, n-1);
            }else{
                recur(row, col, n - 1);
            }
        }
    }
}
