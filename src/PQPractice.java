
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PQPractice {

    private record GraphicMemoir(String name, int interest) implements Comparable<GraphicMemoir> {
        public int compareTo(GraphicMemoir other) {
            // for integers have to ask for comparator from somewhere else
            return Integer.compare(this.interest, other.interest);

            // for strings compareTo works directly???
            // return this.name.compareTo(other.name);
        }

    }

    public static void main(String[] args) {
        // by default is a min priority queue
        PriorityQueue<GraphicMemoir> pq = new PriorityQueue<>(Comparator.reverseOrder());

        pq.add(new GraphicMemoir("I'm A Wild Seed", 62));
        pq.add(new GraphicMemoir("The Third Person", 83));
        pq.add(new GraphicMemoir("Calling Dr. Laura", 55));
        pq.add(new GraphicMemoir("The Bride Was A Boy", 100));

        System.out.println(pq.poll());
        System.out.println(pq.poll());

        // pq.add(7);
        // pq.add(33);
        // pq.add(2);
        // pq.add(99);
        // pq.poll();
        // pq.poll();

        // System.out.println(pq.peek());
        // System.out.println(pq.poll());

        List<Integer> nums = List.of(33, 2, 5, 77, 2, 8, 99, 1, 2, 55, 2, 5, 6, 33, 2);
        Timer.time();
        topKEfficient(nums, 4);
        System.out.println(Timer.time("topKEfficient"));
        // System.out.println(topKEfficient(nums, 4));
    }

    // return top K elements in list
    // original list is NOT modified
    public static List<Integer> topK(List<Integer> nums, int k) {
        List<Integer> copy = new ArrayList<>(nums);
        Collections.sort(copy);
        return copy.subList(nums.size() - k, nums.size());
    }

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

    public class Timer {
        private static long startTime = 0;

        // Call this to start the timer
        public static void time() {
            startTime = System.nanoTime();
        }

        // Call this to get elapsed time as a formatted string
        public static String time(String label) {
            long endTime = System.nanoTime();
            long duration = endTime - startTime;
            double millis = duration / 1_000_000.0;
            return label + " took " + millis + " ms";
        }
    }

}