package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam2003_clear {
    static int[] arr;
    static int left = 0;
    static int right = 0;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int N = Integer.parseInt(tmp[0]);
        int M = Integer.parseInt(tmp[1]);
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        while (left<N){
            int result = cal(left,right);
            if(result>M|| right==N){
                left++;
            }else{
                right++;
            }
            if(result==M)
                count++;
        }
        System.out.println(count);

    }
    static int cal(int start,int end){
        int sum = 0;
        for(int i=start ; i<end; i++){
            sum+=arr[i];
        }
        return sum;
    }
}
