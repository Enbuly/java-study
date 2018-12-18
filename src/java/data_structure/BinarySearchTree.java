package java.data_structure;

/**
 * @author zhangzy
 * @since 12-16
 * BinarySearchTree
 */

public class BinarySearchTree {

    //the tree root
    private BinaryNode root;

    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean cantains(int x) {
        return contains(x, root);
    }

    private boolean contains(int x, BinaryNode t) {
        if (t == null)
            return false;
        if (x < t.element)
            return contains(x, t.left);
        else if (x > t.element)
            return contains(x, t.right);
        else
            return true;
    }

    private BinaryNode findMin(BinaryNode t) {
        if (t != null)
            while (t.left != null)
                t = t.left;
        return t;
    }

    private BinaryNode findMax(BinaryNode t) {
        if (t != null)
            while (t.right != null)
                t = t.right;
        return t;
    }

    public void insert(int x) {
        root = insert(x, root);
    }

    private BinaryNode insert(int x, BinaryNode t) {
        if (t == null)
            return new BinaryNode(x, null, null);
        if (x < t.element)
            t.left = insert(x, t.left);
        else if (x > t.element)
            t.right = insert(x, t.right);
        else
            System.out.println("do nothing");
        return t;
    }

    public void remove(int x) {
        root = remove(x, root);
    }

    public BinaryNode remove(int x, BinaryNode t) {
        if (t == null)
            return t;
        if (x < t.element)
            t.left = remove(x, t.left);
        else if (x > t.element)
            t.right = remove(x, t.right);
        else if (t.left != null && t.right != null) {
            t.element = findMin(t.right).element;
            t.right = remove(t.element, t.right);
        } else
            t = (t.left != null) ? t.left : t.right;
        return t;
    }

    private static class BinaryNode {

        //the value of this node
        private int element;

        //this node's left child
        private BinaryNode left;

        //this node's right child
        private BinaryNode right;

        public BinaryNode(int theElement) {
            this(theElement, null, null);
        }

        public BinaryNode(int theElement, BinaryNode lt, BinaryNode rt) {
            element = theElement;
            left = lt;
            right = rt;
        }
    }
}