package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class exam1713_clear {
    static int N;
    static int K;
    static List<Person> list;
    static Person[] people;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        people = new Person[101];
        list = new ArrayList<>();
        String[] tmp = br.readLine().split(" ");
        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(tmp[i]);
            if(people[num]==null){
                people[num] = new Person(num,0,0,false);
            }
            if(people[num].isIn){
                people[num].count++;
            }else{
                if(list.size()==N){
                    Collections.sort(list);
                    Person p = list.remove(0);
                    p.isIn = false;
                }
                people[num].count = 1;
                people[num].isIn = true;
                people[num].timeStamp = i;
                list.add(people[num]);
            }
        }
        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.num-o2.num;
            }
        });
        for (Person p : list){
            System.out.print(p.num+" ");
        }
    }
}

class Person implements Comparable<Person>{
    int num;
    int count;
    int timeStamp;
    boolean isIn;

    public Person(int num, int count, int timeStamp, boolean isIn) {
        this.num = num;
        this.count = count;
        this.timeStamp = timeStamp;
        this.isIn = isIn;
    }

    @Override
    public String toString() {
        return "{" +
                "num=" + num +
                ", count=" + count +
                ", timeStamp=" + timeStamp +
                ", isIn=" + isIn +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        if(count==o.count){
            return timeStamp-o.timeStamp;
        }else{
            return count-o.count;
        }
    }
}
