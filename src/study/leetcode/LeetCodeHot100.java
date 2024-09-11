package study.leetcode;



import study.common.ListNode;
import study.common.TreeNode;

import java.util.*;

/**
 * @author mq
 * @create 2024-07-24 10:29
 */
public class LeetCodeHot100 {
    /**
     * 560. 和为 K 的子数组
     * nums = [1,1,1], k = 2
     */
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        int preSum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i = 0; i <nums.length; i++) {
            preSum += nums[i];
            if(map.containsKey(preSum-k)){
                result += map.get(preSum-k);
            }
            map.put(preSum,map.getOrDefault(preSum,0)+1);
        }
        return result;
    }

    /**
     * 53. 最大子数组和
     * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * 子数组是数组中的一个连续部分。
     * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出：6
     * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
     */
    public int maxSubArray(int[] nums) {
        // 初始化ans为Integer的最小值
        int ans = Integer.MIN_VALUE;
        // 前缀和的最小值
        int minPreSum = 0;
        // 当前的前缀和
        int preSum = 0;

        for (int x : nums) {
            // 更新当前的前缀和
            preSum += x;
            // 减去前缀和的最小值得到可能的最大子数组和，并更新ans
            ans = Math.max(ans, preSum - minPreSum);
            // 更新前缀和的最小值
            minPreSum = Math.min(minPreSum, preSum);
        }

        return ans;
    }

    /**
     * 56. 合并区间
     * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
     * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
     * 输出：[[1,6],[8,10],[15,18]]
     * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    /**
     * 189. 轮转数组
     * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
     * 输入: nums = [1,2,3,4,5,6,7], k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右轮转 1 步: [7,1,2,3,4,5,6]
     * 向右轮转 2 步: [6,7,1,2,3,4,5]
     * 向右轮转 3 步: [5,6,7,1,2,3,4]
     */
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if(k == 0){
            return;
        }
        int[] temp = new int[k];
        for (int i = 0; i <k; i++) {
            temp[i] = nums[nums.length-k+i];
        }
        int[] temp1 = new int[nums.length - k];
        for (int i = 0; i < nums.length - k; i++) {
            temp1[i] = nums[i];
        }
        for (int i = 0; i < temp.length; i++) {
            nums[i] = temp[i];
        }
        for (int i = 0; i < temp1.length; i++) {
            nums[k+i] = temp1[i];
        }
    }
    public void rotate1(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; ++i) {
            newArr[(i + k) % n] = nums[i];
        }
//        public static native void arraycopy(Object src,  int  srcPos, Object dest, int destPos,  int length);
//        @param      src      原数组
//        @param      srcPos   原数组开始位置
//        @param      dest      目标数组
//        @param      destPos  目标数组开始位置.
//        @param      length    复制的长度
        System.arraycopy(newArr, 0, nums, 0, n);
    }

    /**
     * 238. 除自身以外数组的乘积
     * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
     * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
     * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
     * 示例 1:
     * 输入: nums = [1,2,3,4]
     * 输出: [24,12,8,6]
     */
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] left = new int[length];
        int[] right = new int[length];
        int[] answer = new int[length];
        left[0] = 1;
        for (int i = 1; i < length; i++) {
            left[i] = nums[i-1] * left[i-1];
        }
        right[length-1] = 1;
        for (int i = length-2; i>=0 ; i--) {
            right[i] = nums[i+1] *right[i+1];
        }
        for (int i = 0; i < length; i++) {
            answer[i] = left[i] * right[i];
        }
        return answer;
    }
    public static void main(String[] args) {
        Integer type =null;
        type = 2;
        System.out.println(type);

    }

    /**
     * 160. 相交链表
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        return null;
    }
    /**
     * 94. 二叉树的中序遍历
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root,res);
        return res;
    }
    private void inorder(TreeNode root, List<Integer> res){
        if(root==null){
            return;
        }
        inorder(root.left,res);
        res.add(root.val);
        inorder(root.right,res);
    }
}
