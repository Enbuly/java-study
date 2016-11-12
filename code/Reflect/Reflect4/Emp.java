package Reflect.Reflect4;

/**
 * Created by john on 2016/5/9.
 * get the class Methods
 */
public class Emp {
    private String name;
    private void Gaga(){System.out.println("Gaga");}
    public void save(){System.out.println("save");}
    public void insert(){System.out.println("insert");}

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                '}';
    }
}
