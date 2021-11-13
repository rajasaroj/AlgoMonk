package algomonk.geekforgeek;

import java.util.*;

/**
 * https://practice.geeksforgeeks.org/problems/level-order-traversal/1
 * 177 level order traversal
 *
 *
 *
 * Algorithm: Breath First Search
 *         10
 *      /      \
 *     20       30
 *   /   \
 *  40   60
 *
 *
 *
 * queue
 * [10, 20, 30]
 * root 10 insert in arr[10]
 * explore [10]: 20 30
 * insert explored elements
 *
 * queue
 * [20, 30, 40 60]
 * deque 20 insert in arr[10, 20]
 * explore [20]: 40,60
 * insert explored elements
 *
 * queue
 * [30, 40 60]
 * deque 30 insert in arr[10, 20, 30]
 * explore [30]: -
 * insert explored elements
 *
 * queue
 * [40 60]
 * deque 40 insert in arr[10, 20, 30, 40]
 * explore [40]: -
 * insert explored elements
 *
 * queue
 * [60]
 * deque 40 insert in arr[10, 20, 30, 40,60]
 * explore [60]: -
 * insert explored elements
 *
 */
public class LevelOrderTraversalBFS {
    public static void main(String[] args) {
        BfsNode bfsNode = new BfsNode(10);
        bfsNode.left = new BfsNode(20);
        bfsNode.right = new BfsNode(30);

        bfsNode.left.left = new BfsNode(40);
        bfsNode.left.right = new BfsNode(60);

        bfsNode.left.left.left = new BfsNode(70);
        bfsNode.left.left.right = new BfsNode(80);

        bfsNode.right.left = new BfsNode(100);
        bfsNode.right.right = new BfsNode(200);


        System.out.println(levelOrder(bfsNode));


    }


    static ArrayList<Integer> levelOrder(BfsNode node)
    {
        Queue<BfsNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        queue.add(node);

        while (!queue.isEmpty()) {

            BfsNode bfsNode = queue.remove();

            list.add(bfsNode.data);

            if (bfsNode.left != null) {
                queue.add(bfsNode.left);
            }

            if (bfsNode.right != null) {
                queue.add(bfsNode.right);
            }
        }
        return list;
    }












    public static BfsNode add(BfsNode node, int data) {
        if (node == null) return new BfsNode(data);

        if (data < node.data) {
            node.left = add(node.left, data);
        } else {
            node.right = add(node.right, data);
        }
        return node;
    }
}

class BfsNode {
    BfsNode left;
    BfsNode right;
    int data;
    BfsNode(int data) {
        this.data = data;
    }
}
