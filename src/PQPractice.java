import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PQPractice {

    private record GraphicMemoir(String name, int interestLvl) implements Comparable<GraphicMemoir> {
        public int compareTo(GraphicMemoir other) {
            return Integer.compare(this.interestLvl, other.interestLvl);
        }
    }

    public static void main(String[] args) {

        /*
         * Time Complexity
         * Add: log(n)
         * Poll: log(n)
         * n = size of PQ
         */

        PriorityQueue<GraphicMemoir> pq = new PriorityQueue<>(Comparator.reverseOrder());

        pq.add(new GraphicMemoir("I'm A Wild Seed", 62));
        pq.add(new GraphicMemoir("The Third Reason", 83));
        pq.add(new GraphicMemoir("Calling Dr. Laura", 55));
        pq.add(new GraphicMemoir("The Bride Was A Boy", 100));

        System.out.println(pq.poll());
        System.out.println(pq.poll());

        // PriorityQueue<Integer> pq = new PriorityQueue<>(); // By default it is a Min
        // PriorityQ

        // pq.add(7);
        // pq.add(33);
        // pq.add(2);
        // pq.add(99);
        // pq.poll();
        // pq.poll();

        // System.out.println(pq.peek());
        // System.out.println(pq.poll());

        List<Integer> nums = List.of(33, 2, 5, 77, 2, 8, 99, 1, 2, 55, 2, 5, 6, 33, 2);
        System.out.println(topK(nums, 4));
        System.out.println(topKEfficient(nums, 4));
    }

    // Return the top K elements in the list
    // The original list is NOT modified
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static List<Integer> topK(List<Integer> nums, int k) {
        List<Integer> copy = new ArrayList<>(nums);
        Collections.sort(copy);
        return copy.subList(nums.size() - k, nums.size());
    }

    // Time Complexity: O(nlog(k))
    // Space Complexity: O(k)
    public static List<Integer> topKEfficient(List<Integer> nums, int k) {
        PriorityQueue<Integer> best = new PriorityQueue<>();

        for (int num : nums) {
            if (best.size() < k) {
                best.add(num);
            } else if (num > best.peek()) {
                best.poll();
                best.add(num);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!best.isEmpty()) {
            result.add(best.poll());
        }

        return result;
    }
}