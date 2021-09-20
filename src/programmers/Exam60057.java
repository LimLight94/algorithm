package programmers;

import java.util.ArrayList;

public class Exam60057 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("aabbaccc"));
    }
}

class Solution {
    int minLength;

    public int solution(String s) {
        minLength = s.length();
        for (int i = 1; i <= s.length(); i++) {
            ArrayList<String> list = new ArrayList<>();
            int[] arrCount = new int[1000];
            int idx = 0;
            while (idx + i <= s.length()) {
                String tmp = s.substring(idx, idx + i);
                if (!list.isEmpty()) {
                    if (list.get(list.size() - 1).equals(tmp)) {
                        arrCount[list.size() - 1]++;
                    }else{
                        list.add(tmp);
                    }
                } else {
                    list.add(tmp);
                }
                idx += i;
            }
            StringBuilder sb = new StringBuilder();
            for (int j=0 ; j< list.size() ; j++){
                if(arrCount[j]!=0){
                    sb.append(arrCount[j]+1);
                }
                sb.append(list.get(j));
            }
            sb.append(s.substring(idx));
            minLength = Math.min(minLength, sb.length());
        }
        return minLength;
    }
}
