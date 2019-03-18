package io;

import java.io.*;

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

    public static void main(String[] args) {
        OutputStreamExample.testFirst();
    }
}
