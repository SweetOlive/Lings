package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author Lings
 * @Version 1.0
 */
public class leetcode83 {
    public static void main(String[] args) {

        //[1,1,2,3,3]
//        ListNode listNode1 = new ListNode(1);
//        ListNode listNode2 = new ListNode(1);
//        ListNode listNode3 = new ListNode(2);
//        ListNode listNode4 = new ListNode(3);
//        ListNode listNode5 = new ListNode(3);
//        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        listNode4.next = listNode5;
//        ListNode list = deleteDuplicates(listNode1);
//        System.out.println(list.toString());

        //[-3,-1,0,0,0,3,3]
        ListNode listNode1 = new ListNode(-3);
        ListNode listNode2 = new ListNode(-1);
        ListNode listNode3 = new ListNode(0);
        ListNode listNode4 = new ListNode(0);
        ListNode listNode5 = new ListNode(0);
        ListNode listNode6 = new ListNode(3);
        ListNode listNode7 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        ListNode list = deleteDuplicates(listNode1);
        System.out.println(list.toString());

    }
    public static ListNode deleteDuplicates(ListNode head) {
        // 硬核解法（暴力解-时间空间开销大）
        ListNode tmp = head;
        //通过set过滤重复节点
        HashSet<Integer> set = new HashSet<>();
        while(tmp != null){
            set.add(tmp.val);
            tmp = tmp.next;
        }
        //重新排序（set会因为后续出现重复数据排序发生改变）
        List<Integer> collect = set.stream().sorted().collect(Collectors.toList());
        //组装每一个节点
        ArrayList<ListNode> list = new ArrayList<>();
        for (Integer i: collect) {
            ListNode node = new ListNode(i);
            list.add(node);
        }
        //各个节点关联起来
        for (int i = 0 ; i < list.size()-1 ; i++) {
            list.get(i).next = list.get(i+1);
        }
        //返回数据
        if (list.size() > 0)
            return list.get(0);


        // 循环解法
        ListNode now = head;
        while (now != null && now.next != null) {
            if (now.val != now.next.val) {
                now = now.next;
            } else {
                now.next = now.next.next;
            }
        }
        return head;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

