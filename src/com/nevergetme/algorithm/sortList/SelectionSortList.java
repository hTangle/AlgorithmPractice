package com.nevergetme.algorithm.sortList;

public class SelectionSortList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(-1);
        ListNode n1 = new ListNode(5);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(0);
        ListNode n5 = new ListNode(6);
        ListNode n6 = new ListNode(-2);
        root.next=n1;
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        root=Sort(root);
        System.out.println();
    }


    public static ListNode Sort(ListNode head) {
        if(head==null||head.next==null)return head;
        ListNode pre=new ListNode(-1);
        ListNode root=pre;
        ListNode cur=head;
        while (cur!=null){
            pre=root;
            while (pre.next!=null&&pre.next.val<cur.val){
                pre=pre.next;
            }
            ListNode tmp=cur.next;
            cur.next=pre.next;
            pre.next=cur;
            cur=tmp;

        }

        return root.next;
    }
}
