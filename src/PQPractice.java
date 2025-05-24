
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;



public class PQPractice {

    private record GraphicMemoir(String name, int interest) implements Comparable<GraphicMemoir> {
        public int compareTo(GraphicMemoir other) {
                //   comparing the number or the 'interest'                comparing the name                           
            return Integer.compare(this.interest, other.interest); // this.name.compareTo(other.name);    
        }
    }
    public static void main(String[] args) {
        
        PriorityQueue<GraphicMemoir> pq = new PriorityQueue<>(Comparator.reverseOrder());

        pq.add(new GraphicMemoir("I'm a Wild Seed", 62));
        pq.add(new GraphicMemoir("The Third Person", 83));
        pq.add(new GraphicMemoir("Calling Dr. Laura", 55));
        pq.add(new GraphicMemoir("The Bride Was a Boy", 100));

        System.out.println(pq.poll());
        System.out.println(pq.poll());

        // PriorityQueue<Integer> pq = new PriorityQueue<>();

        // pq.add(7);
        // pq.add(33);
        // pq.add(2);        // This will be the first value in the priority queue = 2
        // pq.add(99);
        // pq.poll();          // This will remove the first value, which is = 2
        // pq.poll();          // 7
        
        // System.out.println();
        // System.out.println();
        // System.out.println(pq.peek());
        // System.out.println(pq.poll());

        List<Integer> nums = List.of(3,55,22,15,334,6,99,15,1,89,98,75,2);
        System.out.println(topK(nums, 4));

        System.out.println(topKEfficient(nums, 4));
    }

    // Return the Top K elements in the list --- (if I pass 5 as K, it will return the 5 largest elements of the list)
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

/**
 *      Time Complexity of a PriorityQueue
 * 
 *  Add: log(n)
 *  Poll: log(n)
 * 
 *  n = size of PQ
 * 
 */