package programmers;

import java.util.*;

public class Exam42888 {
    public static void main(String[] args) {
        Solution42888 s = new Solution42888();
        String[] result = s.solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"});
        System.out.println(Arrays.toString(result));
    }
}

class Solution42888 {
    public String[] solution(String[] record) {
        ArrayList<String> list = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < record.length; i++) {
            String[] tmp = record[i].split(" ");
            if (tmp[0].equals("Enter")) {
                map.put(tmp[1], tmp[2]);
            } else if (tmp[0].equals("Change")) {
                map.put(tmp[1], tmp[2]);
            }
        }
        for (int i = 0; i < record.length; i++) {
            String[] tmp = record[i].split(" ");
            if (tmp[0].equals("Enter")) {
                list.add(map.get(tmp[1]) + "님이 들어왔습니다.");
            } else if (tmp[0].equals("Leave")) {
                list.add(map.get(tmp[1]) + "님이 나갔습니다.");
            }
        }
        return list.toArray(new String[]{});
    }
}
