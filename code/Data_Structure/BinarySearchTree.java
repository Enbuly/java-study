package Data_Structure;

/**
 * Created by john on 2016/9/11.
 * @author zzy
 * BinarySearchTree
 */

public class BinarySearchTree{
private static class BinaryNode {
    public BinaryNode(int theElement) {
        this(theElement,null,null);
    }
    public BinaryNode(int theElement,BinaryNode lt,BinaryNode rt) {
        element=theElement;
        left=lt;
        right=rt;
    }
    private int element;//the value of this node
    private BinaryNode left;//this node's left child
    private BinaryNode right;//this node's right child
}

    private BinaryNode root;//the tree root

    public BinarySearchTree() {
        root=null;
    }

    public void makeEmpty() {
        root=null;
    }

    public boolean isEmpty() {
        return root==null;
    }

    public boolean cantains(int x) {
        return contains(x,root);
    }

    private boolean contains(int x,BinaryNode t) {
        if(t==null)
            return false;
        if(x<t.element)
            return contains(x,t.left);
        else if(x>t.element)
            return contains(x,t.right);
        else
            return true;
    }

    public int findMin() {
        if(isEmpty()) {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return findMin(root).element;
    }

    private BinaryNode findMin(BinaryNode t) {
        if(t!=null)
            while(t.left!=null)
                t=t.left;
        return t;
    }

    public int findMax() {
        if(isEmpty()) {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return findMax(root).element;
    }

    private BinaryNode findMax(BinaryNode t) {
        if(t!=null)
            while(t.right!=null)
                t=t.right;
        return t;
    }

    public void insert(int x) {
        root=insert(x,root);
    }

    private BinaryNode insert(int x,BinaryNode t) {
        if(t==null)
            return new BinaryNode(x,null,null);
        if(x<t.element)
            t.left=insert(x,t.left);
        else if(x>t.element)
            t.right=insert(x,t.right);
        else
            ;//do nothing
        return t;
    }

    public void remove(int x) {
        root=remove(x,root);
    }

    public BinaryNode remove (int x,BinaryNode t) {
        if(t==null)
            return t;
        if(x<t.element)
            t.left=remove(x,t.left);
        else if(x>t.element)
            t.right=remove(x,t.right);
        else if(t.left!=null&&t.right!=null) {
            t.element=findMin(t.right).element;
            t.right=remove(t.element,t.right);
        }
        else
            t=(t.left!=null)?t.left:t.right;
        return t;
    }
}