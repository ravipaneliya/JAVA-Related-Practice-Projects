package com.sl.basic;

import java.util.PriorityQueue;

public class QueueDemo {
	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int i = 1; i<=10; i++) {
			pq.add(i);
		}
		System.out.println(pq.size() + " - " + pq);
		
		for(int i = 1; i<=10; i++) {
			System.out.println(pq.size() + " - " + pq.poll());
		}
	}
}
