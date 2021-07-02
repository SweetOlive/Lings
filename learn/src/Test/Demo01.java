package Test;

import java.util.ArrayList;

//Dump
public class Demo01 {

    byte[] array = new byte[1024*1024];//1m

    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
        int count = 0;

        try{
            while (true){
                list.add(new Demo01()) ;//问题所在
                count = count + 1;
            }
        }catch (Error e){
            System.out.println("count:"+count);
            e.printStackTrace();
        }
    }

}
