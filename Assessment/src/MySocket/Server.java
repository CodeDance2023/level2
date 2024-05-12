package MySocket;
//服务器类
import Log.JUL;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.LogManager;


public class Server {
    public static int port;
    public static void main(String[] args){
        try {
            Scanner input  = new Scanner(System.in);
            System.out.print("请输入要连接的端口号：");
            port = input.nextInt();
            //将端口号写入propeties文件
            Properties prop = new Properties();   //创建Properties对象监听端口号
            prop.put("127.0.0.1",String.valueOf(port));  //将整形变成字符串的表示形式
            FileOutputStream fos = new FileOutputStream("Assessment/src/ResourceFiles/port.properties",true); //打开续写
            prop.store(fos,"monitor");
            fos.close();   //关闭IO流


            //加载日志配置文件

            //通过类加载器读取配置文件
            InputStream is = JUL.class.getClassLoader().getResourceAsStream("ResourceFiles/logging.properties");

            //创建LogManager对象
            LogManager logManager = LogManager.getLogManager();

            //通过LogManager加载配置文件
            logManager.readConfiguration(is);
            JUL.logger.info("host: 127.0.0.1");  //把主机IP地址写进日志


            //与客户端建立连接
            ServerSocket ss = new ServerSocket(port);   //绑定客户端的"端口号
            while (true) {
                Socket socket = ss.accept();   //监听客户端连接"
                if (socket != null){  //避免空指针异常
                    socket.close();  //关闭传输通道
                }
            }
        } catch (IOException e) {
            String error = e.toString();
            JUL.logger.severe(error);   //将错误信息写进日志
            throw new RuntimeException(e);
        }
    }
}
