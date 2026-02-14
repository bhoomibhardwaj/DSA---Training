LOGIC::

Store all elements in HashSet

For each number:

If num-1 does NOT exist → start counting

Keep checking num+1, num+2...

Track maximum length

Return max length


import java.util.HashSet;

class Solution {
    public int longestConsecutive(int[] nums) {
        
        if (nums.length == 0) return 0;
        
        HashSet<Integer> set = new HashSet<>();
        
        // Add all numbers to set
        for (int num : nums) {
            set.add(num);
        }
        
        int longest = 0;
        
        for (int num : set) {
            
            // Only start if num is beginning of sequence
            if (!set.contains(num - 1)) {
                
                int currentNum = num;
                int currentLength = 1;
                
                // Check next consecutive numbers
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }
                
                longest = Math.max(longest, currentLength);
            }
        }
        
        return longest;
    }
}



