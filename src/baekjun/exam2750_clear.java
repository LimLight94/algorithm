package baekjun;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class exam2750_clear {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        for(int i=0 ; i<n ; i++){
            list.add(scanner.nextInt());
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1<o2)
                    return -1;
                else if(o1>o2)
                    return 1;
                else
                    return 0;
            }
        });
        for(int a : list){
            System.out.println(a);
        }
    }
}
