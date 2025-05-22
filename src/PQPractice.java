import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class PQPractice {

    private record GraphicMemoir(String name, int interest) implements Comparable<GraphicMemoir> {
        public int compareTo(GraphicMemoir other){
            return Integer.compare(this.interest, other.interest);
        }

    }

    public static void main(String[] args) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>();

        // pq.add(7);
        // pq.add(33);
        // pq.add(2);
        // pq.add(99);
        // pq.poll();
        // pq.poll();

        // System.out.println();
        // System.out.println(pq.peek());
        // System.out.println(pq.poll());

        // PriorityQueue<GraphicMemoir> pq = new PriorityQueue<>(Comparator.reverseOrder());
        // pq.add(new GraphicMemoir("I'm a Wild Seed", 62));
        // pq.add(new GraphicMemoir("The Third Person", 83));
        // pq.add(new GraphicMemoir("Calling Dr. Laura", 55));
        // pq.add(new GraphicMemoir("The Bride Was a Boy", 100));

        // System.out.println(pq.poll());
        // System.out.println(pq.poll());


        List<Integer> nums = List.of(33, 2, 43, 59, 0, 28, 71, 50, 25, 6, 4, 3, 1, 15);
        System.out.println(topK(nums, 4));
        System.out.println(topKEfficient(nums, 4));
    }

    // sorting to find top number requires making a copy so we don't edit
    // the original list. This gets less efficient when the list
    // is big, because that's a whole copy of a big structure in memory
    public static List<Integer> topK(List<Integer> nums, int k){
        List<Integer> copy = new ArrayList<>(nums);

        Collections.sort(copy);
        return copy.subList(nums.size() - k, nums.size());
    }

    // Time: O(n * log(k) Space: O(k))
    public static List<Integer> topKEfficient(List<Integer> nums, int k){
        PriorityQueue<Integer> best = new PriorityQueue<>();

        // O(n)
        for (Integer num : nums) {
            if (best.size() < k){
                best.add(num);
            } else if (best.peek() < num){
                best.poll();
                best.add(num);
            }
        }
        
        List<Integer> result = new ArrayList<>();

        while (!best.isEmpty()){
            result.add(best.poll());
        }
        return result;
    }
}