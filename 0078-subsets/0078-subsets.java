class Solution {
    public static void solve(int[] nums, int index, List<Integer> output, List<List<Integer>> ans) {
        // base case
        if(index >= nums.length) {
            ans.add(new ArrayList<>(output));
            return;
        }
        // 1 case hume solve karna hai baki recursion sambhal lega
        // include-exclude pattern
        output.add(nums[index]);
        //include
        solve(nums, index+1, output, ans);
        // exclude
        output.remove(output.size()-1);
        solve(nums, index+1, output, ans);
    }
    public List<List<Integer>> subsets(int[] nums) {
        int index = 0;
        List<Integer> output = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        solve(nums, index, output, ans);
        return ans;
    }
}