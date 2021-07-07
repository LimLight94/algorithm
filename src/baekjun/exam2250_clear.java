package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class exam2250_clear {
    static Map<Integer, Node> tm = new TreeMap<>();
    static int col = 1;
    static Map<Integer,Counting> tmCount = new TreeMap<>();

    static int resultLev = 0;
    static int resultDiff = 0;
    static class Node {
        public Integer val;
        public Integer left;
        public Integer right;

        public Node(Integer val, Integer left, Integer right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    static class Counting{
        public int min;
        public int max;

        public Counting(int min, int max) {
            this.min = min;
            this.max = max;
        }

        public int getDiff(){
            return max-min+1;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        int isFirst = -1;
        boolean[] isNotParent = new boolean[n+2];
        for(int i=0 ; i<n ; i++){
            st = new StringTokenizer(bf.readLine());
            Integer data = Integer.valueOf(st.nextToken());
            Integer left = Integer.valueOf(st.nextToken());
            isNotParent[left+1] = true;
            Integer right = Integer.valueOf(st.nextToken());
            isNotParent[right+1] = true;
            tm.put(data,new Node(data,left,right));
        }
        int startNodeIdx = 0;
        for(int i=2 ; i<n+2 ; i++){
            if(!isNotParent[i])
                startNodeIdx = i-1;
        }
        preOrder(tm.get(startNodeIdx),1);
        for(Integer i : tmCount.keySet()){
            if(resultDiff<tmCount.get(i).getDiff()){
                resultLev = i;
                resultDiff = tmCount.get(i).getDiff();
            }
        }
        System.out.printf("%d %d\n",resultLev,resultDiff);
    }

    static void preOrder(Node node, int level){
        if(node.left!=-1){
            preOrder(tm.get(node.left),level+1);
        }
        if(tmCount.getOrDefault(level,null)==null){
            tmCount.put(level,new Counting(col,col));
        }else{
            Counting c =tmCount.get(level);
            if(c.max<col){
                c.max = col;
            }
            tmCount.put(level,c);
        }
//        System.out.printf("%d(%d,%d) ",node.val,level,col);
        col+=1;
        if(node.right!= -1){
            preOrder(tm.get(node.right),level+1);
        }
    }
}
