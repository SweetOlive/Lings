package leetcode;

public class leetcode292 {

    public static void main(String[] args) {

    }

    public static boolean canWinNim(int n) {
        if (n <= 3) {
            return true;
        }
        if (n%4 == 0){
            return false;
        }
        return true;
    }

}
