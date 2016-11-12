package io_example.RandomAccessFile;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by Administrator on 2015/12/27.
 * a class for RandomAccessFile
 */
public class Book_example {
    static RandomAccessFile myfile=null;
    static long[]primes=new long[20];
    static int LONGSIZE=8;
    public static void main(String[]args){
        try{
            File dir=new File("d:/RandomAccessFile test");
            if(!dir.exists())
                dir.mkdir();
            File myPrimes=new File(dir,"data.txt");
            if(!myPrimes.exists())
                myPrimes.createNewFile();
            myfile=new RandomAccessFile(myPrimes,"rw");

            long count=myfile.length();/**return the file length**/
            long number=0;
            if(count==0){
                primes[0]=2;primes[1]=3;
                count=2;number=5;
            }
            else{
                myfile.seek(myfile.length()-LONGSIZE);
                number=myfile.readLong()+2;
                count=0;
            }
            for(;count<20;number=number+2)
            {
                if(primesTest(number))
                    primes[(int)count++]=number;
            }
            myfile.seek(myfile.length());
            for(int i=0;i<count;i++)
                myfile.writeLong(primes[i]);
            outputPrimes();
            myfile.close();
        }catch(IOException e){}
    }
    static boolean primesTest(long number){
        long limit=(long)Math.ceil(Math.sqrt((double)number));
        for(int i=3;i<=limit;i=i+2)
            if(number%i==0)
                return false;
        return true;
    }
    static void outputPrimes() throws IOException {
        myfile.seek(0);
        for(int i=0;i<myfile.length()/LONGSIZE;i++){
            if(i%10==0)
                System.out.println();
            System.out.print(myfile.readLong()+"\t");
        }
    }
}
