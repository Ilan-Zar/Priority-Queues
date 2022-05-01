import java.util.Queue;
import java.util.AbstractQueue;
/**
 * Sort is a class that builds off of a PriorityQueue class implementations that I have provided
 * which sorts an array using one of the class instances into a sorted array of non-decreasing order
 * @author Ilan Zar
 */
public class Sort<E>{
	/**
	 * This static method is used to sort the array in non-decreasing order using 
	 * one of the three PriorityQueue implementations provided
	 * @param pq A PriorityQueue of generic type
	 * @param a An array of generic type
	 */
	public static <E extends Comparable <? super E>> void PQSort(Queue<E> pq, E[] a) {
		for(int i = 0; i < a.length; i++)
			pq.offer(a[i]);
		for(int i = 0; i < a.length; i++)
			a[i] = pq.poll();
	}
}
