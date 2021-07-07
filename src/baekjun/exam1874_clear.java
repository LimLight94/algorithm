package baekjun;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class exam1874_clear {
    public static void main(String[] args) {
        //input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num_arr = new int[n];
        List<String> result_arr = new ArrayList<>();
        for(int i=0 ; i<n ; i++){
            num_arr[i] = sc.nextInt();
        }
        int target=1;
        int index = 0;
        Stack<Integer> st = new Stack<>();
        while(true){
            if(index==n){
                for(int j=0 ; j<result_arr.size(); j++){
                    System.out.println(result_arr.get(j));
                }
                return;
            }
            if(st.isEmpty()) {
                st.push(target++);
                result_arr.add("+");
            }else if(st.peek()==num_arr[index]){
                st.pop();
                result_arr.add("-");
                index++;
            }else if(st.peek()<num_arr[index]){
                st.push(target++);
                result_arr.add("+");
            }else{
                System.out.println("NO");
                return;
            }
        }
    }
}
