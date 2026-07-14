class Solution {
    public static void solve(int[] candidates, int target, int index, List<Integer> output, List<List<Integer>> ans, int count, int k) {

        // base case
        if(count > k) {
            return;
        }
        if(count == k && target == 0) {
            ans.add(new ArrayList<>(output));
            return;
        }
        //if index goes out of bound then return
        if(index >= candidates.length) {
            return;
        }
        // if target becomes negative then also return
        if( target < 0) {
            return;
        }

        // now 1 case solve karo and baki recursion sambhal lega
        // use include - exclude pattern
        // include -
        output.add(candidates[index]);
        solve(candidates, target - candidates[index], index+1, output, ans, count+1, k);

        while(index+1 < candidates.length && candidates[index] == candidates[index+1]) {
            index++;
        }
        // now exclude
        output.remove(output.size()-1);
        solve(candidates, target, index+1, output, ans, count, k);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        int index = 0;
        int[] candidates = {1,2,3,4,5,6,7,8,9};
        int target = n;
        int count = 0;
        solve(candidates, target, index,output, ans, count, k);
        return ans;
    }
}