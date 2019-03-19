package ioAndNio;

import java.io.*;

/**
 * @author zhangzy
 * @since 3-18
 * IoExample
 */
public class IoExample {

    private static void testFirst() {
        try {
            File file = new File("E:\\IdeaProjects\\ioAndNio");
            if (!file.exists()) {
                file.mkdir();
                System.out.println("create file success!");
            }
            file = new File(file + "\\a.txt");

            String bWrite = "zzy nice!";
            //OutputStream os = new FileOutputStream(file);
            OutputStream os = new BufferedOutputStream(new FileOutputStream(file));
            os.write(bWrite.getBytes());
            os.close();

            //InputStream is = new FileInputStream(file);
            InputStream is = new BufferedInputStream(new FileInputStream(file));
            int size = is.available();

            for (int i = 0; i < size; i++) {
                System.out.print((char) is.read());
            }
            is.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void testSecond() {
        try {
            File file = new File("E:\\IdeaProjects\\ioAndNio");
            if (!file.exists()) {
                file.mkdir();
                System.out.println("create file success!");
            }
            file = new File(file + "\\b.txt");

            String bWrite = "zzy nice!";
            //Writer os = new FileWriter(file);
            Writer os = new BufferedWriter(new FileWriter(file));
            os.write(bWrite);
            os.close();

            //Reader is = new FileReader(file);
            Reader is = new BufferedReader(new FileReader(file));
            char[] a = new char[50];
            is.read(a);
            for (char c : a)
                System.out.print(c);
            is.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void testThird() {
        try {
            File filePath = new File("E:\\IdeaProjects\\ioAndNio");
            if (!filePath.exists()) {
                filePath.mkdir();
                System.out.println("create file success!");
            }
            filePath = new File(filePath + "\\c.txt");

            RandomAccessFile file = new RandomAccessFile(filePath, "rw");
            file.seek(20);
            file.write("Hello World".getBytes());

            byte[] temp = new byte[1024];
            int hasRead = 0;
            file.seek(0);
            while ((hasRead = file.read(temp)) > 0) {
                System.out.println(new String(temp, 0, hasRead));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        IoExample.testFirst();
        IoExample.testSecond();
        IoExample.testThird();
    }
}
