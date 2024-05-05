package Command;
//基于HashMap<String, HashMap<String,String>>实现的指令类
import java.util.HashMap;

public class HashMap_map {
    public static HashMap<String, HashMap<String,String>> hsh = new HashMap<>(); //创建HashMap对象hsh
    public static HashMap<String,String> hs1 = new HashMap<>();  //创建HashMap对象hs1,防止重复进行干扰

    //hset
    public static void hset(String[] com){
        hs1.put(com[2],com[3]);   //把指令的键内容放进hs1集合(是一个HashMap集合)里面
        hsh.put(com[1],hs1);  //把键值对放进hsh集合里面
        if (hsh.containsKey(com[1])){  //如果有这个键，说明加入键值对成功，输出1
            System.out.println(1);
        }
        else{
            System.out.println("null");  //反之，输出null
        }
    }

    //hget
    public static void hget(String[] com){
        HashMap<String, String> mapVaule = hsh.get(com[1]);//获得集合中的键对用的值 -- 是一个HashMap集合
        String vaule = mapVaule.get(com[2]);  //获这个集合脸面的这个键所对应的值
        System.out.println(vaule);
    }

    //hdel
    public static void hdel(String[] com){
        if (com.length == 2) {  //如果指令的长度等于2，作用是把这个键对用的键值对全部删除
            HashMap<String, String> mapVaule = hsh.get(com[1]);  //获得键所对应的值 -- mapVaule
            mapVaule.clear();  //调用Map接口的clear方法进行清除这个键所对用的所有的值 -- mapVaule
            if (mapVaule.isEmpty()){
                System.out.println(1);
            }
            else{
                System.out.println("null");
            }
        }
        else{  //如果长度不是2，就是3，是把这个键对应的键值对内的“值”清除
            HashMap<String, String> mapVaule = hsh.get(com[1]);  //获取键对应的键值对
            String vaule = mapVaule.get(com[2]); //获取要被删除的值
            String ret = mapVaule.remove(com[2]);//删除键值对里面的值
            if (ret.equals(vaule)){  //如果被删除的值等于这个值
                System.out.println(1);  //删除成功，输入1
            }
            else{
                System.out.println("null"); //删除失败，输出null
            }
        }
    }
}
