package Command;
//基于Hashmap<String,String>实现的指令类
import java.util.HashMap;

public class HashMap_ss {
    public static HashMap<String,String> hs = new HashMap<>();  //创建HashMap对象hs

    //set  ------- 将一个键值对存入HashMap集合
    public static void set(String[] com){
        hs.put(com[1],com[2]);
        if (hs.containsKey(com[1])){  //如果存在改键，说明成功存进，输入1
            System.out.println(1);
        }
        else{
            System.out.println("null");  //不存在说明添加失败，返回null
        }
    }

    //get   --------- 获取某一个键所对应的值
    public static void get(String[] com){
        String value;
        if ((value = hs.get(com[1])) != null){   //如果get()返回的时值说明有这个值
            System.out.println(value);
        }
        else{
            System.out.println("null");  //没有这个值就返回null
        }
    }

    //del ---------- 删除这个键所对应的值
    public static void del(String[] com) {
        if ((hs.remove(com[1])) != null) {   //如果remove返回值这个值说明有这个值
            System.out.println(1);
        } else {                               //没有这个值就返回null
            System.out.println("null");
        }
    }

}


