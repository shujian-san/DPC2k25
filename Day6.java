import java.util.*;

public class Day6 {
    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        List<int[]> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        int sum = 0;
        map.put(0, new ArrayList<>(Arrays.asList(-1))); // Handle case where subarray starts from index 0

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (map.containsKey(sum)) {
                for (int startIndex : map.get(sum)) {
                    result.add(new int[]{startIndex + 1, i});
                }
            }

            // Store this prefix sum index
            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, -3, 3, -1, 2};
        List<int[]> subarrays = findZeroSumSubarrays(arr);

        for (int[] sub : subarrays) {
            System.out.println("(" + sub[0] + ", " + sub[1] + ")");
        }
    }
}
