package Reflect.Reflect6;

import Reflect.Reflect5.China;

/**
 * Created by Administrator on 2015/12/25.
 * get the other class parent
 */
public class Person implements China{
    public Person() {
    }
    public Person(String sex){
        this.sex=sex;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    @Override
    public void sayChina(){
        System.out.println("hello ,china");
    }
    @Override
    public void sayHello(String name, int age){
        System.out.println(name+"  "+age);
    }
    private String sex;
}
