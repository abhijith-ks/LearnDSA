package io.abhijith.challenges.problems;

/**
 * Implement LRU cache (Least Recently Used Cache)
 * - Cache should contain the most recently used items.
 * - Cache maximum capacity should not be exceeded
 * - Remove the least recently used item from cache, if cache max capacity exceeds
 * 
 * @author abhijith-ks
 */

import java.util.HashMap;

public class LRUCache {
	
	
//	Doubly LinkedList
	private class DNode{
		int key;
		int val;
		DNode next;
		DNode prev;
	}
	
	private HashMap<Integer, DNode> hashTable = new HashMap<>();
	private int maxCapacity;
	private int totalItemsInCache;
	private DNode head, tail;
	
	
//	Initializing the cache
	public LRUCache(int capacity) {
		this.maxCapacity = capacity;
		totalItemsInCache = 0;
		
		head = new DNode();
		tail = new DNode();
		
		head.prev = null;
		tail.next = null;
		
		head.next = tail;
		tail.prev = head;
	}
	
	
//	Get item from cache
	public int get(int key) {
		DNode node = hashTable.get(key);
		boolean itemFoundInCache = node != null;
		
		if(!itemFoundInCache) {
			return -1;
		}
		
		removeNode(node);
		moveToFirst(node);
		
		return node.val;
	}
	
	
//	Put item to cache
	public void put(int key, int val) {
		DNode node = hashTable.get(key);
		boolean itemFoundInCache  = node != null;
		
		if(!itemFoundInCache) {
			node = new DNode();
			node.key = key;
			node.val = val;
			hashTable.put(key, node);
			if(totalItemsInCache == maxCapacity) {
				removeNode(tail.prev);
				moveToFirst(node);
				
			} else {
				totalItemsInCache++;
				moveToFirst(node);
			}
		} 
		else {
			node.val = val;
			removeNode(node);
			moveToFirst(node);
		}
	}
	
	
//	Move recently accessed item to beginning of cache
	private void moveToFirst(DNode node) {
		head.next.prev = node;
		node.next = head.next;
		node.prev = head;
		head.next = node;
	}
	
	
//	Remove a node from the list
	private void removeNode(DNode node) {
		hashTable.remove(node.key);
		DNode copyPrev = node.prev;
		DNode copyNext = node.next;
		copyPrev.next = copyNext;
		copyNext.prev = copyPrev;
	}
	
	
//	Trigger function to test
	public void findSolution(LRUCache obj) {
		
		obj.put(1, 1);
		obj.put(2, 2);
		obj.put(3, 3);
		obj.put(4, 4);
		obj.put(5, 5);
		printCache(head.next);
		
		obj.get(4);
		printCache(head.next);
		
		obj.get(1);
		printCache(head.next);

		obj.put(3, 30);
		printCache(head.next);
		
		obj.put(6, 6);
		printCache(head.next);
	}
	
	
//	Print the current cache value
	public void printCache(DNode temp) {
		while(temp != tail) {
			System.out.print("{ " + temp.key + " , " + temp.val + " }");
			temp = temp.next;
		}
		System.out.println();
	}

}
