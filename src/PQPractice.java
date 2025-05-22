import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class PQPractice {

    private record GraphicMemoir(String name, int interest) implements Comparable<GraphicMemoir>{
        public int compareTo(GraphicMemoir other){
            return Integer.compare(this.interest, other.interest);
        }
    }
    public static void main(String[] args) {

        PriorityQueue<GraphicMemoir> pq = new PriorityQueue<>();

        pq.add(new GraphicMemoir("I'm a Wild Seed", 63));
        pq.add(new GraphicMemoir("The Third Person", 83));
        pq.add(new GraphicMemoir("Calling Dr. Laura", 55));
        pq.add(new GraphicMemoir("The bride was a boy", 100));
        
        System.out.println(pq.poll());
        
        // PriorityQueue<Integer> pq = new PriorityQueue<>();

        // pq.add(7);
        // pq.add(33);
        // pq.add(2);
        // pq.add(99);
        // pq.poll();
        // pq.poll();
        
        // System.out.println();
        // System.out.println();
        // System.out.println(pq.peek());
        // System.out.println(pq.poll());

        List<Integer> nums = List.of(33,23,1,5,11,64,87,66,99,76,69,45);
        System.out.println(topK(nums,6));
    }

    // return the top k elements in the list
    public static List<Integer> topK(List<Integer> nums, int k){

        List<Integer> copy = new ArrayList<>(nums);
        Collections.sort(copy);
        
        return copy.subList(nums.size() - k, nums.size());
    }

    public static List<Integer> topKEfficent(List<Integer> nums, int k){
        PriorityQueue<Integer> best = new PriorityQueue<>();

        for (int num:nums){
            if(best.size()<k){
                best.add(num);
            } else if( num > best.peek()){
                best.poll();
                best.add(num);
            }
        }

        List<Integer> result = new ArrayList<>();
        while(!best.isEmpty()) {
            result.add(best.poll());
        }

        return result;
    }
}