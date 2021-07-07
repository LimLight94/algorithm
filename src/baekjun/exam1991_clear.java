package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class exam1991_clear {
    static Map<String,Node> tm = new TreeMap<>();
    static class Node {
        public String val;
        public String left;
        public String right;

        public Node(String val, String left, String right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        for(int i=0 ; i<n ; i++){
            st = new StringTokenizer(bf.readLine());
            String data = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();
            tm.put(data,new Node(data,left,right));
        }
        preOrder(tm.get("A"));
        System.out.println();
        inOrder(tm.get("A"));
        System.out.println();
        postOrder(tm.get("A"));
        System.out.println();
    }

    static void preOrder(Node node){
        System.out.print(node.val);
        if(!node.left.equals(".")){
            preOrder(tm.get(node.left));
        }
        if(!node.right.equals(".")){
            preOrder(tm.get(node.right));
        }
    }

    static void inOrder(Node node){
        if(!node.left.equals(".")){
            inOrder(tm.get(node.left));
        }
        System.out.print(node.val);
        if(!node.right.equals(".")){
            inOrder(tm.get(node.right));
        }
    }

    static void postOrder(Node node){
        if(!node.left.equals(".")){
            postOrder(tm.get(node.left));
        }
        if(!node.right.equals(".")){
            postOrder(tm.get(node.right));
        }
        System.out.print(node.val);
    }
}
