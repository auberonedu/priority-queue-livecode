import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PQPractice {

    private record GraphicMemoir(String name, int interestLvl) implements Comparable<GraphicMemoir> {

        // does it always have to be a int?
        public int compareTo(GraphicMemoir other) {
            return Integer.compare(this.interestLvl, other.interestLvl); // this.name.compareTo(other.name) - if it was
                                                                         // a string
        }

    }

    public static void main(String[] args) {

        PriorityQueue<GraphicMemoir> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(new GraphicMemoir("Book 1", 1)); // DEAD LAST
        pq.add(new GraphicMemoir("book 2", 44)); // 1st
        pq.add(new GraphicMemoir("book 3", 4)); // 3rd
        pq.add(new GraphicMemoir("book4", 9)); // 2nd

        System.out.println(pq.poll());
        System.out.println(pq.poll());

        // by default a min pq
        // PriorityQueue<Integer> pq = new PriorityQueue<>();

        // //wait, so if it aint a queue than why can you inherit queue methods

        // pq.add(7);
        // pq.add(33);
        // pq.add(2);
        // pq.add(99);
        // //remember poll REMOVES the TOP THING from the data structure...
        // pq.poll();
        // pq.poll();

        // System.out.println();
        // System.out.println();
        // //peek doesnt do anything, it just shows the current top value!
        // System.out.println(pq.peek());
        // //Poll pops just the 1 item!
        // System.out.println(pq.poll());

        List<Integer> nums = List.of(3, 5, 46, 22, 34335, 25, 35, 5322, 52);
        System.out.println(topK(nums, 4));
    }

    // Return the top K elements in the list
    // The original list is NOT modified
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
                if (best.size() > k) {
                    best.poll();
                    best.add(num);
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!best.isEmpty()) {
            result.add(best.poll());
        }
        //look up the holting problem
        return result;
    }
}