package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;


public class exam1781_clear {
    public static void main(String[] args) throws IOException {
        long result = 0;
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<ExamCupRamen> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] tmp = br.readLine().split(" ");
            ExamCupRamen cupRamen = new ExamCupRamen(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]));
            list.add(cupRamen);
        }
        list.sort((o1, o2) -> {
            return o1.deadLine - o2.deadLine;
        });
        for (ExamCupRamen item : list) {
            priorityQueue.add(item.cupCount);
            if (item.deadLine < priorityQueue.size())
                priorityQueue.poll();
        }
        for (long item: priorityQueue){
            result+=item;
        }
        System.out.println(result);
    }

    static class ExamCupRamen {
        int deadLine;
        long cupCount;

        public ExamCupRamen(int deadLine, long cupCount) {
            this.deadLine = deadLine;
            this.cupCount = cupCount;
        }

        @Override
        public String toString() {
            return "ExamCupRamen{" +
                    "deadLine=" + deadLine +
                    ", cupCount=" + cupCount +
                    '}';
        }
    }
}
