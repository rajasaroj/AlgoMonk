package algomonk.trees;

public class BinaryTreeGeneric  {

    public static void main(String[] args) {
        //BinaryTreeGeneric binaryTreeGeneric = new BinaryTreeGeneric();

        Node<Integer> node = new Node<>(5);
        node.insert( 3);
        node.insert( 4);
        node.insert( 1);
        node.insert( 7);
        node.insert( 8);
        System.out.println();
        node.inorderTraversal();

        Node<String> strnode = new Node<>("dd");
        strnode.insert("cc");
        strnode.insert("ee");
        strnode.insert("aa");
        strnode.insert("ff");

        strnode.inorderTraversal();


        System.out.println(node.contains(99));
    }
}
class Node<T extends Comparable<T>> {

    Node<T> left, right;
    T data;

    Node(T data) { this.data = data; }

    public void insert(T value) {
        if (value.compareTo(data) < 0) {
            if(left == null) { left = new Node<>(value); }
            else { left.insert(value); }
        } else {
            if(right == null) { right = new Node<>(value); }
            else { right.insert(value); }
        }
    }

    public void inorderTraversal() {
        if(left != null) left.inorderTraversal();
        System.out.println(data);
        if(right != null) right.inorderTraversal();
    }

    public boolean contains(T value) {
        boolean found = false;

        if(value.compareTo(data) < 0) {

            if(left == null) { return false; }
            found =  left.contains(value);

        } else if (value.compareTo(data) > 0) {

            if(right == null) { return false; }
            found =  right.contains(value);

        } else {
            System.out.println("found");
            found = true;
            return found;
        }


        return found;
    }


}