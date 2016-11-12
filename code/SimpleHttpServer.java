package HTTP_Server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * @author zzy
 */
public class SimpleHttpServer {
    private static ServerSocket serverSocket;
    private static ExecutorService pool = Executors.newCachedThreadPool();
    private static int PORT = 80;
    private SimpleHttpServer() {
        try {
            serverSocket = new ServerSocket(PORT);
        } catch (Exception e) {
            System.out.println("can not start http server:" + e.getMessage());
        }
        if (serverSocket == null)
            System.exit(1);
        System.out.println("HTTP server is running,port is:" + PORT);
        for (int i=0;i<10;i++)
            pool.execute(new Process(serverSocket,pool));
    }

    public static void main(String[]args) {
        System.out.println("this is simple http server,port is:" + PORT);
        new SimpleHttpServer();
    }
}

class Process implements Runnable {

    private ServerSocket serverSocket;
    private ExecutorService pool;

    Process(ServerSocket serverSocket,ExecutorService pool) {
        this.serverSocket = serverSocket;
        this.pool=pool;
    }

    public void run() {
        try {
            System.out.println("wait a client connect------");
            Socket client = serverSocket.accept();//从连接队列中取出一个连接，如果没有则等待
            if (client != null) {
                System.out.println("the client name who connect to the http server is:" + client);
                try {
                    //GET /index.jsp HTTP/1.1
                    BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                    String line = in.readLine();
                    System.out.println(line);
                    String resource = line.substring(line.indexOf('/'),line.lastIndexOf('/') - 5);
                    int size=line.indexOf('/');
                    String method=line.substring(0,size);
                    while ((line=in.readLine())!=null) {
                        System.out.println(line);
                        if (line.equals(""))
                            break;
                    }
                    System.out.println("the client request resource is:" + resource);
                    System.out.println("the request type is: " + method);
                    fileReaderAndReturn(resource, client);
                    client.close();
                    System.out.println("the server is complete！");
                } catch (Exception e) {
                    System.out.println("http server error:" + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println("http server error:" + e.getMessage());
        }
        pool.execute(new Process(serverSocket,pool));
    }//run over


    /**
     * @param fileName file name
     * @param socket client
     * @throws IOException
     */
    private void fileReaderAndReturn(String fileName, Socket socket) throws IOException {
        if ("/".equals(fileName)) {
            fileName = "/index.jsp";
        }
        if (fileName.contains("?")){
            fileName=fileName.substring(1,fileName.indexOf('?'));
        }else {
            fileName = fileName.substring(1);
        }

        PrintStream out = new PrintStream(socket.getOutputStream(),true);

        File fileToSend = new File("C:\\Users\\john\\IdeaProjects\\HttpServer\\web\\"+fileName);

        if (fileToSend.exists() && !fileToSend.isDirectory()) {
            FileInputStream fis = null;
            byte data[]=new byte[1024];
            try {
                fis=new FileInputStream(fileToSend);
                int temp;
                while ((temp=fis.read(data))!=-1){
                    out.write(data,0,temp);
                }
            } catch (IOException e) {
                out.println("<h1>500 error!</h1>" + e.getMessage());
                e.printStackTrace();
            }
            finally {
                try {
                    out.close();
                } catch (NullPointerException e) {
                    System.out.println(e.getMessage());
                }
                if (fis!=null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            out.println("<h1>404 error！</h1>" + "the file not find");
            out.close();
        }
    }
}
