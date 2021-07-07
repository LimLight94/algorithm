package baekjun;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class exam11866_clear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        List<Integer> resultList = new ArrayList<>();
        for(int i=1 ; i<=n ; i++){
            list.add(i);
        }
        int index = 0;
        while (list.size()!=0){
            index+=k-1;
            if(index>=list.size())
                index = (index%list.size());
            resultList.add(list.remove(index));
        }

        System.out.print("<"+resultList.get(0));

        for(int i=1 ; i<n ; i++){
            System.out.printf(", %d",resultList.get(i));
        }

        System.out.print(">");
    }
}
