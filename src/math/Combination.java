package math;

import java.util.ArrayList;

class MainC {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        Combination combination = new Combination(5,2);
        combination.combination(arr,0,0,0);
        System.out.println(combination.result);
    }
}

public class Combination {
    int n;
    int r;
    int[] now;
    ArrayList<ArrayList<Integer>> result;

    public Combination(int n, int r) {
        this.n = n;
        this.r = r;
        this.now = new int[r];
        this.result = new ArrayList<>();
    }

    public void combination(int[] arr, int depth, int index, int target) {
        if (depth == r) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < now.length; i++) {
                temp.add(arr[now[i]]);
            }
            result.add(temp);
            return;
        }
        if (target == n) return;
        now[index] = target;
        combination(arr, depth + 1, index + 1, target + 1);
        combination(arr, depth, index, target + 1);
    }
}
