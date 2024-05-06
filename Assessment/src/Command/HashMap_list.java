package Command;
//基于HashMap<String,LinkedList<String>>实现的指令类

import java.util.HashMap;
import java.util.LinkedList;

public class HashMap_list {
    public static HashMap<String, LinkedList<String>> hsl = new HashMap<>();  //创建HashMap对象hls
    public static LinkedList<String> list = new LinkedList<>(); //创建Linkedlist对象list

    //lpush     ---------- 在lindkedlist集合里的最左边加入一个元素，并且将一个键和这个集合加进HashMap里面
    public static void lpush(String[] com){
        list.addFirst(com[2]);   //将第二个指令的值添加到list的最左端
        hsl.put(com[1], list);
        if (hsl.containsKey(com[1])){  //如果包含了这个键，即键值对是添加成功
            System.out.println(1);
        }
        else{
            System.out.println("null");
        }
    }

    //rpush      --------- 在lindkedlist集合里的最右边加入一个元素，并且将一个键和这个集合加进HashMap里面
    public static void rpush(String[] com){
        list.addLast(com[2]);   //将第二个指令的值添加到list的最右端
        hsl.put(com[1],list);
        if (hsl.containsKey(com[1])){  //如果包含了这个键，即键值对是添加成功
            System.out.println(1);
        }
        else{
            System.out.println("null");
        }
    }

    //range        -------- 获取某个键所对应的Linkedlist集合，并展示这个集合里面从start到end的范围值
    public static void range(String[] com){
        LinkedList<String> listVaule = hsl.get(com[1]);   //获得键对应的list -- listVaule
        //循环打印list -- listVaule内的值
        for (int i = Integer.parseInt(com[2]); i <= Integer.parseInt(com[3]); ++i){
            System.out.print(listVaule.get(i) + " ");
        }
        System.out.println();
    }

    //len        ---------- 获取某个键对应的集合的元素个数
    public static void len(String[] com){
        LinkedList<String> listVaule = hsl.get(com[1]);  //获取键对应的list -- listVaule
        System.out.println(listVaule.size());  //调用size()方法获得list的长度
    }

    //lpop          -------  获取某个键所对应的集合，并将这个集合最左边的元素删除
    public static void lpop(String[] com){
        LinkedList<String> listVaule = hsl.get(com[1]);  //获取键对用的list -- listVaule
        String ret = listVaule.removeFirst();     //删除其最左边的元素
        System.out.println(ret); //打印被删除的元素
    }

    //rpop          -------  获取某个键所对应的集合，并将这个集合最右边的元素删除
    public static void rpop(String[] com){
        LinkedList<String> listVaule = hsl.get(com[1]);  //获取键对用的list -- listVaule
        String ret = listVaule.removeLast();     //删除其最右边的元素
        System.out.println(ret); //打印被删除的元素
    }

    //ldel         -------------- //删除某个键所对应的集合的所有元素
    public static void ldel(String[] com){
        LinkedList<String> listVaule = hsl.get(com[1]);  //获取键对用的list -- listVaule
        listVaule.clear();  //调用Collection接口的clear方法，清除list的所有元素
        if (listVaule.isEmpty()){    //调用Collection接口的IsEmpty方法，检查集合是否为空
            System.out.println(1);   //返回true,为空说明清除成功，输出1
        }
        else{
            System.out.println("null"); //否则输出null
        }
    }
}
