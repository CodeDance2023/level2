package CallCommand;
//指令的调用类
import Command.Another;
import Command.HashMap_list;
import Command.HashMap_map;
import Command.HashMap_ss;

    public class CallMethod {

    public static void callCom(String[] com) {

        //基于Hashmap<String,String>实现的指令

        //set
        if (com[0].equals("set")){
            HashMap_ss.set(com);
        }

        //get
        else if (com[0].equals("get")){
            HashMap_ss.get(com);
          }

        //del
        else if (com[0].equals("del")){
            HashMap_ss.del(com);
          }

        //基于HashMap<String,LinkedList<String>>实现的指令

        //lpush
        else if(com[0].equals("lpush")){
            HashMap_list.lpush(com);
        }

        //rpush
        else if(com[0].equals("rpush")){
            HashMap_list.rpush(com);
        }

        //range
        else if (com[0].equals("range")){
            HashMap_list.range(com);
        }

        //len
        else if(com[0].equals("len")) {
            HashMap_list.len(com);
        }

        //lpop
        else if (com[0].equals("lpop")){
            HashMap_list.lpop(com);
        }

        //rpop
        else if (com[0].equals("rpop")){
            HashMap_list.rpop(com);
        }

        //ldel
        else if (com[0].equals("ldel")){
            HashMap_list.ldel(com);
        }


        //基于HashMap<String, HashMap<String,String>>实现的指令

        //hset
        else if(com[0].equals("hset")){
            HashMap_map.hset(com);
        }

        //hget
        else if(com[0].equals("hget")){
            HashMap_map.hget(com);
        }

        //hdel(
        else if(com[0].equals("hdel")){       //！！！注意：数组的实际长度由输入的有效个数而定 ！！！
            HashMap_map.hdel(com);
        }




        //help指令
        else if (com[0].equals("help")){
            Another.help(com);
        }

        //ping指令
        else if (com[0].equals("ping")){
//            System.out.println("pong");
            Another.ping(com);
        }

    }
}
