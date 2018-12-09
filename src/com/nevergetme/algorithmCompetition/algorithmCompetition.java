package com.nevergetme.algorithmCompetition;


import com.nevergetme.algorithm.sort.MaxPQ;

import java.text.DecimalFormat;
import java.util.*;

public class algorithmCompetition {

    public static void main(String[] args) {

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
        //System.out.println(isAnagram("rat", "cat"));
//        TreeNode treeNode1=new TreeNode(1);
//        treeNode1.left=new TreeNode(2);
//        //treeNode1.right=new TreeNode(1);
//        TreeNode treeNode2=new TreeNode(1);
//        //treeNode2.left=new TreeNode(1);
//        treeNode2.right=new TreeNode(2);
//        System.out.println(isSameTree(treeNode1,treeNode2));
        //System.out.println(titleToNumber("ZY"));
        //System.out.println(addBinary("101111","10"));
        //System.out.println(generate(6));
        //System.out.println(removeElement(new int[]{4,5},5));
        //System.out.println(addStrings("9","99"));
        //System.out.println(arrangeCoins(2147483647));
//        for(int i=1;i<15;i++){
//            System.out.println(i+":"+arrangeCoins(i));
//        }
        //System.out.println(countSegments(", , , , a, eaefa"));
        //System.out.println(compress(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b','c'}));
        //System.out.println(compress(new char[]{'a','a','a','c','b','b','b','b','b','b','b','b','b','b','b','b','c','d','d'}));
        //System.out.println(hammingWeight(1));
        //System.out.println(isUgly(14));
        //System.out.println(grayCode(3));
        //System.out.println(singleNumber137(new int[]{1,1,1,2,2,2,3,4,4,4}));
        //int[] t=twoSum(new int[]{1,2,3,5,6,4},5);
        //System.out.println(t[0]+","+t[1]);
        //        //plusOne(new int[]{9,8,9});\
        //System.out.println(isPalindrome(101));
        //System.out.println(canPlaceFlowers(new int[]{1,0,0,0,1},2));
        //System.out.println(getRow(3));
        //digitalClassification();

//        for(int i=1;i<10000;i++){
//            if(isPrime(i))
//                System.out.print(i+",");
//            //System.out.print(isPrime(i)+",");
//        }
        //outputPrimeRange();"nzp#o#g"
        //"b#nzp#o#g"
        //System.out.println(backspaceCompare("nzp#o#g","b#nzp#o#g"));
        //System.out.println(longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}));
        //System.out.println(toHex(-1));
        //System.out.println(convertToBase7(-7));
        //System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        TreeNode t1=new TreeNode(4);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(1);
        TreeNode t4=new TreeNode(3);
        TreeNode t5=new TreeNode(6);
        t1.left=t2;
        t1.right=t5;
        t2.left=t3;
        t2.right=t4;
        System.out.println(new algorithmCompetition().sumOfLeftLeaves(t1));
//        System.out.println(minDiffInBST(t1));
        //System.out.println(canConstruct("aa", "aab"));
        //floodFill(new int[][]{{0, 0, 0}, {0, 1, 1}}, 1, 1, 1);


        //System.out.println(isLongPressedName("pyplrz","ppyypllr"));
        //System.out.println(missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
    }
//    public String countAndSay(int n) {
//        StringBuilder sb=new StringBuilder("1");
//        StringBuilder sbTemp=new StringBuilder();
//        for(int i=0;i<n-1;i++){
//            for(int j=0;j<sb.length();){
//                int count=1;
//
//            }
//        }
//    }
    public int sumOfLeftLeaves(TreeNode root) {
        int sumOfLeftLeaf=0;
        return sumOfLeftLeaves(root,sumOfLeftLeaf,false);
    }
    public int sumOfLeftLeaves(TreeNode root,int sumOfLeftLeaf,boolean isLeft) {
        if(root==null)
            return sumOfLeftLeaf;
        if(root.left==null&&root.right==null&&isLeft){
            return sumOfLeftLeaf+root.val;
        }
        if(root.left!=null){
            //sumOfLeftLeaf+=root.left.val;
            sumOfLeftLeaf=sumOfLeftLeaves(root.left,sumOfLeftLeaf,true);
        }
        if(root.right!=null){
            sumOfLeftLeaf=sumOfLeftLeaves(root.right,sumOfLeftLeaf,false);
        }
        return sumOfLeftLeaf;
    }

    public static int missingNumber(int[] nums) {
        long output=0;
        long com=nums.length*(nums.length+1)/2;
        for(int num:nums)
            output+=num;
        return (int)(com-output);
    }
    public static boolean isLongPressedName(String name, String typed) {
        if(typed.length()<name.length()){
            return false;
        }
        int nameLen=name.length();
        int typedLen=typed.length();
        int i=0,j=0;
        int nameCharLen=0,typedCharLen=0;
        while (i<nameLen&&j<typedLen){
            char n=name.charAt(i);
            nameCharLen=1;
            while(++i<nameLen){
                if(name.charAt(i)==n)
                    nameCharLen++;
                else
                    break;
            }
            char t=typed.charAt(j);
            if(t!=n)
                return false;
            typedCharLen=1;
            while(++j<typedLen){
                if(typed.charAt(j)==t){
                    typedCharLen++;
                }else{
                    break;
                }
            }
            if(typedCharLen>=nameCharLen){
                continue;
            }else{
                return false;
            }
        }
        if(j<typedLen||i<nameLen)
            return false;
        else
            return true;
    }

    int min = Integer.MAX_VALUE;
    Integer prev = null;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) return min;
        getMinimumDifference(root.left);
        if (prev != null) {
            min = Math.min(min, root.val - prev);
        }
        prev = root.val;
        getMinimumDifference(root.right);
        return min;
    }

    //    public class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//
//        TreeNode(int x) {
//            val = x;
//        }
//    }
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int currentColor = image[sr][sc];
        if (currentColor == newColor)
            return image;
        floodFill(image, sr, sc, newColor, currentColor);
        //image[sr][sc]=newColor;
        return image;
    }

    public static void floodFill(int[][] image, int sr, int sc, int newColor, int oldColor) {
        if (image[sr][sc] != oldColor)
            return;
        image[sr][sc] = newColor;
        if (sr > 0)
            floodFill(image, sr - 1, sc, newColor, oldColor);
        if (sr < image.length - 1)
            floodFill(image, sr + 1, sc, newColor, oldColor);
        if (sc > 0)
            floodFill(image, sr, sc - 1, newColor, oldColor);
        if (sc < image[0].length - 1)
            floodFill(image, sr, sc + 1, newColor, oldColor);
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        //Map<Character,Integer> map=new HashMap<>();
        if (magazine.length() < ransomNote.length())
            return false;
        char[] m = magazine.toCharArray();
        char[] r = ransomNote.toCharArray();
        int[] sum = new int[26];
        for (char c : m) {
            sum[c - 'a']++;
        }
        for (char c : r) {
            if (sum[c - 'a'] == 0)
                return false;
            else
                sum[c - 'a']--;
        }
        return true;

    }

    ///[90,69,null,49,89,null,52,null,null,null,null]
    public static int minDiffInBST(TreeNode root) {
        int minDistance = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();
        minDiffInBST(root, list);
        Collections.sort(list);
        for (int i = 0; i < list.size() - 1; i++) {
            minDistance = Math.min(minDistance, list.get(i + 1) - list.get(i));
        }
        return minDistance;
        //list.sort();
        //Arrays.sort(list);
    }

    public static void minDiffInBST(TreeNode root, List<Integer> list) {
        if (root.left != null) {
            minDiffInBST(root.left, list);
            //list.add(root.left)
        }
        list.add(root.val);
        if (root.right != null) minDiffInBST(root.right, list);
//        if (minDistance == 1)
//            return minDistance;
//        if (root.left != null) {
//            minDistance = Math.min(minDistance, Math.abs(root.val - root.left.val));
//            if (minDistance == 1)
//                return minDistance;
//            minDistance=minDiffInBST(root.left,minDistance);
//        }
//        if (minDistance == 1)
//            return minDistance;
//        if (root.right != null) {
//            minDistance = Math.min(minDistance, Math.abs(root.val - root.right.val));
//            if (minDistance == 1)
//                return minDistance;
//            minDistance=minDiffInBST(root.right,minDistance);
//        }
//        return minDistance;
    }

    public static int maxProfit(int[] prices) {
        int profit = 0;
        int per = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            per = prices[i + 1] - prices[i];
            if (per > 0)
                profit += per;
        }
        return profit;
    }

    public static String convertToBase7(int num) {
        if (num == 0)
            return "0";
        StringBuffer sb = new StringBuffer();
        boolean isNegative = false;
        if (num < 0) {
            isNegative = true;
            num = (-num);
        }
        while (num != 0) {
            sb.append(num % 7);
            num = num / 7;
        }
        if (isNegative)
            sb.append("-");
        return sb.reverse().toString();
    }

    public static boolean isPowerOfFour(int num) {
        return (Integer.bitCount(num) == 1 && Integer.bitCount(num - 1) % 2 == 0);
    }

    public static int[] findErrorNums(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int duplicate = 0, n = nums.length;
        long sum = (n * (n + 1)) / 2;
        for (int i : nums) {
            if (set.contains(i)) duplicate = i;
            sum -= i;
            set.add(i);
        }
        return new int[]{duplicate, (int) sum + duplicate};
    }

    static char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String toHex(int num) {
        if (num == 0) return "0";
        String output = "";
        while (num != 0) {
            output = map[num & 15] + output;
            num = num >>> 4;
        }
        return output;
    }

    public static String longestWord(String[] words) {
        Arrays.sort(words);
        return "";
    }

    public static boolean backspaceCompare(String S, String T) {
        int SLen = S.length() - 1;
        int TLen = T.length() - 1;
        int sC = 0, tC = 0;
        while (SLen >= 0 && TLen >= 0) {
            while (true) {
                if (S.charAt(SLen) == '#') {
                    sC++;
                } else {
                    sC--;
                }
                if (sC == -1) {
                    sC = 0;
                    break;
                }
                SLen--;
                if (SLen < 0)
                    break;
            }
            while (true) {
                if (T.charAt(TLen) == '#') {
                    tC++;
                } else {
                    tC--;
                }
                if (tC == -1) {
                    tC = 0;
                    break;
                }
                TLen--;
                if (TLen < 0)
                    break;
            }

            if (TLen < 0 && SLen < 0)
                return true;
            else if (TLen < 0 || SLen < 0) {
                return false;
            } else {
                if (S.charAt(SLen) != T.charAt(TLen))
                    return false;
                else {
                    TLen--;
                    SLen--;
                }
            }
        }
        if (SLen >= 0) {
            return isEmptyString(S, SLen);
        }
        if (TLen >= 0) {
            return isEmptyString(T, TLen);
        }
        return true;
    }

    public static boolean isEmptyString(String S, int endIndex) {
        int x = 0;
        for (; endIndex >= 0; endIndex--) {
            if (S.charAt(endIndex) == '#') {
                x++;
            } else {
                x--;
            }
            if (x < 0)
                return false;
        }
        return true;
    }

    public static void outputPrimeRange() {
        //int[] primes = new int[]{1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997, 1009, 1013, 1019, 1021, 1031, 1033, 1039, 1049, 1051, 1061, 1063, 1069, 1087, 1091, 1093, 1097, 1103, 1109, 1117, 1123, 1129, 1151, 1153, 1163, 1171, 1181, 1187, 1193, 1201, 1213, 1217, 1223, 1229, 1231, 1237, 1249, 1259, 1277, 1279, 1283, 1289, 1291, 1297, 1301, 1303, 1307, 1319, 1321, 1327, 1361, 1367, 1373, 1381, 1399, 1409, 1423, 1427, 1429, 1433, 1439, 1447, 1451, 1453, 1459, 1471, 1481, 1483, 1487, 1489, 1493, 1499, 1511, 1523, 1531, 1543, 1549, 1553, 1559, 1567, 1571, 1579, 1583, 1597, 1601, 1607, 1609, 1613, 1619, 1621, 1627, 1637, 1657, 1663, 1667, 1669, 1693, 1697, 1699, 1709, 1721, 1723, 1733, 1741, 1747, 1753, 1759, 1777, 1783, 1787, 1789, 1801, 1811, 1823, 1831, 1847, 1861, 1867, 1871, 1873, 1877, 1879, 1889, 1901, 1907, 1913, 1931, 1933, 1949, 1951, 1973, 1979, 1987, 1993, 1997, 1999, 2003, 2011, 2017, 2027, 2029, 2039, 2053, 2063, 2069, 2081, 2083, 2087, 2089, 2099, 2111, 2113, 2129, 2131, 2137, 2141, 2143, 2153, 2161, 2179, 2203, 2207, 2213, 2221, 2237, 2239, 2243, 2251, 2267, 2269, 2273, 2281, 2287, 2293, 2297, 2309, 2311, 2333, 2339, 2341, 2347, 2351, 2357, 2371, 2377, 2381, 2383, 2389, 2393, 2399, 2411, 2417, 2423, 2437, 2441, 2447, 2459, 2467, 2473, 2477, 2503, 2521, 2531, 2539, 2543, 2549, 2551, 2557, 2579, 2591, 2593, 2609, 2617, 2621, 2633, 2647, 2657, 2659, 2663, 2671, 2677, 2683, 2687, 2689, 2693, 2699, 2707, 2711, 2713, 2719, 2729, 2731, 2741, 2749, 2753, 2767, 2777, 2789, 2791, 2797, 2801, 2803, 2819, 2833, 2837, 2843, 2851, 2857, 2861, 2879, 2887, 2897, 2903, 2909, 2917, 2927, 2939, 2953, 2957, 2963, 2969, 2971, 2999, 3001, 3011, 3019, 3023, 3037, 3041, 3049, 3061, 3067, 3079, 3083, 3089, 3109, 3119, 3121, 3137, 3163, 3167, 3169, 3181, 3187, 3191, 3203, 3209, 3217, 3221, 3229, 3251, 3253, 3257, 3259, 3271, 3299, 3301, 3307, 3313, 3319, 3323, 3329, 3331, 3343, 3347, 3359, 3361, 3371, 3373, 3389, 3391, 3407, 3413, 3433, 3449, 3457, 3461, 3463, 3467, 3469, 3491, 3499, 3511, 3517, 3527, 3529, 3533, 3539, 3541, 3547, 3557, 3559, 3571, 3581, 3583, 3593, 3607, 3613, 3617, 3623, 3631, 3637, 3643, 3659, 3671, 3673, 3677, 3691, 3697, 3701, 3709, 3719, 3727, 3733, 3739, 3761, 3767, 3769, 3779, 3793, 3797, 3803, 3821, 3823, 3833, 3847, 3851, 3853, 3863, 3877, 3881, 3889, 3907, 3911, 3917, 3919, 3923, 3929, 3931, 3943, 3947, 3967, 3989, 4001, 4003, 4007, 4013, 4019, 4021, 4027, 4049, 4051, 4057, 4073, 4079, 4091, 4093, 4099, 4111, 4127, 4129, 4133, 4139, 4153, 4157, 4159, 4177, 4201, 4211, 4217, 4219, 4229, 4231, 4241, 4243, 4253, 4259, 4261, 4271, 4273, 4283, 4289, 4297, 4327, 4337, 4339, 4349, 4357, 4363, 4373, 4391, 4397, 4409, 4421, 4423, 4441, 4447, 4451, 4457, 4463, 4481, 4483, 4493, 4507, 4513, 4517, 4519, 4523, 4547, 4549, 4561, 4567, 4583, 4591, 4597, 4603, 4621, 4637, 4639, 4643, 4649, 4651, 4657, 4663, 4673, 4679, 4691, 4703, 4721, 4723, 4729, 4733, 4751, 4759, 4783, 4787, 4789, 4793, 4799, 4801, 4813, 4817, 4831, 4861, 4871, 4877, 4889, 4903, 4909, 4919, 4931, 4933, 4937, 4943, 4951, 4957, 4967, 4969, 4973, 4987, 4993, 4999, 5003, 5009, 5011, 5021, 5023, 5039, 5051, 5059, 5077, 5081, 5087, 5099, 5101, 5107, 5113, 5119, 5147, 5153, 5167, 5171, 5179, 5189, 5197, 5209, 5227, 5231, 5233, 5237, 5261, 5273, 5279, 5281, 5297, 5303, 5309, 5323, 5333, 5347, 5351, 5381, 5387, 5393, 5399, 5407, 5413, 5417, 5419, 5431, 5437, 5441, 5443, 5449, 5471, 5477, 5479, 5483, 5501, 5503, 5507, 5519, 5521, 5527, 5531, 5557, 5563, 5569, 5573, 5581, 5591, 5623, 5639, 5641, 5647, 5651, 5653, 5657, 5659, 5669, 5683, 5689, 5693, 5701, 5711, 5717, 5737, 5741, 5743, 5749, 5779, 5783, 5791, 5801, 5807, 5813, 5821, 5827, 5839, 5843, 5849, 5851, 5857, 5861, 5867, 5869, 5879, 5881, 5897, 5903, 5923, 5927, 5939, 5953, 5981, 5987, 6007, 6011, 6029, 6037, 6043, 6047, 6053, 6067, 6073, 6079, 6089, 6091, 6101, 6113, 6121, 6131, 6133, 6143, 6151, 6163, 6173, 6197, 6199, 6203, 6211, 6217, 6221, 6229, 6247, 6257, 6263, 6269, 6271, 6277, 6287, 6299, 6301, 6311, 6317, 6323, 6329, 6337, 6343, 6353, 6359, 6361, 6367, 6373, 6379, 6389, 6397, 6421, 6427, 6449, 6451, 6469, 6473, 6481, 6491, 6521, 6529, 6547, 6551, 6553, 6563, 6569, 6571, 6577, 6581, 6599, 6607, 6619, 6637, 6653, 6659, 6661, 6673, 6679, 6689, 6691, 6701, 6703, 6709, 6719, 6733, 6737, 6761, 6763, 6779, 6781, 6791, 6793, 6803, 6823, 6827, 6829, 6833, 6841, 6857, 6863, 6869, 6871, 6883, 6899, 6907, 6911, 6917, 6947, 6949, 6959, 6961, 6967, 6971, 6977, 6983, 6991, 6997, 7001, 7013, 7019, 7027, 7039, 7043, 7057, 7069, 7079, 7103, 7109, 7121, 7127, 7129, 7151, 7159, 7177, 7187, 7193, 7207, 7211, 7213, 7219, 7229, 7237, 7243, 7247, 7253, 7283, 7297, 7307, 7309, 7321, 7331, 7333, 7349, 7351, 7369, 7393, 7411, 7417, 7433, 7451, 7457, 7459, 7477, 7481, 7487, 7489, 7499, 7507, 7517, 7523, 7529, 7537, 7541, 7547, 7549, 7559, 7561, 7573, 7577, 7583, 7589, 7591, 7603, 7607, 7621, 7639, 7643, 7649, 7669, 7673, 7681, 7687, 7691, 7699, 7703, 7717, 7723, 7727, 7741, 7753, 7757, 7759, 7789, 7793, 7817, 7823, 7829, 7841, 7853, 7867, 7873, 7877, 7879, 7883, 7901, 7907, 7919, 7927, 7933, 7937, 7949, 7951, 7963, 7993, 8009, 8011, 8017, 8039, 8053, 8059, 8069, 8081, 8087, 8089, 8093, 8101, 8111, 8117, 8123, 8147, 8161, 8167, 8171, 8179, 8191, 8209, 8219, 8221, 8231, 8233, 8237, 8243, 8263, 8269, 8273, 8287, 8291, 8293, 8297, 8311, 8317, 8329, 8353, 8363, 8369, 8377, 8387, 8389, 8419, 8423, 8429, 8431, 8443, 8447, 8461, 8467, 8501, 8513, 8521, 8527, 8537, 8539, 8543, 8563, 8573, 8581, 8597, 8599, 8609, 8623, 8627, 8629, 8641, 8647, 8663, 8669, 8677, 8681, 8689, 8693, 8699, 8707, 8713, 8719, 8731, 8737, 8741, 8747, 8753, 8761, 8779, 8783, 8803, 8807, 8819, 8821, 8831, 8837, 8839, 8849, 8861, 8863, 8867, 8887, 8893, 8923, 8929, 8933, 8941, 8951, 8963, 8969, 8971, 8999, 9001, 9007, 9011, 9013, 9029, 9041, 9043, 9049, 9059, 9067, 9091, 9103, 9109, 9127, 9133, 9137, 9151, 9157, 9161, 9173, 9181, 9187, 9199, 9203, 9209, 9221, 9227, 9239, 9241, 9257, 9277, 9281, 9283, 9293, 9311, 9319, 9323, 9337, 9341, 9343, 9349, 9371, 9377, 9391, 9397, 9403, 9413, 9419, 9421, 9431, 9433, 9437, 9439, 9461, 9463, 9467, 9473, 9479, 9491, 9497, 9511, 9521, 9533, 9539, 9547, 9551, 9587, 9601, 9613, 9619, 9623, 9629, 9631, 9643, 9649, 9661, 9677, 9679, 9689, 9697, 9719, 9721, 9733, 9739, 9743, 9749, 9767, 9769, 9781, 9787, 9791, 9803, 9811, 9817, 9829, 9833, 9839, 9851, 9857, 9859, 9871, 9883, 9887, 9901, 9907, 9923, 9929, 9931, 9941, 9949, 9967, 9973};
        Scanner sc = new Scanner(System.in);
        int from = sc.nextInt();
        int to = sc.nextInt();
        int number = 0;
        int count = 0;
        boolean first = false;
        for (int i = 2; ; i++) {
            if (isPrime(i)) {
                count++;
                if (count < from)
                    continue;
                if (count > to)
                    break;
                if (first) {
                    if (number % 10 == 0)
                        System.out.println();
                    else
                        System.out.print(" ");
                } else {
                    first = true;
                }
                System.out.print(i);
                number++;
            }
        }

//        for(int prime:primes){
//            if(prime<from)
//                continue;
//            if(prime>to)
//                break;
//            if(first){
//                if(number%10==0)
//                    System.out.println();
//                else
//                    System.out.print(" ");
//            }else {
//                first=true;
//            }
//            System.out.print(prime);
//            number++;
//        }

    }

    public static void digitalClassification() {
        Scanner sc = new Scanner(System.in);
        int[] number = new int[5];
        double A4 = 0;
        boolean flag = true;
        int counts = sc.nextInt();
        for (int i = 0; i < counts; i++) {
            int k = sc.nextInt();
            if (k % 10 == 0) {
                number[0] += k;
            }
            if (k % 5 == 1) {
                if (flag) {
                    number[1] += k;
                    flag = !flag;
                } else {
                    number[1] -= k;
                    flag = !flag;
                }
            } else if (k % 5 == 2) {
                number[2]++;
            } else if (k % 5 == 3) {
                number[3]++;
                A4 += k;
            } else if (k % 5 == 4) {
                if (number[4] < k)
                    number[4] = k;
            }
        }
        if (number[0] == 0) {
            System.out.print("N ");
        } else {
            System.out.print(number[0] + " ");
        }
        if (number[1] == 0) {
            System.out.print("N ");
        } else {
            System.out.print(number[1] + " ");
        }
        if (number[2] == 0) {
            System.out.print("N ");
        } else {
            System.out.print(number[2] + " ");
        }
        if (number[3] == 0) {
            System.out.print("N ");
        } else {
            System.out.print(String.format("%.1f ", A4 / number[3]));
        }
        if (number[4] == 0) {
            System.out.println("N");
        } else {
            System.out.println(number[4] + " ");
        }
        //System.out.println();
    }

    public static boolean isPrime(int k) {
        if (k <= 0) return false;
        if (k <= 2) return true;
        for (int i = 2; i < Math.sqrt(k) + 1; i++) {
            if (k % i == 0)
                return false;
        }
        return true;
    }

    public static void singleDigitStatistics() {
        Scanner sc = new Scanner(System.in);
        int[] number = new int[10];
        String output = null;
        //while(sc.hasNext()){
        output = sc.nextLine();
        char[] c = output.toCharArray();
        for (char cc : c) {
            number[Character.getNumericValue(cc)]++;
        }
        //}
        for (int i = 0; i < number.length; i++) {
            if (number[i] != 0) {
                System.out.println(i + ":" + number[i]);
            }
        }
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        int[] pascal = new int[rowIndex + 1];

        if (rowIndex == 0) {
            list.add(1);
            return list;
        }
        if (rowIndex == 1) {
            list.add(1);
            list.add(1);
            return list;
        }
        pascal[0] = 1;
        pascal[1] = 1;
        int currentLen = 2;
        for (int i = 2; i < rowIndex + 1; i++) {
            for (int j = 1; j < i; j++) {
                pascal[j] = pascal[j - 1] + pascal[j];
            }
            pascal[i] = 1;
        }
        for (int k : pascal) {
            list.add(k);
        }
        return list;
    }

    public static boolean isPowerOfTwo(int n) {
        if (n <= 0)
            return false;
        if (n == 1)
            return true;
        if (n % 2 == 1) {
            return false;
        } else {
            return isPowerOfTwo(n / 2);
        }
    }

    public static int maxSubArray(int[] A) {
//        Kadane’s Algorithm:
//        Initialize:
//        max_so_far = 0
//        max_ending_here = 0
//
//        Loop for each element of the array
//        (a) max_ending_here = max_ending_here + a[i]
//        (b) if(max_ending_here < 0)
//            max_ending_here = 0
//        (c) if(max_so_far < max_ending_here)
//            max_so_far = max_ending_here
//        return max_so_far
        int maxSoFar = A[0], maxEndingHere = A[0];
        for (int i = 1; i < A.length; ++i) {
            maxEndingHere = Math.max(maxEndingHere + A[i], A[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    public static void question3_7(String[] dna) {
        String outputS = "";
        for (int i = 0; i < dna[0].length(); i++) {
            int[] count = new int[4];
            for (String t : dna) {
                switch (t.charAt(i)) {
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
            int k = 0;
            int maxM = 0;
            for (int j = 0; j < 4; j++) {
                if (count[j] > maxM) {
                    maxM = count[j];
                    k = j;
                }
            }
            if (k == 0) {
                outputS += "A";
            } else if (k == 1) {
                outputS += "C";
            } else if (k == 2) {
                outputS += "G";
            } else {
                outputS += "T";
            }
        }
        System.out.println(outputS);
    }

    public static void question3_5(char[][] in, String order) {
        int row = 0, col = 0;
        for (int i = 0; i < 5; i++) {
            boolean finish = false;
            for (int j = 0; j < 5; j++) {
                if (in[i][j] == '0') {
                    row = i;
                    col = j;
                    finish = true;
                    break;
                }
            }
            if (finish)
                break;
        }
        for (int i = 0; i < order.length(); i++) {
            if (order.charAt(i) == '0') {
                break;
            }
            switch (order.charAt(i)) {
                case 'A':
                    if (row == 0) {
                        System.out.println("This puzzle has no final configuration");
                        return;
                    }
                    in[row][col] = in[row - 1][col];
                    in[row - 1][col] = '0';
                    row--;
                    break;
                case 'B':
                    if (row == 4) {
                        System.out.println("This puzzle has no final configuration");
                        return;
                    }
                    in[row][col] = in[row + 1][col];
                    in[row + 1][col] = '0';
                    row++;
                    break;
                case 'L':
                    if (col == 0) {
                        System.out.println("This puzzle has no final configuration");
                        return;
                    }
                    in[row][col] = in[row][col - 1];
                    in[row][col - 1] = '0';
                    col--;
                    break;
                case 'R':
                    if (col == 4) {
                        System.out.println("This puzzle has no final configuration");
                        return;
                    }
                    in[row][col] = in[row][col + 1];
                    in[row][col + 1] = '0';
                    col++;
                    break;
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(in[i][j]);
            }
            System.out.println();
        }
    }

    public static Set<Integer> happySet = new HashSet<>();

    public static boolean isHappy(int n) {
        char[] output = Integer.toString(n).toCharArray();
        int result = 0;
        for (char out : output) {
            result += Character.getNumericValue(out) * Character.getNumericValue(out);
        }
        if (result == 1)
            return true;
        else if (happySet.contains(result))
            return false;
        else
            happySet.add(result);
        return isHappy(result);
    }

    public static char findTheDifference(String s, String t) {

        char[] sN = s.toCharArray();
        char[] tN = t.toCharArray();
        int sum = 0;
        for (char ts : tN) {
            sum += ts;
        }
        for (char ss : sN) {
            sum -= ss;
        }
        return (char) sum;
//        HashMap<Character,Integer> map=new HashMap<>();
//        for(char ts:tN){
//            if(map.containsKey(ts))
//                map.put(ts,map.get(ts)+1);
//            else
//                map.put(ts,1);
//            //map.put(ts,0);
//        }
//        for(char ss:sN){
//            map.put(ss,map.get(ss)-1);
//        }
//        Iterator<Character> it=map.keySet().iterator();
//        while (it.hasNext()){
//            char k=it.next();
//            if(map.get(k)==1){
//                return k;
//            }
//        }
//        return '0';
        //return map.keySet()
    }

    public static int distributeCandies(int[] candies) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = candies.length;
        int number = 0;
        int count = len / 2;
        for (int i = 0; i < len; i++) {
            if (!map.containsKey(candies[i])) {
                map.put(candies[i], 1);
                number++;
                if (number >= count)
                    break;
                ;
            }
        }
        return number;
    }

    public static boolean isCharOrDigiter(char c) {
        if ((c <= '9' && c >= '0') || (c <= 'z' && c >= 'a')) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isPalindrome(String s) {
        char[] output = s.toLowerCase().toCharArray();
        int begin = 0, end = output.length - 1;
        while (begin < end) {
            while (begin < end && (!isCharOrDigiter(output[begin]))) {
                begin++;
            }
            while (begin < end && (!isCharOrDigiter(output[end]))) {
                end--;
            }
            if (begin >= end) {
                break;
            }
            if (output[begin++] != output[end--]) {
                return false;
            }
        }
        return true;
    }

    public static int reachNumber(int target) {
        target = Math.abs(target);
        int sqrt = (int) Math.sqrt(2 * target);
        if (sqrt * (sqrt + 1) < 2 * target) sqrt++;
        if (target % 2 == 0) {
            while (sqrt % 4 != 0 && (sqrt + 1) % 4 != 0) sqrt++;
        } else {
            while (sqrt % 4 == 0 || (sqrt + 1) % 4 == 0) sqrt++;
        }
        return sqrt;
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length == 1) {
            if (flowerbed[0] == 1 && n == 1) {
                return false;
            } else {
                return true;
            }
        }
        if (flowerbed.length == 2) {
            if (flowerbed[0] + flowerbed[1] + n > 1)
                return false;
            else
                return true;
        }
        if (flowerbed[1] == 0 && flowerbed[0] == 0) {
            n--;
            flowerbed[0] = 1;
        }
        if (flowerbed[flowerbed.length - 1] == 0 && flowerbed[flowerbed.length - 2] == 0) {
            n--;
            flowerbed[flowerbed.length - 1] = 1;
        }
        if (n <= 0)
            return true;
        for (int i = 1; i < flowerbed.length - 1; ) {
            if (flowerbed[i] == 0) {
                if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                    if (n <= 0)
                        return true;
                    i += 2;
                } else {
                    i++;
                }
            } else {
                i += 2;
            }
        }
        if (n > 0)
            return false;
        else
            return true;
    }

    public static boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        if (x < 10) {
            return true;
        }
        String output = Integer.toString(x);
        int begin = 0;
        int end = output.length() - 1;
        while (begin < end) {
            if (output.charAt(begin++) != output.charAt(end--))
                return false;
        }
        return true;
//        if(output.equals(new StringBuffer(output).reverse().toString())){
//            return true;
//        }else{
//            return false;
//        }
    }

    public static int[] plusOne(int[] digits) {
        int shift = 1;
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9 && shift == 1) {
                shift = 1;
                list.add(0);
            } else if (shift == 1) {
                shift = 0;
                list.add(digits[i] + 1);
            } else {
                list.add(digits[i]);
            }
        }
        if (shift == 1) {
            list.add(1);
        }
        int[] output = new int[list.size()];
        int size = list.size() - 1;
        for (int i = list.size() - 1; i >= 0; i--) {
            output[size - i] = list.get(i);
        }
        return output;
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            } else {
                map.put(target - nums[i], i);
            }
        }
        return null;
    }

    public static int singleNumber137(int[] nums) {
        int ones = 0, twos = 0;
        for (int i = 0; i < nums.length; i++) {
            ones = (ones ^ nums[i]) & ~twos;
            twos = (twos ^ nums[i]) & ~ones;
        }
        return ones;
//        int ans=0;
//        for(int i=0;i<32;i++){
//            int sum=0;
//            for(int j=0;j<nums.length;j++){
//                if(((nums[j]>>i)&1)==1){
//                    sum++;
//                    sum=sum%3;
//                }
//            }
//            if(sum!=0){
//                ans|=sum<<i;
//            }
//        }
//        return ans;
    }

    public static List<Integer> grayCode(int n) {
        List<Integer> output = new ArrayList<>();
        if (n == 0) {
            output.add(0);
            return output;
        }
        output.add(0);
        output.add(1);
        if (n == 1)
            return output;
        int shift = 2;
        for (int i = 1; i < n; i++) {
            for (int j = output.size() - 1; j >= 0; j--) {
                output.add(shift + output.get(j));
            }
            shift <<= 1;
        }
        return output;
    }

    public static boolean isUgly(int num) {
        if (num == 1) {
            return true;
        }
        if (num < 1) {
            return false;
        }
        while (num != 1) {
            if (num % 2 == 0) {
                num = num / 2;
            } else if (num % 3 == 0) {
                num = num / 3;
            } else if (num % 5 == 0) {
                num = num / 5;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean isPowerOfThree(int n) {
        return (n > 0 && 1162261467 % n == 0);
    }

    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
        //return Integer.bitCount(n);
//        int output=0;
//        while(n!=0){
//            output+=n&1;
//            n=n>>1;
//        }
//        return output;
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow)
                return true;
        }
        return false;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static int compress(char[] chars) {
        if (chars.length == 1) {
            return 1;
        }
        char[] temp = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        int number = 1;
        int j = 1;
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                number++;
            } else {
                //chars[j++]=chars[i+1];
                if (number != 1) {
                    if (number >= 1000) {
                        chars[j++] = '1';
                        number = number % 1000;
                    }
                    if (number >= 100) {
                        chars[j++] = temp[number / 100];
                        number %= 100;
                    }
                    if (number >= 10) {
                        chars[j++] = temp[number / 10];
                        number %= 10;
                    }
                    chars[j++] = temp[number];
                }
                chars[j++] = chars[i + 1];
                number = 1;
                //j=i+1;
            }
        }
        if (number != 1) {
            if (number >= 1000) {
                chars[j++] = '1';
                number = number % 1000;
            }
            if (number >= 100) {
                chars[j++] = temp[number / 100];
                number %= 100;
            }
            if (number >= 10) {
                chars[j++] = temp[number / 10];
                number %= 10;
            }
            chars[j++] = temp[number];
        }
        return j;
    }

    public static int countSegments(String s) {
        if (s == null || s.length() == 0)
            return 0;
        return s.split(" ").length;
//        if(s==null||s.length()==0){
//            return 0;
//        }
//        boolean flag=false;
//        int output=0;
//        int maxLen=0;
//        int count=0;
//        for(int i=0;i<s.length();i++){
//            if(flag){
//                if(Character.isLetter(s.charAt(i)))
//                    count++;
//                else{
//                   flag=false;
//                    output++;
//                   //maxLen=maxLen<count?count:maxLen;
//                   count=0;
//                }
//            }else{
//                if(Character.isLetter(s.charAt(i))){
//                    count++;
//                    flag=true;
//                }
//            }
//        }
//        if(count!=0){
//            output++;
//        }
//        //maxLen=maxLen<count?count:maxLen;
//        return output;
    }

    public static int arrangeCoins(int n) {
        double x = Math.sqrt(2 * (double) n + 0.25) - 0.5;
        return (int) x;
//        if(n==0)
//            return 0;
//        if(n==1){
//            return 1;
//        }
//        long i=1,sum=0;
//        while (true){
//            sum+=i;
//            if(sum>n){
//                return (int)(i-1);
//            }
//            i++;

    }

    public static String addStrings(String num1, String num2) {
        if (num1.length() < num2.length())
            return addStrings(num2, num1);
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;
        int carryBit = 0;
        //List<Integer> list=new ArrayList<>();
        StringBuffer buffer = new StringBuffer();
        while (len2 >= 0) {
            int sum = num1.charAt(len1--) + num2.charAt(len2--) - 96 + carryBit;
            if (sum > 9) {
                carryBit = 1;
                sum = sum - 10;
            } else {
                carryBit = 0;
            }
            buffer.append(sum);
            //list.add(sum);
            //System.out.println(sum);
        }
        for (int i = len1; i >= 0; i--) {
            int sum = num1.charAt(i) + carryBit - 48;
            if (sum > 9) {
                carryBit = 1;
                sum = sum - 10;
            } else {
                carryBit = 0;
            }
            buffer.append(sum);
            //list.add(sum);
        }
        if (carryBit == 1) {
            buffer.append(1);
        }


        return buffer.reverse().toString();
        //return String.valueOf(Integer.MAX_VALUE);
        //return String.valueOf(Integer.parseInt(num1)+Integer.parseInt(num2));
    }

    public static int removeElement(int[] nums, int val) {
        //题目没有要求后几个数为val，因此可以覆盖
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;

//        int i=0,j=nums.length-1;
//        int output=0;
//        if(nums==null)
//            return 0;
//        if(nums.length==1){
//            if(nums[0]==val)
//                return 0;
//            else
//                return 1;
//        }
//        while(i<j){
//            while(i<j){
//                if(nums[i]==val){
//                    output++;
//                    break;
//                }
//                i++;
//            }
//            while (i<j){
//                if(nums[j]!=val){
//                    break;
//                }
//                if(nums[j]==val){
//                    output++;
//                }
//                j--;
//            }
//            if(i<j){
//                int temp=nums[i];
//                nums[i]=nums[j];
//                nums[j]=temp;
//            }
//            i++;
//            j--;
//        }
//        return nums.length-output;
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> output = new ArrayList<>();
        if (numRows == 0) {
            return output;
        }
        List<Integer> line1 = new ArrayList<>();
        line1.add(1);
        output.add(line1);
        if (numRows == 1)
            return output;
        List<Integer> line2 = new ArrayList<>();
        line2.add(1);
        line2.add(1);
        output.add(line2);
        if (numRows == 2)
            return output;
        for (int i = 2; i < numRows; i++) {
            List<Integer> line3 = output.get(i - 1);
            List<Integer> line = new ArrayList<>();
            line.add(1);
            for (int j = 0; j < line3.size() - 1; j++) {
                line.add(line3.get(j) + line3.get(j + 1));
            }
            line.add(1);
            output.add(line);
        }
        return output;
    }

    public static String addBinary(String a, String b) {
        List<String> list = new ArrayList<>();
        int i = a.length() - 1, j = b.length() - 1;
        char carryBit = '0';
        for (; i >= 0 && j >= 0; ) {
            switch (a.charAt(i--) + b.charAt(j--) + carryBit) {
                case 144:
                    list.add("0");
                    carryBit = '0';
                    break;
                case 145:
                    list.add("1");
                    carryBit = '0';
                    break;
                case 146:
                    list.add("0");
                    carryBit = '1';
                    break;
                case 147:
                    list.add("1");
                    carryBit = '1';
                    break;
            }
        }
        if (i < 0 && j >= 0) {
            for (; j >= 0; j--) {
                switch (b.charAt(j) + carryBit) {
                    case 96:
                        list.add("0");
                        carryBit = '0';
                        break;
                    case 97:
                        list.add("1");
                        carryBit = '0';
                        break;
                    case 98:
                        list.add("0");
                        carryBit = '1';
                }
            }
        }
        if (j < 0 && i >= 0) {
            for (; i >= 0; i--) {
                switch (a.charAt(i) + carryBit) {
                    case 96:
                        list.add("0");
                        carryBit = '0';
                        break;
                    case 97:
                        list.add("1");
                        carryBit = '0';
                        break;
                    case 98:
                        list.add("0");
                        carryBit = '1';
                }
            }
        }
        if (carryBit == '1')
            list.add("1");
        StringBuffer stringBuffer = new StringBuffer();
        for (int k = list.size() - 1; k >= 0; k--) {
            stringBuffer.append(list.get(k));
        }
        return stringBuffer.toString();
    }

    public static int titleToNumber(String s) {
        int len = s.length();
        int output = 0;
        for (char c : s.toCharArray()) {
            output = output * 26 + (c - 'A' + 1);
        }

//        for(int i=0;i<s.length();i++){
//            int shift=1;
//            for(int j=1;j<len-i;j++){
//                shift*=26;
//            }
//            output+=shift*(s.charAt(i)-'A'+1);
//        }
        return output;
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null) {
            return false;
        }
        if (p.val == q.val) {
            if (!isTheSameLeaf(p.left, q.left)) {
                return false;
            }
            if (!isTheSameLeaf(p.right, q.right))
                return false;
            return true;
        } else {
            return false;
        }
    }

    public static boolean isTheSameLeaf(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val)
            return false;
        if (!isTheSameLeaf(p.left, q.left))
            return false;
        if (!isTheSameLeaf(p.right, q.right)) {
            return false;
        }
        return true;
    }

    public static String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        if (t.left == null && t.right == null)
            return String.valueOf(t.val);
        String output = String.valueOf(t.val);
        if (t.left != null) {
            output += "(" + visitSubTree(t.left) + ")";
        } else {
            output += "()";
        }
        if (t.right != null) {
            output += "(" + visitSubTree(t.right) + ")";
        }
        return output;
    }

    public static String visitSubTree(TreeNode t) {
        if (t.left == null && t.right == null) {
            return String.valueOf(t.val);
        }
        String output = String.valueOf(t.val);
        if (t.left != null) {
            output += "(" + visitSubTree(t.left) + ")";
        } else {
            output += "()";
        }
        if (t.right != null) {
            output += "(" + visitSubTree(t.right) + ")";
        }
        return output;

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);
            if (!map.containsKey(key)) map.put(key, new ArrayList<String>());
            map.get(key).add(str);
        }
        return new ArrayList<List<String>>(map.values());
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] output = new int[26];
        for (int i = 0; i < s.length(); i++) {
            output[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            output[t.charAt(i) - 'a']--;
        }
        for (int k : output) {
            if (k != 0)
                return false;
        }
        return true;
    }

    public static boolean lemonadeChange(int[] bills) {
        int[] output = new int[2];
        for (int bill : bills) {
            if (bill == 5) {
                output[0]++;
            } else if (bill == 10) {
                if (output[0] <= 0) {
                    return false;
                } else {
                    output[0]--;
                    output[1]++;
                }
            } else {
                if (output[0] <= 0) {
                    return false;
                }
                if (output[1] <= 0) {
                    if (output[0] <= 2) {
                        return false;
                    } else {
                        output[0] -= 3;
                    }
                } else {
                    output[0]--;
                    output[1]--;
                }
            }
        }
        return true;
    }

    public static int romanToInt(String s) {
        int output = 0;
        int len = s.length();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == 'M') {
                output += 1000;
            } else if (cur == 'D') {
                output += 500;
            } else if (cur == 'C') {
                if (i + 1 < len) {
                    if (s.charAt(i + 1) == 'D') {
                        output += 400;
                        i++;
                    } else if (s.charAt(i + 1) == 'M') {
                        output += 900;
                        i++;
                    } else {
                        output += 100;
                    }
                } else {
                    output += 100;
                }
            } else if (cur == 'L') {
                output += 50;
            } else if (cur == 'X') {
                if (i + 1 < len) {
                    if (s.charAt(i + 1) == 'L') {
                        output += 40;
                        i++;
                    } else if (s.charAt(i + 1) == 'C') {
                        output += 90;
                        i++;
                    } else {
                        output += 10;
                    }
                } else {
                    output += 10;
                }
            } else if (cur == 'V') {
                output += 5;
            } else if (cur == 'I') {
                if (i + 1 < len) {
                    if (s.charAt(i + 1) == 'V') {
                        output += 4;
                        i++;
                    } else if (s.charAt(i + 1) == 'X') {
                        output += 9;
                        i++;
                    } else {
                        output += 1;
                    }
                } else
                    output += 1;
            }
        }
        return output;
    }

    public static boolean rotateString(String A, String B) {
        return (A.length() == B.length()) && ((A + A).contains(B));
    }

    public static String reverseOnlyLetters(String S) {
        int begin = 0, end = S.length() - 1;
        int len = S.length();
        char[] output = S.toCharArray();
        while (begin < end) {
            while (!Character.isLetter(output[begin])) {
                begin++;
                if (begin >= len) {
                    break;
                }
            }
            while (!Character.isLetter(output[end])) {
                end--;
                if (end < 0) {
                    break;
                }
            }
            if (begin < end) {
                char t = output[begin];
                output[begin] = output[end];
                output[end] = t;
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
        if (n <= 2) {
            return true;
        }
        int begin = n % 2;
        n = n >> 1;
        while (n != 0) {
            if (n % 2 != begin) {
                begin = n % 2;
                n = n >> 1;
            } else {
                return false;
            }
        }
        //System.out.println((n>>1)^n);
        return true;
    }

    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums.length * nums[0].length != r * c) {
            return nums;
        }
        int[][] output = new int[r][c];
        int index = 0;
        for (int[] num : nums) {
            for (int n : num) {
                output[index / c][index % c] = n;
                index++;
            }
        }
        return output;
    }

    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            if (hashMap.containsKey(num)) {
                hashMap.put(num, hashMap.get(num) + 1);
            } else {
                hashMap.put(num, 1);
            }
        }
        int maxNum = nums.length / 2;
        for (Map.Entry<Integer, Integer> item : hashMap.entrySet()) {
            if (item.getValue() > maxNum) {
                return item.getKey();
            }
        }
        return 0;
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int[] output = new int[nums.length];
        for (int num : nums) {
            output[num - 1]++;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < output.length; i++) {
            if (output[i] == 0) {
                list.add(i + 1);
            }
        }
        return list;
    }

    public static boolean detectCapitalUse(String word) {
        if (word.toLowerCase().equals(word) || word.toUpperCase().equals(word)) {
            return true;
        }
        if (word.length() < 2)
            return false;
        if (word.charAt(0) <= 'Z' && word.charAt(0) >= 'A') {
            if (word.substring(1).toLowerCase().equals(word.substring(1)))
                return true;
        }
        return false;
    }

    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                continue;
            if (nums[pos] == 0) {
                nums[pos] = nums[i];
                nums[i] = 0;
            }
            pos++;
        }
        return;
    }

    public static int addDigits(int num) {
        int output = num % 9;
        if (output == 0) {
            return 1;
        } else {
            return output;
        }
    }

    public static void singleNumber(int[] nums) {
        int output = 0;
        for (int num : nums) {
            output ^= num;
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
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                list.add("FizzBuzz");
            } else if (i % 3 == 0) {
                list.add("Fizz");
            } else if (i % 5 == 0) {
                list.add("Buzz");
            } else {
                list.add(i + "");
            }
        }
        System.out.println(list);
    }

    public static void binaryGap() {
        int N = 5;
        int maxDis = 0;
        boolean begin = true;
        int count = 1;
        while (N != 0) {
            if (begin) {
                if (N % 2 == 1) {
                    begin = false;
                }
            } else {
                if (N % 2 == 0) {
                    count++;
                } else {
                    if (count > maxDis)
                        maxDis = count;
                    count = 1;
                }
            }
            N = N >> 1;
        }
        System.out.println(maxDis);
    }

    public static void numUniqueEmails() {
        String[] emails = new String[]{"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String email : emails) {
            int plusPos = email.indexOf("+");
            int atPos = email.indexOf("@");
            if (plusPos != -1) {
                hashMap.put(email.substring(0, plusPos).replace(".", "") + email.substring(atPos), 1);
            } else {
                hashMap.put(email.substring(0, atPos).replace(".", "") + email.substring(atPos), 1);
            }
        }
        System.out.println(hashMap.size());
    }

    public static void islandPerimeter(int[][] grid) {
        int peri = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    peri += 4;
                    if (i + 1 < row) {
                        if (grid[i + 1][j] == 1) {
                            peri -= 1;
                        }
                    }
                    if (i - 1 >= 0) {
                        if (grid[i - 1][j] == 1) {
                            peri -= 1;
                        }
                    }
                    if (j + 1 < col) {
                        if (grid[i][j + 1] == 1) {
                            peri -= 1;
                        }
                    }
                    if (j - 1 >= 0) {
                        if (grid[i][j - 1] == 1) {
                            peri -= 1;
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
        String S = "abaa";
        char C = 'b';
        int[] output = new int[S.length()];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == C) {
                list.add(i);
            }
        }
        int begin = list.get(0);
        for (int i = 0; i < begin; i++) {
            output[i] = begin - i;
        }
        int end = list.get(list.size() - 1);
        for (int i = end + 1; i < S.length(); i++) {
            output[i] = i - end;
        }
        for (int i = 0; i < list.size() - 1; i++) {
            begin = list.get(i);
            end = list.get(i + 1);
            int mid = (begin + end) / 2;
            for (int j = begin + 1; j < end; j++) {
                if (j <= mid) {
                    output[j] = j - begin;
                } else {
                    output[j] = end - j;
                }
            }
        }
        System.out.println(output.toString());
    }

    public static void uncommonFromSentences(String A, String B) {
        String[] As = A.split(" ");
        String[] Bs = B.split(" ");
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String a : As) {
            if (hashMap.containsKey(a)) {
                hashMap.put(a, hashMap.get(a) + 1);
            } else {
                hashMap.put(a, 1);
            }
        }
        for (String a : Bs) {
            if (hashMap.containsKey(a)) {
                hashMap.put(a, hashMap.get(a) + 1);
            } else {
                hashMap.put(a, 1);
            }
        }
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> item : hashMap.entrySet()) {
            if (item.getValue() == 1)
                list.add(item.getKey());
        }
        String[] output = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            output[i] = list.get(i);
        }
        System.out.println(output);
    }

    public void getDomainMax() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        String[] cpdomains = new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        for (String str : cpdomains) {
            String[] k = str.split(" ");
            int number = Integer.parseInt(k[0]);
            int z = 0;
            if (hashMap.containsKey(k[1])) {
                hashMap.put(k[1], hashMap.get(k[1]) + number);
            } else {
                hashMap.put(k[1], number);
            }

            while (true) {
                z = k[1].indexOf(".", z + 1);
                if (z == -1) {
                    break;
                }
                String s = k[1].substring(z + 1);
                if (hashMap.containsKey(s)) {
                    hashMap.put(s, hashMap.get(s) + number);
                } else {
                    hashMap.put(s, number);
                }
            }
        }
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> item : hashMap.entrySet()) {
            list.add(item.getValue() + " " + item.getKey());
        }
        System.out.println(list.toString());
    }

    public int arrayPairSum(int[] nums) {
        int res = 0;
        if (nums.length < 200) {
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i = i + 2) {
                res += nums[i];
            }
        } else {
            int[] freq = new int[20001];
            for (int i : nums) {
                freq[i + 10000]++;//统计数字的频率
            }
            boolean flag = true;
            for (int i = 0; i < 20001; i++) {
                while (freq[i] > 0) {
                    if (flag) {
                        res += (i - 10000);
                    }
                    flag = !flag;
                    freq[i]--;
                }
            }
        }
        return res;
    }

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        int[] output = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22, 24, 33, 36, 44, 48, 55, 66, 77, 88, 99, 111, 112, 115, 122, 124, 126, 128, 132, 135, 144, 155, 162, 168, 175, 184, 212, 216, 222, 224, 244, 248, 264, 288, 312, 315, 324, 333, 336, 366, 384, 396, 412, 424, 432, 444, 448, 488, 515, 555, 612, 624, 636, 648, 666, 672, 728, 735, 777, 784, 816, 824, 848, 864, 888, 936, 999, 1111, 1112, 1113, 1115, 1116, 1122, 1124, 1128, 1131, 1144, 1155, 1164, 1176, 1184, 1197, 1212, 1222, 1224, 1236, 1244, 1248, 1266, 1288, 1296, 1311, 1326, 1332, 1335, 1344, 1362, 1368, 1395, 1412, 1416, 1424, 1444, 1448, 1464, 1488, 1515, 1555, 1575, 1626, 1632, 1644, 1662, 1692, 1715, 1722, 1764, 1771, 1824, 1848, 1888, 1926, 1935, 1944, 1962, 2112, 2122, 2124, 2128, 2136, 2144, 2166, 2184, 2196, 2212, 2222, 2224, 2226, 2232, 2244, 2248, 2262, 2288, 2316, 2322, 2328, 2364, 2412, 2424, 2436, 2444, 2448, 2488, 2616, 2622, 2664, 2688, 2744, 2772, 2824, 2832, 2848, 2888, 2916, 3111, 3126, 3132, 3135, 3144, 3162, 3168, 3171, 3195, 3216, 3222, 3264, 3276, 3288, 3312, 3315, 3324, 3333, 3336, 3339, 3366, 3384, 3393, 3432, 3444, 3492, 3555, 3612, 3624, 3636, 3648, 3666, 3717, 3816, 3864, 3888, 3915, 3924, 3933, 3996, 4112, 4116, 4124, 4128, 4144, 4164, 4172, 4184, 4212, 4224, 4236, 4244, 4248, 4288, 4332, 4344, 4368, 4392, 4412, 4416, 4424, 4444, 4448, 4464, 4488, 4632, 4644, 4824, 4848, 4872, 4888, 4896, 4932, 4968, 5115, 5155, 5355, 5515, 5535, 5555, 5775, 6126, 6132, 6144, 6162, 6168, 6192, 6216, 6222, 6264, 6288, 6312, 6324, 6336, 6366, 6384, 6432, 6444, 6612, 6624, 6636, 6648, 6666, 6696, 6762, 6816, 6864, 6888, 6912, 6966, 6984, 7112, 7119, 7175, 7224, 7266, 7371, 7448, 7476, 7644, 7728, 7777, 7784, 8112, 8128, 8136, 8144, 8184, 8224, 8232, 8248, 8288, 8328, 8424, 8448, 8488, 8496, 8616, 8664, 8688, 8736, 8824, 8832, 8848, 8888, 8928, 9126, 9135, 9144, 9162, 9216, 9288, 9315, 9324, 9333, 9396, 9432, 9612, 9648, 9666, 9864, 9936, 9999
        };
        for (int k : output) {
            if (k > right)
                break;
            if (k >= left) {
                list.add(k);
            }
        }
        return list;
    }

    public static boolean isDivisible(int a) {
        int len = 0;
        if (a < 100) {
            len = 2;
        } else if (a < 1000) {
            len = 3;
        } else if (a < 10000) {
            len = 4;
        }
        int number = a;
        for (int i = 0; i < len; i++) {
            int t = number % 10;
            if (t == 0)
                return false;
            else {
                if (a % t != 0)
                    return false;
            }
            number = (number - t) / 10;
        }
        return true;
    }
}
