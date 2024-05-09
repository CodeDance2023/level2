package MySocket;
 // 多线程实现类
import CallCommand.CallMethod;

import java.io.*;
import java.util.Scanner;

public class MyThread extends Thread{
    public static String[] com;     //储存指令输入的数组
    public int port;    //因为三个类运行不在
    public MyThread(int port){
        this.port = port; //因为客户/服务端/进程类运行在三个不用的进程，port无法被共享，通过构造方法传进来
     }

    @Override
    public void run() {  //重写run方法
        Scanner input = new Scanner(System.in);
        BufferedReader br;
        BufferedWriter bw;
        try {
            //创建字符缓冲输入流对象
            br = new BufferedReader(new FileReader("Assessment/command.txt"));
            //创建字符缓冲输出流对象并开启续写（append = true）
            bw = new BufferedWriter(new FileWriter("Assessment/command.txt",true));
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        com = new String[10];    //为com数组开辟空间   ------用来储存用空格分割后的字符串数组
        String[] fcom;  //创建字符串输组fcom表示之前输入指令的用空格分割后的字符串数组
        String command;  //辅助字符流读取的字符串
        System.out.println("上次储存的指令的运行结果如下:");
        int flag = 0;  //判断上次是否又指令被执行的标志
        //读取上次输入的指令并执行
            try {
                while ((command = br.readLine()) != null)  //读入上次储存的所有指令，一行一行读取，直到读取完为止
                {
                    flag = 1;  //如果有指令被执行标志就变为1
                    fcom = command.split(" ");  //将字符串指令用空格分割为字符串数组
                    CallMethod.callCom(fcom);  //调用每一条指令对应的方法
                }
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }

            if (flag == 0){
                System.out.println("null");   //如果上次没有指令被执行则输出null
            }

            //新输入指令
        while (true) {
            System.out.print("127.0.0.1:" + port + ">");  //用户输入新的指令......
            String userInput = input.nextLine(); // 读取整行输入的指令字符串
            try {
                if (!userInput.equals("exit")){  //不是exit指令才写入文件
                    bw.write(userInput);   //将输入的指令存到command.txt文件里面去
                }
                bw.newLine();   //写入一个回车，防止数据写在同一行
                bw.flush();  //将缓冲区的数据立即刷入文件
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
            com = userInput.split(" "); // 使用空格分割输入的字符串
            CallMethod.callCom(com);   //传入指令，调用callCom方法
            if (com[0].equals("exit")){   //指令是exit就退出循环
                try {
                    //关闭输入流和输出流
                    bw.close();
                    br.close();
                }
                catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
        }

    }

}