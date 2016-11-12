package io_example.RandomAccessFile;

import java.io.RandomAccessFile;

/**
 * Created by Administrator on 2015/12/26.
 * RandomAccessFile类
 只能访问文件，不能操作其他io设备
 支持随机访问
 在读写等长记录文件有优势
 */
public class RandomAccessFileTest{
    public static void main(String[]args){
        Employee e1 = new Employee("Ronnie", 37);
        Employee e2 = new Employee("John", 33);
        Employee e3 = new Employee("Mark", 38);
        try {
            RandomAccessFile randFile = new RandomAccessFile("employee.txt", "rw");

            randFile.writeChars(e1.getName());
            /**randFile.getFilePointer()返回此文件中的当前偏移量。**/
            /**long zzy=randFile.getFilePointer();
            System.out.println(zzy);一个char16位，两个字节，八个16个字节**/
            randFile.writeInt(e1.getAge());
            /**long zzx=randFile.getFilePointer();
            System.out.println(zzx);一个int32位，四个字节**/
            randFile.writeChars(e2.getName());
            randFile.writeInt(e2.getAge());
            randFile.writeChars(e3.getName());
            randFile.writeInt(e3.getAge());
            randFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            RandomAccessFile randFile = new RandomAccessFile("employee.txt", "r");

            randFile.seek(40);
            String name = "";
            for (int i=0;i<Employee.LEN; ++i) {
                name+=randFile.readChar();
            }
            System.out.println(name.trim()+":" + randFile.readInt());/***name.trim返回字符串的副本，忽略前导空白和尾部空白。**/

            randFile.seek(0);
            name = "";
            for (int i=0;i<Employee.LEN;++i) {
                name += randFile.readChar();
            }
            System.out.println(name.trim() + ":" + randFile.readInt());

            randFile.seek(20);
            name = "";
            for (int i=0;i<Employee.LEN;++i) {
                name += randFile.readChar();
            }
            System.out.println(name.trim() + ":" + randFile.readInt());
            randFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
