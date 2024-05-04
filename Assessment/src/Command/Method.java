package Command;
//指令的具体实现类
import java.util.HashMap;
import java.util.LinkedList;

public class Method {
    public static HashMap<String,String> hs = new HashMap<>();  //创建HashMap对象hs
    public static HashMap<String,String> hs1 = new HashMap<>();  //创建HashMap对象hs1,防止重复进行干扰
    public static HashMap<String, LinkedList<String>> hsl = new HashMap<>();  //创建HashMap对象hls
    public static LinkedList<String> list = new LinkedList<>(); //创建Linkedlist对象list
    public static HashMap<String,HashMap<String,String>> hsh = new HashMap<>(); //创建HashMap对象hsh

    public static void set(String[] com){
        hs.put(com[1],com[2]);
        if (hs.containsKey(com[1])){  //如果存在改键，说明成功存进，输入1
            System.out.println(1);
        }
        else{
            System.out.println("null");  //不存在说明添加失败，返回null
        }
    }

}



