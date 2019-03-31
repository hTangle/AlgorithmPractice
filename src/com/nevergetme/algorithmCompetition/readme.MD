## 61. Rotate List
#### Given a linked list, rotate the list to the right by k places, where k is non-negative.
#### 求链表长度，连成一个环，然后在特定的位置把环断开
```
public ListNode rotateRight(ListNode head, int k) {
        if(head==null||k==0)return head;
        int len=1;
        ListNode h=head;
        while (h.next!=null){
            h=h.next;
            len++;
        }
        h.next=head;
        int m=k%len;
        for(int i=0;i<len-m;i++){
            h=h.next;
        }
        head=h.next;
        h.next=null;
        return head;
    }
```

