package programmers.lv2;
import java.util.*;
public class P42892 {
    class Solution {
        int[][] answer;
        int idx;
        public int[][] solution(int[][] nodeinfo) {
            Node[] nodes = new Node[nodeinfo.length];
            for(int i =0; i<nodeinfo.length; i++){
                nodes[i] = new Node(i+1,nodeinfo[i][0],nodeinfo[i][1]);
            }

            Arrays.sort(nodes,new Comparator<Node>(){
                public int compare(Node n1, Node n2){
                    if(n1.y == n2.y) return n1.x - n2.x;
                    return n2.y - n1.y;
                }
            });

            Node root = nodes[0];
            for(int i =1; i<nodes.length; i++){
                insertNode(root,nodes[i]);
            }


            answer = new int[2][nodeinfo.length];
            idx = 0;
            preOrder(root);
            idx = 0;
            postOrder(root);

            return answer;
        }

        public void insertNode(Node now, Node n){
            if(now.x < n.x){
                if(now.right == null) now.right = n;
                else insertNode(now.right, n);
            }else {
                if(now.left == null) now.left = n;
                else insertNode(now.left, n);
            }
        }

        public void preOrder(Node now){
            answer[0][idx++] = now.key;
            if(now.left != null) preOrder(now.left);
            if(now.right != null) preOrder(now.right);
        }

        public void postOrder(Node now){
            if(now.left != null) postOrder(now.left);
            if(now.right != null) postOrder(now.right);
            answer[1][idx++] = now.key;
        }

        public class Node{
            public int key,x,y;
            public Node left,right;
            public Node(int key, int x, int y){
                this.key = key;
                this.x = x;
                this.y = y;
                left = null;
                right = null;
            }
        }
    }
}
