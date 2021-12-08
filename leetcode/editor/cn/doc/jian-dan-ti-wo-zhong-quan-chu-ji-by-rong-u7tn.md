### 解题思路

```哈希表
### 代码

1. ```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
       Map<Integer,Integer>map=new HashMap<>();
        int[]a=new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])) {
                a[0]=map.get(target-nums[i]);
                a[1]=i;
                break;
            }
            map.put(nums[i],i);
        }
        return a;
    }
}
