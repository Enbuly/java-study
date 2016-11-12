package io_example.Object_test;
/**
 * 其中DataOutputStream的许多方法ObjectOutputStream也有。
 * 其中DataInputStream的许多方法ObjectInputStream也有。
 * **/
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectFileTest {
	public static void main (String[]args){
		try{
			Employee[]staff=new Employee[3];
			staff[0]=new Employee("zzy","6000",21);
			staff[1]=new Employee("zzx","8000",19);
			staff[2]=new Employee("zd","16000",30);
			ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("data.txt"));
			out.writeObject(staff);
			out.close();

			ObjectInputStream in=new ObjectInputStream(new FileInputStream("data.txt"));
			Employee[]newstaff=(Employee[])in.readObject();
			in.close();
			for(int i=0;i<newstaff.length;i++)
				System.out.print(newstaff[i]+" ");
		}catch(Exception e){
			System.out.print(e.getMessage());
		}
	}
}