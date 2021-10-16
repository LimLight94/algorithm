package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class exam1092_clear {
    public static void main(String[] args) throws IOException {
        // input
        int boxCount = 0;
        int turnCount = 0;
        Integer[] arrCar;
        ArrayList<Integer> arrBox = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arrCar = new Integer[N];
        String[] tmp = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arrCar[i] = Integer.parseInt(tmp[i]);
        }
        int M = Integer.parseInt(br.readLine());
        tmp = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            arrBox.add(Integer.parseInt(tmp[i]));
        }

        //logic
        Arrays.sort(arrCar, Collections.reverseOrder());
        arrBox.sort(Collections.reverseOrder());
        if (arrCar[0] < arrBox.get(0)) {
            System.out.println(-1);
            return;
        }
        while (boxCount < M) {
            for (int Max : arrCar) {
                for (int j = 0; j < arrBox.size(); j++) {
                    if (arrBox.get(j) == 0) {
                        continue;
                    }
                    if (Max >= arrBox.get(j)) {
                        arrBox.remove(j);
                        boxCount++;
                        break;
                    }
                }
            }
            turnCount++;
        }
        System.out.println(turnCount);
    }
}
