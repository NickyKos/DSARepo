import java.util.LinkedList;

public class MyHashMap<K, V> implements MyMap<K, V> {

  private static final int DEFAULT_INITIAL_CAPACITY = 16;
  private static final double LOAD_FACTOR = 0.75;
  
  private LinkedList<Entry<K, V>>[] table;
  private int size = 0;
  
  public MyHashMap() {
    this(DEFAULT_INITIAL_CAPACITY);
  }
  
  @SuppressWarnings("unchecked")
  public MyHashMap(int initialCapacity) {
    table = new LinkedList[initialCapacity];
  }
  
  @Override
  public void clear() {
    for (int i = 0; i < table.length; i++)
      if (table[i] != null) table[i].clear();
    size = 0;
  }
  
  @Override
  public boolean containsKey(K key) {
    int bucketIndex = hash(key.hashCode());
    if (table[bucketIndex] != null) {
      for (Entry<K, V> entry : table[bucketIndex])
        if (entry.getKey().equals(key))
          return true;
    }
    return false;
  }
  
  @Override
  public boolean containsValue(V value) {
    for (LinkedList<Entry<K, V>> bucket : table) {
      if (bucket != null) {
        for (Entry<K, V> entry : bucket)
          if (entry.getValue().equals(value))
            return true;
      }
    }
    return false;
  }
  
  @Override
  public java.util.Set<MyMap.Entry<K, V>> entrySet() {
    java.util.Set<MyMap.Entry<K, V>> set = new java.util.HashSet<>();
    for (LinkedList<Entry<K, V>> bucket : table) {
      if (bucket != null)
        set.addAll(bucket);
    }
    return set;
  }
  
  @Override
  public V get(K key) {
    int bucketIndex = hash(key.hashCode());
    if (table[bucketIndex] != null) {
      for (Entry<K, V> entry : table[bucketIndex])
        if (entry.getKey().equals(key))
          return entry.getValue();
    }
    return null;
  }
  
  @Override
  public boolean isEmpty() {
    return size == 0;
  }
  
  @Override
  public java.util.Set<K> keySet() {
    java.util.Set<K> set = new java.util.HashSet<>();
    for (LinkedList<Entry<K, V>> bucket : table) {
      if (bucket != null) {
        for (Entry<K, V> entry : bucket)
          set.add(entry.getKey());
      }
    }
    return set;
  }
  
  @Override
  public V put(K key, V value) {
    int bucketIndex = hash(key.hashCode());
    
    if (table[bucketIndex] == null)
      table[bucketIndex] = new LinkedList<>();
    
    for (Entry<K, V> entry : table[bucketIndex]) {
      if (entry.getKey().equals(key)) {
        V oldValue = entry.getValue();
        entry.value = value;
        return oldValue;
      }
    }
    
    table[bucketIndex].add(new Entry<>(key, value));
    size++;
    
    if (size >= table.length * LOAD_FACTOR)
      rehash();
    
    return null;
  }
  
  @Override
  public void remove(K key) {
    int bucketIndex = hash(key.hashCode());
    if (table[bucketIndex] != null) {
      java.util.Iterator<Entry<K, V>> iter = table[bucketIndex].iterator();
      while (iter.hasNext()) {
        if (iter.next().getKey().equals(key)) {
          iter.remove();
          size--;
          return;
        }
      }
    }
  }
  
  @Override
  public int size() {
    return size;
  }
  
  @Override
  public java.util.Set<V> values() {
    java.util.Set<V> set = new java.util.HashSet<>();
    for (LinkedList<Entry<K, V>> bucket : table) {
      if (bucket != null) {
        for (Entry<K, V> entry : bucket)
          set.add(entry.getValue());
      }
    }
    return set;
  }
  
  private int hash(int hashCode) {
    return Math.abs(hashCode) % table.length;
  }
  
  @SuppressWarnings("unchecked")
  private void rehash() {
    LinkedList<Entry<K, V>>[] oldTable = table;
    table = new LinkedList[2 * oldTable.length];
    
    size = 0;
    for (LinkedList<Entry<K, V>> bucket : oldTable) {
      if (bucket != null) {
        for (Entry<K, V> entry : bucket) {
          put(entry.getKey(), entry.getValue());
        }
      }
    }
  }
}