package com.jcloud.learn.Example;

import java.util.Arrays;

import org.junit.Test;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * <p>
 * resolve: 选定第一个区间A，按序依次遍历剩下的区间B，如果B的起点比A的终点小，则A和B可以合并
 */
public class mergeInterval {

    @Test
    public void testMerge() {
        int[][] intervals = {{8, 10}, {15, 18}, {1, 3}, {2, 6}};
        int[][] result = merge(intervals);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i][i]);
        }
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return Integer.compare(o1[0], o2[0]);
            }
            return Integer.compare(o1[1], o2[2]);
        });

        boolean[] vis = new boolean[intervals.length];
        Arrays.fill(vis, true);
        for (int i = 0; i < intervals.length; i++) {
            if (!vis[i]) {
                continue;
            }
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[j][0] <= intervals[i][1]) {
                    intervals[i][1] = intervals[j][1];
                }
            }
        }
        int count = 0;
        for (boolean v : vis) {
            if (v) {
                count++;
            }
        }

        int[][] ans = new int[count][];
        for (int i = 0, j = 0; i < intervals.length; i++) {
            if (!vis[i]) {
                continue;
            }
            ans[j++] = intervals[i];
        }
        return ans;
    }
}
