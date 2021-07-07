package baekjun;

import java.util.*;

class Node {
    public int x;
    public int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class exam11650_clear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Node> nodeList = new ArrayList<>();
        for(int i=0 ; i<n ; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            nodeList.add(new Node(x,y));
        }
        Collections.sort(nodeList,new Comparator<Node>() {
            @Override
            public int compare(Node a, Node b) {
                // x 좌표의 값이 같다면, y의 값을 기준으로 정렬
                if (a.x == b.x) {
                    return Integer.compare(a.y, b.y);
                }
                // x 좌표의 값이 다르다면, x의 값을 기준으로 정렬
                return Integer.compare(a.x, b.x);
            }
        });
        for(Node node : nodeList){
            System.out.println(node.x+" "+node.y);
        }

    }
}
