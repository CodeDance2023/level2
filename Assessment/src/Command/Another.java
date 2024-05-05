package Command;
//其他指令的实现类
public class Another {

    //help
    public static void help(String[] com){
        if (com.length == 1){    //防止输入help时，数组的长度为1，导致下面的help set...等指令越界
            System.out.println("SET [KEY] [VAULE]");
            System.out.println("GET [KEY]");
            System.out.println("DEL [KEY]");
            System.out.println("LPUSH [KEY] [VAULE]");
            System.out.println("RPUSH [KEY] [VAULE]");
            System.out.println("RANGE [KEY] [START] [END]");
            System.out.println("LEN [KEY]");
            System.out.println("LPOP [KEY]");
            System.out.println("RPOP [KEY]");
            System.out.println("LDEL [KEY]");
            System.out.println("HSET [KEY] [FIELD] [VAULE]");
            System.out.println("HGET [KEY] [FIELD]");
            System.out.println("HDEL [KEY] [FILED]");
            System.out.println("HDEL [KEY]");
        }
        else if (com[1].equals("set")){
            System.out.println("SET [KEY] [VALUE]");
        }
        else if (com[1].equals("get")){
            System.out.println("GET [KEY]");
        }
        else if (com[1].equals("del")){
            System.out.println("DEL [KEY]");
        }
        else if (com[1].equals("lpush")){
            System.out.println("LPUSH [KEY] [VAULE]");
        }
        else if (com[1].equals("rpush")){
            System.out.println("RPUSH [KEY] [VAULE]");
        }
        else if (com[1].equals("range")){
            System.out.println("RANGE [KEY] [START] [END]");
        }
        else if (com[1].equals("len")){
            System.out.println("LEN [KEY]");
        }
        else if (com[1].equals("lpop")){
            System.out.println("LPOP [KEY]");
        }
        else if (com[1].equals("rpop")){
            System.out.println("RPOP [KEY]");
        }
        else if (com[1].equals("ldel")){
            System.out.println("LDEL [KEY]");
        }
        else if (com[1].equals("hset")){
            System.out.println("HSET [KEY] [FIELD] [VAULE]");
        }
        else if (com[1].equals("hget")){
            System.out.println("HGET [KEY] [FIELD]");
        }
        else if (com[1].equals("hdel")){
            if (com.length == 2){
                System.out.println("HDEL [KEY]");
            }
            else{
                System.out.println("HDEL [KEY] [FIELD]");
            }
        }
    }

    //ping
    public static void ping(String[] com){
        System.out.println("pong");
    }
}
