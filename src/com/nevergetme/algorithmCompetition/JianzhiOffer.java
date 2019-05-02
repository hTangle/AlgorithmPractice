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
        TreeNode t1=new TreeNode(10);
        TreeNode t2=new TreeNode(5);
        TreeNode t3=new TreeNode(4);
        TreeNode t4=new TreeNode(7);
        TreeNode t5=new TreeNode(12);
        t1.left=t2;
        t2.left=t3;
        t2.right=t4;
        t1.right=t5;
        jzo.FindPath(t1,22);
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
        //System.out.println(jzo.Add(30,123));
        //HashMap

    }
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> results=new ArrayList<>();
        ArrayList<Integer> currentPath=new ArrayList<>();
        FindPath(root,target,results,currentPath);
        Collections.sort(results, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                if(o1.size()>o2.size())return -1;
                else if(o1.size()<o2.size())return 1;
                else
                    return 0;
            }
        });
        return results;
    }
    public void FindPath(TreeNode root,int target,ArrayList<ArrayList<Integer>> results,ArrayList<Integer> currentPath){
        if(root==null)return;
        if(root.left==null&&root.right==null){
            if(root!=null&&root.val==target){
                ArrayList<Integer> temp=new ArrayList<>();
                for(int k:currentPath){
                    temp.add(k);
                }
                temp.add(root.val);
                results.add(temp);
            }
        }else{
            currentPath.add(root.val);
            if(root.left!=null)FindPath(root.left,target-root.val,results,currentPath);
            if(root.right!=null)FindPath(root.right,target-root.val,results,currentPath);
            currentPath.remove(currentPath.size()-1);
        }
    }
    public boolean duplicate(int[] numbers,int length,int [] duplication) {
        duplication[0]=-1;
        if(numbers.length==0){

            return false;
        }
        Map<Integer,Integer> map=new HashMap<>();
        for(int number:numbers){
            if(map.containsKey(number)){
                duplication[0]=number;
                return true;
            }else{
                map.put(number,1);
            }
        }
        return false;
    }
    public int Add(int num1,int num2) {
        int sum,carry;
        do{
            sum=num1^num2;
            carry=(num1&num2)<<1;
            num1=sum;
            num2=carry;
        }while (num2!=0);
        return num1;
    }
    public int LastRemaining_Solution(int n, int m) {
        if(n<1||m<1)return -1;
        int last=0;
        for(int i=2;i<=n;i++){
            last=(last+m)%i;
        }
        return last;
    }
    public boolean isContinuous(int [] numbers) {
        if(numbers.length==0)return false;
        if(numbers.length==1)return true;
        Arrays.sort(numbers);
        int zeroNumber=0;
        int zeroIndex=0;
        for(zeroIndex=0;zeroIndex<numbers.length;zeroIndex++){
            if(numbers[zeroIndex]==0)zeroNumber++;
            else{
                break;
            }
        }
        if(zeroNumber==numbers.length)return true;
        int small=zeroIndex;
        int big=zeroIndex+1;
        while (big<numbers.length){
            if(numbers[small]==numbers[big]){
                return false;
            }
            zeroNumber-=(numbers[big]-numbers[small]-1);
            if(zeroNumber<0)return false;
            small=big;
            big++;
        }
        return zeroNumber>=0;
    }
    public String ReverseSentence(String str) {
        String res="",tmp="";
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' '){
                res=" "+tmp+res;
                tmp="";
            }else{
                tmp+=str.charAt(i);
            }
        }
        if(tmp.length()>0)res=tmp+res;
        return res;
    }
    public String LeftRotateString(String str,int n) {
        if(n==0)return str;
        if(str.length()==0)return "";
        n=n%str.length();
        return str.substring(n)+str.substring(0,n);
    }
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> output=new ArrayList<>();
        if(array.length<=1)return output;
        int small=0;
        int large=array.length-1;
        while (true){
            if(array[small]+array[large]>sum){
                large--;
            }else if(array[small]+array[large]==sum){
                output.add(array[small]);
                output.add(array[large]);
                break;
            }else{
                small++;
            }
            if(small>=large)break;
        }
        return output;
    }
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        int small=1,large=2;
        int currentSum=3;
        ArrayList<ArrayList<Integer>> outputs=new ArrayList<>();
        while (true){
            if(currentSum<sum){
                large+=1;
                currentSum+=large;
            }else if(currentSum==sum){
                ArrayList<Integer> output=new ArrayList<>();
                for(int i=small;i<=large;i++){
                    output.add(i);
                }
                outputs.add(output);
                large+=1;
                currentSum+=large;
            }else{
                currentSum-=small;
                small+=1;
            }
            if(large>(sum+1)/2||small>=large){
                break;
            }
        }
        return outputs;
    }
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array.length<2)return;
        int resultExculsiveOr=0;
        for(int a:array){
            resultExculsiveOr^=a;
        }
        int index=firstBitOf1(resultExculsiveOr);
        for(int a:array){
            if(isBit1(a,index)){
                num1[0]^=a;
            }else{
                num2[0]^=a;
            }
        }
    }
    public boolean isBit1(int num,int index){
        return (num>>index)%2==1;
    }
    private int firstBitOf1(int num){
        int indexBit=0;
        while (num%2==0){
            num=num>>1;
            indexBit++;
        }
        return indexBit;
    }
    private boolean isBalanced=true;
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root==null)return true;
        IsBalancedDepth(root);
        return isBalanced;
    }

    public int IsBalancedDepth(TreeNode root) {
        if(isBalanced==false)return -5;
        if(root==null)return 0;
        int left=IsBalancedDepth(root.left);
        int right=IsBalancedDepth(root.right);
        isBalanced=Math.abs(left-right)<2?true:false;
        return Math.max(left,right)+1;

    }
    public int TreeDepth(TreeNode root) {
        if(root==null)return 0;
        return Math.max(TreeDepth(root.left),TreeDepth(root.right))+1;
    }

    public int GetNumberOfK(int [] array , int k) {
        int number=0;
        if(array!=null&&array.length!=0){
            int first=GetNumberOfFisrtK(array,k,0,array.length-1);
            int last=GetNumberOfLastK(array,k,0,array.length-1);
            if(first>-1&&last>-1){
                number=last-first+1;
            }
        }
        return number;
        //return GetNumberOfK(array,k,0,array.length-1);
    }
    public int GetNumberOfLastK(int [] array , int k,int begin,int end){
        if(begin>end)return -1;
        if(begin==end)return array[begin]==k?begin:-1;
        int mid=(begin+end)>>1;
        if(array[mid]==k){
            if((mid<array.length-1&&array[mid+1]!=k)||mid==array.length-1){
                return mid;
            }else{
                begin=mid+1;
            }
        }else if(array[mid]>k){
            end=mid-1;
        }else{
            begin=mid+1;
        }
        return GetNumberOfLastK(array,k,begin,end);
    }
    public int GetNumberOfFisrtK(int [] array , int k,int begin,int end) {
        if(begin>end)return -1;
        if(begin==end)return array[begin]==k?begin:-1;
        int mid=(begin+end)/2;
        if(array[mid]==k){
            if((mid>0&&array[mid-1]!=k)||mid==0)
                return mid;
            else{
                end=mid-1;
            }
        }else if(array[mid]>k){
            end=mid-1;
        }else{
            begin=mid+1;
        }
        return GetNumberOfFisrtK(array,k,begin,end);
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int l1=getListNodeLength(pHead1);
        int l2=getListNodeLength(pHead2);
        if(l1<l2)return FindFirstCommonNode(pHead2,pHead1);
        int diff=l1-l2;
        ListNode first=pHead1;
        ListNode second=pHead2;
        for(int i=0;i<diff;i++){
            first=first.next;
        }
        while (first!=null&&second!=null&&first!=second){
            first=first.next;
            second=second.next;
        }
        return first;
    }

    private int getListNodeLength(ListNode root){
        int len=0;
        while (root!=null){
            root=root.next;
            len++;
        }
        return len;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    private int count=0;

    public int InversePairs(int [] array) {
        if(array==null||array.length==0)return -1;
        mergeSort(array,0,array.length-1);
        return count;
    }
    public void mergeSort(int[] array,int left,int right){
        if(left<right){
            int mid=(left+right)/2;
            mergeSort(array,left,mid);
            mergeSort(array,mid+1,right);
            mergeSort(array,left,mid,right);
        }
    }
    public void mergeSort(int[] array,int left,int mid,int right){
        int[] copy=new int[right-left+1];
        int t=right-left;
        int l=mid;
        int r=right;
        while (l>=left&&r>=mid+1){
            if(array[l]>array[r]){
                count+=(r-mid);
                copy[t--]=array[l--];
                if(count>=1000000007){
                    count%=1000000007;
                }
            }else{
                copy[t--]=array[r--];
            }
        }
        while (l>=left){
            copy[t--]=array[l--];
        }
        while (r>=mid+1){
            copy[t--]=array[r--];
        }
        for(int i=0;i<=right-left;i++){
            array[left+i]=copy[i];
        }
    }
//    public int InversePairs(int[] array,int[] copy,int start,int end){
//        if(start==end){
//            return 0;
//        }
//        int length=(end+start)>>2;
//        int left=InversePairs(array,copy,start,length)%1000000007;
//        int right=InversePairs(array,copy,length+1,end)%1000000007;
//        int i=length;
//        int j=end;
//        int indexCopy=end;
//        int count=0;
//        while (i>=start&&j>=length){
//            if(array[i]>array[j]){
//                copy[indexCopy--]=array[i--];
//                count+=j-length;
//                count%=1000000007;
//            }else{
//                copy[indexCopy--]=array[j--];
//            }
//        }
//        for(;i>=start;i--){
//            copy[indexCopy--]=array[i];
//        }
//        for(;j>length;j--){
//            copy[indexCopy--]=array[j];
//        }
//        for(int s=start;s<=end;s++){
//            array[s]=copy[s];
//        }
//        return (left+right+count)%1000000007;
//    }

    public int FirstNotRepeatingChar(String str) {
        Map<Character,Integer> map=new HashMap<>();
        char[] s=str.toCharArray();
        for(char c:s){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(int i=0;i<s.length;i++){
            if(map.get(s[i])==1){
                return i;
            }
        }
        return -1;
    }

    public int getTranslation(int number){
        if(number<0)return 0;
        if(number<9)return 1;
        String num=number+"";
        return getTranslation(num);
    }
    private int getTranslation(String num){
        int len=num.length();
        int[] f=new int[len];
        f[len-1]=1;
        for(int i=len-1;i>=0;i--){
            if(i<len-1){
                int t=(num.charAt(i)-'0')*10+(num.charAt(i+1)-'0');
                if(t<=25&&t>=10){
                    if(i<len-2){
                        f[i]=f[i+1]+f[i+2];
                    }else{
                        f[i]=f[i+1]+1;
                    }
                }else{
                    f[i]=f[i+1];
                }
            }
        }
        return f[0];
    }
    private boolean isUglyNumber(int number){
        while (number%2==0){
            number=number>>1;
        }
        while (number%3==0){
            number=number/3;
        }
        while (number%5==0){
            number/=5;
        }
        return number==1?true:false;
    }
    public int GetUglyNumber_Solution(int index) {
        if(index<7)return index;
        int p2=0,p3=0,p5=0,newNum=1;
        List<Integer> arr=new ArrayList<>();
        arr.add(newNum);
        while (arr.size()<index){
            newNum=Math.min(arr.get(p2)*2,Math.min(arr.get(p3)*3,arr.get(p5)*5));
            if(arr.get(p2)*2==newNum)p2++;
            if(arr.get(p3)*3==newNum)p3++;
            if(arr.get(p5)*5==newNum)p5++;
            arr.add(newNum);
        }
        return newNum;
    }
    public String PrintMinNumber(int [] numbers) {
        List<String> result=new ArrayList<>();
        for(int i:numbers){
            result.add(i+"");
        }
        Collections.sort(result, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo(o2+o1);
            }
        });
        StringBuilder sb=new StringBuilder();
        for(String s:result){
            sb.append(s);
        }
        return sb.toString();
    }
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array.length==0)return 0;
        int currentSum=array[0];
        int maxValue=array[0];
        for(int i=1;i<array.length;i++){
            if(currentSum<=0){
                currentSum=array[i];
            }else{
                currentSum+=array[i];
            }
            if(currentSum>maxValue){
                maxValue=currentSum;
            }
        }
        return maxValue;
    }
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> results=new ArrayList<>();
        if(input==null||input.length<k||k<=0)return results;
        int start=0;int end=input.length-1;
        int index=partition(input,start,end);
        while (index!=k-1){
            if(index>k-1){
                end=index-1;
                index=partition(input,start,end);
            }else{
                start=index+1;
                index=partition(input,start,end);
            }
        }
        for(int i=0;i<k;i++){
            results.add(input[i]);
        }
        return results;
    }
    private int partition(int[] input,int begin,int end){
        int i=begin,j=end+1;
        int x=input[begin];
        if(begin>=end)return end;
        while (begin<end){
            while (input[++i]<x)if(i==end)break;
            while(input[--j]>x)if(j==begin)break;
            if(i>=j)break;
            swap(input,i,j);
        }
        swap(input,begin,j);
        return j;
    }
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array.length==0)return 0;
        if(array.length==1)return array[0];
        int begin=array[0],times=1;
        for(int i=1;i<array.length;i++){
            if(times==0){
                begin=array[i];
                times=1;
                continue;
            }
            if(array[i]!=begin){
                times--;
            }else{
                times++;
            }
        }
        int sum=0;
        for(int i:array){
            if(begin==i)
                sum++;
        }
        if(sum<=array.length/2)return 0;
        return begin;
    }
    public TreeNode Convert(TreeNode pRootOfTree) {
        TreeNode pLast=null;
        pLast=Convert(pRootOfTree,pLast);
        TreeNode pHead=pLast;
        while (pHead!=null&&pHead.left!=null){
            pHead=pHead.left;
        }
        return pHead;
    }
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> results=new ArrayList<>();
        if(str==null||str.length()==0)return results;
        Permutation(str.toCharArray(),results,0);
        Collections.sort(results);
        return results;
    }
    public void Permutation(char[] c,ArrayList<String> result,int begin){
        if(begin==c.length){
            result.add(new String(c));
            return;
        }
        HashSet<Character> set=new HashSet<>();
        for(int i=begin;i<c.length;i++){
            if(!set.contains(c[i])){
                set.add(c[i]);
                swap(c,begin,i);
                Permutation(c,result,begin+1);
                swap(c,begin,i);
            }
        }
    }
    public void swap(char[] c,int i,int j){
        char temp=c[i];
        c[i]=c[j];
        c[j]=temp;
    }
    public void swap(int[] c,int i,int j){
        int temp=c[i];
        c[i]=c[j];
        c[j]=temp;
    }
    private TreeNode Convert(TreeNode pNode,TreeNode pLast){
        if(pNode==null)return pLast;
        TreeNode pCurrent=pNode;
        if(pCurrent.left!=null){
            pLast=Convert(pCurrent.left,pLast);
        }
        pCurrent.left=pLast;
        if(pLast!=null)pLast.right=pCurrent;
        pLast=pCurrent;
        if(pCurrent.right!=null)pLast=Convert(pCurrent.right,pLast);
        return pLast;
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
