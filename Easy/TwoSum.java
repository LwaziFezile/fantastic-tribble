class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++){
            for (int x = 0; x < nums.length; x++){
                if(x == i){
                    continue;
                }
                if (nums[x] + nums[i] == target) {
                    return new int[]{i, x};
                }

            }
        }
        throw new NullPointerException("No Found");
    }
}