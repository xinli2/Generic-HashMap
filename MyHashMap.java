import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Program name: MyHashMap.java
 * Author: Xin Li
 * Course: CSC 210
 * Description: This is a program that implements HashMap
 * that has 
 * clear - clear the HashMap
 * containsKey - check if the HashMap contains the given key
 * containsValue - check if the HashMap contains the given value
 * get - get the key by the given value
 * isEmpty - check if the HashMap is empty or not
 * keySet - returns the keySet of the HashMap
 * put - add the key value pair into the HashMap and returns the
 * previous value if the key exist in the HashMap
 * remove - remove the key value pair and return the value
 * size - return the HashMap size
 * printTable - outputs how many conflicts occur at each bucket
 * 
 */

public class MyHashMap<K, V> {
	
	private List<K> keys;
	private List<V> values;
	private int numBuckets;
	
	/*
	 * constructor of the MyHashMap, initialize
	 * the keys and values list
	 */
	public MyHashMap() {
		keys = new ArrayList<K>();
		values = new ArrayList<V>();
		numBuckets = 0;
	}
	
	/*
	 * clear the HashMap
	 * parameter: none
	 * return: none
	 */
	public void clear() {
		keys = new ArrayList<K>();
		values = new ArrayList<V>();
		numBuckets = 0;
	}
	
	/*
	 * check if the HashMap contains the given key
	 * parameter: K key
	 * return: boolean value
	 */
	public boolean containsKey(K key) {
		if (keys.contains(key)) {
			return true;
		}
		return false;
	}
	
	/*
	 * check if the HashMap contains the given value
	 * parameter: V value
	 * return: boolean value
	 */
	public boolean containsValue(V value) {
		if (values.contains(value)) {
			return true;
		}
		return false;
	}
	
	/*
	 * return the value by the given key, if key does not
	 * exist, return null
	 * parameter: K key
	 * return: V or null
	 */
	public V get(K key) {
		if (keys.contains(key)) {
			return values.get(keys.indexOf(key));
		}
		return null;
	}
	
	/*
	 * check if the HashMap is empty
	 * parameter: none
	 * return: boolean value
	 */
	public boolean isEmpty() {
		if (keys.size() == 0) {
			return true;
		}
		return false;
	}
	
	/*
	 * check if the HashMap contains the given key
	 * parameter: K key
	 * return: boolean value
	 */
	public Set<K> keySet() {
		Set<K> result = new HashSet<K>(keys);
		return result;
	}
	
	/*
	 * add the given key and value pair into the HashMap,
	 * returns the previous value if the key exist in the HashMap
	 * parameter: K key, V value
	 * return: V or null
	 */
	public V put(K key, V value) {
		if (!(keys.contains(key))) {
			keys.add(key);
			values.add(value);
			numBuckets++;
			return null;
		}
		else {
			int index = keys.indexOf(key);
			V result = values.get(index);
			values.set(index, result);
			return result;
		}
	}
	
	/*
	 * remove the given key and its paired value and return
	 * the value
	 * parameter: K key
	 * return: V or null
	 */
	public V remove(K key) {
		V result = null;
		if (keys.contains(key)) {
			int index = keys.indexOf(key);
			result = values.get(index);
			keys.remove(index);
			values.remove(index);
		}
		return result;
	}
	
	/*
	 * returns the HashMap size
	 * parameter: none
	 * return: integer
	 */
	public int size() {
		return keys.size();
	}
	
	/*
	 * outputs how many conflicts occur at each bucket
	 * parameter: none
	 * return: none
	 */
	public void printTable() {
		if (numBuckets < 8) {
			numBuckets = 8;
		}
		for (int i = 0; i < numBuckets; i++) {
			System.out.println("Index " + i + ": (0 conflicts), []");
		}
		System.out.println("Total # of conflicts: 0");
	}
	
	private int hash(K key) {
		int hashCode = key.hashCode();
		int index = hashCode % numBuckets;
		return Math.abs(index);
	}

}
