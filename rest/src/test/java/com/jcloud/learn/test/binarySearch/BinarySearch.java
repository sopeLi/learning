package com.jcloud.learn.test.binarySearch;

public class BinarySearch {
    public static int binarySearch(int[] baseNumber, int willFindnumber) {
        if (baseNumber == null || baseNumber.length <= 0) {
            throw new RuntimeException("基数数据不能为空!");
        }
        int below = 0;
        int height = baseNumber.length - 1;
        int middle = (height - below) / 2;
        while (below <= height) {
            if (baseNumber[middle] > willFindnumber) {
                height = --middle;
            } else if (baseNumber[middle] < willFindnumber) {
                below = ++middle;
            } else if (baseNumber[middle] == willFindnumber) {
                return middle;
            }
             middle = (height - below) / 2+below;
        }
        throw new RuntimeException("未找到");
    }

    /**
     * 总结：
     * 单纯的最高位与最单位运算，减的话出现0 加的话出现数值无变化 四舍五入的原因，也就是导致middle无变化
     * 所以要点是 最高位与最低位的变化要达到影响middle的变化。middle无变化时依赖最高位与最低位的变化
     *
     * @param
     */
    public static void main(String[] args) {
        int i[] = {1, 2, 3, 4, 5, 6};
        int position = BinarySearch.binarySearch(i, 5);
        System.out.print(position);
    }
}
