## 61. Rotate List
#### Given a linked list, rotate the list to the right by k places, where k is non-negative.
#### 求链表长度，连成一个环，然后在特定的位置把环断开

## 60. Permutation Sequence
#### The set [1,2,3,...,n] contains a total of n! unique permutations. By listing and labeling all of the permutations in order
#### 找出规律，每次通过n-1的阶乘得到当前index，然后再迭代

## 54. Spiral Matrix
#### Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
#### 主要是需要注意matrix是否为空

## 59. Spiral Matrix II
#### Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
#### 与54过程是相反的

## 55. Jump Game
#### Given an array of non-negative integers, you are initially positioned at the first index of the array. Each element in the array represents your maximum jump length at that position. Determine if you are able to reach the last index.
#### 贪心算法，每次保存当前能够到达的最大距离和之前能够到达的最大距离

## 45. Jump Game II
#### Given an array of non-negative integers, you are initially positioned at the first index of the array. Each element in the array represents your maximum jump length at that position. Your goal is to reach the last index in the minimum number of jumps.
```
public int jump(int[] nums) {
    int ret=0;//当前跳数
    int last=0;//上一跳达到的最远距离
    int cur=0;//当前能够达到的最远距离
    for(int i=0;i<nums.length;i++){
        if(i>cur)return -1;//达不到终点
        if(i>last){//进行下一次跳跃
            last=cur;
            ret++;
        }
        cur=Math.max(cur,i+nums[i]);
    }
    return ret;
}
```


