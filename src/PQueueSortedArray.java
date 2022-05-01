import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;
/**
 * PQueueSortedArray is a class that builds off of a PriorityQueue which includes
 * a sorted array to hold the values of the PriorityQueue in non-increasing order
 * @author Ilan Zar
 */

public class PQueueSortedArray<E> extends AbstractQueue<E>{
	/**
	 * Three attributes exist in the PQueueSortedArray class
	 * One generic array holding the values of the PriorityQueue
	 * One integer holding the current capacity of the List.
	 * One integer holding the current size of the List.
	 * All attributes are set to default values for simplicity.
	 */
	
	private E[] pq;
	private int capacity = 11;
	private int size = 0;
	/**
	 * A no argument constructor that creates a new array of the generic type that is specified at run time.
	 */
	
	PQueueSortedArray(){this.pq = (E[]) new Object[capacity];}
	/**
	 * This method is used to convert the existing PQueueSortedArray into the form of a String
	 * @return String This returns the String representing the PQueueSortedArray
	 */
	
	@Override
	public String toString() {
		String fin;
		if(size == 0)
			fin = "[]";
		else {
			fin = "[";
			for(int i = 0; i < size-1; i++)
				fin += pq[i] + ", ";
			fin += pq[size - 1] + "]";
		}
		return fin;
	}
	/**
	 * This method is used to add new elements to the PQueueSortedArray
	 * @param e Holds the generic value of the element the user wants to add.
	 * @return boolean This returns the boolean value based on if the add was successful or not.
	 */
	
	@Override
	public boolean add(E e) {
			return offer(e);
	}
	/**
	 * A helper method that compares values of two elements.
	 * @param x The first element
	 * @param y The second element
	 * @return True only if x is less than y
	 * Basic structure was referenced from the Max Heap implementation found here:
	 * https://algs4.cs.princeton.edu/24pq/MaxPQ.java.html
	 */
	
	private boolean lessThan(E x, E y) {
		return ((Comparable)x).compareTo(y) < 0;
	}
	/**
	 * A helper method that resizes the array to twice its current capacity for
	 * optimal runtime performance of resize-able dynamic arrays.
	 */
	
	private void resizeArray() {
		E[] temp = (E[]) new Object[capacity*2];
		for(int i = 0; i < capacity; i++) 
			temp[i] = pq[i];
		pq = temp;
		capacity *= 2;
	}
	/**
	 * This method is used to add new elements to the PQueueSortedArray
	 * @param e Holds the generic value of the element the user wants to add.
	 * @return boolean This returns the boolean value based on if the add was successful or not.
	 * @exception NullPointerException Thrown if value of e is equal to null.
	 * @see NullPointerException
	 */
	
	@Override
	public boolean offer(E e) {
		if(e == null)
			throw new NullPointerException();
		if(size == capacity) 
			resizeArray();
		if(size == 0) 
			pq[0] = e;
		else {
			int i;
			for(i = size - 1; i >= 0 && lessThan(pq[i], e); i--)
				pq[i+1] = pq[i];
			pq[i+1] = e;
			}
		size++;
		return true;
	}
	/**
	 * This method is used to remove the element from the head of the PriorityQueue
	 * @return E This returns the generic value of the element being removed. If the
	 * PriorityQueue is empty it returns null.
	 */
	
	@Override
	public E poll() {
		E min;
		if(size == 0) 
			min = null;
		else {
			min = pq[size - 1];
			size--;
		}
		return min;
	}
	/**
	 * This method is used to remove the element from the head of the PriorityQueue
	 * @return E This returns the generic value of the element being removed.
	 * @exception NoSuchElementException Thrown if PriorityQueue is empty.
	 * @see NoSuchElementException
	 */
	
	@Override
	public E remove() {
		if(size == 0)
			throw new NoSuchElementException();
		else
			return poll();
	}
	/**
	 * This method is used to return the element from the head of the PriorityQueue
	 * @return E This returns the generic value of the element being returned. If the
	 * PriorityQueue is empty it returns null.
	 */
	
	@Override
	public E peek() {
		E min;
		if(size == 0) 
			min = null;
		else 
			min = pq[size - 1];
		return min;
	}
	/**
	 * This method is used to return the element from the head of the PriorityQueue
	 * @return E This returns the generic value of the element being returned.
	 * @exception NoSuchElementException Thrown if PriorityQueue is empty.
	 * @see NoSuchElementException
	 */
	
	@Override
	public E element() {
		if(size == 0) 
			throw new NoSuchElementException();
		else 
			return peek();
	}

	@Override
	public Iterator<E> iterator() {
		throw new UnsupportedOperationException();
	}
	/**
	 * This method is used to return the current size of the PriorityQueue.
	 * @return int This returns the integer value of the size.
	 */
	
	@Override
	public int size() {
		return size;
	}

}
