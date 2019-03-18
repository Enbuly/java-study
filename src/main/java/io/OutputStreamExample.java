package io;

import java.io.*;

/**
 * @author zhangzy
 * @since 3-18
 * io
 */
public class OutputStreamExample {

    private static void testFirst() {
        try {
            String bWrite = "zzy nice!";
            OutputStream os = new FileOutputStream("E:\\IdeaProjects\\io\\a.txt");
            os.write(bWrite.getBytes());
            os.close();

            InputStream is = new FileInputStream("E:\\IdeaProjects\\io\\a.txt");
            int size = is.available();

            for (int i = 0; i < size; i++) {
                System.out.print((char) is.read() + "  ");
            }
            is.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void testSecond() {
        try {
            String bWrite = "zzy nice!";
            Writer os = new FileWriter("E:\\IdeaProjects\\io\\b.txt");
            os.write(bWrite);
            os.close();

            Reader is = new FileReader("E:\\IdeaProjects\\io\\b.txt");
            char[] a = new char[50];
            is.read(a);
            for (char c : a)
                System.out.print(c);
            is.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        OutputStreamExample.testSecond();
    }
}
