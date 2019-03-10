package com.nevergetme.algorithmCompetition;

import java.util.*;

public class JianzhiOffer {
    public static void main(String[] args) {
        JianzhiOffer jzo = new JianzhiOffer();
        //jzo.findFromMatrix(new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}},6);
        //jzo.rotateMinNumber(new int[]{3,4,5,1,2});
        //new JianzhiOffer().repeatNumbersInList(new int[]{2,3,1,0,2,5,3});
        //System.out.println(jzo.NumberOf1(7));
        //System.out.println(jzo.moreThanHalfNumbers(new int[]{1,2,2,3,2,1,2,2,1,2,1}));
//        Map<Integer,Integer> map=new HashMap<>();
//        getCarentChildPairs( new int[][] {
//                {1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7},
//                {4, 5}, {4, 8}, {8, 10}
//        });
        //jzo.recordOddEven(new int[]{1,2,3,4,5});
//        Node head=new Node(1);
//        head.next=new Node(3);
//        head.next.next=new Node(4);
//        head.next.next.next=new Node(7);
//        Node tail=new Node(2);
//        tail.next=new Node(5);
//        tail.next.next=new Node(6);
//        tail.next.next.next=new Node(8);
//        Node output=jzo.mergeList(head,tail);
//        jzo.findKthToTail(head,3);
        //System.out.println(jzo.replaceSpace(new StringBuffer("We Are Happy")));
//        TreeNode t1=new TreeNode(1);
//        TreeNode t2=new TreeNode(2);
//        TreeNode t3=new TreeNode(3);
//        TreeNode t4=new TreeNode(4);
//        TreeNode t5=new TreeNode(5);
//        TreeNode t6=new TreeNode(6);
//        TreeNode t7=new TreeNode(7);
//        TreeNode t8=new TreeNode(8);
//        t1.left=t2;
//        t2.left=t4;
//        t4.right=t7;
//        t1.right=t3;
//        t3.left=t5;
//        t3.right=t6;
//        t6.left=t8;
//        TreeNode t=jzo.reConstructBinaryTree(new int[]{1,2,4,7,3,5,6,8},new int[]{4,7,2,1,5,3,8,6});
//        System.out.println();
//        jzo.push(1);
//        jzo.push(2);
//        jzo.push(3);
//        System.out.println(jzo.pop());
//        System.out.println(jzo.pop());
//        System.out.println(jzo.pop());
        System.out.println(jzo.Fibonacci(3));
        //HashMap

    }
    public int JumpFloor(int target) {
        int[] result=new int[]{0,1};
        if(target<2)return result[target];
        int fibNMinusOne=1;
        int fibNMinusTwo=0;
        int fibN=0;
        for(int i=2;i<=target;i++){
            fibN=fibNMinusOne+fibNMinusTwo;
            fibNMinusTwo=fibNMinusOne;
            fibNMinusOne=fibN;
        }
        return fibN;
    }
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        if(s==null||s.length()==0)return new ArrayList<String>();
        int maxLength=0;
        for(String st:dict){
            maxLength=Math.max(maxLength,st.length());
        }
        Map<Integer, ArrayList<String>> memo = new HashMap<>();
        return wordBreak(s,dict,memo,0,maxLength);

    }
    public ArrayList<String> wordBreak(String s,Set<String> dict,Map<Integer, ArrayList<String>> memo, int startIdx, int maxLength){
        if(memo.containsKey(startIdx)){
            return memo.get(startIdx);
        }
        ArrayList<String> result = new ArrayList<>();
        for(int i=startIdx;i<s.length()&&i+1-maxLength<=startIdx;i++){
            String pref=s.substring(startIdx,i+1);
            if(dict.contains(pref)){
                if(i==s.length()-1){
                    result.add(pref);
                    return result;
                }
                ArrayList<String> laters=wordBreak(s,dict,memo,i+1,maxLength);
                for(String later:laters){
                    result.add(pref+" "+later);
                }
            }
        }
        memo.put(startIdx, result);
        return result;
    }
    public int Fibonacci(int n) {
        int f=0,g=1;
        while ((n--)!=0){
            g+=f;
            f=g-f;
        }
        return f;
//        if(n==0)return 0;
//        if(n==1)return 1;
//        if(n==2)return 1;
//        int f1=1,f2=1;
//        int temp=0;
//        for(int i=2;i<n;i++){
//            temp=f2;
//            f2+=f1;
//            f1=temp;
//            //System.out.println(f1);
//        }
//        return f2;
    }
    public int minNumberInRotateArray(int [] array) {
        if(array.length==0)return 0;
        int begin=0,end=array.length-1;
        int middle=begin;
        while(array[begin]>=array[end]){
            if(end-begin==1){
                middle=end;
                break;
            }
            middle=(begin+end)/2;
            if(array[middle]==array[begin]&&array[middle]==array[end])return minInOrder(array,begin,end);
            if(array[middle]>=array[begin])begin=middle;
            else if(array[middle]<=array[end])end=middle;
        }
        return array[middle];
    }
    public int minInOrder(int[] array,int begin,int end){
        int result=array[begin];
        for(int i=0;i<=end;i++){
            if(result>array[i])result=array[i];
        }
        return result;
    }
//    Stack<Integer> stack1 = new Stack<Integer>();
//    Stack<Integer> stack2 = new Stack<Integer>();
//
//    public void push(int node) {
//        stack1.push(node);
//    }
//
//    public int pop() {
//        while (!stack1.empty()) {
//            stack2.push(stack1.pop());
//        }
//        int result = stack2.pop();
//        while (!stack2.empty()) {
//            stack1.push(stack2.pop());
//        }
//        return result;
//    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return reConstructBinaryTree(pre, in, 0, pre.length - 1, 0, in.length - 1);
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in, int preBegin, int preEnd, int inBegin, int inEnd) {
        int target = pre[preBegin];
        int inTargetIndex = findIndexOfList(in, inBegin, inEnd, target);
        TreeNode node = new TreeNode(target);
        if (inTargetIndex == inBegin) node.left = null;
        else
            node.left = reConstructBinaryTree(pre, in, preBegin + 1, preBegin + inTargetIndex - inBegin, inBegin, inTargetIndex - 1);
        if (inTargetIndex == inEnd)
            node.right = null;
        else
            node.right = reConstructBinaryTree(pre, in, preBegin + inTargetIndex - inBegin + 1, preEnd, inTargetIndex + 1, inEnd);
        return node;
    }

    public int findIndexOfList(int[] arr, int begin, int end, int target) {
        for (int i = begin; i <= end; i++) {
            if (target == arr[i]) return i;
        }
        return 0;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public ArrayList<Integer> printListFromTailToHead(Node listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        Node head = listNode;
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        Collections.reverse(list);
        return list;
    }

    public String replaceSpace(StringBuffer str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i) == ' ' ? "%20" : str.charAt(i));
        }
        return sb.toString();
        //return str.replace(0,str.length(),)
    }

    public boolean hasSubTree(Tree root1, Tree root2) {
        boolean result = false;
        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                result = doesTree1HaveTree2(root1, root2);
            }
            if (!result)
                result = hasSubTree(root1.left, root2);
            if (!result)
                result = hasSubTree(root1.right, root2);
        }
        return result;
    }

    boolean doesTree1HaveTree2(Tree root1, Tree root2) {
        if (root2 == null) return true;
        if (root1 == null) return false;
        if (root1.val != root2.val) return false;
        return doesTree1HaveTree2(root1.left, root2.left) && doesTree1HaveTree2(root1.right, root2.right);
    }

    public boolean Find(int target, int[][] array) {
        if (array == null) return false;
        if (array.length > 0 && array[0].length > 0) {
            int row = 0, col = array[0].length - 1;
            while (row < array.length && col >= 0) {
                if (array[row][col] == target) return true;
                else if (array[row][col] > target) col--;
                else row++;
            }
        }
        return false;
    }

    private static class Tree {
        int val;
        Tree left, right;

        Tree(int val) {
            this.val = val;
        }
    }

    public Node mergeList(Node l1, Node l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        Node pHead = null;
        if (l1.val < l2.val) {
            pHead = l1;
            pHead.next = mergeList(l1.next, l2);
        } else {
            pHead = l2;
            pHead.next = mergeList(l1, l2.next);
        }
        return pHead;
    }

    private static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    public Node findKthToTail(Node head, int k) {
        if (head == null) return null;
        if (k == 0) return null;
        Node pHead = head;
        for (int i = 0; i < k - 1; i++) {
            if (pHead.next != null)
                pHead = pHead.next;
            else
                return null;
        }
        Node kHead = head;
        while (pHead.next != null) {
            pHead = pHead.next;
            kHead = kHead.next;
        }
        return kHead;
//        Node pHead=head;
//        Node kHead;
//        while (pHead!=null&&k>=0){
//            pHead=pHead.next;
//            k--;
//        }
//        if(k>0){
//            System.out.println("Length is less than "+k);
//        }else{
//            kHead=head;
//            while (pHead!=null){
//                pHead=pHead.next;
//                kHead=kHead.next;
//            }
//            System.out.println(kHead.val);
//        }

    }

    public void recordOddEven(int[] input) {
        int begin = 0, end = input.length - 1;
        if (input.length == 0)
            return;
        while (begin < end) {
            while (begin < end && isEven(input[begin]))
                begin++;
            while (begin < end && !isEven(input[end] % 2))
                end--;
            if (begin < end) {
                int temp = input[begin];
                input[begin] = input[end];
                input[end] = temp;
            }
        }
        for (int t : input) {
            System.out.print(t + " ");
        }
        System.out.println();
    }

    private boolean isEven(int n) {
        return n % 2 == 0;
    }

    public static void getCarentChildPairs(int[][] parentChildPairs) {
        //output have two collections, but java's function return type have only one collections a time
        //should i have to use like below
        //List

        // so you can put two collections in a third one and then return right?
        Map<Integer, Integer> outcomeMap = new HashMap<>();
        Map<Integer, Integer> outcomeMapLeft = new HashMap<>();
        for (int i = 0; i < parentChildPairs.length; i++) {
            if (outcomeMapLeft.containsKey(parentChildPairs[i][0])) {
                outcomeMapLeft.put(parentChildPairs[i][0], outcomeMapLeft.get(parentChildPairs[i][0]) + 1);
            } else {
                outcomeMapLeft.put(parentChildPairs[i][0], 1);
            }

            if (outcomeMap.containsKey(parentChildPairs[i][1])) {
                outcomeMap.put(parentChildPairs[i][1], outcomeMap.get(parentChildPairs[i][1]) + 1);
            } else {
                outcomeMap.put(parentChildPairs[i][1], 1);
            }
        }
        List<Integer> zeroParent = new ArrayList<>();
        List<Integer> oneParent = new ArrayList<>();
        Iterator<Map.Entry<Integer, Integer>> iterator = outcomeMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            if (entry.getValue() == 1)
                oneParent.add(entry.getKey());
        }
        Iterator<Map.Entry<Integer, Integer>> iterator1 = outcomeMapLeft.entrySet().iterator();
        while (iterator1.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator1.next();
            if (entry.getValue() == 1)
                zeroParent.add(entry.getKey());
        }
        List<List<Integer>> output = new ArrayList<>();
        output.add(zeroParent);
        output.add(oneParent);
        System.out.println();
        //get the value=1 &&value=0
    }

    public int moreThanHalfNumbers(int[] numbers) {
        if (numbers.length < 1) return 0;
        int currentNumbers = numbers[0];
        int currentTimes = 1;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] != currentNumbers) {
                if (currentTimes == 0) {
                    currentNumbers = numbers[i];
                    currentTimes = 1;
                } else {
                    currentTimes -= 1;
                }
            } else {
                currentTimes += 1;
            }
        }
        return currentNumbers;
    }

    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = (n - 1) & n;
        }
        return count;
    }

    public int maxProductAfterCuttingSolutionTwo(int length) {
        if (length < 2) return 0;
        if (length == 2) return 1;
        if (length == 3) return 2;
        int timesOf3 = length / 3;
        if (length - timesOf3 * 3 == 1) {
            timesOf3 -= 1;
        }
        int timesOf2 = (length - timesOf3 * 3) / 2;
        return (int) (Math.pow(3, timesOf3)) * (int) (Math.pow(2, timesOf2));
    }

    public int maxProductAfterCuttingSolutionOne(int length) {
        if (length < 2) return 0;
        if (length == 2) return 1;
        if (length == 3) return 2;
        int[] products = new int[length + 1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;
        int max = 0;
        for (int i = 4; i <= length; i++) {
            max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int product = products[j] * products[i - j];
                if (max < product)
                    max = product;
                products[i] = max;
            }
        }
        max = products[length];
        return max;
    }

    public void rotateMinNumber(int[] numbers) {
        int index1 = 0;
        int index2 = numbers.length - 1;
        int indexMid = index1;
        while (numbers[index1] >= numbers[index2]) {
            if (index2 - index1 == 1) {
                indexMid = index2;
                break;
            }
            indexMid = (index1 + index2) / 2;
            if (numbers[index1] == numbers[index2] && numbers[index1] == numbers[indexMid])
                rotateMinNumber(numbers, index1, index2);
            if (numbers[indexMid] >= numbers[index1]) {
                index1 = indexMid;
            } else if (numbers[indexMid] <= numbers[index2]) {
                index2 = indexMid;
            }
        }
        System.out.println(numbers[indexMid]);
    }

    public void rotateMinNumber(int[] numbers, int index1, int index2) {
        int reslut = numbers[index1];
        for (int i = index1 + 1; i <= index2; i++) {
            if (reslut > numbers[i])
                reslut = numbers[i];
        }
        System.out.println(reslut);
    }

    public void repeatNumbersInList(int[] input) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            while (input[i] != i) {
                if (input[i] == input[input[i]]) {
                    sb.append(input[i]);
                    break;
                }
                int temp = input[i];
                input[i] = input[input[i]];
                input[temp] = temp;
            }
        }
        System.out.println(sb.toString());
    }

    public void findFromMatrix(int[][] input, int target) {
        //int[] output=new int[2];
        int i = 0;
        int j = input[0].length - 1;
        while (true) {
            if (input[i][j] > target)
                j--;
            else if (input[i][j] < target) {
                i++;
            } else {
                System.out.println(i + "," + j);
                break;
            }
            if (i >= input.length || j < 0) {
                System.out.println("error");
                break;
            }
        }
    }
}
