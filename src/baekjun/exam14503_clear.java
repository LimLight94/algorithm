package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class exam14503_clear {
    static int[][] array;
    static int x, y, direction;
    static int rotateCount = 0;
    static int cleaningCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        array = new int[n][m];
        st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        direction = Integer.parseInt(st.nextToken()); // 0:up 1:right 2:botton 3:left

        for (int i = 0; i < array.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cleaning();
        System.out.println(cleaningCount);
    }

    static void cleaning() {
        array[y][x] = -1;
        cleaningCount++;
//        System.out.println((x) + " , " + (y));
        search();
    }

    static void search() {
        if(rotateCount<4){
//        if (array[y - 1][x] == 0 || array[y + 1][x] == 0 || array[y][x + 1] == 0 || array[y][x - 1] == 0) {
            int[] tmp = getLeftLocation();
            if (array[tmp[1]][tmp[0]] == 0) {
                rotateCount = 0;
                x = tmp[0];
                y = tmp[1];
                rotateLeft();
                cleaning();
            } else {
                rotateCount++;
                rotateLeft();
                search();
            }
        } else {
            int[] tmp = getBottomLocation();
            rotateCount = 0;
            if (array[tmp[1]][tmp[0]] == 1)
                return;
            else {
                x = tmp[0];
                y = tmp[1];
                search();
            }
        }
    }

    static int[] getBottomLocation() {
        int[] result = new int[2];
        switch (direction) {
            case 0:
                result[0] = x;
                result[1] = y+1;
                break;
            case 1:
                result[0] = x-1;
                result[1] = y;
                break;
            case 2:
                result[0] = x;
                result[1] = y-1;
                break;
            case 3:
                result[0] = x+1;
                result[1] = y;
                break;
        }
        return result;
    }

    static int[] getLeftLocation() {
        int[] result = new int[2];
        switch (direction) {
            case 0:
                result[0] = x - 1;
                result[1] = y;
                break;
            case 1:
                result[0] = x;
                result[1] = y - 1;
                break;
            case 2:
                result[0] = x + 1;
                result[1] = y;
                break;
            case 3:
                result[0] = x;
                result[1] = y + 1;
                break;
        }
        return result;
    }

    static void rotateLeft() {
        switch (direction) {
            case 0:
                direction = 3;
                break;
            case 1:
                direction = 0;
                break;
            case 2:
                direction = 1;
                break;
            case 3:
                direction = 2;
                break;
        }
    }
}
