import java.util.*;

public class Day23 {
    public static List<Integer> maxSlidingWindow(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) deque.pollFirst();
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) deque.pollLast();
            deque.offerLast(i);
            if (i >= k - 1) result.add(nums[deque.peekFirst()]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(maxSlidingWindow(arr, k));
    }
}