package utp.zad10.zad1;

import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RWMap<K, V> {
	private final Lock r;
	private final Lock w;
	public RWMap() {
		ReadWriteLock lock = new ReentrantReadWriteLock();
		r = lock.readLock();
		w = lock.writeLock();
	}
	
	private HashMap<K, V> map = new HashMap<>();

	public void put(K key, V value) {
		try {
			w.lock();
			Thread.sleep(200);
			map.put(key, value);
			w.unlock();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public V get(K key) {
		try {
			r.lock();
			Thread.sleep(200);
			V v = map.get(key);
			r.unlock();
			return v;
		} catch (InterruptedException e) {
			e.printStackTrace();
			return null;
		}
	}
}