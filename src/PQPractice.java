
import java.util.Comparator;
import java.util.PriorityQueue;

public class PQPractice {

    private record GraphicMemoir(String name, int interest) implements Comparable<GraphicMemoir> {
        public int compareTo(GraphicMemoir other) {
            //for integers have to ask for comparator from somewhere else
            return Integer.compare(this.interest, other.interest);

            //for strings compareTo works directly???
            // return this.name.compareTo(other.name);
        }

    }
    public static void main(String[] args) {
        //by default is a min priority queue
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

        
    }
}