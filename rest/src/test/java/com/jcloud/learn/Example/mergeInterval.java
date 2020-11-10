package com.jcloud.learn.Example;

import java.util.Arrays;

import org.junit.Test;

public class mergeInterval {

    @Test
    public void testMerge() {

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
