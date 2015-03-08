import java.util.HashMap;
import java.util.NoSuchElementException;


public class TwoSum3 {
	//space is O(n)
	private HashMap<Integer, Integer> map;
	
	public TwoSum3() {
		map = new HashMap<Integer, Integer>();
	}
	//time complexity is O(1)
	public void add(int elem) {
		if (map.containsKey(elem)) {
			map.put(elem, map.get(elem) + 1);
		}
		else {
			map.put(elem, 1);
		}
	}
	//time complexity in worst case is O(n)
	public boolean find (int target) {
		if (map.isEmpty() || map.size() < 2)
			throw new NoSuchElementException();
		for (int elem: map.keySet()) {
			if (map.containsKey(target - elem)) {
				return true;
			}
		}
		return false;
	}

}
