package design;

import java.util.*;

public class RandomizedSet {
    Map<Integer, Integer> map;
    ArrayList<Integer> list;
    Random rand;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        } else
            return false;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;
        int index = map.get(val);
        int lastElement = list.get(list.size() - 1);
        map.put(lastElement, index);
        list.set(index, lastElement);
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int random = rand.nextInt(list.size());
        return list.get(random);
    }

    public static void main(String[] args) {
        RandomizedSet set = new RandomizedSet();
        set.insert(2);
        set.remove(2);
        set.insert(2);
        set.getRandom();
        set.remove(1);
        set.insert(2);
        set.getRandom();
    }
}
