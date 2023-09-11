//Method 1 :- Brute Force

class Solution {
    public int[] twoSum(int[] nums, int target) {

        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){

                if(nums[i]+nums[j] == target){
                    return new int[] {i,j};
                }
            }
        }
        return null;
    }
}

/*------------------------------------------------------------------------*/
//Method 2 :- Map Data Structure

class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> num_map = new HashMap<Integer, Integer>();

        for(int i=0; i<nums.length; i++){
            int diff = target - nums[i];
            System.out.println(diff);
            if(num_map.containsKey(diff)){
                return new int[] {num_map.get(diff), i};
            }
            num_map.put(nums[i],i);
        }
        throw new IllegalArgumentException("no match found");
    }
}


