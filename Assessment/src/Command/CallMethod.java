package Command;
//指令的调用方法类
import java.util.HashMap;
import java.util.LinkedList;


//指令的执行方法
    public class CallMethod {

    public static HashMap<String,String> hs = new HashMap<>();  //创建HashMap对象hs
    public static HashMap<String,String> hs1 = new HashMap<>();  //创建HashMap对象hs1,防止重复进行干扰
    public static HashMap<String, LinkedList<String>> hsl = new HashMap<>();  //创建HashMap对象hls
    public static LinkedList<String> list = new LinkedList<>(); //创建Linkedlist对象list
    public static HashMap<String,HashMap<String,String>> hsh = new HashMap<>(); //创建HashMap对象hsh

    public static void callCom(String[] com) {

        //基于Hashmap<String,String>实现的指令

        //set
        if (com[0].equals("set")){
            hs.put(com[1],com[2]);
            if (hs.containsKey(com[1])){  //如果存在改键，说明成功存进，输入1
                System.out.println(1);
            }
            else{
                System.out.println("null");  //不存在说明添加失败，返回null
            }
//            Method.set(com);
        }

        //get
        else if (com[0].equals("get")){
              String value;
                if ((value = hs.get(com[1])) != null){   //如果get()返回的时值说明有这个值
                    System.out.println(value);
                }
                else{
                    System.out.println("null");  //没有这个值就返回null
                }
          }

        //del
        else if (com[0].equals("del")){
              String value;
                if ((hs.remove(com[1])) != null){   //如果remove返回值这个值说明有这个值
                    System.out.println(1);
                }
                else{                               //没有这个值就返回null
                    System.out.println("null");
                }
          }

        //基于HashMap<String,LinkedList<String>>实现的指令

        //lpush
        else if(com[0].equals("lpush")){
            list.addFirst(com[2]);   //将第二个指令的值添加到list的最左端
            hsl.put(com[1], list);
            if (hsl.containsKey(com[1])){  //如果包含了这个键，即键值对是添加成功
                System.out.println(1);
            }
            else{
                System.out.println("null");
            }
        }

        //rpush
        else if(com[0].equals("rpush")){
            list.addLast(com[2]);   //将第二个指令的值添加到list的最右端
            hsl.put(com[1],list);
            if (hsl.containsKey(com[1])){  //如果包含了这个键，即键值对是添加成功
                System.out.println(1);
            }
            else{
                System.out.println("null");
            }
        }

        //range
        else if (com[0].equals("range")){
            LinkedList<String> listVaule = hsl.get(com[1]);   //获得键对应的list -- listVaule
            //循环打印list -- listVaule内的值
            for (int i = Integer.parseInt(com[2]); i <= Integer.parseInt(com[3]); ++i){
                System.out.print(listVaule.get(i) + " ");
            }
            System.out.println();
        }

        //len
        else if(com[0].equals("len")) {
            LinkedList<String> listVaule = hsl.get(com[1]);  //获取键对应的list -- listVaule
            System.out.println(listVaule.size());  //调用size()方法获得list的长度
        }

        //lpop
        else if (com[0].equals("lpop")){
            LinkedList<String> listVaule = hsl.get(com[1]);  //获取键对用的list -- listVaule
            String ret = listVaule.removeFirst();     //删除其最左边的元素
            System.out.println(ret); //打印被删除的元素
        }

        //rpop
        else if (com[0].equals("rpop")){
            LinkedList<String> listVaule = hsl.get(com[1]);  //获取键对用的list -- listVaule
            String ret = listVaule.removeLast();     //删除其最右边的元素
            System.out.println(ret); //打印被删除的元素
        }

        //ldel
        else if (com[0].equals("ldel")){
            LinkedList<String> listVaule = hsl.get(com[1]);  //获取键对用的list -- listVaule
            listVaule.clear();  //调用Collection接口的clear方法，清除list的所有元素
            if (listVaule.isEmpty()){    //调用Collection接口的IsEmpty方法，检查集合是否为空
                System.out.println(1);   //返回true,为空说明清除成功，输出1
            }
            else{
                System.out.println("null"); //否则输出null
            }
        }


        //基于HashMap<String, HashMap<String,String>>实现的指令

        //hset
        else if(com[0].equals("hset")){
            hs1.put(com[2],com[3]);   //把指令的键内容放进hs1集合里面
            hsh.put(com[1],hs1);  //把键值对放进hsh集合里面
            if (hsh.containsKey(com[1])){  //如果有这个键，说明加入键值对成功，输出1
                System.out.println(1);
            }
            else{
                System.out.println("null");  //反之，输出null
            }
        }

        //hget
        else if(com[0].equals("hget")){
            HashMap<String, String> mapVaule = hsh.get(com[1]);//获得集合中的键对用的值 -- mapVaule
            String vaule = mapVaule.get(com[2]);  //获得键所对应的值
            System.out.println(vaule);
        }

        //hdel(
        else if(com[0].equals("hdel")){       //！！！注意：数组的实际长度由输入的有效个数而定 ！！！
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
                String vaule = mapVaule.get(com[1]); //获取要被删除的值
                String ret = mapVaule.remove(com[2]);//删除键值对里面的值
                if (ret.equals(vaule)){  //如果被删除的值等于这个值
                    System.out.println(1);  //删除成功，输入1
                }
                else{
                    System.out.println("null"); //删除失败，输出null
                }
            }
        }

        //help指令
        else if (com[0].equals("help")){
            if (com.length == 1){    //防止输入help时，数组的长度为1，导致下面的help set...等指令越界
                System.out.println("all");   //
            }
            else if (com[1].equals("set")){
                System.out.println("SET [KEY] [VALUE]");
            }
            else if (com[1].equals("get")){
                System.out.println("GET [KEY]");
            }

        }


        //ping指令
        else if (com[0].equals("ping")){
            System.out.println("pong");
        }

    }
}
