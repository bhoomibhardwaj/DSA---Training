LOGIC::
Create a HashMap to store:
remainder → index

Put (0 → -1) in the map

Initialize:

currentSum = 0

For each index i:

Add nums[i] to currentSum

Compute remainder = currentSum % k

If remainder already exists in map:

If distance between indices ≥ 2
→ return true

Else:

Store remainder with current index

Return false

CODE::

import java.util.HashMap;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // remainder 0 at index -1 (base case)
        map.put(0, -1);
        
        int currentSum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            
            currentSum += nums[i];
            
            int remainder = currentSum % k;
            
            if (map.containsKey(remainder)) {
                
                int previousIndex = map.get(remainder);
                
                // Check subarray length >= 2
                if (i - previousIndex >= 2) {
                    return true;
                }
            } else {
                // Store first occurrence only
                map.put(remainder, i);
            }
        }
        
        return false;
    }
}
