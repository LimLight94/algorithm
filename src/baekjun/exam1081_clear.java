package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam1081_clear {
    public static void main(String[] args) throws IOException {
        int startNum = 0;
        int lastNum = 0;

        int result = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        startNum = Integer.parseInt(s[0]);
        lastNum = Integer.parseInt(s[1]);

        for(int i=startNum ; i<=lastNum ; i++){
            result += splitSum(i);
        }

        System.out.println(result);
    }

    static int splitSum(int num){
        int sum = 0;
        while(num!=0){
            sum+= num%10;
            num /= 10;
        }
        return sum;
    }
}
