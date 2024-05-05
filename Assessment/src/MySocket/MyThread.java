package MySocket;
 // 多线程实现类
import CallCommand.CallMethod;

import java.util.Scanner;

public class MyThread extends Thread{
    public static String[] com;     //储存指令输入的数组
    public int port;    //因为三个类运行不在
    public MyThread(int port){
        this.port = port;  //因为客户/服务端/进程类运行在三个不用的进程，port无法被共享，通过构造方法传进来
     }

    @Override
    public void run() {  //重写run方法
        Scanner input = new Scanner(System.in);
        com = new String[10];    //为数组开辟空间
        while (true) {
            System.out.print("127.0.0.1:" + port + ">");
            String userInput = input.nextLine(); // 读取整行输入
            com = userInput.split(" "); // 使用空格分割输入的字符串
            CallMethod.callCom(com);   //传入指令，调用callCom方法
        }
    }

}