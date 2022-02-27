package Test;

import java.util.ArrayList;
import java.util.List;

public class Test001 {

    public class A extends Test001{}
    public class B extends A{}

    public static class Test{
        public static void main(String[] args) {
            List<B> list = new ArrayList<>();
        }
    }

    String str = new String("good");
    char ch[] = {'a','b','c'};

    public void change(String str,char ch[]){
        str = str.substring(0,2);
        ch[0] = 'g';
    }

    public static void main(String[] args) {

        Test001 ex = new Test001();
        ex.change(ex.str,ex.ch);
        System.out.println(ex.str+" and " + new String(ex.ch));



//        int i = 2;
//        switch (i){
//            case 0:
//                System.out.println(0);
//            case 1:
//                System.out.println(1);
//            case 2:
//                System.out.println(2);
//            case 3:
//                System.out.println(3);
//            default:
//                System.out.println("defalut");
//        }
    }

}
