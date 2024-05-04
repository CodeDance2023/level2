        package MySocket;
        //客户端类
        import java.io.IOException;
        import java.net.Socket;
        import java.util.Scanner;

        public class Client {
                public static int port;   //端口号
                public static void main(String[] args) throws IOException {
                Scanner input = new Scanner(System.in);

                System.out.print("请再次确定并输入你想连接的端口号: ");
                port = input.nextInt();   //输入想连接的端口号
                Socket socket = new Socket("127.0.0.1",port);  //申请连接port端口,连接失败会自动抛出异常终止程序
                System.out.println("连接成功！");
                        MyThread t = new MyThread(port);  //创建线程对象并传入端口port
                        t.start();    //开启线程
                socket.close();  //上面连接失败会抛出异常，因此到了这句话的socket一定是一个非空对象
            }
        }

