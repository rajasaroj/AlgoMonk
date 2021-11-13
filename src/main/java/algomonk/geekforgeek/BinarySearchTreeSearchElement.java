package algomonk.geekforgeek;

public class BinarySearchTreeSearchElement {

    public static void main(String[] args) {
        BtNode root = add(null, 3);
        add(root, 8);
        add(root, 5);

        System.out.println(find(root, 8));
    }


    public static boolean find(BtNode node,int data) {

        boolean found = false;

        if (node == null) return found;

        if (data > node.data) {
            found = found || find(node.right, data);
        } else if (data < node.data) {
            found = found || find(node.left, data);
        } else {
            found = true;
        }

        return found;

    }

    /**
     *
     * 3, 8, 5
     *
     * tree structure will be:
     *      3
     *       \
     *        8
     *       /
     *      5
     *
     * @param node
     * @param data
     * @return
     */
    public static BtNode add(BtNode node, int data) {

        if (node == null) {
            return new BtNode(data);
        }

        if (data > node.data) {
            node.right = add(node.right, data);
        } else {
            node.left = add(node.left, data);
        }

        return node;
    }
}

class BtNode {
    BtNode left;
    BtNode right;
    int data;

    BtNode(int data) {
        this.data = data;
    }
}