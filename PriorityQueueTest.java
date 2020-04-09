
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PriorityQueueTest {

    private Integer[] inArray;
    private Integer[] outArray;

    public PriorityQueueTest(Integer[] inArray, Integer[] outArray){
        this.inArray = inArray;
        this.outArray = outArray;
    }
    @Parameterized.Parameters
    public static Collection a(){
        return Arrays.asList(new Integer[][][]{
                {{1,4,3,2},{1,2,3,4}},
                {{3,2,5,7},{2,3,5,7}},
                {{3,1,5,6},{1,3,5,6}},
                {{1,3,2},{1,2,3}},
                {{1,4,2,3},{1,2,3,4}}
        });
    }
    @Test
    public void test(){
        PriorityQueue pq = new PriorityQueue<>();
        pq.addAll(Arrays.asList(this.inArray));
        for(int i=0;i<this.outArray.length;i++){
            assertEquals(pq.poll(),outArray[i]);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void IllegalArgumentException(){
        PriorityQueue pq = new PriorityQueue<>();
        pq.addAll(pq);
    }

    @Test(expected = NullPointerException.class)
    public void NullPointerException(){
        PriorityQueue pq = new PriorityQueue<>();
        Integer[] a = null;
        pq.addAll(Arrays.asList(a));
    }

    @Test(expected = ClassCastException.class)
    public void ClassCastException(){
        PriorityQueue pq  = new PriorityQueue<>();
        pq.add("test");
        pq.add(1);
    }
}