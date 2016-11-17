package Design_mode.MyBridge;

/**
 * Created by john on 2016/10/9.
 */
public class Tree {
    protected Color color;
    protected Size size;
    public Tree(Color color,Size size){
        this.color=color;
        this.size=size;
    }
    public String tree(){
        return "this is a "+color.color()+" "+size.size()+" tree!";
    }
}
