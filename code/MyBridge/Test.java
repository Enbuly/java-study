package Design_mode.MyBridge;

/**
 * Created by john on 2016/10/9.
 */
public class Test {
    public static void main(String[]args){
        Tree tree=new Tree(new Black(),new Small());
        System.out.println(tree.tree());
    }
}
