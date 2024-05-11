        package MySocket;
        //客户端类
        import Log.JUL;

        import java.io.IOException;
        import java.io.InputStream;
        import java.net.Socket;
        import java.util.Scanner;
        import java.util.logging.LogManager;

        public class Client {
                public static int port;   //端口号
                public static void main(String[] args){
                        try {
                                Scanner input = new Scanner(System.in);
                                //客户端请求连接
                                System.out.print("请再次确定并输入你想连接的端口号: ");
                                port = input.nextInt();   //输入想连接的端口号
                                Socket socket = new Socket("127.0.0.1",port);  //申请连接port端口,连接失败会自动抛出异常终止程序
                                System.out.println("连接成功！");
                                MyThread t = new MyThread(port);  //创建线程对象并传入端口port
                                t.start();    //开启线程
                                socket.close();  //上面连接失败会抛出异常，因此到了这句话的socket一定是一个非空对象
                        }
                        catch (IOException e) {
                                String error = e.toString();
                                JUL.logger.severe(error);  //把错误信息写进日志
                                throw new RuntimeException(e);
                        }
                }
        }

