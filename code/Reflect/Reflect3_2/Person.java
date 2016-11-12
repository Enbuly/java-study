package Reflect.Reflect3_2;

/**
 * Created by Administrator on 2015/12/25.
 * through the class object make the other object
 */
public class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(int age,String name) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
