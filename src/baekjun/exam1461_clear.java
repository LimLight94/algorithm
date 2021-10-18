package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class exam1461_clear {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Integer> plusList = new ArrayList<>();
        ArrayList<Integer> minusList = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<N ; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if(tmp>0) plusList.add(tmp);
            else minusList.add(Math.abs(tmp));
        }
        plusList.sort(Collections.reverseOrder());
        minusList.sort(Collections.reverseOrder());
        ArrayList<Integer> resultList = new ArrayList<>();
        int idx = 0;
        while (idx<plusList.size()){
            resultList.add(plusList.get(idx));
            idx+=M;
        }
        idx = 0;
        while (idx<minusList.size()){
            resultList.add(minusList.get(idx));
            idx+=M;
        }
        resultList.sort(Comparator.reverseOrder());
        int result = 0;
        for(int i=0 ; i<resultList.size() ; i++){
            if(i==0) result+=resultList.get(i);
            else result+=resultList.get(i)*2;
        }
        System.out.println(result);
    }
}
