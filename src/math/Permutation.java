package math;

import java.util.*;

class MainP{
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,7,9};
        Permutation p = new Permutation(arr.length,2);
        p.permutation(arr,0);
        System.out.println(p.getResult());
    }
}
public class Permutation {
    private int n;
    private int r;
    private int[] now;
    private ArrayList<ArrayList<Integer>> result;

    public Permutation(int n, int r) {
        this.n = n;
        this.r = r;
        this.now = new int[r];
        result = new ArrayList<>();
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public void permutation(int[] arr, int depth) {
        if (depth == r) {
            ArrayList<Integer> tmpList = new ArrayList<>();
            for (int i = 0; i < now.length; i++) {
                tmpList.add(now[i]);
            }
            result.add(tmpList);
            return;
        }
        for (int i = depth; i < n; i++) {
            swap(arr, i, depth);
            now[depth] = arr[depth];
            permutation(arr, depth + 1);
            swap(arr, i, depth);
        }
    }

    public ArrayList<ArrayList<Integer>> getResult() {
        return result;
    }
}

