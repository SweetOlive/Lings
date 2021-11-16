package leetcode;

import java.util.ArrayList;

/**
 * @Author Lings
 * @Version 1.0
 */
public class leetcode2 {

    public static void main(String[] args) {
//        挺暴力的解法
//        实例1
//        输入：l1 = [2,4,3], l2 = [5,6,4]
//        输出：[7,0,8]
//        解释：342 + 465 = 807.
//        ListNode L1_1 = new ListNode(2);
//        ListNode L1_2 = new ListNode(4);
//        ListNode L1_3 = new ListNode(3);
//        L1_1.next = L1_2;
//        L1_2.next = L1_3;
//
//        ListNode L2_1 = new ListNode(5);
//        ListNode L2_2 = new ListNode(6);
//        ListNode L2_3 = new ListNode(4);
//        L2_1.next = L2_2;
//        L2_2.next = L2_3;

//        实例2
//        输入：l1 = [0], l2 = [0]
//        输出：[0]
//        ListNode L1_1 = new ListNode(0);
//        ListNode L2_1 = new ListNode(0);

//        实例3   有坑，会忘了进位，少了最后一个 1
//        输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//        输出：[8,9,9,9,0,0,0,1]
        ListNode L1_1 = new ListNode(9);
        ListNode L1_2 = new ListNode(9);
        ListNode L1_3 = new ListNode(9);
        ListNode L1_4 = new ListNode(9);
        ListNode L1_5 = new ListNode(9);
        ListNode L1_6 = new ListNode(9);
        ListNode L1_7 = new ListNode(9);
        L1_1.next = L1_2;
        L1_2.next = L1_3;
        L1_3.next = L1_4;
        L1_4.next = L1_5;
        L1_5.next = L1_6;
        L1_6.next = L1_7;

        ListNode L2_1 = new ListNode(9);
        ListNode L2_2 = new ListNode(9);
        ListNode L2_3 = new ListNode(9);
        ListNode L2_4 = new ListNode(9);
        L2_1.next = L2_2;
        L2_2.next = L2_3;
        L2_3.next = L2_4;

        System.out.println(addTwoNumbers(L1_1,L2_1).toString());

    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        // 拆解链表 1 组装为list 1
        ArrayList<Integer> list_num_1 = new ArrayList<>();
        while(l1 != null){
            list_num_1.add(l1.val);
            l1 = l1.next;
        }
        // 拆解链表 2 组装为list 2
        ArrayList<Integer> list_num_2 = new ArrayList<>();
        while(l2 != null){
            list_num_2.add(l2.val);
            l2 = l2.next;
        }

        ArrayList<Integer> list_num = new ArrayList<>();
        int max = Math.max(list_num_1.size(), list_num_2.size());// 取最大值
        int min = Math.min(list_num_1.size(),list_num_2.size());// 取最小值
        if (list_num_1.size() <= list_num_2.size()){
            for(int i = max - 1 ; i >= 0 ; i--){
                if (i >= min){
                    list_num.add(list_num_2.get(i));
                }
                else{
                    int sum = list_num_1.get(i)+list_num_2.get(i);
                    list_num.add(sum);
                }
            }
        }else{
            for(int i = max - 1 ; i >= 0 ; i--){
                if (i >= min){
                    list_num.add(list_num_1.get(i));
                }
                else{
                    int sum = list_num_1.get(i)+list_num_2.get(i);
                    list_num.add(sum);
                }
            }
        }
        //组装每一个节点
        ArrayList<ListNode> list = new ArrayList<>();
        boolean cnt = false;// 记录下位是否进位
        for (int i = list_num.size() - 1 ; i >= 0 ; i--) {
            int num = list_num.get(i);
            if (cnt)
                num+=1;
            if (num / 10 > 0){
                cnt = true;
                ListNode node = new ListNode(num % 10);
                list.add(node);
            }else {
                cnt = false;
                ListNode node = new ListNode(num);
                list.add(node);
            }
        }
        // 补进位 1
        if (cnt){
            ListNode node = new ListNode(1);
            list.add(node);
        }

        //各个节点关联起来
        for (int i = 0 ; i < list.size()-1 ; i++) {
            list.get(i).next = list.get(i+1);
        }
        return list.get(0);

    }
}


