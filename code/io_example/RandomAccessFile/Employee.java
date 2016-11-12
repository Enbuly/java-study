package io_example.RandomAccessFile;
/**
 * Created by Administrator on 2015/12/26.
 * RandomAccessFile类
 只能访问文件，不能操作其他io设备
 支持随机访问
 在读写等长记录文件有优势
 */
public class Employee{
    private String name;
    private int age;
    public static final int LEN = 8;
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public Employee(String name, int age){
        if (name.length() > LEN) { /** 为了构造等长记录，String name由八个char组成**/
            this.name=name.substring(0, LEN-1);
            /**截取字符串的0到LEN-1部分，返回一个新字符串，它是此字符串的一个子字符串。**/
        } else {
            this.name=name;
            while(this.name.length()<LEN) {
                this.name +='\u0000';
            }
        }
        this.age = age;
    }
}
