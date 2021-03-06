package ioAndNio;

import java.io.*;

/**
 * @author zhangzy
 * @since 3-18
 * IoExample
 */
public class IoExample {

    private final static String DEFAULT_PATH = "E:\\IdeaProjects\\ioAndNio";

    private static void testByteStream() {
        try {
            File file = verifyPath("\\a.txt");
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

    private static void testCharacterStream() {
        try {
            File file = verifyPath("\\b.txt");
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

    private static void testRandomAccessFile() {
        try {
            File filePath = verifyPath("\\c.txt");
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

    private static File verifyPath(String fileName) {
        File file = new File(DEFAULT_PATH);
        if (!file.exists()) {
            file.mkdir();
            System.out.println("create file success!");
        }
        return new File(file + fileName);
    }

    public static void main(String[] args) {
        IoExample.testByteStream();
        IoExample.testCharacterStream();
        IoExample.testRandomAccessFile();
    }
}
