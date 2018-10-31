package com.nevergetme.algorithmCompetition;

import java.util.*;

public class algorithmCompetition {
    public static void question3_7(String[] dna){
        String outputS="";
        for(int i=0;i<dna[0].length();i++){
            int[] count=new int[4];
            for(String t:dna){
                switch (t.charAt(i)){
                    case 'A':
                        count[0]++;
                        break;
                    case 'C':
                        count[1]++;
                        break;
                    case 'G':
                        count[2]++;
                        break;
                    case 'T':
                        count[3]++;
                        break;
                }
            }
            int k=0;
            int maxM=0;
            for(int j=0;j<4;j++){
                if(count[j]>maxM){
                    maxM=count[j];
                    k=j;
                }
            }
            if(k==0){
                outputS+="A";
            }else if(k==1){
                outputS+="C";
            }else if(k==2){
                outputS+="G";
            }else{
                outputS+="T";
            }
        }
        System.out.println(outputS);
    }
    public static void question3_5(char[][] in,String order){
        int row=0,col=0;
        for(int i=0;i<5;i++){
            boolean finish=false;
            for(int j=0;j<5;j++){
                if(in[i][j]=='0'){
                    row=i;
                    col=j;
                    finish=true;
                    break;
                }
            }
            if(finish)
                break;
        }
        for(int i=0;i<order.length();i++){
            if(order.charAt(i)=='0'){
                break;
            }
            switch (order.charAt(i)){
                case 'A':
                    if(row==0){
                        System.out.println("This puzzle has no final configuration");
                        return;
                    }
                    in[row][col]=in[row-1][col];
                    in[row-1][col]='0';
                    row--;
                    break;
                case 'B':
                    if(row==4){
                        System.out.println("This puzzle has no final configuration");
                        return;
                    }
                    in[row][col]=in[row+1][col];
                    in[row+1][col]='0';
                    row++;
                    break;
                case 'L':
                    if(col==0){
                        System.out.println("This puzzle has no final configuration");
                        return;
                    }
                    in[row][col]=in[row][col-1];
                    in[row][col-1]='0';
                    col--;
                    break;
                case 'R':
                    if(col==4){
                        System.out.println("This puzzle has no final configuration");
                        return;
                    }
                    in[row][col]=in[row][col+1];
                    in[row][col+1]='0';
                    col++;
                    break;
            }
        }
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                System.out.print(in[i][j]);
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
//        question3_5(new char[][]{{'T','R','G','S','J'},
//                {'X','D','O','K','I'},
//                {'M','0','V','L','N'},
//                {'W','P','A','B','E'},
//                {'U','Q','H','C','F'}},"ARRBBL0");
//        question3_7(new String[]{"TATGATAC","TAAGCTAC","AAAGATCC","TGAGATAC","TAAGATGT"});
//        List<Integer> list=new ArrayList<>();
//        int left=2;
//        int right=9999;
//        for(int i=left;i<=right;i++){
//            if(i<10){
//                System.out.print(i+",");
//            }else{
//                if(isDivisible(i)){
//                    System.out.print(i+",");
//                }
//            }
//        }
//        String s="hello";
//        char[] c=s.toCharArray();
//        char t='0';
//        int le=c.length-1;
//        for(int i=0;i<c.length/2;i++){
//            t=c[i];
//            c[i]=c[le-i];
//            c[le-i]=t;
//        }
//        System.out.println(String.valueOf(c));

//        System.out.println(5>>>3);

//        while(num!=0){
//            k=num%2;
//            num=num>>1;
//
//        }
//        Stack<Integer> stack=new Stack<>();
//        String a="()))((";
//        int count=0;
//        for(int i=0;i<a.length();i++){
//            if(a.charAt(i)=='('){
//                stack.push(1);
//            }else{
//                if(stack.empty()){
//                    count++;
//                }else{
//                    stack.pop();
//                }
//            }
//        }
//        count+=stack.size();
//        System.out.println(count);
        //shortestToChar();
        //uncommonFromSentences("this apple is sweet","this apple is sour");
//        islandPerimeter(new int[][]{{1},{0}});
//        numUniqueEmails();
        //binaryGap();
//        fizzBuzz(15);
        //singleNumber(new int[]{2,2,1});
        //System.out.println(addDigits(1138));
        //moveZeroes(new int[]{0,1,0,3,12});
        //System.out.println(detectCapitalUse("FlaG"));
        //findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
        //System.out.println(majorityElement(new int[]{2,2,1,1,1,2,2}));
        //matrixReshape(new int[][]{{1,2},{3,4}},4,1);
        //System.out.println(hasAlternatingBits(4));
        //System.out.println(reverseOnlyLetters("a-bC-dEf-ghIj"));
        //System.out.println(romanToInt("MCMXCIV"));
        //System.out.println(lemonadeChange(new int[]{5,5,10,10,20}));
        System.out.println(isAnagram("rat","cat"));
    }
    public static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        int[] output=new int[26];
        for(int i=0;i<s.length();i++){
            output[s.charAt(i)-'a']++;
        }
        for(int i=0;i<t.length();i++){
            output[t.charAt(i)-'a']--;
        }
        for(int k:output){
            if(k!=0)
                return false;
        }
        return true;
    }
    public static boolean lemonadeChange(int[] bills) {
        int[] output=new int[2];
        for(int bill:bills){
            if(bill==5){
                output[0]++;
            }else if(bill==10){
                if(output[0]<=0){
                    return false;
                }else{
                    output[0]--;
                    output[1]++;
                }
            }else{
                if(output[0]<=0){
                    return false;
                }
                if(output[1]<=0){
                    if(output[0]<=2){
                        return false;
                    }else{
                        output[0]-=3;
                    }
                }else {
                    output[0]--;
                    output[1]--;
                }
            }
        }
        return true;
    }
    public static int romanToInt(String s) {
        int output=0;
        int len=s.length();
        for(int i=0;i<s.length();i++){
            char cur=s.charAt(i);
            if(cur=='M'){
                output+=1000;
            }else if(cur=='D'){
                output+=500;
            }else if(cur=='C'){
                if(i+1<len){
                    if(s.charAt(i+1)=='D'){
                        output+=400;
                        i++;
                    }else if(s.charAt(i+1)=='M'){
                        output+=900;
                        i++;
                    }else{
                        output+=100;
                    }
                }else {
                    output+=100;
                }
            }else if(cur=='L'){
                output+=50;
            }else if(cur=='X'){
                if(i+1<len){
                    if(s.charAt(i+1)=='L'){
                        output+=40;
                        i++;
                    }else if(s.charAt(i+1)=='C'){
                        output+=90;
                        i++;
                    }else{
                        output+=10;
                    }
                }else {
                    output+=10;
                }
            }else if(cur=='V'){
                output+=5;
            }else if(cur=='I'){
                if(i+1<len){
                    if(s.charAt(i+1)=='V'){
                        output+=4;
                        i++;
                    }else if(s.charAt(i+1)=='X'){
                        output+=9;
                        i++;
                    }else {
                        output+=1;
                    }
                }else
                    output+=1;
            }
        }
        return output;
    }
    public static boolean rotateString(String A, String B) {
        return (A.length()==B.length())&&((A+A).contains(B));
    }
    public static String reverseOnlyLetters(String S) {
        int begin=0,end=S.length()-1;
        int len=S.length();
        char[] output=S.toCharArray();
        while(begin<end){
            while(!Character.isLetter(output[begin])){
                begin++;
                if(begin>=len){
                    break;
                }
            }
            while(!Character.isLetter(output[end])){
                end--;
                if(end<0){
                    break;
                }
            }
            if(begin<end){
                char t=output[begin];
                output[begin]=output[end];
                output[end]=t;
            }
            begin++;
            end--;
        }
        return String.valueOf(output);
    }
    public static boolean hasAlternatingBits(int n) {
//        if(((n>>1)^n)==0){
//            return true;
//        }else {
//            return false;
//        }
        if(n<=2){
            return true;
        }
        int begin=n%2;
        n=n>>1;
        while(n!=0){
            if(n%2!=begin){
                begin=n%2;
                n=n>>1;
            }else{
                return false;
            }
        }
        //System.out.println((n>>1)^n);
        return true;
    }
    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        if(nums.length*nums[0].length!=r*c){
            return nums;
        }
        int[][] output=new int[r][c];
        int index=0;
        for(int[] num:nums){
            for(int n:num){
                output[index/c][index%c]=n;
                index++;
            }
        }
        return output;
    }
    public static int majorityElement(int[] nums) {
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        for(int num:nums){
            if(hashMap.containsKey(num)){
                hashMap.put(num,hashMap.get(num)+1);
            }else{
                hashMap.put(num,1);
            }
        }
        int maxNum=nums.length/2;
        for(Map.Entry<Integer,Integer> item:hashMap.entrySet()){
            if(item.getValue()>maxNum){
                return item.getKey();
            }
        }
        return 0;
    }
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int[] output=new int[nums.length];
        for(int num:nums){
            output[num-1]++;
        }
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<output.length;i++){
            if(output[i]==0){
                list.add(i+1);
            }
        }
        return list;
    }
    public static boolean detectCapitalUse(String word) {
        if(word.toLowerCase().equals(word)||word.toUpperCase().equals(word)){
            return true;
        }
        if(word.length()<2)
            return false;
        if(word.charAt(0)<='Z'&&word.charAt(0)>='A'){
            if(word.substring(1).toLowerCase().equals(word.substring(1)))
                return true;
        }
        return false;
    }
    public static void moveZeroes(int[] nums) {
        if(nums==null||nums.length==0)
            return;
        int pos=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)
                continue;
            if(nums[pos]==0){
                nums[pos]=nums[i];
                nums[i]=0;
            }
            pos++;
        }
        return;
    }
    public static int addDigits(int num) {
        int output=num%9;
        if(output==0){
            return 1;
        }else{
            return output;
        }
    }
    public static void singleNumber(int[] nums) {
        int output=0;
        for(int num:nums){
            output^=num;
        }
        System.out.println(output);
//        List<Integer> list=new ArrayList<>();
//        for(int num:nums){
//            if(list.contains(num)){
//                list.remove(list.indexOf(num));
//            }else {
//                list.add(num);
//            }
//        }
//        System.out.println(list.get(0));
    }
    public static void fizzBuzz(int n) {
        List<String> list=new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(i%3==0&&i%5==0){
                list.add("FizzBuzz");
            }else if(i%3==0){
                list.add("Fizz");
            }else if(i%5==0){
                list.add("Buzz");
            }else {
                list.add(i+"");
            }
        }
        System.out.println(list);
    }
    public static void binaryGap() {
        int N=5;
        int maxDis=0;
        boolean begin=true;
        int count=1;
        while(N!=0){
            if(begin){
                if(N%2==1){
                    begin=false;
                }
            }else {
                if (N % 2 == 0) {
                    count++;
                } else {
                    if (count > maxDis)
                        maxDis = count;
                    count = 1;
                }
            }
            N=N>>1;
        }
        System.out.println(maxDis);
    }
    public static void numUniqueEmails() {
        String[] emails=new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        HashMap<String,Integer> hashMap=new HashMap<>();
        for(String email:emails){
            int plusPos=email.indexOf("+");
            int atPos=email.indexOf("@");
            if(plusPos!=-1){
                hashMap.put(email.substring(0,plusPos).replace(".","")+email.substring(atPos),1);
            }else{
                hashMap.put(email.substring(0,atPos).replace(".","")+email.substring(atPos),1);
            }
        }
        System.out.println(hashMap.size());
    }
    public static void islandPerimeter(int[][] grid) {
        int peri=0;
        int row=grid.length;
        int col=grid[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1) {
                    peri += 4;
                    if (i + 1 < row) {
                        if (grid[i + 1][j] == 1) {
                            peri -= 1;
                        }
                    }
                    if (i - 1 >= 0) {
                        if (grid[i-1][j]==1){
                            peri-=1;
                        }
                    }
                    if(j+1<col){
                        if(grid[i][j+1]==1){
                            peri-=1;
                        }
                    }
                    if(j-1>=0){
                        if(grid[i][j-1]==1){
                            peri-=1;
                        }
                    }
                }
            }
        }
//        if(row>=2&&col>=2) {
//            for (int i = 1; i < row - 1; i++) {
//                for (int j = 1; j < col - 1; j++) {
//                    if (grid[i][j] == 1)
//                        peri += (4 - grid[i - 1][j] - grid[i + 1][j] - grid[i][j - 1] - grid[i][j + 1]);
//                }
//            }
//        }
//        if(row>=2){
//            for(int i=1;i<col-1;i++){
//                if(grid[0][i]==1)
//                    peri+=(4-grid[0][i-1]-grid[0][i+1]-grid[1][i]);
//                if(grid[row-1][i]==1)
//                    peri+=(4-grid[row-1][i-1]-grid[row-1][i+1]-grid[row-2][i]);
//            }
//
//        }else{
//            for(int i=1;i<col-1;i++){
//                if(grid[0][i]==1)
//                    peri+=(4-grid[0][i-1]-grid[0][i+1]);
//            }
//        }
//        if(col>=2){
//            for(int i=1;i<row-1;i++){
//                if(grid[i][0]==1)
//                    peri+=(4-grid[i-1][0]-grid[i+1][0]-grid[i][1]);
//                if(grid[i][col-1]==1)
//                    peri+=(4-grid[i-1][col-1]-grid[i+1][col-1]-grid[i][col-2]);
//            }
//        }else{
//            for(int i=0;i<row-1;i++){
//                if(grid[i][0]==1)
//                    peri+=(4-grid[i-1][0]-grid[i+1][0]);
//            }
//        }
//        if(row>=2&&col>=2){
//            if(grid[0][0]==1)
//                peri+=(4-grid[0][1]-grid[1][0]);
//            if(grid[row-1][0]==1)
//                peri+=(4-grid[row-1][1]-grid[row-2][0]);
//            if(grid[0][col-1]==1)
//                peri+=(4-grid[1][col-1]-grid[0][col-2]);
//            if(grid[row-1][col-1]==1)
//                peri+=(4-grid[row-1][col-2]-grid[row-2][col-1]);
//        }else if(row<2&&col>=2){
//            if(grid[0][0]==1)
//                peri+=(4-grid[0][1]);
//            if(grid[0][col-1]==1)
//                peri+=(4-grid[0][col-2]);
//        }else if(row>=2&&col<2){
//            if(grid[0][0]==1)
//                peri+=(4-grid[1][0]);
//            if(grid[row-1][0]==1)
//                peri+=(4-grid[row-2][0]);
//        }else{
//            if(grid[0][0]==1)
//                peri=4;
//        }
        System.out.println(peri);
    }
    public static void shortestToChar() {
        String S="abaa";
        char C='b';
        int[] output=new int[S.length()];
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)==C){
                list.add(i);
            }
        }
        int begin=list.get(0);
        for(int i=0;i<begin;i++){
            output[i]=begin-i;
        }
        int end=list.get(list.size()-1);
        for(int i=end+1;i<S.length();i++){
            output[i]=i-end;
        }
        for(int i=0;i<list.size()-1;i++){
            begin=list.get(i);
            end=list.get(i+1);
            int mid=(begin+end)/2;
            for(int j=begin+1;j<end;j++){
                if(j<=mid){
                    output[j]=j-begin;
                }else{
                    output[j]=end-j;
                }
            }
        }
        System.out.println(output.toString());
    }
    public static void uncommonFromSentences(String A, String B) {
        String[] As=A.split(" ");
        String[] Bs=B.split(" ");
        HashMap<String,Integer> hashMap=new HashMap<>();
        for(String a:As){
            if(hashMap.containsKey(a)){
                hashMap.put(a,hashMap.get(a)+1);
            }else{
                hashMap.put(a,1);
            }
        }
        for(String a:Bs){
            if(hashMap.containsKey(a)){
                hashMap.put(a,hashMap.get(a)+1);
            }else{
                hashMap.put(a,1);
            }
        }
        List<String> list=new ArrayList<>();
        for(Map.Entry<String,Integer> item:hashMap.entrySet()){
            if(item.getValue()==1)
                list.add(item.getKey());
        }
        String[] output=new String[list.size()];
        for(int i=0;i<list.size();i++){
            output[i]=list.get(i);
        }
        System.out.println(output);
    }
    public void getDomainMax(){
        HashMap<String,Integer> hashMap=new HashMap<>();
        String[] cpdomains=new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        for(String str:cpdomains){
            String[] k=str.split(" ");
            int number=Integer.parseInt(k[0]);
            int z=0;
            if(hashMap.containsKey(k[1])){
                hashMap.put(k[1],hashMap.get(k[1])+number);
            }else{
                hashMap.put(k[1],number);
            }

            while(true){
                z=k[1].indexOf(".",z+1);
                if(z==-1){
                    break;
                }
                String s=k[1].substring(z+1);
                if(hashMap.containsKey(s)){
                    hashMap.put(s,hashMap.get(s)+number);
                }else{
                    hashMap.put(s,number);
                }
            }
        }
        List<String> list=new ArrayList<>();
        for(Map.Entry<String,Integer> item:hashMap.entrySet()){
            list.add(item.getValue()+" "+item.getKey());
        }
        System.out.println(list.toString());
    }
    public int arrayPairSum(int[] nums) {
        int res = 0;
        if (nums.length < 200) {
            Arrays.sort(nums);
            for (int i = 0 ; i < nums.length ; i = i + 2) {
                res += nums[i];
            }
        } else {
            int[] freq = new int[20001];
            for (int i : nums) {
                freq[i+10000] ++;//统计数字的频率
            }
            boolean flag = true;
            for (int i = 0 ; i < 20001; i ++) {
                while (freq[i] > 0) {
                    if (flag) {
                        res += (i-10000);
                    }
                    flag = !flag;
                    freq[i] --;
                }
            }
        }
        return res;
    }
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list=new ArrayList<>();
        int[] output=new int[]{2,3,4,5,6,7,8,9,11,12,15,22,24,33,36,44,48,55,66,77,88,99,111,112,115,122,124,126,128,132,135,144,155,162,168,175,184,212,216,222,224,244,248,264,288,312,315,324,333,336,366,384,396,412,424,432,444,448,488,515,555,612,624,636,648,666,672,728,735,777,784,816,824,848,864,888,936,999,1111,1112,1113,1115,1116,1122,1124,1128,1131,1144,1155,1164,1176,1184,1197,1212,1222,1224,1236,1244,1248,1266,1288,1296,1311,1326,1332,1335,1344,1362,1368,1395,1412,1416,1424,1444,1448,1464,1488,1515,1555,1575,1626,1632,1644,1662,1692,1715,1722,1764,1771,1824,1848,1888,1926,1935,1944,1962,2112,2122,2124,2128,2136,2144,2166,2184,2196,2212,2222,2224,2226,2232,2244,2248,2262,2288,2316,2322,2328,2364,2412,2424,2436,2444,2448,2488,2616,2622,2664,2688,2744,2772,2824,2832,2848,2888,2916,3111,3126,3132,3135,3144,3162,3168,3171,3195,3216,3222,3264,3276,3288,3312,3315,3324,3333,3336,3339,3366,3384,3393,3432,3444,3492,3555,3612,3624,3636,3648,3666,3717,3816,3864,3888,3915,3924,3933,3996,4112,4116,4124,4128,4144,4164,4172,4184,4212,4224,4236,4244,4248,4288,4332,4344,4368,4392,4412,4416,4424,4444,4448,4464,4488,4632,4644,4824,4848,4872,4888,4896,4932,4968,5115,5155,5355,5515,5535,5555,5775,6126,6132,6144,6162,6168,6192,6216,6222,6264,6288,6312,6324,6336,6366,6384,6432,6444,6612,6624,6636,6648,6666,6696,6762,6816,6864,6888,6912,6966,6984,7112,7119,7175,7224,7266,7371,7448,7476,7644,7728,7777,7784,8112,8128,8136,8144,8184,8224,8232,8248,8288,8328,8424,8448,8488,8496,8616,8664,8688,8736,8824,8832,8848,8888,8928,9126,9135,9144,9162,9216,9288,9315,9324,9333,9396,9432,9612,9648,9666,9864,9936,9999
        };
        for(int k:output){
            if(k>right)
                break;
            if(k>=left){
                list.add(k);
            }
        }
        return list;
    }
    public static boolean isDivisible(int a){
        int len=0;
        if(a<100){
            len=2;
        }else if(a<1000){
            len=3;
        }else if(a<10000){
            len=4;
        }
        int number=a;
        for(int i=0;i<len;i++){
            int t=number%10;
            if(t==0)
                return false;
            else {
                if(a%t!=0)
                    return false;
            }
            number=(number-t)/10;
        }
        return true;
    }
}
