package algomonk.trees;
//
//public class BasicBinaryTree {
//
//    public static void main(String[] args) {
//        Node root = new Node(5);
//        insert(root, 3);
//        insert(root, 4);
//        insert(root, 1);
//        insert(root, 7);
//        insert(root, 8);
//        insert(root, 10);
//        display(root);
//        //System.out.println(root);
//
//    }
//
//    public static void display(Node root) {
//
//        if(root.left != null) {
//            display(root.left);
//        }
//        System.out.println(root.data);
//        if(root.right != null) {
//            display(root.right);
//        }
//
//
//
////        if(root != null) {
////            //System.out.println(root.data);
////        }
//    }
//
//    public static Node insert(Node node, int data) {
//
//        if(data <= node.data) {
//            if (node.left == null) {
//                node.left = new Node(data);
//            } else {
//                node.left = insert(node.left, data);
//            }
//
//        } else {
//            if (node.right == null) {
//                node.right = new Node(data);
//            } else {
//                node.right = insert(node.right, data);
//            }
//        }
//
//
//        return node;
//    }
////}
////class Node {
////    Node left, right;
////    int data;
////
////    public Node(int data) {
////        this.left = null;
////        this.right = null;
////        this.data = data;
////    }
////}
