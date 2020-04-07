package problem3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Solution {
	public static void bruteForce() {
		Scanner in = new Scanner(System.in);
		int merp = in.nextInt();
		int N, K;
		List<Integer> l = new ArrayList<>();
		
		for(int c = 1; c <= merp; c++) {
			N = in.nextInt();
			K = in.nextInt();
			
			l.clear();
			for(int i = 0; i < N; i++) {
				l.add(in.nextInt());
			}
			
			System.out.println(l);
			
			for(int i = 0; i < K; i++) {
				int insertIndex = 0;
				int maxGap = 0;
				for(int j = 0; j < l.size() - 1; j++) {
					int gap = l.get(j + 1) - l.get(j);
					if(gap > maxGap) {
						maxGap = gap;
						insertIndex = j;
					}
				}
				
				l.add(insertIndex + 1, (l.get(insertIndex + 1) + l.get(insertIndex)) / 2);
				System.out.println(l);
			}
			
			for(int i = 0; i < l.size() - 1; i++)
				
			
			System.out.println(l);
//			System.out.println("Case #" + c + ": " + l.get(l.size() - 1));
		}
		
		in.close();
	}
	
	public static void main(String[] args) {
		bruteForce();
		
//		Scanner in = new Scanner(System.in);
//		int merp = in.nextInt();
//		int N, K;
//		PriorityQueue pq = new PriorityQueue();
//		
//		for(int c = 1; c <= merp; c++) {
//			N = in.nextInt();
//			K = in.nextInt();
//			
//			pq = new PriorityQueue();
//			int prev = in.nextInt();
//			for(int i = 0; i < N - 1; i++) {
//				int curr = in.nextInt();
//				pq.add(curr - prev);
//				prev = curr;
//			}
//			
//			for(int i = 0; i < K; i++) {
//				int gap = pq.poll();
//				pq.add((int) Math.floor(gap / 2.0));
//				pq.add((int) Math.ceil(gap / 2.0));
//
//			}
//			
//			System.out.println("Case #" + c + ": " + pq.peek());
//		}
//		
//		in.close();
	}

	// https://www.techiedelight.com/min-heap-max-heap-implementation-in-java/
	
	// Class for implementing Priority Queue 
	static class PriorityQueue
	{
		// vector to store heap elements
		private Vector<Integer> A;

		// constructor: use default initial capacity of vector
		public PriorityQueue()
		{
			A = new Vector<>();
		}

		// constructor: set custom initial capacity for vector
		public PriorityQueue(int capacity)
		{
			A = new Vector<>(capacity);
		}

		// return parent of A.get(i)
		private int parent(int i)
		{
			// if i is already a root node
			if (i == 0)
				return 0;

			return (i - 1) / 2;
		}

		// return left child of A.get(i)
		private int LEFT(int i)
		{
			return (2 * i + 1);
		}

		// return right child of A.get(i)
		private int RIGHT(int i)
		{
			return (2 * i + 2);
		}

		// swap values at two indexes
		void swap(int x, int y)
		{
			// swap with child having greater value
			Integer temp = A.get(x);
			A.setElementAt(A.get(y), x);
			A.setElementAt(temp, y);
		}

		// Recursive Heapify-down procedure. Here the node at index i
		// and its two direct children violates the heap property
		private void heapify_down(int i)
		{
			// get left and right child of node at index i
			int left = LEFT(i);
			int right = RIGHT(i);

			int largest = i;

			// compare A.get(i) with its left and right child
			// and find largest value
			if (left < size() && A.get(left) > A.get(i)) {
				largest = left;
			}

			if (right < size() && A.get(right) > A.get(largest)) {
				largest = right;
			}

			if (largest != i)
			{
				// swap with child having greater value
				swap(i, largest);

				// call heapify-down on the child
				heapify_down(largest);
			}
		}

		// Recursive Heapify-up procedure
		private void heapify_up(int i)
		{
			// check if node at index i and its parent violates
			// the heap property
			if (i > 0 && A.get(parent(i)) < A.get(i))
			{
				// swap the two if heap property is violated
				swap(i, parent(i));

				// call Heapify-up on the parent
				heapify_up(parent(i));
			}
		}

		// return size of the heap
		public int size()
		{
			return A.size();
		}

		// check if heap is empty or not
		public Boolean isEmpty()
		{
			return A.isEmpty();
		}

		// insert specified key into the heap
		public void add(Integer key)
		{
			// insert the new element to the end of the vector
			A.addElement(key);

			// get element index and call heapify-up procedure
			int index = size() - 1;
			heapify_up(index);
		}

		// function to remove and return element with highest priority 
		// (present at root). It returns null if queue is empty
		public Integer poll()
		{
			try {
				// if heap is empty, throw an exception
				if (size() == 0) {
					throw new Exception("Index is out of range (Heap underflow)");
				}

				// element with highest priority
				int root = A.firstElement();	// or A.get(0);

				// replace the root of the heap with the last element of the vector
				A.setElementAt(A.lastElement(), 0);
				A.remove(size()-1);

				// call heapify-down on root node
				heapify_down(0);

				// return root element
				return root;
			}
			// catch and print the exception
			catch (Exception ex) {
				System.out.println(ex);
				return null;
			}
		}

		// function to return, but does not remove, element with highest priority 
		// (present at root). It returns null if queue is empty
		public Integer peek()
		{
			try {
				// if heap has no elements, throw an exception
				if (size() == 0) {
					throw new Exception("Index out of range (Heap underflow)");
				}

				// else return the top (first) element
				return A.firstElement();	// or A.get(0);
			}
			// catch the exception and print it, and return null
			catch (Exception ex) {
				System.out.println(ex);
				return null;
			}
		}

		// function to remove all elements from priority queue
		public void clear()
		{
			System.out.print("Emptying queue: ");
			while (!A.isEmpty()) {
				System.out.print(poll() + " ");
			}
			System.out.println();
		}

		// returns true if queue contains the specified element
		public Boolean contains(Integer i)
		{
			return A.contains(i);
		}

		// returns an array containing all elements in the queue
		public Integer[] toArray()
		{
			return A.toArray(new Integer[size()]);
		}
		
		public String toString() {
			return A.toString();
		}
	}
}
