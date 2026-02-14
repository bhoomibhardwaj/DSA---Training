LOGIC::

create a HashMap to store prefix sum and its frequency

Put (0 → 1) in the map

Initialize:

currentSum = 0

count = 0

For each number in the array:

Add number to currentSum

If (currentSum - k) exists in the map
→ increase count by the frequency of (currentSum - k)

Store/update currentSum in the map

Return count

CODE::

import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        
        // Map to store prefix sum and its frequency
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Important: Base case
        map.put(0, 1);
        
        int currentSum = 0;
        int count = 0;
        
        for (int num : nums) {
            
            // Add current number to prefix sum
            currentSum += num;
            
            // Check if (currentSum - k) exists in map
            if (map.containsKey(currentSum - k)) {
                count += map.get(currentSum - k);
            }
            
            // Store/update current prefix sum in map
            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }
        
        return count;
    }
}
