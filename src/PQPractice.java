import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PQPractice {

    private record GraphicMemoir (String name, int interest) implements Comparable<GraphicMemoir> {
        public int compareTo(GraphicMemoir other) {
            return Integer.compare(this.interest, other.interest);
        }

    }
    public static void main(String[] args) {

        
        PriorityQueue<GraphicMemoir> pq = new PriorityQueue<>(Comparator.reverseOrder()); // default ordering

        
        pq.add(new GraphicMemoir("I'm a Wild Seed", 62)); 
        pq.add(new GraphicMemoir("The Third Person", 83));
        pq.add(new GraphicMemoir("Calling Dr. Laura", 55));
        pq.add(new GraphicMemoir("The Bride Was a Boy", 100));

        System.out.println(pq.poll()); 
        System.out.println(pq.poll()); 


        // // creating a priority queue
        // PriorityQueue<Integer> pq = new PriorityQueue<>();

        // // adding elements to the priority queue
        // pq.add(7);
        // pq.add(33);
        // pq.add(2);
        // pq.add(99);
        // pq.poll(); // removes the head of the queue
        // pq.poll();

        // System.out.println(); // prints 2
        // System.out.println(pq.peek()); // prints 33
        // System.out.println(pq.poll()); // prints 33

        List<Integer> nums = List.of(33, 2, 7, 99, 1, 5, 4, 6, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
        //System.out.println(topK(nums, 4)); 

        System.out.println(topKEfficient(nums, 4)); 
    }

    // returns the top k elements from the list
    // the orginal list is not modified
    public static List<Integer> topK(List<Integer> nums, int k) {
        List<Integer> copy = new ArrayList<>(nums); // create a copy of the list

        Collections.sort(copy); // sort the copy in ascending order
        return copy.subList(nums.size() - k, nums.size()); // get the last k elements
    }

    public static List<Integer> topKEfficient(List<Integer> nums, int k) {
        PriorityQueue<Integer> best = new PriorityQueue<>(); // create a min heap

        for (int num : nums) {
            if (best.size() < k) {
                best.add(num); // add the number to the heap
            } else if (num > best.peek()) { // if the number is greater than the smallest in the heap
                best.poll(); // remove the smallest
                best.add(num); // add the new number
            }
        }

        List<Integer> result = new ArrayList<>(); // create a new list to store the result
        while (!best.isEmpty()) { // while the heap is not empty
            result.add(best.poll()); // remove the smallest element and add it to the result
        }

        return result;

        
    }
}