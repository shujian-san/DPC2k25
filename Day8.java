import java.util.*;

public class Day8 {
    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        List<int[]> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        int prefixSum = 0;
        map.put(0, new ArrayList<>(Arrays.asList(-1))); // Handle subarray starting at index 0
        
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            
            if (map.containsKey(prefixSum)) {
                for (int startIndex : map.get(prefixSum)) {
                    result.add(new int[]{startIndex + 1, i});
                }
            }
            
            map.putIfAbsent(prefixSum, new ArrayList<>());
            map.get(prefixSum).add(i);
        }
        
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, -3, 3, -1, 2};
        
        List<int[]> subarrays = findZeroSumSubarrays(arr);
        
        for (int[] pair : subarrays) {
            System.out.println("(" + pair[0] + ", " + pair[1] + ")");
        }
    }
}
