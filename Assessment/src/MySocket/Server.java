package MySocket;
//服务器类
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;
import java.util.Scanner;


public class Server {
    public static int port;
    public static void main(String[] args) throws IOException {
        Scanner input  = new Scanner(System.in);
        System.out.print("请输入要连接的端口号：");
        port = input.nextInt();
        //将端口号写入propeties文件
        Properties prop = new Properties();   //创建Properties对象监听端口号
        prop.put("127.0.0.1",String.valueOf(port));  //将整形变成字符串的表示形式
        FileOutputStream fos = new FileOutputStream("Assessment\\port.properties",true); //打开续写
        prop.store(fos,"monitor");
        fos.close();

        ServerSocket ss = new ServerSocket(port);   //绑定客户端的"端口号
        while (true) {
            Socket socket = ss.accept();   //监听客户端连接"
            if (socket != null){  //避免空指针异常
                socket.close();
            }
        }
    }
}
