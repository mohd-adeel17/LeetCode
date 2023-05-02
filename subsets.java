import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public void solve(List<List<Integer>>ans,List<Integer>output,int ind,int nums[]){
        if(ind>= nums.length){
            ans.add(new ArrayList<>(output));
            // ans.remove(ans.length()-1);
            return;
        }
        solve(ans, output, ind+1, nums);

       
        output.add(nums[ind]);
        solve(ans,output,ind+1,nums);
        output.remove(output.get(output.size()-1));

    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>ans=new ArrayList<>() ;

        List<Integer>output=new ArrayList<>();


        int ind=0;
        solve(ans,output,ind,nums);
        return ans;


    }
}
