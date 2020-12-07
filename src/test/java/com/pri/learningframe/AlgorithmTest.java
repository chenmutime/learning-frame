package com.pri.learningframe;

import java.util.Arrays;

public class AlgorithmTest {

    public static void main(String[] args) {
        AlgorithmTest algorithmTest = new AlgorithmTest();
        Solution solution = algorithmTest.new Solution();
//        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
//        solution.removeDuplicates(nums);
//        System.out.print(nums.length + "=======");
//        for (int i = 0; i < nums.length; i++) {
//            System.out.print(nums[i] + ",");
//        }
        int[] prices = new int[]{1, 2, 4, 2, 5, 7, 2, 4, 9, 0};
        int price = solution.maxProfit(prices);
        System.out.println("======>" + price);
    }

    class Solution {

        /**
         * 去除一个数组中的重复项
         * @param nums
         * @return
         */
        public int removeDuplicates(int[] nums) {
            int lastEle = nums[0];
            int i = 1;
            while (true) {
                if (i >= nums.length - 1) {
                    break;
                }
                // 如果相同，下次循环还是从当前位置开始
                if (nums[i] == lastEle) {
                    // 后面的元素向前进一位
                    for (int j = i; j < nums.length - 1; j++) {
                        nums[j] = nums[j + 1];
                    }

                    // 移除末尾元素
                    nums = Arrays.copyOf(nums, nums.length - 1);
                } else {
                    lastEle = nums[i];
                    i++;
                }
            }
            return nums.length;
        }

        /**
         * 买卖股票的最佳时机 II
         * 三角形算法（自定义）、贪心算法
         *
         * @param prices
         * @return
         */
//      2, 1, 3, 3, 2, 6
        public int maxProfit(int[] prices) {
            int price = 0;
            int buyIndex = 0;
            int size = prices.length;
            loop1:
//            这里的i仅作为循环次数限制
            for (int i = 0; i < size - 1; i++) {
                if (i >= size - 1) {
                    break loop1;
                }
                int sellPrice = 0;
                int buyPrice = prices[buyIndex];
                boolean end = false;
                int sellIndex = buyIndex + 1;
                loop2:
                for (; sellIndex < size; sellIndex++) {
                    sellPrice = prices[sellIndex];
//                    到这里就结束了，第一层循环不用继续了
                    if (sellIndex == size - 1) {
                        end = true;
                        break loop2;
                    }
//                    如果卖出价格大于买入价格
                    if (sellPrice > buyPrice) {
                        int sellTrendIndex = sellIndex + 1;
//                        如果发现再往后的卖出价格更高
                        if (prices[sellTrendIndex] >= sellPrice) {
                            continue;
//                            如果发现再往后的卖出价格走低了，则直接跳出当前循环，卖出当前持有的股票
                        } else if (prices[sellTrendIndex] < sellPrice) {
//                            跳出之前，先获取下一次买入股票的时机，即卖出价格日的第二天
                            buyIndex = sellTrendIndex;
                            break loop2;
                        }
                    } else {
//                        如果发现次日的股票价格更低，则买入次日的
                        buyIndex += 1;
                        continue loop1;
                    }
                }
                if (sellPrice > buyPrice) {
                    price += sellPrice - buyPrice;
                }
                if (end) {
                    break loop1;
                }
            }
            return price;
        }

    }
}
